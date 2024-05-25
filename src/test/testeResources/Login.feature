# language: pt
Funcionalidade: : Login

  Cenario: 02 Login com credenciais invalidas
    Dado que estou na area não logada do app
    Quando insiro o cpf inexistente "01010101010"
    E preencho com qualquer senha dentro dos criterios de aceite {Senha@123}
    E clico no botao de entrar
    Entao visualizo o modal de CPF/Senha invalidos

  Cenario: 03 Login com usuario bloqueado
    Dado que estou na area nao logada do app
    Quando insiro o cpf bloqueado "73040542559"
    E preencho com qualquer senha dentro dos criterios de aceite {Senha1234@}
    E clico no botao de entrar
    Entao visualizo o modal com a mensagem de conta bloqueada


  Cenario: 08 Recuperacao de senha com CPF invalido
    Dado que eu acesso a opção Esqueci minha senha na área não logada
    Quando informo um CPF invalido
    Entao visualizo a mensagem de Documento invalido


  Cenario: 09 Recuperacao de senha com CPF bloqueado
    Dado que acesso a opcao esqueci minha senha na area não logada
    Quando informo um CPF bloqueado
    Entao visualizo o modal de usuário bloqueado