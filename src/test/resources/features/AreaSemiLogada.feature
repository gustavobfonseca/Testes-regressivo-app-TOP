# language: pt
Funcionalidade: Área semi logada

  Cenário:01 Recuperação de senha
    Dado que realizo o logout para a área semi logada do app, estando com a biometria habilitada
    Dado que acesso a área semi logada do aplicativo
    Quando clico em "Esqueci minha senha."
    Quando informo o seguinte CPF "13715099054" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a senha "Devires@123"
    E confirmo a nova senha "Devires@123"
    E clico em confirmar redefinir senha
    Entao acesso a tela home do aplicativo

  Cenário: Login com biometria
    Dado que realizo o logout para a área semi logada do app, estando com a biometria habilitada
    Quando clico em "Entrar" na área semi logada
    Então visualizo a solicitação de biometria para login

  Cenário: Login com senha
    Dado que realizo o logout para a área semi logada do app, estando com a biometria desabilitada
    Quando submeto a senha correta do CPF
    E clico em "Entrar" na área semi logada
    Então sou logado para a home do aplicativo com o modal de ativação de biometria

  Cenário: Login com senha incorreta
    Dado que realizo o logout para a área semi logada do app, estando com a biometria desabilitada
    Quando submeto a senha incorreta para o CPF
    E clico em "Entrar" na área semi logada
    Então visualizo o modal de CPF e, ou senha incorretos

  Cenário: Logout para a área não logada
    Dado que acesso a área semi logada do aplicativo
    Quando clico em "Trocar de conta"
    E confirmo no modal
    Então sou direcionado para a tela da área não logada
