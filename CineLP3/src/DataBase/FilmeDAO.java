package DataBase;

import Model.Filme;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {

    private Connection connection;

    public FilmeDAO(){

        connection = new DataBase().getConnection();

    }

    public void create(Filme f) {
        String sql = "INSERT INTO Filme(nome, genero, sinopse,duracao,qtddVendida,img) " + "VALUES (?, ?, ?, ?, ?, ?);";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getGenero());
            stmt.setString(3, f.getSinopse());
            stmt.setString(4, f.getDuracao());
            stmt.setInt(5, f.getQtddVendida());
            stmt.setString(6, f.getImg());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Filme read(int id) {
        String sql = "SELECT * FROM Filme WHERE id = ?";
        Filme f = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                f = new Filme(rs.getInt("id"),rs.getString("nome"),rs.getString("genero"),rs.getString("sinopse"),rs.getString("duracao"),rs.getInt("qtddVendida"),rs.getString("img"));
            }
            return f;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Filme f) {

        String sql = "UPDATE Filme SET nome = ?, genero = ?, sinopse = ?, duracao = ?, qtddVendida = ?, img = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getGenero());
            stmt.setString(3, f.getSinopse());
            stmt.setString(4, f.getDuracao());
            stmt.setInt(5, f.getQtddVendida());
            stmt.setString(6, f.getImg());
            stmt.setInt(7, f.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Gravado!");
    }
    public void delete(Filme f) {

        try {
            String sql = "DELETE FROM Filme WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, f.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Filme> getFilmes() {

        try {
            String sql = "SELECT * FROM Filme";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Filme> filmes = new ArrayList<Filme>();

            while (rs.next()) {
                Filme f = new Filme(rs.getInt("id"),rs.getString("nome"),rs.getString("genero"),rs.getString("sinopse"),rs.getString("duracao"),rs.getInt("qtddVendida"),rs.getString("img"));
                filmes.add(f);
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

