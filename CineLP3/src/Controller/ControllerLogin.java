package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Model.Funcionario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerLogin implements Initializable{
    @FXML
    public Label BtnClose;
    public Button BtnEntrar;
    public Label LbEsqueceuSenha;
    public TextField txtUsuario;
    public PasswordField txtSenha;
    private Funcionario f1 = new Funcionario("123","Victor",123,"admin","Administrador");
    private Funcionario f2 = new Funcionario("123","Victor",123,"user","Atendente");

    @FXML
    public void HandleClose(MouseEvent Event)
    {
        Platform.exit();
        System.exit(0);
    }
    public void EsqueceuSenha(MouseEvent Event)
    {
        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
        aviso.setTitle("Esqueceu sua senha?");
        aviso.setHeaderText("Como recupera-la:");
        aviso.setContentText("Entre em contato com o Administrador de seu estabelecimento relatando o esquecimento,apenas ele tem acesso a essa infromação.");
        aviso.show();
    }
    public void Entrar(ActionEvent actionEvent) {
        if (txtUsuario.getText().equals(f1.getUsuario())&&(Integer.parseInt(txtSenha.getText()))==f1.getSenha())
        {
            if (f1.getTipo().equals("Atendente"))
            {
                try {

                    Parent root = FXMLLoader.load(getClass().getResource("../View/HomeAtendente.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (f1.getTipo().equals("Administrador"))
            {
                  try {

                        Parent root = FXMLLoader.load(getClass().getResource("../View/HomeAdmin.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
        else if (txtUsuario.getText().equals(f2.getUsuario())&&(Integer.parseInt(txtSenha.getText()))==f2.getSenha())
        {
            if (f2.getTipo().equals("Atendente"))
            {
                try {

                    Parent root = FXMLLoader.load(getClass().getResource("../View/HomeAtendente.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (f2.getTipo().equals("Administrador"))
            {
                try {

                    Parent root = FXMLLoader.load(getClass().getResource("../View/HomeAdmin.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
