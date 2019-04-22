package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VendaIngressosController implements Initializable {
    public AnchorPane PnPrincipal;
    public Spinner SpnInt;
    public Spinner SpnMeia;
    public Pane PnIngressos;
    public Pane PnSelecionar;
    public Pane PnBilheteria;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactoryInt = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
        SpinnerValueFactory<Integer> valueFactoryMeia = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
        SpnInt.setValueFactory(valueFactoryInt);
        SpnMeia.setValueFactory(valueFactoryMeia);
        Shadow();

    }
    public void GetMedidas(Double h,double w)
    {
        PnPrincipal.setPrefWidth(w);
        PnPrincipal.setPrefHeight(h);
    }
    public void close()
    {
        Stage login = (Stage)PnPrincipal.getScene().getWindow();
        login.close();
    }
    public void Shadow()
    {
        DropShadow Shad = new DropShadow();
        Shad.setOffsetX(4);
        Shad.setOffsetY(6);
        Shad.setColor(Color.rgb(0, 0, 0));
        PnIngressos.setEffect(Shad);
        PnBilheteria.setEffect(Shad);
        PnSelecionar.setEffect(Shad);


    }
}
