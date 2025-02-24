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

  Cenário:03 Pontos de Ônibus e Metrô
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando clico na opção "Mobilidade"
    E insiro um endereco de origem e destino
    E clico em Onibus e Metro

  Cenário:04 Rotas e trajetos
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando clico na opção "Mobilidade"
    E insiro um endereco de origem e destino
    Então visualizo a lista de rotas ate o destino

  Cenário:05 Selecao de trajeto
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste@123"
    E vou para a minha home do aplicativo
    Quando clico na opção "Mobilidade"
    E insiro um endereco de origem e destino
    E seleciono uma das rotas listadas
    E arrasto o modal pra cima

  Cenário:06 Encerrar viagem
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando clico na opção "Mobilidade"
    E insiro um endereco de origem e destino
    E seleciono uma das rotas listadas
    E arrasto o modal pra cima
    E deslizo o modal até o final
    E clico em encerrar viagem

  Cenário:07 Re-centralizacao
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "54926406829", senha "Teste123"
    E vou para a minha home do aplicativo
    Quando clico na opção "Mobilidade"
    E arrasto o mapa
    E clico em re centralizar
    Então o mapa centraliza para minha posição atual