<h1 align="center">Game Store</h1>

## Descrição do Projeto
<p align="center">Projeto criado com o objetivo de simular uma loja de games</p>

## Conteúdo
<!--ts-->

   * Imagens
   * Instalação
      * Pré Requisitos
      * Criando o banco de dados
      * Rodando o Back End (servidor)
      * Populando o banco de dados
      * Iniciando a aplicação
      * Rodando o Front End (cliente)
   * Sobre
      * End Points
      * Tecnologias
      * Libs
   * Considerações
      
      
<!--te-->

## Imagens

- Página inicial:

![Print - pagina inicial](https://user-images.githubusercontent.com/63609321/119279786-506ace00-bc04-11eb-9228-29cc58cab09d.png)

![print - pagina inicial produtos row](https://user-images.githubusercontent.com/63609321/119279810-755f4100-bc04-11eb-91ed-401560657816.png)


- Página inicial (Produtos no carrinho):

![Print - pagina inicial carrinho com produtos](https://user-images.githubusercontent.com/63609321/119279804-6d070600-bc04-11eb-8530-d38dd2536e37.png)

- Carrinho:

![Print - Carrinho](https://user-images.githubusercontent.com/63609321/119279828-8dcf5b80-bc04-11eb-9427-1f08a1b44ac7.png)

![Print - Tabela produtos no carrinho](https://user-images.githubusercontent.com/63609321/119279846-9de73b00-bc04-11eb-8f51-99d4746dc239.png)

- Finalizar compra:

![Print -  Finalizar compra](https://user-images.githubusercontent.com/63609321/119279878-c40cdb00-bc04-11eb-9110-6bdd12fda55a.png)

![Print - Form finalizar compra](https://user-images.githubusercontent.com/63609321/119279881-c707cb80-bc04-11eb-8bfb-941cd0a38af7.png)


## Instalação
  
 ### Pré Requisitos:

- [Instalar Eclipse IDE for Enterprise Java and Web Developers](https://www.eclipse.org/downloads/packages/release/2021-03/r/eclipse-ide-enterprise-java-and-web-developers)
- [Instalar VSCode](https://code.visualstudio.com/download)
- [Instalar MariaDB](https://mariadb.org/download/)
- [Instalar React](https://nodejs.org/en/download/)
  
<p align="center">
  
  ### Criando o banco de dados:
  ```bash
  # No HeidiSQL, acesse o usuário que você criou durante a instalação
  # Clique com o botão direito em cima do nome do seu usuário e:
    (Criar novo -> Banco de dados -> Nome: game_store_db -> Colação: (Mantenha a que já está pré-selecionada) -> ok 
  # Realize os próximos passos para que as tabelas sejam criadas
  ```  
  
  
  ### 🎲 Rodando o Back End (servidor):

```bash
# Clone este repositório
$ git clone <https://github.com/VitorNilson/teste-game-store.git>

# Utilize uma IDE para abrir o prjeto (Dê prefrência pela IDE Eclipse for Enterprise Java)
# Abra o workspace na pasta raiz
# Importe a pasta Ps-React-Java como maven:
  ( File -> Import -> Maven -> Existing Maven Projects -> Browse -> PS-React-Java -> Finish )
# Aguarde as dependências serem baixadas
# Vá até a pasta src/main/resources e edite o application.properties: 

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://(link_do_seu_data_base)/(nome_do_data_base_criado_anteriormente)
spring.datasource.username=(seu_user)
spring.datasource.password=(sua_senha)
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

  # Abra a classe (Application.java):
  ( src/main/java -> br.com.supera.game.store -> Application.java )
  # Rode a classe para que o projeto se inicialize e sejam criadas as tabelas no banco de dados
  $ run as java application
  
  ```
  
  ### Populando o banco de dados:
  
  ```bash
  # Execute o comando abaixo para que o banco de dados seja populado
  
  ## Observe que o nome do meu banco de dados é game_store_db, recomendo que faça o mesmo para poupar tempo.
  
  ```sql  
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('312', 'https://cdn.awsli.com.br/600x450/1105/1105463/produto/61074565/386e2e64e8.jpg', 'Super Mario Odyssey', '197.88', '100');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('201', 'https://images-americanas.b2w.io/produtos/01/00/item/129427/9/129427953_1GG.png', 'Call Of Duty Infinite Warfare', '49.99', '80');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('102', 'https://cdn.awsli.com.br/600x450/396/396949/produto/13308398/990fa70215.jpg', 'The Witcher III Wild Hunt', '119.50', '250');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('99', 'https://upload.wikimedia.org/wikipedia/pt/1/18/Call_of_Duty_WWII_Cover_Art.jpg', 'Call Of Duty WWII', '249.99', '205');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('12', 'https://images-americanas.b2w.io/produtos/01/00/offers/01/00/item/126077/6/126077695_1GG.png', 'Mortal Kombat XL', '69.99', '150');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('74', 'https://http2.mlstatic.com/D_NQ_NP_759901-MLB41945098264_052020-O.jpg', 'Shards of Darkness', '71.94', '400');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('31', 'https://i.zst.com.br/thumbs/12/1f/f/28021744.jpg', 'Terra Média: Sombras de Mordor', '79.99', '50');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('420', 'https://upload.wikimedia.org/wikipedia/pt/e/e0/FIFA_18_Capa.jpg', 'FIFA 18', '195.39', '325');
INSERT INTO `game_store_db`.`product` (`id`, `image`, `name`, `price`, `score`) VALUES ('501', 'https://cdn.cdkeys.com/700x700/media/catalog/product/h/o/horizon-zero-dawn.jpg', 'Horizon Zero Dawn', '115.8', '290');

  
  ``` 
</p>
  
  ### Iniciando a aplicação:  
  ```bash
  
  # Retorne à Eclipse IDE e rode novamente a classe Application.java
  
  ```
  
Finalmente temos o back-end rodando. Para verificar os dados em Json acesse: http://localhost:8080/produtos 

  
  ### 🎲 Rodando o Front End (cliente):
  ```bash
  
  # Abra o prompt de comandos e acesse a pasta (React -> ps-react-java)
  $ cd react/ps-react-java
  
  # Dentro do diretório ps-react-java digite o comando abaixo para abrir o projeto no VSCODE:
  $ code .
  
  # Com o projeto aberto, na aba superior clique em (Terminal -> New Terminal)
  # No terminal digite o comando:
  $ npm install
  
  # Após as dependencias terem sido instaladas:
  $ npm start
  
  # Caso você receba o erro abaixo:
    > ps-react-java@0.1.0 start
    > react-scripts start

    'react-scripts' não é reconhecido como um comando interno
    ou externo, um programa operável ou um arquivo em lotes.
  # Digite o comando:
  $ npm install react-scripts@2.1.8
  $ npm start
  
  ```
Front End rodando. Acesse: http://localhost:3000/
  
  # Sobre
  
  ### EndPoints:
  
  A API possui os seguintes EndPoints:
  
  - http://localhost:8080/produtos (Lista todos os produtos)
  - http://localhost:8080/produtos?sortBy={requisito_de_ordenamento} (Ordena os produtos pelo requisito passado, ex: "name", "score", "price")
  - http://localhost:8080/produtos/carrinho (Lista todos os produtos dentro do carrinho)
  - http://localhost:8080/produtos/carrinho/size (Retorna a quantidade de itens dentro do carrinho)
  - http://localhost:8080/comprar/{id} (Adicina um produto ao carrinho)
  - http://localhost:8080/carrinho/total-value (Retorna o valor total dos produtos no carrinho)
  - http://localhost:8080/carrinho/total-frete (Retorna o valor total do frete dos produtos)
  - http://localhost:8080/carrinho/finalizar-compra (Recebe os parametros do formulário do FrontEnd com os dados do usuário (Nome, CPF, cartão de crédito...) e os salva junto do carrinho no banco de dados.
  - http://localhost:8080/carrinho/remover/{id} (Remove produtos com o mesmo ID do carrinho)
 
  
  
  ### Tecnologias:
  
  - [React](https://pt-br.reactjs.org/)
  - [Spring DevTools](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html) - Escolhido para facilitar no desenvolvimento da api, principalmente por reiniciar de forma automática o servidor Tomcat a cada alteração no código fonte.
  - [Spring Web](https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/using-boot-devtools.html) - Escolhido para desenvolver a API.
  - [Spring Data](https://spring.io/projects/spring-data) - Escolhido para persistência através de JPA.
  - [MariaDB](https://mariadb.org/) - Escolhido por ser um banco de dados fácil.
  - [ReactStrap - Bootstrap](https://reactstrap.github.io/)
  - [Axios](https://axios-http.com/)
  
  ### Libs:
  
  - [Input Mask](https://www.npmjs.com/package/react-input-mask)
  
  ## Considerações:
  
  Foi proposto que alguns requisitos fossem cumpridos, deixo abaixo os que não consegui atender:
  - Banco de dados em memória. Não foi posto explicitamente como requisito, mas creio que o objetivo era sim de utilizar banco de dados em memória. Não consegui, tive de utilizar MariaDB pois é uma banco que já estou acostumado a utilizar.
  - Utilizar as imagens contidas na pasta assets. Não consegui passar o endereço caminho correto das imagens para a tag ```<img src="">```. Só consegui passar o endereço da imagem hospedada em servidores.
  - Ordernar por nome, score e preço. Consegui criar o EndPoint, porém não consegui fazer com que dentro do React o EndPoint fosse acessado.
  


