package Controller;

import DataBaseSimulation.FilmesDAO;
import Model.Filme;
import Model.Funcionario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeAdminController implements Initializable {
    @FXML
    public Pane PnInfo;
    @FXML
    public AnchorPane PnRoot;
    @FXML
    public Label LbTituloJanela;
    @FXML
    public Pane PnButton;
    @FXML
    public Pane PnHome;
    @FXML
    public Pane PnGerenciamento;
    @FXML
    public Pane PnCaixa;
    @FXML
    private Label LbData;
    @FXML
    private AnchorPane PnMenu;
    @FXML
    private Pane PnVenda;
    @FXML
    private Pane PnDataHora;
    @FXML
    private AnchorPane PnTopo;
    @FXML
    private Label LbClose;
    @FXML
    private Label LbVendasRealizadas;
    @FXML
    private AnchorPane PnJanelas;
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
       SetHora();
       SetData();
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
    public void HandleClose(MouseEvent Event)
    {
        Platform.exit();
        System.exit(0);
    }
    public void OpenHome(MouseEvent Event){
        PnJanelas.getChildren().clear();
        PnRoot.setStyle("-fx-background-color:   #082640");
        PnMenu.setStyle("-fx-background-color:    #1F72A6");
        PnTopo.setStyle("-fx-background-color:   #1F72A6");
        LbTituloJanela.setText("Home Screen");
        PnJanelas.getChildren().setAll(PnDataHora,PnVenda,Tabela,PnInfo,PnButton);
        HomeHighlight();
    }
    @FXML
    public void OpenGerenciador(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Gerenciamento.fxml"));
        AnchorPane pane = loader.load();
        GerenciamentoController controller = loader.getController();
        controller.SetMedidas(PnJanelas.getHeight(),PnJanelas.getWidth());
        PnRoot.setStyle("-fx-background-color:  #1B0140");
        PnMenu.setStyle("-fx-background-color:  #4703A6");
        PnTopo.setStyle("-fx-background-color:  #4703A6");
        LbTituloJanela.setText("Gerenciamento");
        PnJanelas.getChildren().setAll(pane);
        GerenciamentoHighlight();
    }
    private void HomeHighlight() {
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color: #082640");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnGerenciamento.setOnMouseEntered(event -> { PnGerenciamento.setStyle("-fx-background-color:  #082640");});
        PnGerenciamento.setOnMouseExited(event -> {PnGerenciamento.setStyle("-fx-background-color:  transparent");});
        PnCaixa.setOnMouseEntered(event -> {PnCaixa.setStyle("-fx-background-color:  #082640");});
        PnCaixa.setOnMouseExited(event -> {PnCaixa.setStyle("-fx-background-color:  transparent");});
    }
    private void GerenciamentoHighlight() {
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color:  #1B0140");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnGerenciamento.setOnMouseEntered(event -> { PnGerenciamento.setStyle("-fx-background-color:  #1B0140");});
        PnGerenciamento.setOnMouseExited(event -> {PnGerenciamento.setStyle("-fx-background-color:  transparent");});
        PnCaixa.setOnMouseEntered(event -> {PnCaixa.setStyle("-fx-background-color:  #1B0140");});
        PnCaixa.setOnMouseExited(event -> {PnCaixa.setStyle("-fx-background-color:  transparent");});
    }
    private void CaixaHighlight() {
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color:  #1B0140");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnGerenciamento.setOnMouseEntered(event -> { PnGerenciamento.setStyle("-fx-background-color:  #1B0140");});
        PnGerenciamento.setOnMouseExited(event -> {PnGerenciamento.setStyle("-fx-background-color:  transparent");});
        PnCaixa.setOnMouseEntered(event -> {PnCaixa.setStyle("-fx-background-color:  #1B0140");});
        PnCaixa.setOnMouseExited(event -> {PnCaixa.setStyle("-fx-background-color:  transparent");});
    }
    @FXML
    public void SetHora()
    {
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    @FXML
    public  void SetUser(Funcionario f)
    {
        lbUsuario.setText(f.getUsuario());

    }
    @FXML
    private void atualizaHoras() {
        Date agora = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");
        LbHora.setText(formatador.format(agora));
    }
    private void SetData(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        LbData.setText(format.format(date));
    }
}
