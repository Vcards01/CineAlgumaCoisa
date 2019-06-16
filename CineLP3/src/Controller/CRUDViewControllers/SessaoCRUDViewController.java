package Controller.CRUDViewControllers;

import Controller.TableGerControllers.TableGerSessaoController;
import DataBase.FilmeDAO;
import DataBase.SalaDAO;
import DataBase.SessaoDAO;
import Model.Filme;
import Model.Sala;
import Model.Sessao;
import Support.CriarLugares;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    //verifica se é editavel
    private boolean editavel = false;
    //controlador da tela anterior
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
    //Abre em modo edição
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
    @FXML
    public void Save(ActionEvent event)
    {
        String hora;
        hora=SpnHora.getValue()+":"+SpnMin.getValue();
        if((hora.equals("0:0")||CbFilme.getValue()==null||CbSala.getValue()==null||TxtInteira.getText().isEmpty()||TxtMeia.getText().isEmpty()))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos em branco");
            alert.setHeaderText(null);
            alert.setContentText("Não deixe nenhum campo em branco!");
            alert.showAndWait();
        }
        else
        {
            if(!CheckNumber(TxtInteira.getText())||!CheckNumber(TxtMeia.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Preço invalido");
                alert.setHeaderText(null);
                alert.setContentText("Apenas numeros são permitidos!");
                alert.showAndWait();
            }
            else
            {
                SessaoDAO DAO = new SessaoDAO();
                Sessao s = new Sessao(hora,(Filme)CbFilme.getValue(),(Sala)CbSala.getValue(),Double.parseDouble(TxtInteira.getText()),Double.parseDouble(TxtMeia.getText()));
                //Cria um nova sessão e tambem cria os lugares usando uma thread
                if(!editavel)
                {
                    DAO.create(s);
                    CriarLugares l = new CriarLugares();
                    l.SetSessao(DAO.getSessao().get(DAO.getSessao().size()-1));
                    Thread t = new Thread(l);
                    t.start();
                }
                //Atualiza um lugar
                else
                {
                    s.setId(Integer.parseInt(TxtId.getText()));
                    DAO.update(s);
                }
                controller.SetTable();
                Stage janela = (Stage)TxtMeia.getScene().getWindow();
                janela.close();
            }
            }


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
    public void SetController(TableGerSessaoController controller)
    {
        this.controller = controller;
    }
}
