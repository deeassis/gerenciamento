package br.com.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gerenciamento.dao.ProdutoDao;
import br.com.gerenciamento.model.Produto;

@Controller// Prefixo de rota para produtos
public class ProdutoController {

    @RequestMapping("/listar")
    public String listarProdutos(Model model) {
        ProdutoDao dao = new ProdutoDao();
        model.addAttribute("produtos", dao.listarProdutos());
        return "home"; // Retorna a página listar.html
    }

    @RequestMapping("/form")
    public String formProduto(Integer idProduto, Model model) {
        ProdutoDao dao = new ProdutoDao();
        Produto produto = new Produto();

        if (idProduto != null) {
            produto = dao.buscarProdutoPorId(idProduto);
        }

        model.addAttribute("produto", produto);
        return "produtos/form"; // Retorna a página form.html
    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public String adicionarProduto(Produto produto) {
        ProdutoDao dao = new ProdutoDao();
        dao.adicionarProduto(produto);
        return "redirect:/produtos/listar"; // Redireciona para a lista de produtos
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.POST)
    public String atualizarProduto(Integer idProduto, Produto produto) {
        ProdutoDao dao = new ProdutoDao();
        dao.atualizarProduto(produto);
        return "redirect:/produtos/listar"; // Redireciona para a lista de produtos
    }

    @RequestMapping("/deletar")
    public String deletarProduto(Integer idProduto) {
        ProdutoDao dao = new ProdutoDao();
        dao.deletarProduto(idProduto);
        return "redirect:/produtos/listar"; // Redireciona para a lista de produtos
    }
}

