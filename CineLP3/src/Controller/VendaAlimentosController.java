package Controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class VendaAlimentosController implements Initializable {
    public AnchorPane PnPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void GetMedidas(Double h,double w)
    {
        PnPrincipal.setPrefWidth(w);
        PnPrincipal.setPrefHeight(h);
    }
}
