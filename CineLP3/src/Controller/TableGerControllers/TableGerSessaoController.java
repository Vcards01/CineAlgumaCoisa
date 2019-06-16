package Controller.TableGerControllers;

import Controller.CRUDViewControllers.SessaoCRUDViewController;
import DataBase.LugarDAO;
import DataBase.SessaoDAO;
import Model.Filme;
import Model.Sala;
import Model.Sessao;
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

public class TableGerSessaoController implements Initializable {
    @FXML
    public AnchorPane SessaoTable;
    @FXML
    public TableView <Sessao> TabelaSessao;
    @FXML
    public TableColumn<Sessao,Filme> ColunaFilme;
    @FXML
    public TableColumn<Sessao, Sala> ColunaSala;
    @FXML
    public TableColumn<Sessao,String> ColunaHoraExib;
    @FXML
    public TableColumn<Sessao,Double>  ColunaPrecoInteira;
    @FXML
    public TableColumn<Sessao,Double>  ColunaPrecoMeia;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColunaFilme.setCellValueFactory(new PropertyValueFactory<>("filme"));
        ColunaSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
        ColunaHoraExib.setCellValueFactory(new PropertyValueFactory<>("horario"));
        ColunaPrecoInteira.setCellValueFactory(new PropertyValueFactory<>("precoEntradaInteira"));
        ColunaPrecoMeia.setCellValueFactory(new PropertyValueFactory<>("precoEntradaMeia"));
        TabelaSessao.setItems(GetSessao());
    }

    private ObservableList<Sessao> GetSessao(){
        SessaoDAO s = new SessaoDAO();
        ObservableList<Sessao> Sessao = FXCollections.observableArrayList(s.getSessao());
        return Sessao;
    }public void SetTable()
    {
        TabelaSessao.getItems().clear();
        TabelaSessao.getItems().addAll(GetSessao());
        TabelaSessao.refresh();
    }
    @FXML
    public void AddSessao(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/SessaoCRUDView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        SessaoCRUDViewController controller = loader.getController();
        controller.SetController(this);
        stage.show();
    }
    @FXML
    public void EditSessao(MouseEvent event) throws IOException {
        if(TabelaSessao.getSelectionModel().getSelectedItem()!=null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/SessaoCRUDView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            SessaoCRUDViewController controller = loader.getController();
            controller.OpenEditable(TabelaSessao.getSelectionModel().getSelectedItem());
            controller.SetController(this);
            stage.show();
        }
    }
    @FXML
    public void RmvSessao(MouseEvent event)
    {
        SessaoDAO DAO = new SessaoDAO();
        LugarDAO LDAO = new LugarDAO();
        LDAO.Delete(TabelaSessao.getSelectionModel().getSelectedItem());
        DAO.delete(TabelaSessao.getSelectionModel().getSelectedItem());
        SetTable();
    }
}
