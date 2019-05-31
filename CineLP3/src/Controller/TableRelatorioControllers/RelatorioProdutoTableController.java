package Controller.TableRelatorioControllers;

import DataBase.ProdutoDAO;
import Model.Filme;
import Model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RelatorioProdutoTableController implements Initializable {
    public TableView TableProdutos;
    public TableColumn Produtos;
    public TableColumn Vendidos;
    public AnchorPane root;
    ProdutoDAO PDAO = new ProdutoDAO();
    public void initialize(URL location, ResourceBundle resources) {
       Produtos.setCellValueFactory(new PropertyValueFactory <>("nome"));
       Vendidos.setCellValueFactory(new PropertyValueFactory<>("quantidadeDeVenda"));
        TableProdutos.setItems(GetProdutos());
        System.out.println("Devia ter abrido aqui");
    }
    private ObservableList <Produto> GetProdutos()
    {
        ObservableList<Produto>produtos= FXCollections.observableArrayList(PDAO.getProdutos());
        return produtos;
    }
    public void setMedidas(double w,double h)
    {
        root.setPrefWidth(w);
        root.setPrefHeight(h);
    }
}
