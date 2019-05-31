package Controller;

import Controller.TableGerControllers.TableGerEstoqueController;
import Controller.TableRelatorioControllers.*;
import DataBase.*;
import Model.Caixa;
import Model.Filme;
import Model.Funcionario;
import Model.Relatorios;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import java.util.ArrayList;
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
    public TableColumn ColunaRelatorio;
    @FXML
    public Label LbVendasRealizadas;
    @FXML
    public Label LbVendasRealizadasNome;
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
    private TableView<Relatorios> Tabela;
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
       ColunaRelatorio.setCellValueFactory(new PropertyValueFactory<>("nome"));
       Tabela.setItems(GetRelatorios());
       SetFuncMes();

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
    //Configura o nome e a quantidade vendida do funcionario do Mês
    public void SetFuncMes()
    {
        Funcionario f =null;
        int Maior=0;
        FuncionarioDAO DAO = new FuncionarioDAO();
        for (Funcionario x:DAO.getFuncionarios())
        {
            if(x.getQtddVendas()>Maior)
            {
                Maior=x.getQtddVendas();
                f=x;
            }
        }
        LbVendasRealizadas.setText(Integer.toString(f.getQtddVendas()));
        LbVendasRealizadasNome.setText(f.getNome());
    }
    //Fecha a janela
    @FXML
    public void HandleClose(MouseEvent Event)
    {
        Platform.exit();
        System.exit(0);
    }
    //Configura ação dos botões do menu.
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
    //Configura a Hora
    @FXML
    public void SetHora()
    {
        KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
        Timeline timeline = new Timeline(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    //Configura o usuario que logou
    @FXML
    public  void SetUser(Funcionario f)
    {
        lbUsuario.setText(f.getUsuario());

    }
    //Atualiza os segundo da hora
    private void atualizaHoras() {
        Date agora = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");
        LbHora.setText(formatador.format(agora));
    }
    //Configura a Data
    private void SetData(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        LbData.setText(format.format(date));
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
    //Configura o botão Ver Mais para abrir as tabelas com o relatorio escolhido
    @FXML
    public void VerMais(ActionEvent evente) throws IOException {
        Relatorios r = Tabela.getSelectionModel().getSelectedItem();
        if(r.getNome().equals("Venda de Filmes"))
        {
            PnInfo.setVisible(true);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesRelatorios/RelatorioFilmesTable.fxml"));
            AnchorPane pane = loader.load();
            RelatorioFilmesTableController controller = loader.getController();
            controller.setMedidas(PnInfo.getWidth(),PnInfo.getHeight());
            PnInfo.getChildren().setAll(pane);
        }
        else if(r.getNome().equals("Venda de Produtos"))
        {
            PnInfo.setVisible(true);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesRelatorios/RelatorioProdutoTable.fxml"));
            AnchorPane pane = loader.load();
            RelatorioProdutoTableController controller = loader.getController();
            controller.setMedidas(PnInfo.getWidth(),PnInfo.getHeight());
            PnInfo.getChildren().setAll(pane);
        }
        else if(r.getNome().equals("Vendas realizas"))
        {
            PnInfo.setVisible(true);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesRelatorios/RelatorioVendaTable.fxml"));
            AnchorPane pane = loader.load();
            RelatorioVendaTableController controller = loader.getController();
            controller.setMedidas(PnInfo.getWidth(),PnInfo.getHeight());
            PnInfo.getChildren().setAll(pane);
        }
        else if(r.getNome().equals("Caixa"))
        {
            PnInfo.setVisible(true);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesRelatorios/RelatorioCaixaTable.fxml"));
            AnchorPane pane = loader.load();
            RelatorioCaixaTableController controller = loader.getController();
            controller.setMedidas(PnInfo.getWidth(),PnInfo.getHeight());
            PnInfo.getChildren().setAll(pane);
        }
        else if(r.getNome().equals("Funcionarios"))
        {
            PnInfo.setVisible(true);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesRelatorios/RelatorioFuncionarioTable.fxml"));
            AnchorPane pane = loader.load();
            RelatorioFuncionarioTableController controller = loader.getController();
            controller.setMedidas(PnInfo.getWidth(),PnInfo.getHeight());
            PnInfo.getChildren().setAll(pane);
        }
    }
    //Setta todos os relatorios em uma lista
    private ArrayList<Relatorios> SetRelatorios()
    {
        ArrayList<Relatorios>relatorios = new ArrayList <>();
        Relatorios RF = new Relatorios();
        Relatorios RP = new Relatorios();
        Relatorios RV = new Relatorios();
        Relatorios RC = new Relatorios();
        Relatorios RFunc = new Relatorios();
        RF.setNome("Venda de Filmes");
        relatorios.add(RF);
        RP.setNome("Venda de Produtos");
        relatorios.add(RP);
        RV.setNome("Vendas realizas");
        relatorios.add(RV);
        RC.setNome("Caixa");
        relatorios.add(RC);
        RFunc.setNome("Funcionarios");
        relatorios.add(RFunc);
        return relatorios;
    }
    //Transforma a lista de Relatorios em uma ObservableList
    private ObservableList<Relatorios> GetRelatorios()
    {
        ObservableList<Relatorios> relatorios = FXCollections.observableArrayList(SetRelatorios());
        return relatorios;
    }
    //Configurar o Destaque dos botões do menu.
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

}
