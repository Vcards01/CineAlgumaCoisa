package Controller;

import DataBaseSimulation.FilmesDataBase;
import Model.Filme;
import Model.Sala;
import Model.Sessao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VendaIngressosController implements Initializable {
    public AnchorPane PnPrincipal;
    public Spinner SpnInt;
    public Spinner SpnMeia;
    public Pane PnIngressos;
    public Pane PnSelecionar;
    public Pane PnBilheteria;
    public ImageView ImgCapa;
    public ComboBox CbFilme;
    public Pane PnCenter;
    public Label LbValorTotal;
    public ComboBox CbSessao;
    public Label LbSala;
    public Label LbPrecoInteira;
    public Label LbPrecoMeia;
    public Button BtnCancelar;
    public Button BtnConfirmar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SetSpinner();
        Shadow();
        CbFilme.setItems(GetFilmes());
        ChangeCapa();
        ChangeTotal();
        ChangeSala();
 }
    private void SetSpinner()
    {
        SpinnerValueFactory<Double> valueFactoryInt = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,100);
        SpinnerValueFactory<Double> valueFactoryMeia = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,100);
        SpnInt.setValueFactory(valueFactoryInt);
        SpnMeia.setValueFactory(valueFactoryMeia);
    }
    private void ChangeCapa()
    {
        CbFilme.valueProperty().addListener(new ChangeListener<Filme>() {
            @Override public void changed(ObservableValue ov, Filme f, Filme f1) {
                ImgCapa.setImage(f1.getImage());
                ObservableList<Sessao> Sessões = FXCollections.observableArrayList(f1.getSessoes());
                CbSessao.setItems(Sessões);
            }
        });
    }
    private void ChangeSala(){
        CbSessao.valueProperty().addListener(new ChangeListener<Sessao>() {
            @Override public void changed(ObservableValue ov, Sessao s, Sessao s1) {
                LbSala.setText(Integer.toString(s1.getSala().getId()));
                LbPrecoInteira.setText(Double.toString(s1.getPrecoEntradaInteira()));
                LbPrecoMeia.setText(Double.toString(s1.getPrecoEntradaMeia()));

            }
        });
    }
    private void ChangeTotal()
    {
        SpnInt.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue observable, Double oldValue, Double newValue) {
                LbValorTotal.setText(Double.toString(newValue * Double.parseDouble(LbPrecoInteira.getText())+ (double)SpnMeia.getValue()*Double.parseDouble(LbPrecoMeia.getText())));
            }
        });
        SpnMeia.valueProperty().addListener(new ChangeListener<Double>() {
            @Override
            public void changed(ObservableValue observable, Double oldValue, Double newValue) {
                LbValorTotal.setText(Double.toString(newValue * Double.parseDouble(LbPrecoMeia.getText())+ (double)SpnInt.getValue()*Double.parseDouble(LbPrecoInteira.getText())));
            }
        });
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
    private void Shadow()
    {
        DropShadow Shad = new DropShadow();
        Shad.setOffsetX(4);
        Shad.setOffsetY(6);
        Shad.setColor(Color.rgb(0, 0, 0));
        PnIngressos.setEffect(Shad);
        PnBilheteria.setEffect(Shad);
        PnSelecionar.setEffect(Shad);
    }
    private ObservableList<Filme> GetFilmes() {
        FilmesDataBase f = null;
        try {
            f = new FilmesDataBase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<Filme> Filmes = FXCollections.observableArrayList(f.getSimulation());
        return Filmes;

    }
    public void Cancelar(ActionEvent evente)
    {
        SpnInt.getValueFactory().setValue(0.0);
        SpnMeia.getValueFactory().setValue(0.0);
    }
    public void Confirma(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/EscolhaLugar.fxml"));
       AnchorPane pane = loader.load();
       EscolhaLugarController controller = loader.getController();
       Sessao s = (Sessao)CbSessao.getValue();
       controller.getSala(s.getSala());
        Scene scene = new Scene(pane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

}
