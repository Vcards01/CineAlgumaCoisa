package Controller.TableGerControllers;

import Controller.CRUDViewControllers.FuncionarioCRUDViewController;
import DataBase.FuncionarioDAO;
import Model.Funcionario;
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

public class TableGerFuncionarioController implements Initializable {
    @FXML
    public AnchorPane FuncTable;
    @FXML
    public TableColumn<Funcionario,String> ColunaNome;
    @FXML
    public TableColumn<Funcionario,String> ColunaFuncao;
    @FXML
    public TableColumn<Funcionario,String> ColunaCPF;
    @FXML
    public TableColumn<Funcionario,Double> ColunaSalario;
    @FXML
    public TableColumn<Funcionario,String> ColunaUsuario;
    @FXML
    public TableView <Funcionario> TabelaFunc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ColunaFuncao.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        ColunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        ColunaSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        ColunaUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        TabelaFunc.setItems(GetFuncionario());

    }
    private ObservableList<Funcionario> GetFuncionario() {
        FuncionarioDAO f = new FuncionarioDAO();
        ObservableList<Funcionario> Funcionarios = FXCollections.observableArrayList(f.getFuncionarios());
        return Funcionarios;
    }
    @FXML
    public void AddFuncionario(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/FuncionarioCRUDView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    @FXML
    public void EditFuncionario(MouseEvent event) throws IOException {
        if(TabelaFunc.getSelectionModel().getSelectedItem()!=null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/FuncionarioCRUDView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            FuncionarioCRUDViewController controller = loader.getController();
            controller.OpenEditable(TabelaFunc.getSelectionModel().getSelectedItem());
            stage.show();
        }
    }
    @FXML
    public void RmvFuncionario(MouseEvent event)
    {

    }


}
