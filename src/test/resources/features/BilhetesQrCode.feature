# language: pt
Funcionalidade: BilhetesQrCode

  Cenario:01 Compra bilhete CPTM ou Metro com pagamento via pix e reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "05454081051", senha "Teste123"
    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção Metro e Trem
    E seleciono 10 bilhete
    E avanço para as formas de pagamento
    E confirmo pix como forma de pagamento
    Então visualizo a tela de confirmação de pagamento via pix

  Cenario:02 Compra combo de bilhete +50 pontos via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "06193372067", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção Metro e Trem
    E seleciono 1 bilhete
    E continuo a compra com pontos
    E submeto o cartao final "6091"
    E confirmo o pagamento informando o CVV "333"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:03 Compra combo de bilhete +100 pontos via cartão de débito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "06193372067", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção Metro e Trem
    E seleciono 2 bilhete
#    E continuo a compra com pontos
    E clico em 100 pontos
    E submeto o cartao final "6091"
    E confirmo o pagamento informando o CVV "333"
    Então visualizo a tela de Pagamento efetuado com sucesso
#
  Cenario:04 Compra de bilhete via cartão de débito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "06193372067", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção Metro e Trem
    E seleciono 2 bilhete
#    E continuo a compra com pontos
#    E clico em 100 pontos
    E submeto o cartao final "6091"
    E confirmo o pagamento informando o CVV "333"
    Então visualizo a tela de Pagamento efetuado com sucesso
#
#
  Cenario:05 Erro na compra de bilhete via cartão de débito com cartao invalido e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção Metro e Trem
    E seleciono 2 bilhete
#    E clico em Talvez Mais Tarde
    E submeto o cartao final "0148"
    E confirmo o pagamento informando o CVV "123"
    Então visualizo a tela de Erro no pagamento

    #Crédito desabilitado
#  Cenario:03 Compra bilhete CPTM ou Metro com pagamento via cartão de crédito com cartão invalido
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
##    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste@123"
#    E acesso a home do aplicativo
#    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
#    E clico na opçao Comprar Bilhetes
#    E clico na opção Metro e Trem
#    E seleciono 2 bilhete
#    E avanço para as formas de pagamento
#    E confirmo Cartão de credito inválido
#    E confirmo o pagamento informando o CVV "111"
#    Então visualizo a tela de Erro no pagamento

#  Cenario:04 Compra bilhete CPTM ou Metro com pagamento via cartão de credito com cartao valido
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
##    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
#    E acesso a home do aplicativo
#    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
#    E clico na opçao Comprar Bilhetes
#    E clico na opção Metro e Trem
#    E seleciono 1 bilhete
#    E avanço para as formas de pagamento
#    E confirmo Cartão de credito válido
#    E confirmo o pagamento informando o CVV "123"
#    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:06 Compra de bilhete CPTM, Metro com pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E vou para a minha home do aplicativo
    E eu clico no botao do mock gemalto token
    E clico em Conta Digital na home
    E volto para a home
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção Metro e Trem
    E seleciono 1 bilhete
    E clico em Talvez Mais Tarde
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1571"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:07 Erro na compra de bilhete CPTM, Metro com pagamento via saldo em conta e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
#    E vou para a minha home do aplicativo
#    E eu habilito o mock do token no perfil do usuario
    E clico em Conta Digital na home
    E volto para a home
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opçao Comprar Bilhetes
    E clico na opção Metro e Trem
    E seleciono 1 bilhete
#    E avanço para as formas de pagamento
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1111"
    Então visualizo a tela de Erro no pagamento

#    Crédito desabilitado
#  Cenario:08 Remover cartão de crédito como forma de pagamento tendo menos que 3 cartões cadastrados
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Teste123"
#    E acesso a home do aplicativo
#    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
#    E clico na opção Formas de Pagamento
#    E clico na opção excluir cartão
#    E confirmo a exclusão
#    Entao o cartão não deverá estar listado

#  Cenario:09 Adicionar cartão de crédito como forma de pagamento tendo menos que 3 cartões cadastrados
##    Dado que estou na área não logada do app
##    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
##    E vou para a minha home do aplicativo
#    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
#    E clico na opção Formas de Pagamento
#    E clico em Adicionar forma de pagamento
#    E clico na opção Cartão de crédito
#    E submeto as informações corretas do cartão
#      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
#      | Teste Cadastro | 4001 7482 7831 6091 | 01/28 | 123 | 519.197.408-56 |
#    Entao visualizo a tela de Cartão cadastrado com sucesso

#  Cenario:10 Cadastro de cartão de crédito inválido
##    Dado que estou na área não logada do app
##    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
##    E vou para a minha home do aplicativo
#    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
#    E clico na opção Formas de Pagamento
#    E clico em Adicionar forma de pagamento
#    E clico na opção Cartão de crédito
#    E submeto as informações corretas do cartão
#      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
#      | Teste Cadastro | 1234 5678 9101 1123 | 03/30 | 111 | 519.197.408-56 |
#    Entao visualizo a tela de falha no cadastro

  Cenario:08 Remover cartão de débito como forma de pagamento tendo menos que 3 cartões cadastrados
   Dado que estou na área não logada do app
   E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Teste123"
   E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico na opção excluir cartão
    E confirmo a exclusão
    Entao o cartão não deverá estar listado

  Cenario:09 Cadastro de cartão de débito inválido
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de débito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 1234 5678 9101 1123 | 03/30 | 111 | 327.721.478-86 |
    Entao visualizo a tela de falha no cadastro

  Cenario:10 Cadastro de cartão de débito e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
#    Quando reseto o app
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico na opção Formas de Pagamento
    E clico em Adicionar forma de pagamento
    E clico na opção Cartão de débito
    E submeto as informações corretas do cartão
      | NomeCartao     | numeroCartao        | dtVal | cvv | numCelular  |
      | Teste Cadastro | 4001 7482 7831 6091 | 01/28 | 123 | 519.197.408-56 |
    Entao visualizo a tela de Cartão cadastrado com sucesso


  Cenario:11 Acessar meus bilhetes offline
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "06193372067", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E eu desligo a conexão de internet do dispositivo
    E clico na opçao Comprar Bilhetes
    E clico na opção Acessar meus bilhetes Offline
    Entao visualizo a lista de bilhetes disponiveis para uso
    E reestabeleço a conexão com a internet

  Cenario:12 Acessar minhas formas de pagamento ao reestabelecer a conexão com a internet e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E acesso a home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E eu desligo a conexão de internet do dispositivo
    E clico na opção Formas de Pagamento estando offline
    E reestabeleço a conexão com a internet
    E clico em tentar novamente
    Entao visualizo a tela de formas de pagamento

  Cenario:13 Historico de compra de bilhete
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado
    E clico no ultimo registro de compra no historico
    Entao visualizo o modal com os detalhes da compra


