# FEItv

## Sobre o Projeto
O FEItv é uma plataforma de vídeos desenvolvida com base no YouTube aplicando os conceitos de JDBC, MVC e POO.

## Tecnologias Utilizadas
- **Java** - Linguagem de programação principal
- **Swing** - Interface gráfica (GUI)
- **JDBC** - Conexão com banco de dados
- **PostgreSQL** - Banco de dados
- **MVC** - Arquitetura (Model, View, Controller)

## Funcionalidades
- Cadastro de usuário
- Login de usuário
- Lista de vídeos na tela principal
- Barra de pesquisa por nome de vídeo
- Visualização de informações dos vídeos
- Curtir e Descurtir vídeos
- Criar, Editar e Excluir listas de reprodução (Favoritos)
- Adicionar e Remover vídeos das listas de reprodução

## Banco de Dados
Banco de dados utilizado é o PostgreeSQL, As tabelas são:

- **usuario** - Armazena os dados dos usuários
- **video** - Armazena os dados dos vídeos
- **curtida** - Relaciona usuários e vídeos curtidos
- **lista_reproducao** - Armazena as listas de reprodução
- **video_lista** - Relaciona vídeos e listas de reprodução

## Passo a Passo como executar
1. Clone o repositório:
  https://github.com/Sartori2/FEItv.git
2. Crie o banco de dados rodando o script sql **/database_feitv.sql**
3. Configure a sua senha do banco de dados no arquivo **Conexao.java**
   (troque o campo "fei" pela sua senha)
4. Execute o projeto no NetBeans

## Autoria
Feito por **Renan Sartori**
