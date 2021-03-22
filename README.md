# Banco

Sistema bancário para gerenciamento de finanças e transações.

Exemplo simples para fixação de conteúdo, neste podemos simular e gerenciar uma ação de um cliente dentro do fluxo de um banco.

![Banco](https://github.com/lucasscaramelo/banco/blob/develop/imagens/sistema_banc%C3%A1rio.png)

Arquitetura Maven, se necessário execute:

> mvn clean install

**Instalar extensão para suporte do Lombok(depende de sua IDE).**


Para concluir, não podemos deixar de fora os testes unitários, para executar use o comando:

> mvn test

Com a dependência do Pitest instalada em nosso projeto, podemos executar testes mutantes 🙂

Abra o prompt de comando na raiz do projeto e execute:

>mvn org.pitest:pitest-maven:mutationCoverage

Para saber mais sobre testes mutantes, acesse o projeto Pitest 😉
