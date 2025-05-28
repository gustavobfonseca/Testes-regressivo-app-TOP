# Automação Android APP TOP com Appium

Este projeto refere-se à testes de automatizados do aplicativo TOP para a plataforma Android utilizando Appium.

## 🔧 Pré-requisitos

Certifique-se de que todos os seguintes pré-requisitos estejam instalados e configurados em seu sistema:

1. **Java Development Kit (JDK)**
   - Baixe e instale a versão mais recente do JDK.
   - Configure a variável de ambiente `JAVA_HOME`.

2. **Android SDK**
   - Instale o Android SDK através do Android Studio ou linha de comando.
   - Configure as variáveis de ambiente `ANDROID_HOME` e adicione `$ANDROID_HOME/tools` e `$ANDROID_HOME/platform-tools` ao `PATH`.

3. **Node.js e NPM**
   - Instale a versão mais recente do Node.js.

4. **Appium**
   - Instale o Appium globalmente:
     ```bash
     npm install -g appium
     ```

5. **Appium Doctor**
   - Instale o Appium Doctor para verificar a instalação:
     ```bash
     npm install -g appium-doctor
     ```

6. **Configurar dispositivo Android**
   - Conecte um dispositivo Android via USB ou configure um emulador.
   - Ative a "Depuração USB" no dispositivo.

## Verificação da Configuração

Execute o seguinte comando para verificar se todas as dependências estão configuradas corretamente:

```bash
appium-doctor --android
```

## Iniciando o Servidor Appium

Você pode iniciar o servidor Appium usando a linha de comando:

```bash
appium
```

Ou utilizando o Appium Desktop, que oferece uma interface gráfica.

## Configuração do Projeto de Automação

### Dependências

Para este projeto, é utilizando Java. Utilize Maven ou Gradle para gerenciar as dependências do Appium. Exemplo de dependência Maven:

```xml
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>7.4.1</version>
</dependency>
```

### Execução do Script de Automação

- Conecte o dispositivo android no computador, com o "Modo Desenvolvedor" habilitado e a o app TOP instalado.
- Para a execução da ferature de cadastro, é necessário ter acesso à VPN da Autopass e estar com ela ligada, para que seja possível buscar os códigos gerados para os tokens SMS e E-mail.
- Certifique-se de que o servidor Appium está rodando.
- Execute o script de teste via linha de comando ou sua IDE favorita.

---

## 👤 DESENVOLVIDO POR:

Matheus Munari Denani

---

## 📝 Notas Finais

- Este documento serve como ponto de partida para configurar e realizar testes de automação do aplicativo TOP para Android.
- Para informações adicionais, consulte a [documentação oficial do Appium](http://appium.io/docs/en/about-appium/intro/).

---

Certifique-se de ajustar caminhos de arquivos, versões de bibliotecas, e quaisquer outras configurações específicas ao seu projeto.
```

Este `README.md` fornece um guia abrangente para instalação, configuração e execução de testes de automação em um projeto que utiliza Appium para aplicações Android. Ajuste conforme necessário para as especificidades do seu projeto.