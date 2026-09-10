🎓 Sistema Unicsul

Sistema desktop desenvolvido em **Java** para gerenciamento de alunos dos campi da Universidade Cruzeiro do Sul (Unicsul).

O projeto foi desenvolvido como atividade acadêmica com o objetivo de aplicar conceitos de **Estruturas de Dados**, utilizando **Árvores Binárias de Busca** para armazenar, localizar e organizar os alunos.


📋 Sobre o Projeto

O sistema permite cadastrar alunos em diferentes campi da Unicsul, localizar um aluno cadastrado e listar os alunos de um determinado campus em ordem alfabética.

Cada campus possui sua própria árvore binária.


🚀 Funcionalidades

- 👨‍🎓 Cadastro de novos alunos
- 🏫 Seleção do campus do aluno
- 🔎 Localização de alunos
- 🚫 Impedimento de cadastro duplicado
- 📋 Listagem de alunos por campus
- 🔤 Listagem em ordem alfabética
- 🌳 Utilização de Árvores Binárias de Busca
- 🖥️ Interface gráfica utilizando Java Swing


🏫 Campi

O sistema possui uma árvore binária independente para cada campus:

- Anália Franco
- Guarulhos
- Liberdade
- Paulista
- São Miguel
- Santo Amaro
- Villa Lobos


🛠️ Tecnologias utilizadas

- ☕ Java
- 🖥️ Java Swing
- 🌳 Árvore Binária de Busca
- 💻 Visual Studio Code

📂 Estrutura do Projeto

SISTEMA UNICSUL
│
├── Main.java
├── No.java
├── ArvoreBinaria.java
├── SistemaUnicsul.java
├── TelaPrincipal.java
├── TelaCadastro.java
├── TelaLocalizar.java
└── TelaListar.java


🌳 Árvore Binária

Cada campus possui sua própria árvore binária.

A inserção dos alunos segue a seguinte regra:

          Nome
         /    \
    Menores  Maiores


Nomes menores ficam à esquerda.

Nomes maiores ficam à direita.

Para listar os alunos em ordem alfabética, é utilizado o percurso Em Ordem (In-Order):


🔎 Localização

Ao pesquisar um aluno, o sistema verifica todas as árvores dos campi.

Caso o aluno seja encontrado, o sistema informa em qual campus ele está cadastrado.

Caso contrário, apresenta uma mensagem informando que o aluno não foi localizado.


🚫 Cadastro duplicado

Antes de inserir um novo aluno, o sistema verifica se o nome já existe em alguma das árvores.

Caso o aluno já esteja cadastrado, o sistema impede um novo cadastro.


🖥️ Interface

A interface gráfica foi desenvolvida utilizando Java Swing, contendo três funcionalidades principais:

Cadastrar Novo Aluno

Permite informar o nome do aluno e selecionar seu campus.

Localizar Aluno

Permite pesquisar um aluno em todos os campi.

Listar Alunos

Permite selecionar um campus e visualizar seus alunos em ordem alfabética.


🎯 Objetivo Acadêmico

O projeto tem como objetivo aplicar conceitos de Estruturas de Dados, principalmente:

Árvores Binárias de Busca
Nós
Inserção
Busca
Percurso em ordem
Organização de dados
Interface gráfica em Java


👨‍💻 Projeto Acadêmico

Projeto desenvolvido para fins acadêmicos no curso de Ciência da Computação.

Sistema Unicsul — Gerenciamento de Alunos
