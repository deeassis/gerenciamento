package br.com.gerenciamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gerenciamento.dao.PedidoDao;
import br.com.gerenciamento.model.Pedido;

@Controller
@RequestMapping("/pedidos") // Prefixo de rota para pedidos
public class PedidoController {

    @RequestMapping("/listar")
    public String listarPedidos(Model model) {
        PedidoDao dao = new PedidoDao();
        model.addAttribute("pedidos", dao.listarPedidos());
        return "pedidos/listar"; // Retorna a página listar.html
    }

    @RequestMapping("/form")
    public String formPedido(Integer idPedido, Model model) {
        PedidoDao dao = new PedidoDao();
        Pedido pedido = new Pedido();

        if (idPedido != null) {
            pedido = dao.buscarPedidoPorId(idPedido);
        }

        model.addAttribute("pedido", pedido);
        return "pedidos/form"; // Retorna a página form.html
    }

    @RequestMapping(value = "/adicionar", method = RequestMethod.POST)
    public String adicionarPedido(Pedido pedido) {
        PedidoDao dao = new PedidoDao();
        dao.adicionarPedido(pedido);
        return "redirect:/pedidos/listar"; // Redireciona para a lista de pedidos
    }

    @RequestMapping(value = "/atualizar", method = RequestMethod.POST)
    public String atualizarPedido(Integer idPedido, Pedido pedido) {
        PedidoDao dao = new PedidoDao();
        dao.atualizarPedido(pedido);
        return "redirect:/pedidos/listar"; // Redireciona para a lista de pedidos
    }

    @RequestMapping("/deletar")
    public String deletarPedido(Integer idPedido) {
        PedidoDao dao = new PedidoDao();
        dao.deletarPedido(idPedido);
        return "redirect:/pedidos/listar"; // Redireciona para a lista de pedidos
    }
}
