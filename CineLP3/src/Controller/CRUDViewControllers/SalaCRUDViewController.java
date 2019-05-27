package Controller.CRUDViewControllers;

import Controller.TableGerControllers.TableGerSalaController;
import DataBase.SalaDAO;
import Model.Sala;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SalaCRUDViewController implements Initializable {
    @FXML
    public TextField Txtid;
    @FXML
    public TextField TxtQuantidadeLugares;
    private boolean editavel = false;
    private TableGerSalaController controller;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void OpenEditable(Sala s)
    {
        editavel=true;
        Txtid.setText(Integer.toString(s.getId()));
        TxtQuantidadeLugares.setText(Integer.toString(s.getQtddLugares()));
    }
    @FXML
    public void Cancelar(ActionEvent event)
    {
        Stage janela = (Stage)Txtid.getScene().getWindow();
        janela.close();
    }
    public void Save(ActionEvent event)
    {
        SalaDAO DAO = new SalaDAO();
        Sala s = new Sala(Integer.parseInt(TxtQuantidadeLugares.getText()));
        if(!editavel)
        {
            DAO.create(s);
        }
        else
        {
            s.setId(Integer.parseInt(Txtid.getText()));
            DAO.update(s);
        }
        controller.SetTable();
        Stage janela = (Stage)TxtQuantidadeLugares.getScene().getWindow();
        janela.close();
    }

    public void SetController(TableGerSalaController controller)
    {
        this.controller = controller;
    }
}
