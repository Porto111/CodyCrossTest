# language: pt
Funcionalidade: Jogar CodyCross via OCR

  Contexto:
    Dado que o aplicativo CodyCross foi aberto

  Cenário: Iniciar o jogo
    Quando eu tocar no botão Jogar
    E eu tocar no botão Salvar progresso
    Então a tela inicial do primeiro nível deve ser exibida
