<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Gestão de Adesivos</title>
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
        <input type="text" placeholder="Busque por adesivos" />
      </div>
      <div class="item-nav">
        <a href="#adicionarAdesivo">
          <button type="button">Novo Adesivo</button>
        </a>
      </div>
    </div>
  </header>

  <main>
    <!-- Listagem de Adesivos -->
    <section id="listarAdesivos" class="conteudo-adesivos">
      <h1>Adesivos Disponíveis</h1>
      <div class="items-adesivos">
        <c:forEach items="${produtos}" var="produto">
          <div class="adesivo">
            <img src="${produto.imagem}" alt="${produto.nome}" />
            <h2>${produto.nome}</h2>
            <p>${produto.modelo} - ${produto.cor}</p>
            <h3>R$ ${produto.preco}</h3>
            <div class="acoes">
              <a href="#editarProduto?id=${produto.id}" class="botao">Editar</a>
              <a href="#deletarProduto?id=${produto.id}" class="botao-danger">Excluir</a>
            </div>
          </div>
        </c:forEach>
      </div>
    </section>

    <!-- Adicionar Adesivo -->
    <section id="adicionarAdesivo" class="conteudo-form">
      <h1>Adicionar Adesivo</h1>
      <form method="POST" action="adicionarProduto" enctype="multipart/form-data">
        <input name="nome" type="text" placeholder="Nome do Adesivo" required />
        <input name="modelo" type="text" placeholder="Modelo" required />
        <input name="cor" type="text" placeholder="Cor" required />
        <input name="preco" type="text" placeholder="Preço" required />
        <input name="quantidade" type="number" placeholder="Quantidade" required />
        <textarea name="descricao" placeholder="Descrição"></textarea>
        <input name="imagem" type="file" required />
        <button type="submit">Salvar</button>
      </form>
    </section>

    <!-- Editar Produto -->
    <section id="editarProduto" class="conteudo-form">
      <h1>Editar Produto</h1>
      <form method="POST" action="editarProduto?id=${produto.id}" enctype="multipart/form-data">
        <input name="nome" type="text" value="${produto.nome}" required />
        <input name="modelo" type="text" value="${produto.modelo}" required />
        <input name="cor" type="text" value="${produto.cor}" required />
        <input name="preco" type="text" value="${produto.preco}" required />
        <input name="quantidade" type="number" value="${produto.quantidade}" required />
        <textarea name="descricao">${produto.descricao}</textarea>
        <input name="imagem" type="file" />
        <button type="submit">Salvar Alterações</button>
      </form>
    </section>

    <!-- Deletar Produto -->
    <section id="deletarProduto" class="conteudo-adesivo">
      <h1>Tem certeza de que deseja excluir o adesivo "${produto.nome}"?</h1>
      <form method="POST" action="deletarProduto?id=${produto.id}">
        <button type="submit" class="botao-danger">Sim, deletar</button>
        <a href="#listarAdesivos" class="botao">Cancelar</a>
      </form>
    </section>
  </main>

  <footer class="rodape">
    <p>© 2024 - Todos os direitos reservados.</p>
  </footer>
</body>
</html>
