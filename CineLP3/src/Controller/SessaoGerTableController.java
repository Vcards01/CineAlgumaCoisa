package Controller;

import Model.Filme;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class SessaoGerTableController {
    @FXML
    public AnchorPane SessaoTable;
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
        SessaoTable.setPrefWidth(w);
        SessaoTable.setPrefHeight(h);
    }
}
