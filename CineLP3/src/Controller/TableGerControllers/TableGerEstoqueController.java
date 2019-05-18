package Controller.TableGerControllers;

import Controller.CRUDViewControllers.ProdutoCRUDViewController;
import DataBase.ProdutoDAO;
import Model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableGerEstoqueController implements Initializable{

    @FXML
    public AnchorPane EstoqueTable;
    @FXML
    public TableView <Produto> TabelaEstoque;
    @FXML
    public TableColumn<Produto,String> ColunaNome;
    @FXML
    public TableColumn<Produto,String> ColunaTipo;
    @FXML
    public TableColumn<Produto,Double> ColunaPreco;
    @FXML
    public TableColumn <Produto, Integer> ColunaQtddEstoq;

        @Override
    public void initialize(URL location, ResourceBundle resources) {
       ColunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
       ColunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
       ColunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
       ColunaQtddEstoq.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
       TabelaEstoque.setItems(GetProduto());
    }

    private ObservableList<Produto> GetProduto() {
        ProdutoDAO p = new ProdutoDAO();
        ObservableList<Produto> Produtos = FXCollections.observableArrayList(p.getProdutos());
        return Produtos;
     }
    @FXML
    public void AddProduto(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/ProdutoCRUDView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    @FXML
    public void EditProduto(MouseEvent event) throws IOException {
        if(TabelaEstoque.getSelectionModel().getSelectedItem()!=null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/ProdutoCRUDView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            ProdutoCRUDViewController controller = loader.getController();
            controller.OpenEditable(TabelaEstoque.getSelectionModel().getSelectedItem());
            stage.show();
        }
    }
    @FXML
    public void RmvProduto(MouseEvent event)
    {

    }



}
