# language: pt
Funcionalidade: : Login

  Cenario: 02 - Login com credenciais inválidas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais inválidas para login
    Entao visualizo o modal de CPF e, ou Senha inválidos

  Cenario: 03 - login com usuario bloqueado
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais bloqueadas para login
    Entao visualizo o modal de usuário bloqueado
    E reseto o app

  Cenario: 09 - Recuperação de senha com CPF bloqueado
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo um CPF bloqueado
    Entao visualizo o modal de usuário bloqueado na tela de esqueci minha senha
    E reseto o app

  Cenario: 08 - Recuperação de senha com CPF inválido
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo um CPF inválido
    Entao visualizo a mensagem de Documento inválido
    E clico em cancelar

  Cenario: Teste - Recuperação de senha
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "32772147886"
    E insiro o token

  Cenario: 01 - Login com as credenciais validas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login
    Entao acesso a home do aplicativo
