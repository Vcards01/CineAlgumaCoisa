package Controller;

import Controller.TableGerControllers.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GerenciamentoController implements Initializable {
    @FXML
    public AnchorPane PaneGer;
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
    public Pane PnBtnGer;
    @FXML
    public AnchorPane PnTitulo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Shadow();
    }

    public void SetMedidas(double h, double w)
    {
        PaneGer.setPrefWidth(w);
        PaneGer.setPrefHeight(h);
    }

    @FXML
    public void OpenFilmeTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesGerenciar/FilmesGerTable.fxml"));
        AnchorPane pane = loader.load();
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenSalasTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesGerenciar/SalasGerTable.fxml"));
        AnchorPane pane = loader.load();
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenSessaoTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesGerenciar/SessaoGerTable.fxml"));
        AnchorPane pane = loader.load();
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenFuncTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesGerenciar/FuncGerTable.fxml"));
        AnchorPane pane = loader.load();
        RenderTable.getChildren().setAll(pane);
    }
    @FXML
    public void OpenEstoqueTable(MouseEvent Event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/TablesGerenciar/EstoqueGerTable.fxml"));
        AnchorPane pane = loader.load();
        RenderTable.getChildren().setAll(pane);
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
        PnBtnGer.setEffect(Shad);
        RenderTable.setEffect(Shad);
        PnTitulo.setEffect(Shad);

    }

}


