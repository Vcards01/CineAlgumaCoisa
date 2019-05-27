package Controller.CRUDViewControllers;

import Controller.TableGerControllers.TableGerFilmeController;
import Controller.TableGerControllers.TableGerFuncionarioController;
import DataBase.FilmeDAO;
import DataBase.FuncionarioDAO;
import Model.Filme;
import Model.Funcionario;
import Model.Sala;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FuncionarioCRUDViewController implements Initializable {
    @FXML
    public TextField TxtNome;
    @FXML
    public TextField TxtSenha;
    @FXML
    public TextField TxtUsuario;
    @FXML
    public TextField TxtSalario;
    @FXML
    public TextField TxtCPF;
    @FXML
    public ComboBox CbTipo;
    private boolean editavel=false;
    private TableGerFuncionarioController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FillCombobox();
    }
    public void OpenEditable(Funcionario f)
    {
        editavel=true;
        TxtNome.setText(f.getNome());
        TxtCPF.setText(f.getCpf());
        TxtSalario.setText(Double.toString(f.getSalario()));
        TxtSenha.setText(f.getSenha());
        TxtUsuario.setText(f.getUsuario());
        CbTipo.setValue(f.getTipo());
    }
    public void SetController(TableGerFuncionarioController controller)
    {
        this.controller = controller;
    }
    @FXML
    public void Cancelar(ActionEvent event)
    {
        Stage janela = (Stage)TxtNome.getScene().getWindow();
        janela.close();
    }
    public void Save(ActionEvent event)
    {
        FuncionarioDAO DAO = new FuncionarioDAO();
        Funcionario f = new Funcionario(TxtCPF.getText(),TxtNome.getText(),TxtSenha.getText(),TxtUsuario.getText(),CbTipo.getValue().toString(),Double.parseDouble(TxtSalario.getText()));
        if(!editavel)
        {
            DAO.create(f);
        }
        else
        {
            DAO.update(f);
        }
        controller.SetTable();
        Stage janela = (Stage)TxtNome.getScene().getWindow();
        janela.close();

    }
    public void FillCombobox()
    {
        ArrayList<String>Tipo = new ArrayList<>();
        Tipo.add("Administrador");
        Tipo.add("Atendente");
        ObservableList<String>Tipos = FXCollections.observableArrayList(Tipo);
        CbTipo.setItems(Tipos);
    }
}
