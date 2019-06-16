package DataBase;

import Model.Filme;
import Model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    private Connection connection;
    public FuncionarioDAO(){

        connection = new DataBase().getConnection();

    }

    public void create(Funcionario f) {
        String sql = "INSERT INTO Funcionario(cpf, nome, senha,usuario,tipo,salario,qtddVendas) " + "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            stmt.setString(2, f.getNome());
            stmt.setString(3, f.getSenha());
            stmt.setString(4, f.getUsuario());
            stmt.setString(5, f.getTipo());
            stmt.setDouble(6, f.getSalario());
            stmt.setInt(7, f.getQtddVendas());
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Funcionario read(String id) {
        String sql = "SELECT * FROM Funcionario WHERE cpf = ?";
        Funcionario f = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                f = new Funcionario(rs.getString("cpf"),rs.getString("nome"),rs.getString("senha"),rs.getString("usuario"),rs.getString("tipo"),rs.getDouble("salario"),rs.getInt("qtddVendas"));
            }
            return f;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(Funcionario f) {

        String sql = "UPDATE Funcionario SET  nome = ?, senha = ?, usuario = ?, tipo = ?, salario = ?,qtddVendas = ?" +
                " WHERE cpf = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getSenha());
            stmt.setString(3, f.getUsuario());
            stmt.setString(4, f.getTipo());
            stmt.setDouble(5, f.getSalario());
            stmt.setInt(6, f.getQtddVendas());
            stmt.setString(7, f.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Funcionario f) {

        try {
            String sql = "DELETE FROM Funcionario WHERE cpf = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, f.getCpf());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList <Funcionario> getFuncionarios() {

        try {
            String sql = "SELECT * FROM Funcionario";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

            while (rs.next()) {
                Funcionario f = new Funcionario(rs.getString("cpf"),rs.getString("nome"),rs.getString("senha"),rs.getString("usuario"),rs.getString("tipo"),rs.getDouble("salario"),rs.getInt("qtddVendas"));
                funcionarios.add(f);
            }
            rs.close();
            stmt.close();
            return funcionarios;

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
