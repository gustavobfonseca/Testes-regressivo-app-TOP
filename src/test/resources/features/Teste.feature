# language: pt
Funcionalidade: Teste

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