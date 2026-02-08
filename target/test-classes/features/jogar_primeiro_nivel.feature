# language: pt

Funcionalidade: Jogar primeiro nível do CodyCross

  Como jogador
  Quero acessar o primeiro nível do jogo
  Para iniciar a resolução das palavras do tema

  Cenário: Acessar o primeiro nível e preencher a primeira palavra

    Dado que o aplicativo CodyCross foi aberto
    Quando acesso o primeiro nível do jogo
    E seleciono as letras da palavra inicial
    Então o progresso do nível deve ser atualizado