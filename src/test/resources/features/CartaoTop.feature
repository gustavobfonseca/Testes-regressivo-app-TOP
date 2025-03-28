# language: pt
Funcionalidade: Cartão Top

  #OBS: Garantir que a massa 325.056.645-44 tenha um cartão puro transporte FORA da blacklist antes de executar o teste da funcionalidade


#  Cenário:01 Onboarding puro transporte e reseto o app
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico no botão Eu Quero
#    E seleciono a opção receber em casa
#    Então sou direcionado para o serviço de cartão da Pacman
#
#  Cenário:02 Onboarding puro transporte senior e reseto o app
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada com mais de sessenta anos
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico no botão Eu Quero
#    E clico em Continuar
#    Então so devo visualizar o elemento de retirar na loja

  Cenario:03 Compra combo de credito comum + 1000 pontos pagamento via pix
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E continuo a recarga com pontos
    E dou scroll até outro valor
    E clico em outro valor
    E insiro o valor de R$ "1000" em pontos
    E submeto pix como forma de pagamento para recarga comum
    Então visualizo a tela de codigo pix gerado para pagamento

  Cenario:04 Compra de credito comum pagamento via pix e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
#    E clico em Talvez Mais Tarde
    E submeto pix como forma de pagamento para recarga comum
    Então visualizo a tela de codigo pix gerado para pagamento

#    Crédito desabilitado
#  Cenario:03 Compra de credito comum Erro no pagamento via cartao de credito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "01627692029", senha "Teste123"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Comum
#    E insiro o valor de R$ "400"
#    E clico em Talvez Mais Tarde
#    E submeto o cartao final "0148"
#    E confirmo o pagamento informando o CVV "001"
#    Então visualizo a tela de Erro no pagamento
#
#    Crédito desabilitado
#  Cenario:02 Compra de credito comum Pagamento via cartao de credito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "01627692029", senha "Teste123"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Comum
#    E insiro o valor de R$ "400"
#    E clico em Talvez Mais Tarde
#    E submeto o cartao final "6091"
#    E confirmo o pagamento informando o CVV "737"
#    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:05 Compra combo de credito comum + 150 pontos Pagamento via cartao de debito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "01627692029", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Talvez Mais Tarde
    E submeto o cartao final "6091"
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:06 Compra de credito comum Erro no pagamento via cartao de debito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "01627692029", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
#    E clico em Talvez Mais Tarde
    E submeto o cartao final "0148"
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Erro no pagamento

  Cenario:07 Compra combo de credito comum + 150 pontos Pagamento via cartao de debito e reseto o app e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "01627692029", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
#    E continuo a recarga com pontos
    E clico em 150 pontos
    E submeto o cartao final "6091"
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Pagamento efetuado com sucesso


#  Cenário:06 Codigo PIX expirado para recarga comum
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Comum
#    E insiro o valor de R$ "400"
#    E clico em Comprar
#    E submeto pix como forma de pagamento
#    E aguardo por mais de 1 minuto e meio na tela
#    Então visualizo a tela de "Código Pix Expirado"

  Cenario:08 Compra de credito comum erro no pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E vou para a minha home do aplicativo
    E eu clico no botao do mock gemalto token
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Talvez Mais Tarde
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "0001"
    Então visualizo a tela de Erro no pagamento

  Cenario:09 Compra de credito comum - Pagamento via saldo em conta e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
#    E vou para a minha home do aplicativo
#    E eu clico no botao do mock gemalto token
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
#    E clico em Talvez Mais Tarde
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1571"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:10 Informativo escolar - meia tarifa e depois reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "05454081051", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de saldo
    E clico na opção Saiba mais no item escolar
    Entao visualizo a tela de beneficio escolar meia tarifa

  Cenário:11 Direcionamento para as duvidas sobre o beneficio passe escolar e depois reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51168429242", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Passe Livre
    E clico em Duvidas sobre o seu Beneficio Escolar
    Então sou direcionado para a pagina da EMTU de beneficio escolar

  Cenario:12 Compra combo de credito escolar pagamento via cartao de debito + 50 pontos
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E continuo a recarga com pontos
    E submeto o cartao final "6091"
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:13 Compra de credito escolar - Erro no pagamento via cartao de debito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
#    E clico em Talvez Mais Tarde
    E submeto o cartao final "0148"
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario:14 Compra de credito escolar pagamento via cartao de debito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
#    E clico em Talvez Mais Tarde
    E submeto o cartao final "6091"
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:15 Compra de credito escolar - Pagamento via PIX
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
#    E clico em Talvez Mais Tarde
    E submeto pix como forma de pagamento para recarga comum
    Então visualizo a tela de codigo pix gerado para pagamento

    # Crédito desabilitado
