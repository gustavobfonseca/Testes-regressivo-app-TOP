package org.example;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import io.cucumber.plugin.event.Step;
import junit.framework.TestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;

public class GerarVideoEvidencia {
    private static AppiumDriver driver;
    private static String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    private static LocalTime timestampInicial;
    public static String nomeArquivoVideo;
    private Process screenRecordProcess;

    @Before
    public void gravarEvidencia(Scenario scenario) throws IOException, InterruptedException {
        Thread.sleep(3000);
        nomeArquivoVideo = scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".mp4";

        // iniciar a gravação
//        System.out.println("Iniciando gravação da evidência");
        timestampInicial = LocalTime.now();
        ProcessBuilder processBuilder = new ProcessBuilder("adb", "shell", "screenrecord", "--time-limit", "180", "/sdcard/" + nomeArquivoVideo);
        screenRecordProcess = processBuilder.start();
    }

    @After
    public void pararGravacao() throws IOException, InterruptedException {
        System.out.println("Parando vídeo");
        if (screenRecordProcess != null) {
//            System.out.println("video maior que 0");
            Thread.sleep(3000);
            screenRecordProcess.destroy();
            Thread.sleep(2000);
            screenRecordProcess.waitFor();
        }

        String caminho = System.getProperty("user.dir") + File.separator + "target" + File.separator + "evidencias";
        String puxarVideo = String.format("adb pull /sdcard/%s %s", nomeArquivoVideo, caminho);

//        System.out.println("Puxando o vídeo do dispositivo para o diretório de destino: " + caminho);
        Process pullProcess = Runtime.getRuntime().exec(puxarVideo);
        int exitCode = pullProcess.waitFor();

        if (exitCode != 0) {
            System.err.println("Erro ao puxar o vídeo do dispositivo, código de saída: " + exitCode);
            throw new IOException("Não foi possível puxar o vídeo do dispositivo");
        }

        File videoFile = new File(caminho, nomeArquivoVideo);
        if (videoFile.exists() && videoFile.isFile() ){
            if (videoFile.length()< 1){
                throw new IOException("Não foi possível gravar a evidencia");
            }

            // excluir o vídeo do mobile
            String deleteCommand = String.format("adb shell rm /sdcard/%s", nomeArquivoVideo);
//            System.out.println("Excluindo o vídeo do dispositivo: " + deleteCommand);
            Process deleteProcess = Runtime.getRuntime().exec(deleteCommand);
            deleteProcess.waitFor();

            if (deleteProcess.exitValue() != 0) {
                System.err.println("Erro ao excluir o vídeo do dispositivo, código de saída: " + deleteProcess.exitValue());
                throw new IOException("Não foi possível excluir o vídeo do dispositivo");
            } else {
//                System.out.println("Vídeo excluído do dispositivo com sucesso");
            }
        } else {
            System.err.println("Vídeo não encontrado no diretório de destino: " + videoFile.getAbsolutePath());
        }
    }

    @AfterStep
    public void verificarTamanhoVideo(Scenario scenario) throws IOException, InterruptedException {
        System.out.println("Timestamp inicial: " + timestampInicial);
        LocalTime timestampAtual = LocalTime.now();
        Duration duracao = Duration.between(timestampInicial, timestampAtual);
        int duracaoGravacao = (int) duracao.getSeconds() / 60;
        System.out.println("Subtração dos timestamp: " + duracao.getSeconds());
        if(duracao.getSeconds() >= 180){
            System.out.println("Vídeo maior que 3 minutos, portanto iniciando nova gravação");
            pararGravacao();
            timestamp += duracaoGravacao/3;
            nomeArquivoVideo = scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".mp4";

            // iniciar a gravação
//        System.out.println("Iniciando gravação da evidência");
            timestampInicial = LocalTime.now();
            ProcessBuilder processBuilder = new ProcessBuilder("adb", "shell", "screenrecord", "--time-limit", "180", "/sdcard/" + nomeArquivoVideo);
            screenRecordProcess = processBuilder.start();

        }

    }
}
