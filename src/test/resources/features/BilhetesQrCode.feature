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


  Cenario: Adicionar cartão de crédito como forma de pagamento tendo menos que 3 cartõe scadastrados
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de crédito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 5555 4444 3333 1111 | 03/30 | 737 | 327.721.478-86 |
    Entao visualizo a tela de Cartão cadastro com sucesso

  Cenario: Remover cartão de crédito como forma de pagamento tendo menos que 3 cartõe scadastrados
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico na opção excluir cartão
    E confirmo a exclusão
    Entao o cartão não deverá estar listado
    E reseto o app

  Cenario: Compra de bilhete via cartão de débito
    Dado que estou na área não logada do app
    E submeto minhas credenciais válidas para login
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de débito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