#  Cenario:09 Compra de credito escolar Erro no pagamento via cartao de credito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "05454081051", senha "Teste123"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Escolar
#    E insiro o valor de R$ "1000"
#    E clico em Talvez Mais Tarde
#    E submeto o cartao final "0148"
#    E confirmo o pagamento informando o CVV "001"
#    Então visualizo a tela de Erro no pagamento
#
#  Cenario:10 Compra combo de credito escolar Pagamento via cartao de credito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Escolar
#    E insiro o valor de R$ "1000"
#    E continuo a recarga com pontos
#    E submeto o cartao final "6091"
#    E confirmo o pagamento informando o CVV "001"
#    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenário:16 Filtro de histórico e depois reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "36536935004", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no icone de filtro
    E filtro por periodo e uso
    Então visualizo o registro de uso do cartao

  Cenário:17 Comunicar Perda ou Roubo de Cartao Hibrido e reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Teste123"
    E vou para a minha home do aplicativo
    E clico em Conta Digital
    E volto para a home
    Quando eu clico em Cartão TOP
    E clico no botão "Comunicar Perda / Roubo"
    E clico em "Prosseguir com o cancelamento"
    Então sou direcionado para o chatbot da Pefisa via WhatsApp


  #  Recuperar cartão depois de executar este cenário
  #Step de clicar em Quero cancelar meu cartão esta manual
  Cenário:18 Comunicar Perda ou Roubo de Cartão Puro Transporte e reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "325.056.645-44", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no botão "Comunicar Perda / Roubo"
    E clico em Perdi meu cartão
    E clico em continuar o cancelamento
    E clico em quero cancelar meu cartao
    Então visualizo a tela de cancelamento enviado

  Cenário:19 Informativo Escolar Passe Livre
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51168429242", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Passe Livre
    Então visualizo a tela de beneficio escolar passe livre

  Cenario:20 Informativo escolar passe livre e depois reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51168429242", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico na opção Saiba mais no item escolar
    E clico em Duvidas sobre o seu Beneficio Escolar
    Entao sou direcionado para a pagina da EMTU de beneficio meia tarifa


  Cenário:21 Informativo senior
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "79964771088", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Senior
    Então visualizo a tela informativa do beneficio Senior

  Cenário:22 Direcionamento duvidas sobre beneficio senior e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "79964771088", senha "Teste123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Senior
    E clico no texto Central de Ajuda
    Então sou direcionado para a página do TOP Sênior na Central de Ajuda Autopass

  Cenário:23 Beneficio senior + escolar passe livre e reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "61425883303", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    Então visualizo a informação de ambos os benefícios com suas datas de validade


    #Tempo de expiração aumentado para 1 hora então não faz sentido testar
#  Cenario:14 Codigo PIX expirado para recarga escolar
##    Dado que estou na área não logada do app
##    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
##    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Escolar
#    E insiro o valor de R$ "1000"
#    E clico em Comprar
#    E submeto pix como forma de pagamento
#    E aguardo por mais de 1 minuto e meio na tela
#    Então visualizo a tela de "Código Pix Expirado"


#  Cenario: Compra de crédito escolar - Pagamento via saldo em conta
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Escolar
#    E insiro o valor de R$ "1000"
#    E clico em Comprar
#    E confirmo saldo disponível como forma de pagamento
#    E confirmo o pagamento informando a senha correta "7734"
#    Então visualizo a tela de Pagamento efetuado com sucesso
#
#  Cenario: Compra de crédito escolar - Erro no pagamento via saldo em conta
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico em Comprar Créditos
#    E clico na opção Escolar
#    E insiro o valor de R$ "1000"
#    E clico em Comprar
#    E confirmo saldo disponível como forma de pagamento
#    E confirmo o pagamento informando a senha correta "1111"
#    Então visualizo a tela de Erro no pagamento
