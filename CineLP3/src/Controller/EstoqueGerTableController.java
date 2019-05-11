package Controller;

import Model.Filme;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EstoqueGerTableController {

        @FXML
        public AnchorPane EstoqueTable;
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
            EstoqueTable.setPrefWidth(w);
            EstoqueTable.setPrefHeight(h);
        }
}
