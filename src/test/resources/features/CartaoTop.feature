# language: pt
Funcionalidade: Cartão Top

  Cenario: Compra de crédito comum - Erro no pagamento via cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "32772147886", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario: Compra de crédito comum - Pagamento via cartão de crédito

    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Compra de crédito comum - Erro no pagamento via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "32772147886", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario: Compra de crédito comum - Pagamento via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "32772147886", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Compra de crédito comum - Erro no pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    E eu clico no botao do mock gemalto token
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1111"
    Então visualizo a tela de Erro no pagamento

  Cenario: Compra de crédito comum - Pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    E eu habilito o mock do token no perfil do usuario
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "7734"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Compra de crédito escolar - Erro no pagamento via cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario: Compra de crédito escolar - Pagamento via cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de crédito como forma de pagamento
    E confirmo o pagamento informando o CVV "737"
    Então visualizo a tela de Pagamento efetuado com sucesso

  Cenario: Compra de crédito escolar - Erro no pagamento via cartão de débito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto a opção Cartão de Débito como forma de pagamento
    E confirmo o pagamento informando o CVV "001"
    Então visualizo a tela de Erro no pagamento

  Cenario: Compra de crédito comum - Pagamento via pix
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto pix como forma de pagamento
    Então visualizo a tela de codigo pix gerado para pagamento
    E reseto o app

  Cenario: Informativo escolar - meia tarifa
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E expando o modal de saldo
    E clico na opção Saiba mais no item escolar
    Entao visualizo a tela de beneficio escolar meia tarifa
    E reseto o app

  Cenario: Compra de crédito escolar - Pagamento via PIX
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto pix como forma de pagamento
    Então visualizo a tela de codigo pix gerado para pagamento

  Cenario: Compra de crédito escolar - Pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "7734"
    Então visualizo a tela de Pagamento efetuado com sucesso
    E reseto o app

  Cenario: Compra de crédito escolar - Erro no pagamento via saldo em conta
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E confirmo saldo disponível como forma de pagamento
    E confirmo o pagamento informando a senha correta "1111"
    Então visualizo a tela de Erro no pagamento
    E reseto o app

  Cenario: Código PIX expirado para recarga escolar
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Escolar
    E insiro o valor de R$ "1000"
    E clico em Comprar
    E submeto pix como forma de pagamento
    E aguardo por mais de 1 minuto e meio na tela
    Então visualizo a tela de "Código Pix Expirado"

  Cenário: Comunicar Perda ou Roubo de Cartão Híbrido
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no botão "Comunicar Perda / Roubo"
    E clico em "Prosseguir com o cancelamento"
    Então sou direcionado para o chatbot da Pefisa via WhatsApp

  Cenário: Direcionamento para as dúvidas sobre o benefício passe escolar
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51168429242", senha "Devires@123"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no botao de expandir o modal de benefícios
    E clico em Saiba Mais
    Então sou direcionado para a pagina da EMTU de beneficio escolar

  Cenário: Filtro de histórico
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "40302598472", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico no icone de filtro
    E filtro por periodo e uso
    Então visualizo o registro de uso do cartao

  Cenário: Código PIX expirado para recarga comum
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "65998952049", senha "Laura107"
    E vou para a minha home do aplicativo
    Quando eu clico em Cartão TOP
    E clico em Comprar Créditos
    E clico na opção Comum
    E insiro o valor de R$ "400"
    E clico em Comprar
    E submeto pix como forma de pagamento
    E aguardo por mais de 1 minuto e meio na tela
    Então visualizo a tela de "Código Pix Expirado"