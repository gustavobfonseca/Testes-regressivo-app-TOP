# language: pt

Funcionalidade: Mobilidade

  Cenário:01 Mapa das estações
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E vou para a minha home do aplicativo
    Quando clico na opção "Mapa das estações"
    Então visualizo o Mapa do Transporte Metropolitano de SP


  Cenário:02 Mobilidade
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E vou para a minha home do aplicativo
#    Quando clico na opção "Mobilidade"
    Então visualizo a tela de Disponível em breve
