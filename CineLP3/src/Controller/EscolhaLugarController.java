package Controller;

import Model.Sala;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EscolhaLugarController implements Initializable {
    public AnchorPane PnCine;
    private Sala sala ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void getSala(Sala s)
    {
        for(int i=0;i< s.getQtddLugares();i++)
        {

            PnCine.getChildren().add(new Button("Poltrona"));

        }
    }
    public void setLugares()
    {

    }
}
