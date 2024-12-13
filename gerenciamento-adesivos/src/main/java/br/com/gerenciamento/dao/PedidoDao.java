package br.com.gerenciamento.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.gerenciamento.model.Pedido;
import br.com.gerenciamento.config.ConnectionFactory;

public class PedidoDao {

    // CREATE: Adicionar Pedido
    public void adicionarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente_nome, quantidade, data_pedido, previsao_entrega, endereco, referencia_modelo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pedido.getClienteNome());
            stmt.setInt(2, pedido.getQuantidade());
            stmt.setString(3, pedido.getDataPedido());
            stmt.setString(4, pedido.getPrevisaoEntrega());
            stmt.setString(5, pedido.getEndereco());
            stmt.setInt(6, pedido.getReferenciaModelo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar pedido!", e);
        }
    }

    // READ: Listar Pedidos
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                    rs.getInt("id"),
                    rs.getString("cliente_nome"),
                    rs.getInt("quantidade"),
                    rs.getString("data_pedido"),
                    rs.getString("previsao_entrega"),
                    rs.getString("endereco"),
                    rs.getInt("referencia_modelo")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pedidos!", e);
        }

        return pedidos;
    }

    // UPDATE: Atualizar Pedido
    public void atualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedidos SET cliente_nome = ?, quantidade = ?, data_pedido = ?, previsao_entrega = ?, endereco = ?, referencia_modelo = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pedido.getClienteNome());
            stmt.setInt(2, pedido.getQuantidade());
            stmt.setString(3, pedido.getDataPedido());
            stmt.setString(4, pedido.getPrevisaoEntrega());
            stmt.setString(5, pedido.getEndereco());
            stmt.setInt(6, pedido.getReferenciaModelo());
            stmt.setInt(7, pedido.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar pedido!", e);
        }
    }

    // DELETE: Deletar Pedido
    public void deletarPedido(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar pedido!", e);
        }
    }

    // FIND BY ID: Buscar Pedido por ID
    public Pedido buscarPedidoPorId(int id) {
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pedido(
                        rs.getInt("id"),
                        rs.getString("cliente_nome"),
                        rs.getInt("quantidade"),
                        rs.getString("data_pedido"),
                        rs.getString("previsao_entrega"),
                        rs.getString("endereco"),
                        rs.getInt("referencia_modelo")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar pedido!", e);
        }

        return null;
    }
}
