# language: pt
Funcionalidade: : Login

  Cenario: Login com credenciais inválidas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais inválidas para login
    Entao visualizo o modal de CPF e, ou Senha inválidos

  Cenario: Login com as credenciais validas
    Dado que estou na área não logada do app
    Quando submeto minhas credenciais válidas para login
    Entao acesso a home do aplicativo