package DataBase;

import Model.Filme;
import Model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendaDAO {
    private Connection connection;

    public VendaDAO(){

        connection = new DataBase().getConnection();

    }

    public void create(Venda v) {
        String sql = "INSERT INTO Venda(data, hora, valor) " + "VALUES (?, ?, ?);";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, v.getData());
            stmt.setString(2, v.getHora());
            stmt.setDouble(3, v.getValor());
            stmt.execute();
            stmt.close();
            System.out.println("Venda Gravada!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Venda read(int id) {
        String sql = "SELECT * FROM Venda WHERE id = ?";
        Venda v = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                v = new Venda(rs.getInt("id"),rs.getString("data"),rs.getString("hora"),rs.getDouble("valor"));
            }
            return v;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Venda v) {

        String sql = "UPDATE Venda SET data = ?, hora = ?, valor = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,v.getData());
            stmt.setString(2, v.getHora());
            stmt.setDouble(3, v.getValor());
            stmt.setInt(4, v.getIdVenda());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Gravado!");
    }
    public void delete(Venda v) {

        try {
            String sql = "DELETE FROM Venda WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, v.getIdVenda());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Venda> getVendas() {

        try {
            String sql = "SELECT * FROM Venda";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Venda> vendas = new ArrayList<Venda>();

            while (rs.next()) {
              Venda  v = new Venda(rs.getInt("id"),rs.getString("data"),rs.getString("hora"),rs.getDouble("valor"));
              vendas.add(v);
            }
            rs.close();
            stmt.close();
            return vendas;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
