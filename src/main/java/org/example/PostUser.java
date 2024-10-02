package org.example;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

// passa apenas uma senha que será gerado um cpf e cadastrado uma pessoa, o método retorna o cpf cadastrado para que vc possa usar
public class PostUser {

    public static String gerarCpf() throws Exception {
        String url = "https://www.4devs.com.br/ferramentas_online.php";
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("acao", "gerar_cpf")
                .asString();

        if (response.getStatus() == 200) {
            return response.getBody();
        } else {
            throw new RuntimeException("Erro ao gerar CPF: " + response.getStatusText());
        }
    }


    public static String criarUser(String senha, String nascimento) throws Exception {

        String cpf = gerarCpf();

        try {
            String url = "https://arquiteturaadmin-hml.autopasscorp.com/bff/users";

            String jsonInputString = "{"
                    + "\"address\": {"
                    + "\"neighborhood\": \"Centro\","
                    + "\"address\": \"Rua Exemplo\","
                    + "\"country\": \"Brasil\","
                    + "\"city\": \"São Paulo\","
                    + "\"complement\": \"Apto 101\","
                    + "\"cep\": \"01000-000\","
                    + "\"uf\": \"SP\","
                    + "\"number\": \"1234\""
                    + "},"
                    + "\"document\": {"
                    + "\"kind\": \"cpf\","
                    + "\"identification\": \"" + cpf + "\""
                    + "},"
                    + "\"name\": \"Post Teste\","
                    + "\"gender\": \"male\","
                    + "\"birthday\": \"" + nascimento + "\","
                    + "\"email\": {"
                    + "\"email\": \"postTeste.teste@example.com\""
                    + "},"
                    + "\"phoneNumber\": {"
                    + "\"phone\": \"+5511933926666\""
                    + "},"
                    + "\"password\": \"" + senha + "\","
                    + "\"validation\": {"
                    + "\"hash\": \"abc123hash\","
                    + "\"deviceManufacturer\": \"Google\","
                    + "\"deviceModel\": \"sdk_gphone64_arm64\","
                    + "\"deviceId\": \"1eb146119da9d01e\""
                    + "},"
                    + "\"termsAccepted\": ["
                    + "{"
                    + "\"kind\": \"AUTOPASS_APP\","
                    + "\"accepted\": true"
                    + "},"
                    + "{"
                    + "\"kind\": \"PEFISA_ACCOUNT\","
                    + "\"accepted\": false"
                    + "}"
                    + "],"
                    + "\"policyAccepted\": ["
                    + "{"
                    + "\"kind\": \"AUTOPASS_APP\","
                    + "\"accepted\": true"
                    + "},"
                    + "{"
                    + "\"kind\": \"PEFISA_ACCOUNT\","
                    + "\"accepted\": false"
                    + "}"
                    + "]"
                    + "}";


            // Fazendo a requisição POST com Unirest
            HttpResponse<String> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .body(jsonInputString)
                    .asString();

            System.out.println("Response Code: " + response.getStatus());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(criarUser("Teste@123", "1999-12-05"));
    }
}

