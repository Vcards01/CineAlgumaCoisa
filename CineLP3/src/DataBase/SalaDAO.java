package DataBase;

import Model.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaDAO {

    private Connection connection;

    public SalaDAO(){

        connection = new DataBase().getConnection();

    }

    public void create(Sala s) {
        String sql = "INSERT INTO Sala(qtddLugares) " + "VALUES (?);";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,s.getQtddLugares());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Sala read(int id){
        String sql = "SELECT * FROM Sala WHERE id = ?";
        Sala s = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                s = new Sala(rs.getInt("id"),rs.getInt("qtddLugares"));
            }
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Sala s) {

        String sql = "UPDATE Sala SET qtddLugares = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, s.getQtddLugares());
            stmt.setInt(2, s.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Sala s) {

        try {
            String sql = "DELETE FROM Sala WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, s.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Sala> getSalas() {

        try {
            String sql = "SELECT * FROM Sala";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Sala> filmes = new ArrayList <Sala>();
            while (rs.next()) {
                Sala s = new Sala(rs.getInt("id"),rs.getInt("qtddLugares"));
                filmes.add(s);
            }
            rs.close();
            stmt.close();
            return filmes;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
