package Controller;

import Model.Filme;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class SalasGerTableController {

    @FXML
    public AnchorPane SalasTable;
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


    public void SetMedidas(double h, double w)
    {
        SalasTable.setPrefWidth(w);
        SalasTable.setPrefHeight(h);
    }
}
