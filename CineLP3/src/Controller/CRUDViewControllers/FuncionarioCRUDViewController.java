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
import javafx.scene.control.Alert;
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
    //Verifica se editavel
    private boolean editavel=false;
    //Controller da tela anterior
    private TableGerFuncionarioController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FillCombobox();
    }
    //Abre em modo edição
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
    @FXML
    public void Save(ActionEvent event)
    {
        if(TxtCPF.getText().isEmpty()||TxtNome.getText().isEmpty()||TxtSenha.getText().isEmpty()||TxtUsuario.getText().isEmpty()||CbTipo.getValue()==null||TxtSalario.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos em branco");
            alert.setHeaderText(null);
            alert.setContentText("Não deixe nenhum campo em branco!");
            alert.showAndWait();
        }
        else
        {
            if(!CheckNumber(TxtCPF.getText())||!CheckNumber(TxtSalario.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CPF ou Salario invalido");
                alert.setHeaderText(null);
                alert.setContentText("Apenas numeros são permitidos!");
                alert.showAndWait();
            }
            else
            {
                FuncionarioDAO DAO = new FuncionarioDAO();
                Funcionario f = new Funcionario(TxtCPF.getText(),TxtNome.getText(),TxtSenha.getText(),TxtUsuario.getText(),CbTipo.getValue().toString(),Double.parseDouble(TxtSalario.getText()));
                //Salva um novo funcinario
                if(!editavel)
                {
                    DAO.create(f);
                }
                //Atualiza um funcionario
                else
                {
                    DAO.update(f);
                }
                controller.SetTable();
                Stage janela = (Stage)TxtNome.getScene().getWindow();
                janela.close();

            }
        }

    }
    public void FillCombobox()
    {
        ArrayList<String>Tipo = new ArrayList<>();
        Tipo.add("Administrador");
        Tipo.add("Atendente");
        ObservableList<String>Tipos = FXCollections.observableArrayList(Tipo);
        CbTipo.setItems(Tipos);
    }
    public boolean CheckNumber( String s ) {
        // cria um array de char
        char[] c = s.toCharArray();
        boolean d = true;
        for ( int i = 0; i < c.length; i++ ){
            // verifica se o char não é um dígito
            if(c[i]=='.')
            {
                continue;
            }
            else if ( !Character.isDigit( c[ i ] ) ) {
                d = false;
                break;
            }
        }
        return d;
    }
}
