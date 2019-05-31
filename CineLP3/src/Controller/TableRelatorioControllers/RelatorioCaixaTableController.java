package Controller.TableRelatorioControllers;

import DataBase.CaixaDAO;
import Model.Caixa;
import Model.Venda;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RelatorioCaixaTableController implements Initializable {
    public AnchorPane root;
    public TableView TableCaixa;
    public TableColumn Data;
    public TableColumn ValorInicial;
    public TableColumn ValorFinal;
    public TableColumn ValorLucro;
    private CaixaDAO DAO = new CaixaDAO();

    public void initialize(URL location, ResourceBundle resources) {
        Data.setCellValueFactory(new PropertyValueFactory <>("data"));
        ValorInicial.setCellValueFactory(new PropertyValueFactory<>("valorInicial"));
        ValorFinal.setCellValueFactory(new PropertyValueFactory<>("valorAtual"));
        ValorLucro.setCellValueFactory(new PropertyValueFactory<>("lucro"));
        TableCaixa.setItems(GetVendas());
        System.out.println("Devia ter abrido aqui");
    }
    private ObservableList <Caixa> GetVendas()
    {
        ObservableList<Caixa>caixas= FXCollections.observableArrayList(DAO.getCaixa());
        return caixas;
}
    public void setMedidas(double w,double h)
    {
        root.setPrefWidth(w);
        root.setPrefHeight(h);
    }
}
