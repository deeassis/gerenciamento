<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin - Home</title>
  <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
  <header class="navbar">
    <div class="container-navbar">
      <div class="item-nav">
        <div class="logo">
          <img alt="Logo" src="images/logo.png" />
          <span>Admin</span>
        </div>
      </div>
      <div class="item-nav">
        <a href="home.jsp" class="botao">Home</a>
        <a href="gestaoProdutos.jsp" class="botao">Produtos</a>
        <a href="gestaoPedidos.jsp" class="botao">Pedidos</a>
      </div>
    </div>
  </header>

  <main>
    <section class="conteudo-home">
      <h1>Bem-vindo ao Sistema de Gestão</h1>
      <p>Selecione uma opção:</p>
      <div class="botoes-home">
        <a href="gestaoProdutos.jsp" class="botao">Gerenciar Produtos</a>
        <a href="gestaoPedidos.jsp" class="botao">Gerenciar Pedidos</a>
      </div>
    </section>
  </main>

  <footer class="rodape">
    <p>© 2024 - Todos os direitos reservados.</p>
  </footer>
</body>
</html>

