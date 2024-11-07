# language: pt
Funcionalidade: Vantagens

  Cenário:01 Modal TOP+ Recompensas
    Dado que estou na área não logada do app
    E logo com uma conta recem criada com mais de sessenta anos
    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    E clico em TOP+ recompensas
    Então visualizo o onboarding do TOP + recompensas

  Cenário:02 Onboarding TOP+ Recompensas
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada com mais de sessenta anos
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    E clico em TOP+ recompensas
    Quando avanco pelas tres etapas do onboarding
    Então sou direcionado para a webview na Minu

  Cenário:03 Pular onboarding TOP+ recompensas
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada com mais de sessenta anos
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    E clico em TOP+ recompensas
    Quando clico em Pular na primeira tela do onboarding
    Então sou direcionado para a webview na Minu

  Cenário:04 Não ver mais o Onboarding TOP+ Recompensas
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada com mais de sessenta anos
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    E clico em TOP+ recompensas
    Quando clico em nao mostrar mais
    E sou direcionado para a webview na Minu
    E fecho a webview da Minu
    E dou scroll até Minhas Vantagens
    E clico em TOP+ recompensas
    Então sou direcionado para a webview na Minu

  Cenário:05 Guia de servicos TOP Saude
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada com mais de sessenta anos
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    Quando eu acesso o TOP Saude
    Então sou direcionado para a pagina de guia medico da AVUS

  Cenário:06 Saiba mais sobre o TOP Saude
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada com mais de sessenta anos
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    Quando eu acesso o TOP Saude
    E clico em Saiba mais
    Então sou direcionado para a pagina do TOP Saude

  Cenário:07 TOP Saude e reseto o app
#    Dado que estou na área não logada do app
#    E logo com uma conta recem criada com mais de sessenta anos
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    Quando eu acesso o TOP Saude
    E clico em Quero Contratar
    Então sou direcionado para a webview da Avus

  Cenário:08 Desconto em loja fisica Drogaria São Paulo
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    E dou scroll até Drogaria São Paulo
    E clico em Drogaria Sao Paulo
    Quando eu clico em Buscar Loja
    Então sou direcionado para a página institucional da Drogaria Sao Paulo

  Cenário:09 Desconto pelo site da Drogaria Sao Paulo
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    E dou scroll até Drogaria São Paulo
    E clico em Drogaria Sao Paulo
    Quando eu clico em desconto pelo site
    E clico em ir para o site
    Então sou direcionado para o login na Drogaria Sao Paulo

  Cenário:10 Personalizar favoritos
#    Dado que estou na área não logada do app
#    E submeto as seguintes credenciais validas para login, cpf "11335685995", senha "Devires@123"
#    E vou para a minha home do aplicativo
    E dou scroll até Minhas Vantagens
    E clico em Personalizar Favoritos
    E troco a ordem de exibição das vantagens
    Então retorno a home com a exibicao dos menus de vantagens ordenados de acordo com a minha escolha
    E o menu de personalizar favoritos deve estar por utilmo