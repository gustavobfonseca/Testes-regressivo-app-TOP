# language: pt

Funcionalidade: Cadastro

  Cenário: Cadastro com sucesso
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E submeto os demais dados corretamente até a finalização do formulário
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email
    E clico em confirmar email
    E insiro a senha "Devires@123"
    E confirmo a nova senha "Devires@123"
    E clico em confirmar cadastrar senha
    E aceito os termos de uso e privacidade
    Entao visualizo o modal de "Cadastro realizado com sucesso".

  Cenário: Dados pessoais em branco
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E clico no botão "Continuar" com os demais campos em branco
    Entao visualizo as mensagens de campos obrigatórios nos campos em branco.

  Cenário: Cadastro com CPF já cadastrado
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF já cadastrado
    Entao visualizo o modal de "CPF já cadastrado".

  Cenario: CPF inválido
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF inválido para cadastro
    E submeto os demais dados corretamente até a finalização do formulário
    Entao visualizo a mensagem de "CPF inválido" no campo CPF.

  Cenário: E-mail inválido
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E informo e-mail fora do padrão sem "@"
    E clico em "Continuar" com os demais campos preenchidos corretamente, menos o e-mail
    Entao visualizo a mensagem de "E-mail inválido" no campo "E-mail".

  Cenário: Celular inválido
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E informo DDD + celular com menos de 11 dígitos
    E clico em "Continuar" com os demais campos preenchidos corretamente, menos o celular
    Entao visualizo a mensagem de "Telefone inválido" no campo "Celular".
    E informo DDD + celular inválido sem começar com 9
    Entao visualizo a mensagem de "Telefone inválido" no campo "Celular".

  Cenário: Usuário menor de idade
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E informo a data de nascimento menor que 13 anos
    E clico em "Continuar" com os demais campos preenchidos dentro dos critérios de aceite, menos a data de nascimento
    Entao visualizo a mensagem de "Não é possível cadastrar menores de idade" no campo "Data de nascimento"

  Cenário: Cadastro com Token SMS inválido
    Dado que estou na área não logada do app
    E acesso a opção "Criar uma conta"
    E clico em 'Continuar' informando todos os dados pessoais corretamente
    E insiro o token sms invalido
    E clico em confirmar sms
    Então visualizo o modal de código inválido

  Cenário: Reenviar Token SMS
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E clico em 'Continuar' informando todos os dados pessoais corretamente
    E clico em "REENVIAR CÓDIGO" após término do contador SMS
    Então recebo um novo código atualizado via SMS


  Cenário: Cadastro com Token E-mail inválido
    Dado que estou na área não logada do app
    E acesso a opção "Criar uma conta"
    E clico em 'Continuar' informando todos os dados pessoais corretamente
    E insiro o token sms
    E clico em confirmar sms
    E insiro o token email invalido
    E clico em confirmar email
    Então visualizo o modal de código inválido

  Cenário: Reenviar Token E-mail
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E clico em 'Continuar' informando todos os dados pessoais corretamente
    E insiro o token sms
    E clico em confirmar sms
    E clico em "REENVIAR CÓDIGO" após término do contador e-mail
    Então recebo um novo código atualizado via e-mail

  Cenário: Editar meu número de celular
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E informo o número de telefone errado "11911234567"
    E clico em "Continuar" com os demais campos preenchidos corretamente, menos o celular
    E clico em "Editar meu número de celular"
    E clico em "CONFIRMAR NÚMERO" após inserir um novo número de celular
    Então o modal é fechado exibindo a tela de confirmação com os 4 últimos dígitos do número atualizado

  Cenário: Editar meu endereço de e-mail
    Dado que estou na área não logada do app
    Quando acesso a opção "Criar uma conta"
    E informo um CPF válido ainda não cadastrado
    E informo o endereço de e-mail errado "email.errado@gmail.com"
    E clico em "Continuar" com os demais campos preenchidos corretamente, menos o e-mail
    E insiro o token sms
    E clico em confirmar sms
    E clico em "Editar meu endereço de e-mail"
    E clico em "CONFIRMAR E-MAIL" após inserir um novo e-mail
    Então o modal é fechado exibindo a tela de confirmação com o e-mail atualizado

    Cenário: Validação dos requisítos da senha
      Dado que estou na área não logada do app
      Quando acesso a opção "Criar uma conta"
      E informo um CPF válido ainda não cadastrado
      E submeto os demais dados corretamente até a finalização do formulário
      E insiro o token sms
      E clico em confirmar sms
      E insiro o token email
      E clico em confirmar email
      Entao verifico os criterios de aceite do campo "Sua senha" validando o estado do botão "Confirmar" e visualizando os checks nos requisítos da senha
