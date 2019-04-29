package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DataBaseSimulation.FuncionariosDAO;
import Model.Funcionario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable{
    @FXML
    private Label BtnClose;
    @FXML
    private Button BtnEntrar;
    @FXML
    private Label LbEsqueceuSenha;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Label LbSenhaIncorreta;
    @FXML
    private ImageView imgAviso;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LbSenhaIncorreta.setVisible(false);
        imgAviso.setVisible(false);
    }
    @FXML
    public void HandleClose(MouseEvent Event)
    {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    public void EsqueceuSenha(MouseEvent Event)
    {
        Alert aviso = new Alert(Alert.AlertType.INFORMATION);
        aviso.setTitle("Esqueceu sua senha?");
        aviso.setHeaderText("Como recupera-la:");
        aviso.setContentText("Entre em contato com o Administrador de seu estabelecimento relatando o esquecimento,apenas ele tem acesso a essa infromação.");
        aviso.show();
    }
    @FXML
    public void Entrar(ActionEvent actionEvent) {
        FuncionariosDAO f1 = new FuncionariosDAO();
        ArrayList<Funcionario> list = f1.getSimulation();
        int flag = 0;
        for (Funcionario x:list)
        {
            if (x.getUsuario().toUpperCase().equals(txtUsuario.getText().toUpperCase()))
            {
                flag =1;
                try{
                    if(x.getSenha()==Integer.parseInt(txtSenha.getText()))
                    {
                        if (x.getTipo().equals("Atendente"))
                        {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/HomeAtendente.fxml"));
                                Parent root = loader.load();
                                Stage stage = new Stage();
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.initStyle(StageStyle.UNDECORATED);
                                stage.setMaximized(true);
                                HomeAtendenteController controle = (HomeAtendenteController)loader.getController();
                                controle.GetUser(x);
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        else if(x.getTipo().equals("Administrador"))
                        {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/HomeAdmin.fxml"));
                                Parent root = loader.load();
                                Stage stage = new Stage();
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.initStyle(StageStyle.UNDECORATED);
                                stage.setMaximized(true);
                                stage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                        Stage login = (Stage)BtnEntrar.getScene().getWindow();
                        login.close();
                    }
                    else
                    {
                        LbSenhaIncorreta.setVisible(true);
                        imgAviso.setVisible(true);
                    }
                } catch (NumberFormatException e) {
                    LbSenhaIncorreta.setVisible(true);
                    imgAviso.setVisible(true);
                }

            }
            if(flag==0)
            {
                LbSenhaIncorreta.setVisible(true);
                imgAviso.setVisible(true);
            }

        }
    }
}
