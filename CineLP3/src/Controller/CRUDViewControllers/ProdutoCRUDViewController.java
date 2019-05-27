package Controller.CRUDViewControllers;

import Controller.TableGerControllers.TableGerEstoqueController;
import DataBase.ProdutoDAO;
import Model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProdutoCRUDViewController implements Initializable {
    @FXML
    public TextField TxtPreco;
    @FXML
    public TextField TxtId;
    @FXML
    public TextField TxtNome;
    @FXML
    public Spinner SpnQuantidade;
    @FXML
    public ComboBox CbTipo;
    private boolean editavel=false;
    private TableGerEstoqueController controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FillComboBox();
        SetSpinner();
    }
    public void OpenEditable(Produto p)
    {
        editavel=true;
        TxtId.setText(Integer.toString(p.getId()));
        TxtNome.setText(p.getNome());
        TxtPreco.setText(Double.toString(p.getPreco()));
        SpnQuantidade.getValueFactory().setValue(p.getQuantidade());
        CbTipo.setValue(p.getTipo());
    }
    public void FillComboBox()
    {
        ArrayList<String>tipos = new ArrayList<>();
        tipos.add("Salgado");
        tipos.add("Doce");
        tipos.add("Bebida");
        ObservableList<String>tipo = FXCollections.observableArrayList(tipos);
        CbTipo.setItems(tipo);
    }
    public void SetSpinner()
    {
        SpinnerValueFactory<Integer> valueFactoryQuantidade = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100);
        SpnQuantidade.setValueFactory(valueFactoryQuantidade);
    }
    @FXML
    public void Cancelar(ActionEvent event)
    {
        Stage janela = (Stage)TxtPreco.getScene().getWindow();
        janela.close();
    }
    public void SetController(TableGerEstoqueController controller)
    {
        this.controller = controller;
    }
    @FXML
    public void Cancel(ActionEvent event)
    {
        Stage janela = (Stage)TxtPreco.getScene().getWindow();
        janela.close();

    }
    public void Save(ActionEvent event)
    {
        ProdutoDAO DAO = new ProdutoDAO();
        Produto p= new Produto((int)SpnQuantidade.getValue(),TxtNome.getText(),CbTipo.getValue().toString(),Double.parseDouble(TxtPreco.getText()));
        if(!editavel)
        {
            DAO.create(p);
        }
        else
        {
            p.setId(Integer.parseInt(TxtId.getText()));
            DAO.update(p);
        }
        controller.SetTable();
        Stage janela = (Stage)TxtPreco.getScene().getWindow();
        janela.close();

    }
}
