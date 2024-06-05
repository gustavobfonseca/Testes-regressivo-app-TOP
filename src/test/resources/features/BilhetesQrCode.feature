# language: pt
Funcionalidade: BilhetesQrCode


  Cenario: Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com o cvv preenchido corretamente
    Dado que estou na área não logada do app
    E submeto minhas credenciais válidas para login
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com o cvv preenchido incorretamente
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento
