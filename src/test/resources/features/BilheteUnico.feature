# language: pt
Funcionalidade: Bilhete Unico

  Cenario:01 Onboarding Bilhete Unico
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "06193372067", senha "Devires@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    Entao visualizo a tela de onboarding de Bilhete Unico

  Cenario:02 Modal Onde Encontar o Numero do Bilhete
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "06193372067", senha "Devires@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em Cadasrar Bilhete Unico
    E clico em Onde Encontrar o Numero do Bilhete Unico
    Entao visualizo o modal informativo sobre a localizacao do numero do bilhete

  Cenario:03 Cadastro de Bilhete Unico
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "06193372067", senha "Devires@123"
    E acesso a home do aplicativo
    Quando navego ate Bilhete Unico
    E clico em Cadasrar Bilhete Unico
    E submeto as informacoes validas do bilhete
      |  numero   |  apelido  |
      | 556005492 | BU Matheus|
    Entao devo visualizar a tela do BU