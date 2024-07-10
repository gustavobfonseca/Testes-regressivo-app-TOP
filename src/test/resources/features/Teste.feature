# language: pt
Funcionalidade: teste

  Cenario: Compra de bilhete CPTM, Metro com pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    E eu habilito o mock do token no perfil do usuario
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "7734"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Erro na compra de bilhete CPTM, Metro com pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    E eu habilito o mock do token no perfil do usuario
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1111"
    Então visualizo a tela de Erro no pagamento

  Cenario: Acessar meus bilhetes offline
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E eu desligo a conexão de internet do dispositivo
    E clico na opçao Comprar Bilhetes
    E clico na opção Acessar meus bilhetes Offline
    Entao visualizo a lista de bilhetes disponiveis para uso
    E reestabeleço a conexão com a internet
    E reseto o app

  Cenario: Acessar minhas formas de pagamento ao reestabelecer a conexão com a internet

    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E eu desligo a conexão de internet do dispositivo
    E clico na opção Formas de Pagamento
    E reestabeleço a conexão com a internet
    E clico em tentar novamente
    Entao visualizo a tela de formas de pagamento
    E reseto o app

  Cenario: Historico de compra de bilhete

    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico no ultimo registro de compra no historico
    Entao visualizo o modal com os detalhes da compra
    E reseto o app

