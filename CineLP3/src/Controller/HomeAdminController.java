package Controller;

import Model.Caixa;
import Model.Filme;
import Model.Funcionario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
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
    public TableColumn ColunaFilme;
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
    private AnchorPane PnJanelas;
    @FXML
    private TableView<Filme> Tabela;
    @FXML
    private Pane PnLogout;
    @FXML
    private Label lbUsuario;
    @FXML
    private Label LbHora;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       PnInfo.setVisible(false);
       SetHora();
       SetData();
       Shadow();

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
    @FXML
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
        PnRoot.setStyle("-fx-background-color:  #004D40");
        PnMenu.setStyle("-fx-background-color:  #00796B");
        PnTopo.setStyle("-fx-background-color:  #00796B");
        LbTituloJanela.setText("Gerenciamento");
        PnJanelas.getChildren().setAll(pane);
        GerenciamentoHighlight();
    }
    @FXML
    public void OpenCaixa(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/Caixa.fxml"));
        AnchorPane pane = loader.load();
        CaixaController controller = loader.getController();
        controller.SetMedidas(PnJanelas.getHeight(),PnJanelas.getWidth());
        PnRoot.setStyle("-fx-background-color:   #1B5E20");
        PnMenu.setStyle("-fx-background-color:   #388E3C");
        PnTopo.setStyle("-fx-background-color:   #388E3C");
        LbTituloJanela.setText("Caixa");
        PnJanelas.getChildren().setAll(pane);
        CaixaHighlight();
    }
    //Adiciona Sombra aos paineis
    public void Shadow()
    {
        DropShadow Shad = new DropShadow();
        Shad.setOffsetX(4);
        Shad.setOffsetY(6);
        Shad.setColor(Color.rgb(0, 0, 0));
        DropShadow Shad2 = new DropShadow();
        Shad.setOffsetX(2);
        Shad.setOffsetY(4);
        Shad.setColor(Color.rgb(0, 0, 0));
        PnInfo.setEffect(Shad);
        PnVenda.setEffect(Shad);
        PnDataHora.setEffect(Shad);
        PnTopo.setEffect(Shad2);
        PnMenu.setEffect(Shad);
        Tabela.setEffect(Shad2);
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
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color:  #004D40");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnGerenciamento.setOnMouseEntered(event -> { PnGerenciamento.setStyle("-fx-background-color:  #004D40");});
        PnGerenciamento.setOnMouseExited(event -> {PnGerenciamento.setStyle("-fx-background-color:  transparent");});
        PnCaixa.setOnMouseEntered(event -> {PnCaixa.setStyle("-fx-background-color:  #004D40");});
        PnCaixa.setOnMouseExited(event -> {PnCaixa.setStyle("-fx-background-color:  transparent");});
    }
    private void CaixaHighlight() {
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color:  #1B5E20");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnGerenciamento.setOnMouseEntered(event -> { PnGerenciamento.setStyle("-fx-background-color: #1B5E20");});
        PnGerenciamento.setOnMouseExited(event -> {PnGerenciamento.setStyle("-fx-background-color:  transparent");});
        PnCaixa.setOnMouseEntered(event -> {PnCaixa.setStyle("-fx-background-color:  #1B5E20");});
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
