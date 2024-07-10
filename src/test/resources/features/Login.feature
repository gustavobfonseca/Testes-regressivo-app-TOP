# language: pt
Funcionalidade: Login

  Cenario: 02 - Login com credenciais inválidas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais inválidas para login
    Entao visualizo o modal de CPF e, ou Senha inválidos

    Cenario: 03 - login com usuario bloqueado
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais bloqueadas para login
    Entao visualizo o modal de usuário bloqueado
    E reseto o app

  Cenario: 09 - Recuperação de senha com CPF bloqueado
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo um CPF bloqueado
    Entao visualizo o modal de usuário bloqueado na tela de esqueci minha senha
    E reseto o app

  Cenario: 08 - Recuperação de senha com CPF inválido
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo um CPF inválido
    Entao visualizo a mensagem de Documento inválido
    E clico em cancelar

  Cenario: Login através da recuperação de senha
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "32772147886" que possui o email 'lucas.kuroda@devires.com.br' e o telefone '+5514996237865'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a nova senha "Devires@1234"
    E confirmo a nova senha "Devires@1234"
    E clico em confirmar redefinir senha
    Entao acesso a tela home do aplicativo


  Cenario: Login com senha antiga
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '32772147886' e senha 'Devires@123'
    Entao visualizo o modal de CPF e, ou Senha inválidos

  Cenario: Login com nova senha
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '32772147886' e senha 'Devires@1234'
    Entao acesso a home do aplicativo
    E redefino a senha

  Cenario: Recuperacao de senha com token SMS invalido
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "32772147886" que possui o email 'lucas.kuroda@devires.com.br' e o telefone '+5514996237865'
    E insiro o token sms invalido
    E clico em confirmar sms
    Entao visualizo o modal de codigo invalido

  Cenario: Recuperacao de senha com token Email invalido
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "32772147886" que possui o email 'lucas.kuroda@devires.com.br' e o telefone '+5514996237865'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email invalido
    E clico em confirmar email
    Entao visualizo o modal de codigo invalido

  Cenario: Recuperação de senha com senha inválida
    Dado que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "32772147886" que possui o email 'lucas.kuroda@devires.com.br' e o telefone '+5514996237865'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    Entao verifico os criterios de aceite dos campos "Sua senha" e "Confirmar senha" validando as mensagens exibidas

  Cenario: 01 - Login com as credenciais validas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '32772147886' e senha 'Devires@123'
    Entao acesso a home do aplicativo

#  Cenario: Atendimento usuário bloqueado
#    Dado que estou na área não logada do app
#    Quando submeto minhas credenciais bloqueadas para login
#    E visualizo o modal de usuário bloqueado
#    E clico no botão 'Atendimento via Whatsapp' no modal     NAO ESTA FUNCIONANDO
#    Entao sou direcionado para o WhatsApp da Central de atendimento Autopass

  Cenario: Central de Ajuda
    Dado que estou na área não logada do app
    Quando clico na opção "Central de Ajuda"
    E clico no botão "Enviar mensagem"
    Entao sou direcionado para o WhatsApp da Central de atendimento Autopass
