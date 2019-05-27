package Controller.CRUDViewControllers;

import Controller.TableGerControllers.TableGerFilmeController;
import Controller.TableGerControllers.TableGerSessaoController;
import DataBase.FilmeDAO;
import DataBase.LugarDAO;
import DataBase.SalaDAO;
import DataBase.SessaoDAO;
import Model.Filme;
import Model.Lugares;
import Model.Sala;
import Model.Sessao;
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
import java.util.ResourceBundle;

public class SessaoCRUDViewController implements Initializable {
    @FXML
    public ComboBox CbFilme;
    @FXML
    public ComboBox CbSala;
    @FXML
    public TextField TxtInteira;
    @FXML
    public TextField TxtMeia;
    @FXML
    public Spinner SpnHora;
    @FXML
    public Spinner SpnMin;
    @FXML
    public TextField TxtId;
    private boolean editavel = false;
    private TableGerSessaoController controller;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FillComboBox();
        SetSpinner();
    }
    private void SetSpinner()
    {
        SpinnerValueFactory<Integer> valueFactoryHora = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23);
        SpinnerValueFactory<Integer> valueFactoryMin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59);
        SpnHora.setValueFactory(valueFactoryHora);
        SpnMin.setValueFactory(valueFactoryMin);
    }
    public void FillComboBox() {
        FilmeDAO FDAO = new FilmeDAO();
        SalaDAO SDAO = new SalaDAO();
        ObservableList<Filme> Filmes = FXCollections.observableArrayList(FDAO.getFilmes());
        ObservableList<Sala> Salas = FXCollections.observableArrayList(SDAO.getSalas());
        CbFilme.setItems(Filmes);
        CbSala.setItems(Salas);

    }
    public void OpenEditable(Sessao s)
    {
        String hora,min;
        hora=s.getHorario().substring(0,2);
        min=s.getHorario().substring(3,5);
        editavel=true;
        TxtId.setText(Integer.toString(s.getId()));
        TxtInteira.setText(Double.toString(s.getPrecoEntradaInteira()));
        TxtMeia.setText(Double.toString(s.getPrecoEntradaMeia()));
        SpnHora.getValueFactory().setValue(Integer.parseInt(hora));
        SpnMin.getValueFactory().setValue(Integer.parseInt(min));
        CbSala.setValue(s.getSala());
        CbFilme.setValue(s.getFilme());
    }
    @FXML
    public void Cancelar(ActionEvent event)
    {
        Stage janela = (Stage)TxtMeia.getScene().getWindow();
        janela.close();
    }

    public void Save(ActionEvent event)
    {
       SessaoDAO DAO = new SessaoDAO();
        LugarDAO LDAO = new LugarDAO();
        String hora;
        hora=SpnHora.getValue()+":"+SpnMin.getValue();
        Sessao s = new Sessao(hora,(Filme)CbFilme.getValue(),(Sala)CbSala.getValue(),Double.parseDouble(TxtInteira.getText()),Double.parseDouble(TxtMeia.getText()));
        if(!editavel)
        {
            DAO.create(s);
            for(int i=0;i<s.getSala().getQtddLugares();i++)
            {

                Lugares l = new Lugares(i+1,false,DAO.getSessao().get(DAO.getSessao().size()-1));
                LDAO.create(l);
            }
        }
        else
        {
            s.setId(Integer.parseInt(TxtId.getText()));
            DAO.update(s);
        }
        controller.SetTable();
        Stage janela = (Stage)TxtMeia.getScene().getWindow();
        janela.close();
    }
    public void SetController(TableGerSessaoController controller)
    {
        this.controller = controller;
    }
}
