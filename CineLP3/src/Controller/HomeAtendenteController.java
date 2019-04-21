package Controller;

import DataBaseSimulation.FilmesDataBase;
import Model.Filme;
import Model.Funcionario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeAtendenteController implements Initializable {
    public Pane PnInfo;
    @FXML
    private ImageView ImgCapaFilme;
    @FXML
    private Button btnVerMais;
    @FXML
    private TableView<Filme> Tabela;
    @FXML
    private TableColumn<Filme,String> ColunaFilme;
    @FXML
    private TableColumn<Filme,String> ColunaGenero;
    @FXML
    private Pane PnLogout;
    @FXML
    private Label lbUsuario;
    @FXML
    private Label LbHora;
    @FXML
    private Label LbTitulo;
    @FXML
    private Label LbGenero;
    @FXML
    private Label LbDuracao;
    @FXML
    public Label LbSinopse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PnInfo.setVisible(false);
        setHora();
        ColunaFilme.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ColunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        Tabela.setItems(GetFilmes());
    }
    @FXML
    public  void GetUser(Funcionario f)
    {
        lbUsuario.setText(f.getUsuario());
    }
    @FXML
    public void Logout(MouseEvent event)
    {
        Stage stage = (Stage)PnLogout.getScene().getWindow();
        stage.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            Stage login = new Stage();
            Scene scene = new Scene(root);
            login.initStyle(StageStyle.UNDECORATED);
            login.setScene(scene);
            login.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void setHora()
    {
        LbHora.setEffect(new DropShadow(10, Color.WHITE));
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    @FXML
    private void atualizaHoras() {
        Date agora = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");
        LbHora.setText(formatador.format(agora));
    }

    private ObservableList<Filme> GetFilmes() {
        FilmesDataBase f = null;
        try {
            f = new FilmesDataBase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObservableList<Filme> Filmes = FXCollections.observableArrayList(f.getSimulation());
        return Filmes;

    }

    @FXML
    public void VerMais(ActionEvent evente)
    {
        Filme f = Tabela.getSelectionModel().getSelectedItem();
        LbTitulo.setText(f.getNome());
        LbGenero.setText(f.getGenero());
        LbDuracao.setText(f.getDuracao());
        LbSinopse.setText(f.getSinopse());
        ImgCapaFilme.setImage(f.getImage());
        PnInfo.setVisible(true);
    }
    }


