package Controller.TableGerControllers;

import Controller.CRUDViewControllers.FilmesCRUDViewController;
import DataBase.FilmeDAO;
import Model.Filme;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class TableGerFilmeController implements Initializable {
    @FXML
    public AnchorPane FilmesTable;
    @FXML
    public TableView<Filme> Tabela;
    @FXML
    public TableColumn<Filme,String> ColunaTitulo;
    @FXML
    public TableColumn<Filme,String> ColunaGenero;
    @FXML
    public TableColumn<Filme,String> ColunaDuracao;
    @FXML
    public Pane AddBtn;
    @FXML
    public Pane EditBtn;
    @FXML
    public Pane RmvBtn;

    @FXML


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ColunaTitulo.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ColunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        ColunaDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        Tabela.setItems(GetFilmes());
    }

    private ObservableList<Filme> GetFilmes() {
        FilmeDAO fDAO = new FilmeDAO();
        ObservableList<Filme> Filmes = FXCollections.observableArrayList(fDAO.getFilmes());
        return Filmes;
    }
    public void SetTable()
    {
        Tabela.getItems().clear();
        Tabela.getItems().addAll(GetFilmes());
        Tabela.refresh();
    }
    @FXML
    public void AddFilme(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/FilmesCRUDView.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        FilmesCRUDViewController controller = loader.getController();
        controller.SetController(this);
        stage.show();
    }
    @FXML
    public void EditFilme(MouseEvent event) throws IOException {
        if(Tabela.getSelectionModel().getSelectedItem()!=null)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/FilmesCRUDView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            FilmesCRUDViewController controller = loader.getController();
            controller.SetController(this);
            controller.OpenEditable(Tabela.getSelectionModel().getSelectedItem());
            stage.show();
        }
    }
    @FXML
    public void RmvFilme(MouseEvent event)
    {
        FilmeDAO fDAO = new FilmeDAO();
        Filme f = Tabela.getSelectionModel().getSelectedItem();
        fDAO.delete(f);
        SetTable();

    }

}
