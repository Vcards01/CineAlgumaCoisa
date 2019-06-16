package DataBase;
import Model.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CaixaDAO {

    private Connection connection;

    public CaixaDAO()
    {
        connection = new DataBase().getConnection();
    }
    public void create(Caixa c) {
        String sql = "INSERT INTO Caixa(data,valorInicial,valorAtual,lucro,status) " + "VALUES (?, ?, ?, ?, ?);";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getData());
            stmt.setDouble(2, c.getValorInicial());
            stmt.setDouble(3, c.getValorAtual());
            stmt.setDouble(4, c.getLucro());
            stmt.setBoolean(5, c.getStatus());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Caixa read(String data) {
        String sql = "SELECT * FROM Caixa WHERE data = ?";
        Caixa c = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,data);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                c = new Caixa(rs.getString("data"),rs.getDouble("valorInicial"),rs.getDouble("lucro"),rs.getDouble("valorAtual"),rs.getBoolean("status"));
            }
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Caixa c) {

        String sql = "UPDATE Caixa SET  valorInicial = ?, valorAtual = ?, lucro = ?, status = ?" +
                " WHERE data = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setDouble(1, c.getValorInicial());
            stmt.setDouble(2, c.getValorAtual());
            stmt.setDouble(3, c.getLucro());
            stmt.setBoolean(4, c.getStatus());
            stmt.setString(5, c.getData());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Caixa c) {

        try {
            String sql = "DELETE FROM Caixa WHERE data= ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, c.getData());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Caixa> getCaixa() {

        try {
            String sql = "SELECT * FROM Caixa";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Caixa> Caixas = new ArrayList<Caixa>();

            while (rs.next()) {
               Caixa c = new Caixa(rs.getString("data"),rs.getDouble("valorInicial"),rs.getDouble("lucro"),rs.getDouble("valorAtual"),rs.getBoolean("status"));
               Caixas.add(c);
            }
            rs.close();
            stmt.close();
            return Caixas;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
