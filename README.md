# CatMidas
## Catalogo de Mídias de Entretenimento
![gato1](https://github.com/user-attachments/assets/12f224dd-c0c4-4c83-8107-b205da567d23)
### Backend do CatMidas

CatMidas é um sistema web de controle de midias de entretenimento, nele o usuário pode cadastrar, editar, visualizar ou remover midias de entretenimento que ele estiver consumindo ou prentende consumir, assim garantindo maior controle sobre as midias que ele consome e evitando de criar listas enormes em documentos fisicos ou digitais que, 
além de não garantir acessibilidade, pois conforme a lista de midias consumidas pelo usuário cresce, o controle do mesmo sobre a própria lista pode não crescer junto, além
de que pode ocorrer de o usuario perder sua lista e ter que remontá-la do zero, o que pode ser chato.
</br>
Com isso o CatMidas visa resolver essas inconveniências, sendo um sistema central de controle de mídias, em que o usuário pode ter um controle sobre suas series e filmes já
vistos ou não sem temer algum incidente com sua lista ou que ela fique grande demais para controlar.
</br>

#### Objetivos
Apesar de tentar resolver uma incoveniência, fiz este projeto primariamente com o intuito de estudar a criação de uma API Rest em Java e Spring e outros assuntos relacionados.
</br>
Atualmente este projeto não está hospedado em nenhuma plataforma, sendo acessível atraves da execução local do mesmo. Porém, caso queira ver mais dele, recomendo acessar o repositório do front-end do projeto em <https://github.com/Thiago-M-Silva/CatMidas_Front>

#### Tecnologias
* Linguagem: Java 17
* Banco de dados: PostgreSql
* Frameworks: Spring Boot/Web/Data/Security/Doc
* Ferramentas: Docker (criacao de containers para a aplicacao), Swagger (proveniente do Spring Doc para a documentacao dos endpoints), Postman (testes dos endpoints), Maven (gerenciamento de dependencias) e a IDE IntelliJ Community.
* Bibliotecas: JUnit e Mockito (criacao de testes unitarios), Lombok, Itext (criação de arquivos pdf)

#### Como Executar
1. Clone esse repositório executando o seguinte comando no terminal `git clone https://github.com/Thiago-M-Silva/CatMidas_backend.git`
2. Para executar pela primeira vez utilizando Docker execute o seguinte comando no terminal `docker-compose up --build` isso deve criar e executar os containers e a aplicação
3. Após isso o sistema deve estar acessível em  https://localhost:8080 e caso queira ver a documentação Swagger, basta acessar o endereço localhost:8080/swagger-ui.html em seu navegador

#### Funcionalidades
Atualmente o sistema possui endpoints para as seguintes funcionalidades
* Cadastro e login de usuarios e ADMs
* CRUD de mídias
* Emissão arquivo pdf contendo uma lista de mídias marcadas pelo usuário como favorito
