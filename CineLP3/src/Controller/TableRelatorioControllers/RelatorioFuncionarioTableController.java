package Controller.TableRelatorioControllers;

import DataBase.FuncionarioDAO;
import Model.Funcionario;
import Model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RelatorioFuncionarioTableController implements Initializable {

    public AnchorPane root;
    public TableView TableFuncionarios;
    public TableColumn Funcionarios;
    public TableColumn Vendidos;
    private FuncionarioDAO DAO = new FuncionarioDAO();

    public void initialize(URL location, ResourceBundle resources) {
        Funcionarios.setCellValueFactory(new PropertyValueFactory <>("nome"));
        Vendidos.setCellValueFactory(new PropertyValueFactory<>("qtddVendas"));
        TableFuncionarios.setItems(GetFuncionarios());
        System.out.println("Devia ter abrido aqui");
    }
    private ObservableList <Funcionario> GetFuncionarios()
    {
        ArrayList<Funcionario>Func = new ArrayList <>();
        for (Funcionario x:DAO.getFuncionarios())
        {
            if(x.getQtddVendas()>0)
            {
                Func.add(x);
            }
        }
        ObservableList<Funcionario>funcionarios= FXCollections.observableArrayList(Func);
        return funcionarios;
    }
    public void setMedidas(double w,double h)
    {
        root.setPrefWidth(w);
        root.setPrefHeight(h);
    }
}
