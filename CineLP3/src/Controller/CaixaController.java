package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class CaixaController implements Initializable {
    @FXML
    public Label LbStatus;
    @FXML
    public Label LbInicial;
    @FXML
    public Label LbLucro;
    @FXML
    public Label LbTotal;
    @FXML
    public AnchorPane PnFundo;
    public AnchorPane PnStatus;
    public AnchorPane PnInicial;
    public AnchorPane PnLucro;
    public AnchorPane PnTotal;
    public AnchorPane PnTitulo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Shadow();
    }

    public void SetMedidas(double h, double w)
    {
        PnFundo.setPrefWidth(w);
        PnFundo.setPrefHeight(h);
    }
    @FXML
    public void AbrirCaixa(ActionEvent evente)
    {
        if(LbStatus.getText().equals("Aberto"))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Caixa aberto");
            alert.setHeaderText(null);
            alert.setContentText("O caixa ja esta aberto");
            alert.showAndWait();
        }
        else
        {
            LbStatus.setText("Aberto");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Caixa aberto");
            alert.setHeaderText(null);
            alert.setContentText("O caixa foi aberto");
            alert.showAndWait();
        }
    }
    @FXML
    public void FecharCaixa(ActionEvent evente)
    {
        if(LbStatus.getText().equals("Aberto"))
        {
            LbStatus.setText("Fechado");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Caixa fechado");
            alert.setHeaderText(null);
            alert.setContentText("O caixa foi fechado");
            alert.showAndWait();
        }
        else
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Caixa fechado");
            alert.setHeaderText(null);
            alert.setContentText("O caixa ja esta fechado");
            alert.showAndWait();
        }
    }
    public void Shadow()
    {
        DropShadow Shad = new DropShadow();
        Shad.setOffsetX(4);
        Shad.setOffsetY(6);
        Shad.setColor(Color.rgb(0, 0, 0));
        DropShadow Shad2 = new DropShadow();
        Shad.setOffsetX(2);
        Shad.setOffsetY(4);
        Shad.setColor(Color.rgb(0, 0, 0));
        PnTitulo.setEffect(Shad);
        PnInicial.setEffect(Shad);
        PnStatus.setEffect(Shad);
        PnLucro.setEffect(Shad);
        PnTotal.setEffect(Shad);

    }

}
