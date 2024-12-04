# language: pt
Funcionalidade: Onboarding Banking

#  OBS: Este cenário so funciona com CPFs cadastrados pela pefisa,
#  antes de executar os testes na funcionalidade garanta que as massas estão corretas
#  OBS2: Esta funcionalidade não é 100% automática, pois os cenários dependem de fotos
#  de documentos reais, portanto fique atento na execução do cenário e atue só quando necessário

  Cenário:01 Onboarding conta digital
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "12508818976", senha "Devires@123"
    E acesso a home do aplicativo
    Quando navego ate conta digital
    E clico em Quero Analisar Meu perfil
    E preencho o sexo e informações de endereço
    E permito o usoda camera pelo app
    E clico em abrir a camera
#    Esta etapa do fluxo é manual
    E envio uma selfie
    E seleciono RG
#    Essa etapa do fluxo é manual
    E envio uma foto do RG
    E confirmo as informações do RG
    E confirmo as informacoes adicionais
    E confirmo a oferta de Conta Digital e Cartao de Debito
    E aceito os termos e condicoes da conta digital top
    E aceito as politicas de privacidade
#    Essa etapa do fluxo é manual
    E assino meu nome
    E confirmo recebimento em casa
    Entao visualizo a tela de solicitacao enviada para conta digital

  Cenário:02 Onboarding cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "57314533814", senha "Devires@123"
    E acesso a home do aplicativo
    Quando navego ate cartao de credito
    E clico em Quero Analisar Meu perfil
    E preencho o sexo e informações de endereço
    E permito o usoda camera pelo app
    E clico em abrir a camera
#    Esta etapa do fluxo é manual
    E envio uma selfie
    E seleciono RG
#    Essa etapa do fluxo é manual
    E envio uma foto do RG
    E confirmo as informações do RG
    E confirmo as informacoes adicionais
    E confirmo a oferta de Conta Digital e Cartao de Credito
    E informo a data de vencimento do cartao
    E aceito os termos e condicoes da conta digital top e os termos de contrato do cartao
    E aceito as politicas de privacidade
#    Essa etapa do fluxo é manual
    E assino meu nome
    E confirmo recebimento em casa
    Entao visualizo a tela de solicitacao enviada para conta digital

  Cenário:03 Update para conta digital
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "47821943827", senha "Devires@123"
    E acesso a home do aplicativo
    E eu clico em Cartão TOP
    E volto para o menu
    Quando navego ate conta digital
    E clico em Quero Analisar Meu perfil
    E preencho o sexo e informações de endereço
    E permito o usoda camera pelo app
    E clico em abrir a camera
#    Esta etapa do fluxo é manual
    E envio uma selfie
    E seleciono RG
#    Essa etapa do fluxo é manual
    E envio uma foto do RG
    E confirmo as informações do RG
    E confirmo as informacoes adicionais
    E visualizo a opcao Manter apenas funcao Transporte
    E confirmo a oferta de Conta Digital e Cartao de Debito
    E aceito os termos e condicoes da conta digital top
    E aceito as politicas de privacidade
#    Essa etapa do fluxo é manual
    E assino meu nome
    E confirmo recebimento em casa
    Entao visualizo a tela de solicitacao enviada para conta digital

  Cenário:04 Update para cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "49513505804", senha "Devires@123"
    E acesso a home do aplicativo
    E eu clico em Cartão TOP
    E volto para o menu
    Quando navego ate cartao de credito
    E clico em Quero Analisar Meu perfil
    E preencho o sexo e informações de endereço
    E permito o usoda camera pelo app
    E clico em abrir a camera
#    Esta etapa do fluxo é manual
    E envio uma selfie
    E seleciono RG
#    Essa etapa do fluxo é manual
    E envio uma foto do RG
    E confirmo as informações do RG
    E confirmo as informacoes adicionais
    E confirmo a oferta de Conta Digital e Cartao de Credito
    E informo a data de vencimento do cartao
    E aceito os termos e condicoes da conta digital top e os termos de contrato do cartao
    E aceito as politicas de privacidade
#    Essa etapa do fluxo é manual
    E assino meu nome
    E confirmo recebimento em casa
    Entao visualizo a tela de solicitacao enviada para conta digital

  Cenário:05 Inibição de upgrade de conta digital para cartão de crédito
    Dado que estou na área não logada do app
    E submeto as seguintes credenciais validas para login, cpf "51919740856", senha "Devires@123"
    E acesso a home do aplicativo
    Quando navego ate cartao de credito
    Então visualizo a tela de inibição de upgrade
