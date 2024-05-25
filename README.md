<!DOCTYPE html>
<html lang="pt-br">
<body>
    <header>
        <div class="container">
            <h1>Exange Manager</h1>
            <h2>Desenvolvimento de Software para Gestão de investimentos</h2>
        </div>
    </header>
    <div class="container">
        <section>
            <h3>Tecnologias Utilizadas</h3>
            <ul>
                <li>DDD (Domain-Driven Design)</li>
                <li>Design Patterns</li>
                <li>SOLID Principles</li>
                <li>API Rest</li>
                <li>Spring Boot</li>
                <li>Banco de Dados H2 (persistente)</li>
                <li>Swagger</li>
                <li>JPA</li>
            </ul>
        </section>
        <section>
            <h3>Conexões com o Banco de Dados</h3>
            <ul>
                <li><strong>URL do Banco de Dados</strong>: <a href="http://localhost:8080/h2-ui/">http://localhost:8080/h2-ui/</a></li>
                <li><strong>Login</strong>: dev</li>
                <li><strong>Senha</strong>: (não possui)</li>
                <li><strong>JDBC URL</strong>: <code>jdbc:h2:file:./src/main/resources/exchangeManager</code></li>
            </ul>
            <p><em>Nota: Este banco de dados será salvo diretamente no projeto conforme o caminho especificado.</em></p>
        </section>
        <section>
            <h3>Conexões com o Swagger</h3>
            <ul>
                <li><strong>URL do Swagger</strong>: <a href="http://localhost:8080/swagger-ui/index.html">http://localhost:8080/swagger-ui/index.html</a></li>
            </ul>
        </section>
        <section>
            <h3>Linguagem de Programação</h3>
            <ul>
                <li>Java 17</li>
            </ul>
        </section>
        <section>
            <h3>Case de Desenvolvimento</h3>
            <p>Este projeto foi desenvolvido conforme o case de Gerenciamento de Investimentos. Detalhes adicionais podem ser encontrados <a href="https://miro.com/welcomeonboard/MWxGZHdqbGFXWGxKUzgxRUxQc3UwT3U4MXNrRHpTcVpyQjVxcmczbE1tc1JpQ1lNYURuTHVXVkNUaU5uWGtuSnwzNDU4NzY0NTg0Nzg0NjQ3MDI3fDI=?share_link_id=985262556916">neste link</a>.</p>
        </section>
        <section>
            <h2>Endpoints API Rest</h2>
            <h3>Domínio de Carteira</h3>
            <ul>
                <li><strong>Mapeamento do Controller</strong>: <code>api/v1/carteira</code></li>
            </ul>
            <p><strong>Criação de Nova Carteira (POST)</strong>: <code>/novaCarteira</code></p>
            <p>Body: (não contém body)</p>
            <p><strong>Atualização de Carteira (PUT)</strong>: <code>/atualizaCarteira</code></p>
            <pre><code>{
  "numeroConta": "string"
}</code></pre>
            <p><strong>Listar Todas as Carteiras (GET)</strong>: <code>/todas</code></p>
            <p><strong>Buscar Carteira por Número de Conta (GET)</strong>: <code>/buscaPorNumeroConta/{NUMERO_CONTA}</code></p>
            <p><strong>Deletar Carteira (DELETE)</strong>: <code>/delete?numeroConta={NUMERO_CONTA}</code></p>
          <hr>
            <h3>Domínio de Investidor</h3>
            <ul>
                <li><strong>Mapeamento do Controller</strong>: <code>api/v1/investidor</code></li>
            </ul>
            <p><strong>Criação de Novo Investidor (POST)</strong>: <code>/novo</code></p>
            <pre><code>{
  "nome": "string",
  "documentos": [
    {
      "numeroDocumento": 0,
      "tipo": "RG"
    }
  ],
  "celular": 0,
  "email": "string",
  "sexo": "MASCULINO",
  "profissao": "string",
  "dataNascimento": "2024-05-25",
  "renda": 0,
  "endereco": {
    "id": 0,
    "cep": 0,
    "rua": "string",
    "complemento": "string",
    "bairro": "string",
    "cidade": "string"
  },
  "carteira": {
    "numeroConta": "string"
  }
}</code></pre>
            <p><strong>Editar Investidor (PUT)</strong>: <code>/editar</code></p>
            <pre><code>{
  "nome": "string",
  "documentos": [
    {
      "numeroDocumento": 0,
      "tipo": "RG"
    }
  ],
  "celular": 0,
  "email": "string",
  "sexo": "MASCULINO",
  "profissao": "string",
  "dataNascimento": "2024-05-25",
  "renda": 0,
  "endereco": {
    "id": 0,
    "cep": 0,
    "rua": "string",
    "complemento": "string",
    "bairro": "string",
    "cidade": "string"
  },
  "carteira": {
    "numeroConta": "string"
  }
}</code></pre>
            <p><strong>Buscar Investidor por Documento (GET)</strong>: <code>/documento/{NUMERO_DOCUMENTO}</code></p>
            <p><strong>Listar Todos os Investidores (GET)</strong>: <code>/busca</code></p>
            <p><strong>Deletar Investidor (DELETE)</strong>: <code>/delete/{numeroDocumento}</code></p>
        </section>
    </div>
<hr>
</body>
</html>
