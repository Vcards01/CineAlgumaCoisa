package Controller;

import DataBase.FilmeDAO;
import Model.Filme;
import Model.Funcionario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class HomeAtendenteController implements Initializable {
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
    public Pane PnIngressos;
    @FXML
    public Pane PnAlimentação;
    @FXML
    private Label LbData;
    @FXML
    public AnchorPane PnMenu;
    @FXML
    private Pane PnVenda;
    @FXML
    private Pane PnDataHora;
    @FXML
    public AnchorPane PnTopo;
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
    @FXML
    public Button BtnCancelar;
    @FXML
    public Button BtnConfirma;
    @FXML
    public Button BtnVoltar;
    @FXML
    public Button BtnProximo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PnInfo.setVisible(false);
        SetData();
        SetHora();
        ColunaFilme.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Tabela.setItems(GetFilmes());
        Shadow();
        HomeHighlight();
    }
//Configura o usuario logado
    @FXML
    public  void SetUser(Funcionario f)
    {
        lbUsuario.setText(f.getUsuario());
        LbVendasRealizadas.setText(Integer.toString(f.getQtddVendas()));
    }
//Configura a hota no painel
    @FXML
    public void SetHora()
    {
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
//Atualiza as hora a cada segundo.
    private void atualizaHoras() {
        Date agora = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");
        LbHora.setText(formatador.format(agora));
    }
//Configura a data no painel
    private void SetData(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        LbData.setText(format.format(date));
    }
//Faz logout e volta para a tela de login.
    @FXML
    public void Logout(MouseEvent event) {
        Stage stage = (Stage) PnLogout.getScene().getWindow();
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

//Retorna uma ObservableList de filmes para popular a tabela.
    private ObservableList<Filme> GetFilmes() {
        FilmeDAO fDAO = new FilmeDAO();
        ObservableList<Filme> Filmes = FXCollections.observableArrayList(fDAO.getFilmes());
        return Filmes;
    }
//Ação do botão ver mais.
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
//Fecha Janela
    @FXML
    public void HandleClose(MouseEvent Event)
    {
        Platform.exit();
        System.exit(0);
    }
//Configura ação dos botões do menu.
    @FXML
    public void OpenVendaIngresso(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/VendaIngressos.fxml"));
        AnchorPane pane = loader.load();
        VendaIngressosController controller = loader.getController();
        controller.SetMedidas(PnJanelas.getHeight(),PnJanelas.getWidth());
        PnRoot.setStyle("-fx-background-color:  #80CBC4");
        PnMenu.setStyle("-fx-background-color:  #009688");
        PnTopo.setStyle("-fx-background-color:  #009688");
        LbTituloJanela.setText("Venda");
        PnJanelas.getChildren().setAll(pane);
        IngressosHighlight();
     }
    @FXML
    public void OpenHome(MouseEvent Event){
        PnJanelas.getChildren().clear();
        PnRoot.setStyle("-fx-background-color:  #8DBFDA");
        PnMenu.setStyle("-fx-background-color:   #36769A");
        PnTopo.setStyle("-fx-background-color:  #36769A");
        LbTituloJanela.setText("Home Screen");
        PnJanelas.getChildren().setAll(PnDataHora,PnVenda,Tabela,PnInfo,PnButton);
        HomeHighlight();
    }
    @FXML
    public void OpenAlimentos(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/VendaAlimentos.fxml"));
        AnchorPane pane = loader.load();
        VendaAlimentosController controller = loader.getController();
        controller.GetMedidas(PnJanelas.getHeight(),PnJanelas.getWidth());
        PnRoot.setStyle("-fx-background-color:   #B32F3D");
        PnMenu.setStyle("-fx-background-color:   #81001F");
        PnTopo.setStyle("-fx-background-color:   #81001F");
        LbTituloJanela.setText("Venda");
        PnJanelas.getChildren().setAll(pane);
        AlimentosHighlight();
    }
//Configurar o Destaque dos botões do menu.
    private void HomeHighlight() {
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color:  #8DBFDA");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnIngressos.setOnMouseEntered(event -> { PnIngressos.setStyle("-fx-background-color:  #8DBFDA");});
        PnIngressos.setOnMouseExited(event -> {PnIngressos.setStyle("-fx-background-color:  transparent");});
        PnAlimentação.setOnMouseEntered(event -> {PnAlimentação.setStyle("-fx-background-color:  #8DBFDA");});
        PnAlimentação.setOnMouseExited(event -> {PnAlimentação.setStyle("-fx-background-color:  transparent");});
    }
    private void IngressosHighlight(){
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color:   #80CBC4");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnIngressos.setOnMouseEntered(event -> { PnIngressos.setStyle("-fx-background-color:   #80CBC4");});
        PnIngressos.setOnMouseExited(event -> {PnIngressos.setStyle("-fx-background-color:  transparent");});
        PnAlimentação.setOnMouseEntered(event -> {PnAlimentação.setStyle("-fx-background-color:   #80CBC4");});
        PnAlimentação.setOnMouseExited(event -> {PnAlimentação.setStyle("-fx-background-color:  transparent");});
    }
    private void AlimentosHighlight(){
        PnHome.setOnMouseEntered(event -> { PnHome.setStyle("-fx-background-color:   #B32F3D");});
        PnHome.setOnMouseExited(event -> {PnHome.setStyle("-fx-background-color:  transparent");});
        PnIngressos.setOnMouseEntered(event -> { PnIngressos.setStyle("-fx-background-color:    #B32F3D");});
        PnIngressos.setOnMouseExited(event -> {PnIngressos.setStyle("-fx-background-color:  transparent");});
        PnAlimentação.setOnMouseEntered(event -> {PnAlimentação.setStyle("-fx-background-color:    #B32F3D");});
        PnAlimentação.setOnMouseExited(event -> {PnAlimentação.setStyle("-fx-background-color:  transparent");});
    }
}

