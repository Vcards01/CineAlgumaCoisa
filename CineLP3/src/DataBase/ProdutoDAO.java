package DataBase;

import Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    private Connection connection;
    public ProdutoDAO(){

        connection = new DataBase().getConnection();

    }

    public void create(Produto p) {
        String sql = "INSERT INTO Produto(quantidade, nome, tipo, preco, quantidadeDeVenda) " + "VALUES (?, ?, ?, ?, ?);";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, p.getQuantidade());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getTipo());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getQuantidadeDeVenda());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto read(int id) {
        String sql = "SELECT * FROM Produto WHERE id = ?";
        Produto p = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                p = new Produto(rs.getInt("id"),rs.getInt("quantidade"),rs.getString("nome"),rs.getString("tipo"),rs.getDouble("preco"),rs.getInt("quantidadeDeVenda"));
            }
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Produto p) {

        String sql = "UPDATE Produto SET  quantidade = ?, nome = ?, tipo = ?, preco = ?, quantidadeDeVenda = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, p.getQuantidade());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getTipo());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getQuantidadeDeVenda());
            stmt.setInt(6, p.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Produto p) {

        try {
            String sql = "DELETE FROM Produto WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, p.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Produto> getProdutos() {

        try {
            String sql = "SELECT * FROM Produto";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Produto> produtos = new ArrayList<Produto>();

            while (rs.next()) {
                Produto p =new Produto(rs.getInt("id"),rs.getInt("quantidade"),rs.getString("nome"),rs.getString("tipo"),rs.getDouble("preco"),rs.getInt("quantidadeDeVenda"));
                produtos.add(p);
            }
            rs.close();
            stmt.close();
            return produtos;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
