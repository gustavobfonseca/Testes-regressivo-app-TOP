# language: pt
Funcionalidade: Login

  Cenário:01 Login com credenciais invalidas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais inválidas para login
    Entao visualizo o modal de CPF e, ou Senha inválidos

  Cenário:02 login com usuario bloqueado
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais bloqueadas para login
    Entao visualizo o modal de usuário bloqueado

  Cenário:03 Recuperação de senha com CPF bloqueado
    Dado que estou na área não logada do app
    E que acesso a opção esqueci minha senha na área não logada
    Quando informo um CPF bloqueado
    Entao visualizo o modal de usuário bloqueado na tela de esqueci minha senha


  Cenário:04 Recuperacao de senha com CPF invalido
    Dado que estou na área não logada do app
    E que acesso a opção esqueci minha senha na área não logada
    Quando informo um CPF inválido
    Entao visualizo a mensagem de Documento inválido
    E clico em cancelar

  Cenário:05 Login atraves da recuperacao de senha
    Dado que estou na área não logada do app
    E que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "06193372067" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a senha "Teste1234"
    E confirmo a nova senha "Teste1234"
    E clico em confirmar redefinir senha
    Entao acesso a tela home do aplicativo

  Cenário:06 Login com senha antiga
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '06193372067' e senha 'Teste123'
    Entao visualizo o modal de CPF e, ou Senha inválidos

  Cenário:07 Login com nova senha
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '06193372067' e senha 'Teste1234'
    Entao acesso a home do aplicativo
    E redefino a senha

  Cenário:08 Recuperacao de senha com token SMS invalido
    Dado que estou na área não logada do app
    E que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "06193372067" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms invalido
    E clico em confirmar sms
    Entao visualizo o modal de codigo invalido

  Cenário:09 Recuperacao de senha com token Email invalido
    Dado que estou na área não logada do app
    E que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "06193372067" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email invalido
    E clico em confirmar email
    Entao visualizo o modal de codigo invalido

  Cenário:10 Recuperacao de senha com senha invalida
    Dado que estou na área não logada do app
    E que acesso a opção esqueci minha senha na área não logada
    Quando informo o seguinte CPF "06193372067" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    Entao verifico os criterios de aceite dos campos "Sua senha" e "Confirmar senha" validando as mensagens exibidas

#  Cenário:13 Login através da recuperação de senha
#    Dado que estou na área não logada do app
#    E que acesso a opção esqueci minha senha na área não logada
#    Quando informo o seguinte CPF "06193372067" que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'
#    E insiro o token sms
#    E clico em confirmar sms
#    E insiro o token email
#    E clico em confirmar email
#    E insiro a senha "Devires@123"
#    E confirmo a nova senha "Devires@123"
#    E clico em confirmar redefinir senha
#    Entao acesso a tela home do aplicativo

  Cenário:11 Login com as credenciais validas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login, cpf '06193372067' e senha 'Teste123'
    Entao acesso a home do aplicativo

#  Cenario: Atendimento usuário bloqueado
#    Dado que estou na área não logada do app
#    Quando submeto minhas credenciais bloqueadas para login
#    E visualizo o modal de usuário bloqueado
#    E clico no botão 'Atendimento via Whatsapp' no modal
#    Entao sou direcionado para o WhatsApp da Central de atendimento Autopass

  Cenário:12 Central de Ajuda
    Dado que estou na área não logada do app
    Quando clico na opção "Central de Ajuda"
    E clico no botão Enviar mensagem
    Entao sou direcionado para o WhatsApp da Central de atendimento Autopass