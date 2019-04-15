package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import java.awt.event.ActionEvent;

public class ControllerLogin implements Initializable{
    @FXML
    public Label BtnClose;
    public Button BtnEntrar;

    @FXML
    public void HandleClose(MouseEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
