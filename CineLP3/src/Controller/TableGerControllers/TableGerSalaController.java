package Controller.TableGerControllers;

import Controller.CRUDViewControllers.SalaCRUDViewController;
import DataBase.SalaDAO;
import Model.Sala;
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

public class TableGerSalaController implements Initializable {

    @FXML
    public AnchorPane SalasTable;
    @FXML
    public TableView <Sala>TabelaSala;
    @FXML
    public TableColumn <Sala,Integer> ColunaQtddLugares;
    @FXML
    public TableColumn <Sala,Integer> ColunaNumeroSala;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColunaNumeroSala.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColunaQtddLugares.setCellValueFactory(new PropertyValueFactory<>("qtddLugares"));
        TabelaSala.setItems(GetSala());
    }

    public ObservableList<Sala> GetSala()
    {
        SalaDAO s = new SalaDAO();
        ObservableList<Sala> Salas = FXCollections.observableArrayList(s.getSalas());
        return Salas;
    }
    @FXML
    public void AddSala(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/SalaCRUDView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    @FXML
    public void EditSala(MouseEvent event) throws IOException {
        if(TabelaSala.getSelectionModel().getSelectedItem()!=null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/SalaCRUDView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            SalaCRUDViewController controller = loader.getController();
            controller.OpenEditable(TabelaSala.getSelectionModel().getSelectedItem());
            stage.show();
        }
    }
    @FXML
    public void RmvSala(MouseEvent event)
    {

    }
}
