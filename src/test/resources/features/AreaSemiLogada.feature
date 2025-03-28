# language: pt
Funcionalidade: Área Semi Logada

  Cenário:01 Recuperação de senha e reseto o app
    Dado que estou na área não logada do app
    Quando que realizo o logout para a área semi logada do app, estando com a biometria habilitada
#    Dado que acesso a área semi logada do aplicativo
    E clico em Esqueci minha senha.
    E informo o seguinte CPF "06193372067" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a senha "Teste123"
    E confirmo a nova senha "Teste123"
    E clico em confirmar redefinir senha
    Então acesso a tela home do aplicativo

  Cenário:02 Login com biometria e reseto o app
    Dado que estou na área não logada do app
    Quando que realizo o logout para a área semi logada do app, estando com a biometria habilitada
    E clico em "Entrar" na área semi logada
    Então visualizo a solicitação de biometria para login

  Cenário:03 Login com senha e reseto o app
    Dado que estou na área não logada do app
    Quando que realizo o logout para a área semi logada do app, estando com a biometria desabilitada
    E submeto a senha correta do CPF
    E clico em "Entrar" na área semi logada
    Então sou logado para a home do aplicativo com o modal de ativação de biometria

  Cenário:04 Login com senha incorreta e reseto o app
    Dado que estou na área não logada do app
    Quando que realizo o logout para a área semi logada do app, estando com a biometria desabilitada
    E submeto a senha incorreta para o CPF
    E clico em "Entrar" na área semi logada
    Então visualizo o modal de CPF e, ou senha incorretos

  Cenário:05 Logout para a área não logada e reseto o app
    Dado que estou na área não logada do app
    Quando que acesso a área semi logada do aplicativo
    E clico em Trocar de conta
    E confirmo no modal
    Então sou direcionado para a tela da área não logada

  Cenário:06 Mapa das Estações e reseto o app
    Dado que estou na área não logada do app
    Quando que acesso a área semi logada do aplicativo
    E acesso a opção Mapa das Estações
    Então visualizo o Mapa do Transporte Metropolitano de SP

  Cenário:07 Central de Ajuda e reseto o app
    Dado que estou na área não logada do app
    Quando que acesso a área semi logada do aplicativo
    E acesso a opção "Central de Ajuda"
    Então visualizo a página inicial da Central de Ajuda Autopass

  Cenário:08 Bilhetes offline
    Dado que estou na área não logada do app
    Quando que acesso o menu "Bilhetes QR Code" tendo bilhetes disponíveis para utilização
    E vou até o perfil do usuario
    E faço o logoff do app para a área semi logada
    E acesso a opção "Bilhetes Offline"
    Então visualizo meus bilhetes disponíveis para utilização
