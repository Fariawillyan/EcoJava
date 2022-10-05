#Spring Security Learning

De forma pratica essa é uma aplicação que mostra as funcionalidades basicas e faceis que você consegue fazer usando o spring securtiy
nesse caso demonstrei que conseguimos colocar para que usuarios precisem de certas permissões para acessar as requisições web 
oque adiciona mais uma camada de segurança em uma aplicação de forma mais basica possivel

//--Para que funciona apenas execute o ArturApplication, a pagina de login irá aparecer ao pesquisar localhost:8080--//

Tem apenas 2 usuarios cadastrados que ficam na memoria ao ser inicializado o programa
Usuario: Artur
Senha: hackforit
Role: ADMIN

Usuario: Vitor
senha: 123456
Role: USER

Caso queira você consegue alterar o nome,senha e role em SecurityConfig na parte de InMemoryAuthentication