package br.com.gerenciamento.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.com.gerenciamento.model.Produto;
import br.com.gerenciamento.config.ConnectionFactory;

public class ProdutoDao {

    // CREATE: Adicionar Produto
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (cor, modelo, ano, cilindrada, marca, quantidade, preco, imagem) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getCor());
            stmt.setString(2, produto.getModelo());
            stmt.setInt(3, produto.getAno());
            stmt.setString(4, produto.getCilindrada());
            stmt.setString(5, produto.getMarca());
            stmt.setInt(6, produto.getQuantidade());
            stmt.setDouble(7, produto.getPreco());
            stmt.setString(8, produto.getImagem());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar produto!", e);
        }
    }

    // READ: Listar Produtos
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getInt("id"),
                    rs.getString("cor"),
                    rs.getString("modelo"),
                    rs.getInt("ano"),
                    rs.getString("cilindrada"),
                    rs.getString("marca"),
                    rs.getInt("quantidade"),
                    rs.getDouble("preco"),
                    rs.getString("imagem")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos!", e);
        }

        return produtos;
    }

    // UPDATE: Atualizar Produto
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE produtos SET cor = ?, modelo = ?, ano = ?, cilindrada = ?, marca = ?, quantidade = ?, preco = ?, imagem = ? WHERE id = ?";
        try (Connection conn =ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getCor());
            stmt.setString(2, produto.getModelo());
            stmt.setInt(3, produto.getAno());
            stmt.setString(4, produto.getCilindrada());
            stmt.setString(5, produto.getMarca());
            stmt.setInt(6, produto.getQuantidade());
            stmt.setDouble(7, produto.getPreco());
            stmt.setString(8, produto.getImagem());
            stmt.setInt(9, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto!", e);
        }
    }

    // DELETE: Deletar Produto
    public void deletarProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar produto!", e);
        }
    }

    // FIND BY ID: Buscar Produto por ID
    public Produto buscarProdutoPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                        rs.getInt("id"),
                        rs.getString("cor"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("cilindrada"),
                        rs.getString("marca"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getString("imagem")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar produto!", e);
        }

        return null;
    }
}