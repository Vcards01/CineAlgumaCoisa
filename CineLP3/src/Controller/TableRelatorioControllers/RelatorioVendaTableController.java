package Controller.TableRelatorioControllers;

import DataBase.VendaDAO;
import Model.Produto;
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

public class RelatorioVendaTableController implements Initializable {
    public TableView TableVendas;
    public TableColumn Data;
    public TableColumn Hora;
    public TableColumn Valor;
    public AnchorPane root;
    VendaDAO DAO = new VendaDAO();

    public void initialize(URL location, ResourceBundle resources) {
        Data.setCellValueFactory(new PropertyValueFactory <>("data"));
        Hora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        Valor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
        TableVendas.setItems(GetVendas());
        System.out.println("Devia ter abrido aqui");
    }
    private ObservableList <Venda> GetVendas()
    {
        ObservableList<Venda>vendas= FXCollections.observableArrayList(DAO.getVendas());
        System.out.println(vendas.size());
        return vendas;
    }
    public void setMedidas(double w,double h)
    {
        root.setPrefWidth(w);
        root.setPrefHeight(h);
    }
}
