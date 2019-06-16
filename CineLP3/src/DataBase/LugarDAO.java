package DataBase;

import Model.Lugares;
import Model.Sessao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LugarDAO {

    private Connection connection;

    public LugarDAO(){

        connection = new DataBase().getConnection();

    }

    public void create(Lugares l) {
        String sql = "INSERT INTO Lugares(id,status,sessao) " + "VALUES (?, ?, ?);";

        try {
            int status =0;
            if(l.isOcupado())
            {
                status=1;
            }
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, l.getId());
            stmt.setInt(2, status);
            stmt.setInt(3, l.getSessao().getId());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Lugares l) {

        String sql = "UPDATE Lugares set status = ?  WHERE id = ? AND sessao=?";
        int status=0;
        if(l.isOcupado())
        {
            status=1;
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, status);
            stmt.setInt(2, l.getId());
            stmt.setInt(3, l.getSessao().getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Lugares read(int id,int idSessao) {
        SessaoDAO sDAO = new SessaoDAO();
        boolean status;
        String sql = "SELECT * FROM Lugares WHERE id = ? AND sessao = ?";
        Lugares l = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.setInt(2,idSessao);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                if(rs.getInt("status")==1)
                {
                    status=true;
                }
                else
                {
                    status=false;
                }
                l = new Lugares(rs.getInt("id"),status,(sDAO.read(rs.getInt("sessao"))));
            }
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void Delete(Sessao s)
    {
        try {
            String sql = "DELETE FROM Lugares WHERE sessao = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, s.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Lugares> getLugares(Sessao s) {
        boolean status;
        SessaoDAO sDAO = new SessaoDAO();
        try {
            String sql = "SELECT * FROM Lugares WHERE sessao=?";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,s.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList <Lugares> lugares = new ArrayList<Lugares>();
            while (rs.next()) {
                if(rs.getInt("status")==0)
                {
                    status=false;
                }
                else
                {
                    status=true;
                }
                Lugares l = new Lugares(rs.getInt("id"),status,sDAO.read(rs.getInt("sessao")));
                lugares.add(l);
            }
            rs.close();
            stmt.close();
            return lugares;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
