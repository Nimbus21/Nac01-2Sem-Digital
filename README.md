# Nac01-2Sem-Digital

Deploy em: https://capsuledevdigital01.herokuapp.com/

# Como executar o projeto

Localmente deve-se executar a classe Nac012SemDigital.java que contém o método main e inicia a aplicação dentro do Spring em servidor pré-definido pelo framework. A aplicação por padrão inicia em localhost na porta 80. Essa configuração, bem como as configurações do banco H2, encontra-se no arquivo application.properties presente em resources. Alternativamente é possível utilizar o link do Heroku que leva a um ambiente com a aplicação devidamente implementada. 

Para cadastrar uma entidade que depende da existência de outra (devido a constraint do banco de dados), via POST request, é necessário criar no corpo da requisição, o objeto JSON com os demais objetos requeridos simultaneamente. Para ler as entidades atualmente salvas no banco, via GET request, é preciso enviar a requisição na URL. Para atualizar, via PUT request, é preciso referenciar o código da entidade desejada na URL e também no objeto JSON com as informações atualizadas no corpo da requisição. Para apagar, via DELETE request, é necessário enviar a requisição pela URL seguida do código da entidade.

# Funcionalidades desenvolvidas

O sistema permite cadastrar, ler, atualizar e apagar as entidades referentes ao projeto, persistindo as tabelas no banco de dados em memória H2. Além disso, retorna e recebe, via Rest API, objetos JSON de acordo com as requisições feitas pelo navegador.

# Arquitetura utilizada

Arquitetura se baseia em web services RESTful para realizar a comunicação do navegador com o sistema de entidades gerenciadas pelo JPA, que por sua vez, realiza a persistência no banco de dados.

# Integrantes do grupo

Nome: Claudia Sol Park 
RM: 84013

Nome: Guilherme Henri Aoki Ardisson 
RM: 82123

Nome: Pedro Alves Mendes 
RM: 82217

Nome: Rodrigo Ken Harada Hirata 
RM: 82673

Nome: Thandy Dyaus Ribeiro Siappo Norberto 
RM: 83944
