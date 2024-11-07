# language: pt
Funcionalidade: Cartão Top

  Cenario:01 Compra de crédito comum - Erro no pagamento via cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "05454081051", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario:02 Compra de crédito comum - Pagamento via cartão de crédito

    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:03 Compra de crédito comum Erro no pagamento via cartão de débito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "32772147886", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario:04 Compra de crédito comum - Pagamento via cartão de débito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "32772147886", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:05 Compra de crédito comum - Pagamento via pix
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto pix como forma de pagamento
    Então visualizo a tela de codigo pix gerado para pagamento

  Cenário:06 Código PIX expirado para recarga comum e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto pix como forma de pagamento
    E aguardo por mais de 1 minuto e meio na tela
    Então visualizo a tela de "Código Pix Expirado"

  Cenario:07 Compra de crédito comum - Erro no pagamento via saldo em conta
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Devires@123"
#    E vou para a minha home do aplicativo
#    E eu clico no botao do mock gemalto token
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1111"
    Então visualizo a tela de Erro no pagamento

  Cenario:08 Compra de crédito comum - Pagamento via saldo em conta e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Devires@123"
#    E vou para a minha home do aplicativo
    E eu clico no botao do mock gemalto token
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1571"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:09 Compra de crédito escolar - Erro no pagamento via cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "05454081051", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario:10 Compra de crédito escolar - Pagamento via cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "05454081051", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario:11 Compra de crédito escolar - Erro no pagamento via cartão de débito
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "05454081051", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario:12 Compra de crédito escolar - Pagamento via PIX
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto pix como forma de pagamento
    Então visualizo a tela de codigo pix gerado para pagamento

  Cenario:13 Código PIX expirado para recarga escolar e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto pix como forma de pagamento
    E aguardo por mais de 1 minuto e meio na tela
    Então visualizo a tela de "Código Pix Expirado"

  Cenario:14 Informativo escolar - meia tarifa e depois reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de saldo
    E clico na opção Saiba mais no item escolar
    Entao visualizo a tela de beneficio escolar meia tarifa
    E reseto o app

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

  Cenário:15 Comunicar Perda ou Roubo de Cartão Híbrido
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no botão "Comunicar Perda / Roubo"
    E clico em "Prosseguir com o cancelamento"
    Então sou direcionado para o chatbot da Pefisa via WhatsApp

  Cenário:16 Beneficio escolar passe livre
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    Então visualizo a informação do benefício Passe Livre com a data de validade

  Cenário:17 Direcionamento para as dúvidas sobre beneficio passe livre
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Passe Livre
    E clico na label de Dúvidas sobre seu benefício escolar?
    Então sou direcionado para a pagina de beneficio escolar EMTU

  Cenário:18 Direcionamento para as dúvidas sobre o benefício passe escolar e depois reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "51168429242", senha "Devires@123"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Passe Livre
    Então sou direcionado para a pagina da EMTU de beneficio escolar

  Cenário:19 Filtro de histórico e depois reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "40302598472", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no icone de filtro
    E filtro por periodo e uso
    Então visualizo o registro de uso do cartao

  Cenário:20 Beneficio sênior
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "79964771088", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    Então visualizo a informação do benefício Sênior com a data de validade

  Cenário:21 Informativo sênior
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "79964771088", senha "Laura107"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Senior
    Então visualizo a tela informativa do beneficio Senior

  Cenário:22 Direcionamento dúvidas sobre benefício sênior e reseto o app
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "79964771088", senha "Laura107"
#    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    E clico no icone Saiba Mais no item Senior
    E clico no texto Central de Ajuda
    Então sou direcionado para a página do TOP Sênior na Central de Ajuda Autopass

  Cenário:23 Beneficio sênior + escolar passe livre e reseto o app
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "61425883303", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de beneficios
    Então visualizo a informação de ambos os benefícios com suas datas de validade

#  Cenário:24 Comunicar Perda ou Roubo de Cartão Puro Transporte
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "18167741974", senha "Devires@123"
#    E vou para a minha home do aplicativo
#    Quando eu clico em Cartão TOP
#    E clico no botão "Comunicar Perda / Roubo"
#    E clico em Perdi meu cartão
#    E clico em continuar o cancelamento
#    E clico em quero cancelar meu cartao

  Cenário:25 Onboarding puro transporte e reseto o app
    Dado que estou na área não logada do app
    E logo com uma conta recem criada
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no botão Eu Quero
    E seleciono a opção receber em casa
    Então sou direcionado para o serviço de cartão da Pacman

  Cenário:26 Opção de recebimento do cartão para usuário 60+
    Dado que estou na área não logada do app
    E logo com uma conta recem criada com mais de sessenta anos
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no botão Eu Quero
    E clico em Continuar
    Então so devo visualizar o elemento de retirar na loja