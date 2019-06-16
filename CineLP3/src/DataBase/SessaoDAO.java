package DataBase;


import Model.Filme;
import Model.Sessao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SessaoDAO {
    private Connection connection;

    public SessaoDAO(){

        connection = new DataBase().getConnection();

    }

    public void create(Sessao s) {
        String sql = "INSERT INTO Sessao(horario,filme,sala,qtddVendidos,precoInteira,precoMeia,lugaresDisponiveis) " + "VALUES (?, ?, ?, ?, ?, ?,?);";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, s.getHorario());
            stmt.setInt(2, s.getFilme().getId());
            stmt.setInt(3, s.getSala().getId());
            stmt.setInt(4, s.getqtddVendidos());
            stmt.setDouble(5, s.getPrecoEntradaInteira());
            stmt.setDouble(6, s.getPrecoEntradaMeia());
            stmt.setInt(7, s.getLugaresDisponiveis());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Sessao read(int id) {
        SalaDAO sDAO = new SalaDAO();
        FilmeDAO fDAO = new FilmeDAO();
        String sql = "SELECT * FROM Sessao WHERE id = ?";
        Sessao s = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                s = new Sessao(rs.getInt("id"),rs.getString("horario"),fDAO.read(rs.getInt("filme")),sDAO.read(rs.getInt("sala")),rs.getInt("qtddVendidos"),rs.getDouble("precoInteira"),rs.getDouble("precoMeia"),rs.getInt("lugaresDisponiveis"));
            }
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Sessao read(Filme f) {
        SalaDAO sDAO = new SalaDAO();
        FilmeDAO fDAO = new FilmeDAO();
        String sql = "SELECT * FROM Sessao WHERE filme = ?";
        Sessao s = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,f.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                s = new Sessao(rs.getInt("id"),rs.getString("horario"),fDAO.read(rs.getInt("filme")),sDAO.read(rs.getInt("sala")),rs.getInt("qtddVendidos"),rs.getDouble("precoInteira"),rs.getDouble("precoMeia"),rs.getInt("lugaresDisponiveis"));
            }
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Sessao s) {

        String sql = "UPDATE Sessao SET horario = ?, filme = ?, sala = ?, qtddVendidos = ?, precoInteira = ?, precoMeia = ?, lugaresDisponiveis = ?" +
                " WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, s.getHorario());
            stmt.setInt(2, s.getFilme().getId());
            stmt.setInt(3, s.getSala().getId());
            stmt.setInt(4, s.getqtddVendidos());
            stmt.setDouble(5, s.getPrecoEntradaInteira());
            stmt.setDouble(6, s.getPrecoEntradaMeia());
            stmt.setInt(7, s.getLugaresDisponiveis());
            stmt.setInt(8, s.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Sessao s) {

        try {
            String sql = "DELETE FROM Sessao WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, s.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Sessao> getSessao() {
        SalaDAO sDAO = new SalaDAO();
        FilmeDAO fDAO = new FilmeDAO();

        try {
            String sql = "SELECT * FROM Sessao";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList <Sessao> filmes = new ArrayList<Sessao>();

            while (rs.next()) {
                Sessao s = new Sessao(rs.getInt("id"),rs.getString("horario"),fDAO.read(rs.getInt("filme")),sDAO.read(rs.getInt("sala")),rs.getInt("qtddVendidos"),rs.getDouble("precoInteira"),rs.getDouble("precoMeia"),rs.getInt("lugaresDisponiveis"));
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
    public ArrayList <Sessao> getSessao(Filme f) {
        SalaDAO sDAO = new SalaDAO();
        FilmeDAO fDAO = new FilmeDAO();

        try {
            String sql = "SELECT * FROM Sessao where filme = ?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,f.getId());
            ResultSet rs = stmt.executeQuery();

            ArrayList <Sessao> filmes = new ArrayList<Sessao>();

            while (rs.next()) {
                Sessao s = new Sessao(rs.getInt("id"),rs.getString("horario"),fDAO.read(rs.getInt("filme")),sDAO.read(rs.getInt("sala")),rs.getInt("qtddVendidos"),rs.getDouble("precoInteira"),rs.getDouble("precoMeia"),rs.getInt("lugaresDisponiveis"));
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
