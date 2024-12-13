<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gestão de Pedidos</title>
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
        <a href="#adicionarPedido" class="botao">Novo Pedido</a>
      </div>
    </div>
  </header>

  <main>
    <!-- Listagem de Pedidos -->
    <section id="listarPedidos" class="conteudo-pedidos">
      <h1>Pedidos Realizados</h1>
      <div class="items-pedidos">
        <c:forEach items="${pedidos}" var="pedido">
          <div class="pedido">
            <h2>Pedido #${pedido.id}</h2>
            <p>Cliente: ${pedido.cliente}</p>
            <p>Data: ${pedido.data}</p>
            <p>Valor Total: R$ ${pedido.valorTotal}</p>
            <div class="acoes">
              <a href="#editarPedido?id=${pedido.id}" class="botao">Editar</a>
              <a href="#deletarPedido?id=${pedido.id}" class="botao-danger">Excluir</a>
            </div>
          </div>
        </c:forEach>
      </div>
    </section>

    <!-- Adicionar Pedido -->
    <section id="adicionarPedido" class="conteudo-form">
      <h1>Adicionar Pedido</h1>
      <form method="POST" action="adicionarPedido">
        <input name="cliente" type="text" placeholder="Nome do Cliente" required />
        <input name="data" type="date" required />
        <input name="valorTotal" type="text" placeholder="Valor Total" required />
        <textarea name="itens" placeholder="Itens do Pedido"></textarea>
        <button type="submit">Salvar Pedido</button>
      </form>
    </section>

    <!-- Editar Pedido -->
    <section id="editarPedido" class="conteudo-form">
      <h1>Editar Pedido</h1>
      <form method="POST" action="editarPedido?id=${pedido.id}">
        <input name="cliente" type="text" value="${pedido.cliente}" required />
        <input name="data" type="date" value="${pedido.data}" required />
        <input name="valorTotal" type="text" value="${pedido.valorTotal}" required />
        <textarea name="itens">${pedido.itens}</textarea>
        <button type="submit">Salvar Alterações</button>
      </form>
    </section>

    <!-- Deletar Pedido -->
    <section id="deletarPedido" class="conteudo-pedido">
      <h1>Tem certeza de que deseja excluir o pedido #${pedido.id}?</h1>
      <form method="POST" action="deletarPedido?id=${pedido.id}">
        <button type="submit" class="botao-danger">Sim, deletar</button>
        <a href="#listarPedidos" class="botao">Cancelar</a>
      </form>
    </section>
  </main>

  <footer class="rodape">
    <p>© 2024 - Todos os direitos reservados.</p>
  </footer>
</body>
</html>
