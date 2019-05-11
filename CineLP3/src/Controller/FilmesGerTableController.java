package Controller;

import DataBaseSimulation.FilmesDAO;
import Model.Filme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


public class FilmesGerTableController implements Initializable {
    @FXML
    public AnchorPane FilmesTable;
    @FXML
    public TableView<Filme> Tabela;
    @FXML
    public TableColumn<Filme,String> ColunaTitulo;
    @FXML
    public TableColumn<Filme,String> ColunaGenero;
    @FXML
    public TableColumn<Filme,String> ColunaDuracao;
    @FXML
    public TableColumn<Filme,String> ColunaSinopse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColunaTitulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Tabela.setItems(GetFilmes());
    }

    public void SetMedidas(double h, double w)
    {
        FilmesTable.setPrefWidth(w);
        FilmesTable.setPrefHeight(h);
    }

    private ObservableList<Filme> GetFilmes() {
        FilmesDAO f = null;
        try {
            f = new FilmesDAO();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<Filme> Filmes = FXCollections.observableArrayList(f.getFilmes());
        return Filmes;
    }

}
