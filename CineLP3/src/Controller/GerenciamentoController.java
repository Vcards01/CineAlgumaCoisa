package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class GerenciamentoController {
    @FXML
    public AnchorPane PaneGer;
    @FXML
    public Pane PnFundo;
    @FXML
    public AnchorPane PnCrud;
    @FXML
    public Pane GerFilmesBtn;
    @FXML
    public Pane GerSessoesBtn;
    @FXML
    public Pane GerSalasBtn;
    @FXML
    public Pane GerFuncBtn;
    @FXML
    public Pane RenderTable;
    @FXML
    public Pane AddBtn;
    @FXML
    public Pane RmvBtn;
    @FXML
    public Pane EditBtn;
    @FXML
    public Pane VizuBtn;


    public void SetMedidas(double h, double w)
    {
        PaneGer.setPrefWidth(w);
        PaneGer.setPrefHeight(h);
    }

    @FXML
    public void OpenFilmeTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Tables/FilmesGerTable.fxml"));
        AnchorPane pane = loader.load();
        FilmesGerTableController controller = loader.getController();
        controller.SetMedidas(RenderTable.getHeight(),RenderTable.getWidth());
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenSalasTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Tables/SalasGerTable.fxml"));
        AnchorPane pane = loader.load();
        SalasGerTableController controller = loader.getController();
        controller.SetMedidas(RenderTable.getHeight(),RenderTable.getWidth());
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenSessaoTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Tables/SessaoGerTable.fxml"));
        AnchorPane pane = loader.load();
        SessaoGerTableController controller = loader.getController();
        controller.SetMedidas(RenderTable.getHeight(),RenderTable.getWidth());
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenFuncTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Tables/FuncGerTable.fxml"));
        AnchorPane pane = loader.load();
        FuncGerTableController controller = loader.getController();
        controller.SetMedidas(RenderTable.getHeight(),RenderTable.getWidth());
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenEstoqueTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Tables/EstoqueGerTable.fxml"));
        AnchorPane pane = loader.load();
        EstoqueGerTableController controller = loader.getController();
        controller.SetMedidas(RenderTable.getHeight(),RenderTable.getWidth());
        RenderTable.getChildren().setAll(pane);
    }

}


