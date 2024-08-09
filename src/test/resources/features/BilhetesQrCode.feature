# language: pt
Funcionalidade: BilhetesQrCode

  Cenario: Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com o cvv preenchido incorretamente
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento


  Cenario: Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com o cvv preenchido corretamente
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso


  Cenario: Adicionar cartão de crédito como forma de pagamento tendo menos que 3 cartõe scadastrados
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de crédito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 5555 4444 3333 1111 | 03/30 | 737 | 327.721.478-86 |
    Entao visualizo a tela de Cartão cadastro com sucesso

  Cenario: Remover cartão de crédito como forma de pagamento tendo menos que 3 cartõe scadastrados
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico na opção excluir cartão
    E confirmo a exclusão
    Entao o cartão não deverá estar listado
    E reseto o app

  Cenario: Cadastro de cartão de crédito inválido
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de crédito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 1234 5678 9101 1123 | 03/30 | 111 | 327.721.478-86 |
    Entao visualizo a tela de falha no cadastro

  Cenario: Cadastro de cartão de débito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de débito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 4000 0600 0000 0006 | 03/30 | 737 | 327.721.478-86 |
    Entao visualizo a tela de Cartão cadastro com sucesso

  Cenario: Erro na compra de bilhete via cartão de débito informando o cvv incorreto
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de débito como forma de pagamento
    E confirmo o pagamento informando o CVV "333"
    Então visualizo a tela de Erro no pagamento

  Cenario: Compra de bilhete via cartão de débito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo Cartão de débito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Acessar meus bilhetes offline
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E eu desligo a conexão de internet do dispositivo
    E clico na opçao Comprar Bilhetes
    E clico na opção Acessar meus bilhetes Offline
    Entao visualizo a lista de bilhetes disponiveis para uso
    E reestabeleço a conexão com a internet
    E reseto o app

  Cenario: Acessar minhas formas de pagamento ao reestabelecer a conexão com a internet
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E eu desligo a conexão de internet do dispositivo
    E clico na opção Formas de Pagamento
    E reestabeleço a conexão com a internet
    E clico em tentar novamente
    Entao visualizo a tela de formas de pagamento
    E reseto o app

  Cenario: Historico de compra de bilhete
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico no ultimo registro de compra no historico
    Entao visualizo o modal com os detalhes da compra
    E reseto o app

  Cenario: Compra de bilhete CPTM, Metro com pagamento via saldo em conta
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando reseto o app
    E eu habilito o mock do token no perfil do usuario
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "7734"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Erro na compra de bilhete CPTM, Metro com pagamento via saldo em conta
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
#    E eu habilito o mock do token no perfil do usuario
    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção CPTM, Metrô
    E seleciono a quantidade de bilhetes
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1111"
    Então visualizo a tela de Erro no pagamento

