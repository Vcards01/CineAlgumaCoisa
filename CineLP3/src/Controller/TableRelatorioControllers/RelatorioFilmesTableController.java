package Controller.TableRelatorioControllers;

import DataBase.FilmeDAO;
import Model.Filme;
import Model.Relatorios;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RelatorioFilmesTableController implements Initializable {
    public TableView TableFilmes;
    public TableColumn Filmes;
    public TableColumn Ingressos;
    public AnchorPane root;
    private Relatorios r;
    FilmeDAO FDAO = new FilmeDAO();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Filmes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Ingressos.setCellValueFactory(new PropertyValueFactory<>("qtddVendida"));
        TableFilmes.setItems(GetFilmes());
        System.out.println("Devia ter abrido aqui");
    }
    private ObservableList<Filme> GetFilmes()
    {
        ObservableList<Filme>filmes= FXCollections.observableArrayList(FDAO.getFilmes());
        return filmes;
    }
    public void setMedidas(double w,double h)
    {
        root.setPrefWidth(w);
        root.setPrefHeight(h);
    }

}
