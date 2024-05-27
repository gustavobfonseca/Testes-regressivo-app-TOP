package org.example;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hooks {
    private static AppiumDriver driver;
    private static List<Scenario> scenariosErro =new ArrayList<>();
    private static String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    private static List<Scenario> scenariosOK = new ArrayList<>();
    private static Integer contadorFail=0;
    private static Integer contadorOK=0;
    private static StringBuilder relatorio = new StringBuilder();




    @After
    public void verificarErro(Scenario scenario) {
        if (scenario.isFailed()) {
            contadorFail++;
            // Verifica se o driver foi inicializado corretamente
            if (driver != null) {
                scenariosErro.add(scenario);
                // Captura o screenshot
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // Cria um diretório específico para cada cenário
                String scenarioDirectoryName = "target/screenshots/" + scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");
                String screenshotName = timestamp + "-ERRO" + ".png";
                String screenshotPath = scenarioDirectoryName + "/" + screenshotName;

                // Cria o diretório de destino se não existir
                try {
                    Files.createDirectories(Paths.get(scenarioDirectoryName));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Salva o screenshot no sistema de arquivos
                try {
                    System.out.println("Teste falhou");
                    Files.write(Paths.get(screenshotPath), screenshotBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Anexa o caminho do screenshot ao cenário do Cucumber
                scenario.attach(screenshotBytes, "image/png", screenshotName);
            } else {
                System.out.println("Driver não foi inicializado.");

            }
        } else {
            contadorOK++;
            scenariosOK.add(scenario);
            System.out.println(scenario.getName() + " foi realizado com sucesso");


        }
    }

    @AfterAll
    public static void relatorioCenarioFinal() {
        if (driver == null){
            relatorio.append("Para executar seus testes com êxito, inicialize o driver !");
        }else {

            relatorio.append("\n");
            relatorio.append("================================================================================\n");
            relatorio.append("Foram realizados " + (contadorFail + contadorOK) + " testes\n");
            relatorio.append("• Passaram " + contadorOK + "\n");
            relatorio.append("• Falharam " + contadorFail + "\n");
            relatorio.append("================================================================================\n");

            for (Scenario scenarioAtual : scenariosOK) {
                relatorio.append("\n");
                relatorio.append("Teste OK no cenário: " + scenarioAtual.getName() + "\n");
                relatorio.append("Cenário da linha " + scenarioAtual.getLine() + "\n");
                relatorio.append("\n");
            }

            relatorio.append("================================================================================\n");

            for (Scenario scenarioAtual : scenariosErro) {
                relatorio.append("\n");
                relatorio.append("• Erro no cenário: " + scenarioAtual.getName() + "\n");
                relatorio.append("Cenário da linha " + scenarioAtual.getLine() + "\n");
                relatorio.append("\n");
            }

            relatorio.append("================================================================================\n");
            relatorio.append("\n");
            relatorio.append("Todos os cenários que falharam foram gerados prints para evidênciar o momento da falha");
            relatorio.append("\n");
            relatorio.append("Você pode encontra-los em: target/screenshots");
            relatorio.append("\n");
            relatorio.append("Esse relatório está salvo em um arquivo txt que pode ser encontado em: /target/relatorio_final-teste-data-atual.txt");
        }


        try (FileWriter writer = new FileWriter("target/relatorio_final-teste-"+timestamp+".txt")) {
            writer.write(relatorio.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(relatorio.toString());
    }
}
