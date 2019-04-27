package Controller;

import DataBaseSimulation.FilmesDataBase;
import Model.Filme;
import Model.Sessao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.util.ResourceBundle;

public class VendaIngressosController implements Initializable {
    @FXML
    private AnchorPane PnPrincipal;
    @FXML
    public Spinner SpnInt;
    @FXML
    public Spinner SpnMeia;
    @FXML
    public Pane PnIngressos;
    @FXML
    public Pane PnSelecionar;
    @FXML
    public Pane PnBilheteria;
    @FXML
    public ImageView ImgCapa;
    @FXML
    public ComboBox CbFilme;
    @FXML
    public Label LbValorTotal;
    @FXML
    public ComboBox CbSessao;
    @FXML
    public Label LbSala;
    @FXML
    public Label LbPrecoInteira;
    @FXML
    public Label LbPrecoMeia;
    @FXML
    public Button BtnCancelar;
    @FXML
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
    @FXML
    private void SetSpinner()
    {
        SpinnerValueFactory<Double> valueFactoryInt = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,100);
        SpinnerValueFactory<Double> valueFactoryMeia = new SpinnerValueFactory.DoubleSpinnerValueFactory(0,100);
        SpnInt.setValueFactory(valueFactoryInt);
        SpnMeia.setValueFactory(valueFactoryMeia);
    }
    @FXML
    private void ChangeCapa()
    {

            CbFilme.valueProperty().addListener(new ChangeListener<Filme>() {
                @Override public void changed(ObservableValue ov, Filme f, Filme f1) {

                    ImgCapa.setImage(f1.getImage());
                    ObservableList<Sessao> Sessões = FXCollections.observableArrayList(f1.getSessoes());
                    CbSessao.setItems(Sessões);
                    LbValorTotal.setText("0.0");
                    SpnInt.getValueFactory().setValue(0.0);
                    SpnMeia.getValueFactory().setValue(0.0);
                    LbPrecoInteira.setText("0.0");
                    LbPrecoMeia.setText("0.0");
                }
            });
    }

    @FXML
    private void ChangeSala(){
        CbSessao.valueProperty().addListener(new ChangeListener<Sessao>() {
            @Override public void changed(ObservableValue ov, Sessao s, Sessao s1) {
                if(s1!=null)
                {
                    LbSala.setText(Integer.toString(s1.getSala().getId()));
                    LbPrecoInteira.setText(Double.toString(s1.getPrecoEntradaInteira()));
                    LbPrecoMeia.setText(Double.toString(s1.getPrecoEntradaMeia()));
                    LbValorTotal.setText("0.0");
                    SpnInt.getValueFactory().setValue(0.0);
                    SpnMeia.getValueFactory().setValue(0.0);
                }
                else
                {
                    LbSala.setText("-");
                }
             }
        });
    }
    @FXML
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
    @FXML
    public void Cancelar(ActionEvent evente)
    {
        SpnInt.getValueFactory().setValue(0.0);
        SpnMeia.getValueFactory().setValue(0.0);
    }
    @FXML
    public void Confirma(ActionEvent event) throws IOException {
        if(Double.parseDouble(LbValorTotal.getText())!=0.0)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/EscolhaLugar.fxml"));
            AnchorPane pane = loader.load();
            EscolhaLugarController controller = loader.getController();
            Sessao s = (Sessao)CbSessao.getValue();
            controller.SetTela(s);
            Scene scene = new Scene(pane,1000,500);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Valor total invalido");
            alert.setHeaderText(null);
            alert.setContentText("Verifique se todos os passos para compra de um ingresso foram executados!");
            alert.showAndWait();
        }


    }

}
