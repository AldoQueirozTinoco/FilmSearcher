# Film Searcher

<p>O projeto <strong>Film Searcher</strong> foi feito com Spring Boot e thymeleaf para realizar uma busca de filmes por nome. A aplicação acessa uma API externa que replica a do IMDb e retorna o filme correspondente ao nome informado.</p>

# Como Utilizar
<ol type="1">
<li>O usuário precisa logar na plataforma da API http://www.omdbapi.com e requisitar uma API KEY que será enviada por email</li>
<li>Declarar a KEY como variável local utilizando o powershell e digitando o comando: <strong> setx API_KEY "seu_valor_da_api_key_aqui" </strong> no windows ou no linux/mac utilizando o bash: <strong> export  API_KEY=seu_valor_da_api_key_aqui </strong> e após adicionar a variável recarregue o perfil com <strong>source ~/.bashrc (ou o arquivo de perfil apropriado)
</strong>
</li>  
  <li> Ao rodar a application, basta acessar o localhost:8080 e digitar o nome do filme no campo disponível para tal</li>
</ol>
