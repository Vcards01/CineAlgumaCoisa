package Controller;

import DataBase.CaixaDAO;
import Model.Caixa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class CaixaController implements Initializable {
    @FXML
    public Label LbStatus;
    @FXML
    public Label LbInicial;
    @FXML
    public Label LbLucro;
    @FXML
    public Label LbTotal;
    @FXML
    public AnchorPane PnFundo;
    @FXML
    public AnchorPane PnStatus;
    @FXML
    public AnchorPane PnInicial;
    @FXML
    public AnchorPane PnLucro;
    @FXML
    public AnchorPane PnTotal;
    @FXML
    public AnchorPane PnTitulo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CaixaDAO DAO = new CaixaDAO();
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyy");
        Caixa c = DAO.read(formatarDate.format(data));
        //Verifica se o caixa ja estava aberto ou não
        if(c == null)
        {
            LbStatus.setText("Fechado");
        }
        else
        {
            if(!c.getStatus())
            {
                LbStatus.setText("Fechado");
            }
            else
            {
                LbStatus.setText("Aberto");
            }
           AttValores();
        }
        Shadow();
    }
//Atualiza os valores de acordo com caixas ja abertos
    public void AttValores()
    {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyy");
        CaixaDAO DAO = new CaixaDAO();
        Caixa c = DAO.read(formatarDate.format(data));
        LbInicial.setText(Double.toString(c.getValorInicial()));
        LbLucro.setText(Double.toString(c.getLucro()));
        LbTotal.setText(Double.toString(c.getValorAtual()));
    }
    public void SetMedidas(double h, double w)
    {
        PnFundo.setPrefWidth(w);
        PnFundo.setPrefHeight(h);
    }
    @FXML
    public void AbrirCaixa(ActionEvent evente) throws IOException {
        CaixaDAO DAO = new CaixaDAO();
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyy");
        Caixa c = DAO.read(formatarDate.format(data));
        //Verefica se existe um caixa ja para a data atual
        if(c == null)
        {
            c =new Caixa(formatarDate.format(data),0,0,0,true);
            DAO.create(c);
            //Solicita o valor inicial
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/CRUDView/CaixaCRUDView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.showAndWait();
            //Atualiza o status
            LbStatus.setText("Aberto");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Caixa aberto");
            alert.setHeaderText(null);
            alert.setContentText("O caixa foi aberto");
            alert.showAndWait();
        }
        else
        {
            //Reabre um caixa
            if(!c.getStatus())
            {
                c.setStatus(true);
                DAO.update(c);
                LbStatus.setText("Aberto");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Caixa aberto");
                alert.setHeaderText(null);
                alert.setContentText("O caixa foi aberto");
                alert.showAndWait();
            }
            //Avisa q ja ta aberto
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Caixa aberto");
                alert.setHeaderText(null);
                alert.setContentText("O caixa ja esta aberto");
                alert.showAndWait();
            }
        }
        //Atualiza os valors
        AttValores();
    }
    @FXML
    public void FecharCaixa(ActionEvent evente)
    {
        CaixaDAO DAO = new CaixaDAO();
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyy");
        Caixa c = DAO.read(formatarDate.format(data));
        //Verifica se existe caixa para ser fechado
        if(c==null)
        {
            LbStatus.setText("Fechado");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Caixa fechado");
            alert.setHeaderText(null);
            alert.setContentText("O caixa já esta fechado");
            alert.showAndWait();
        }
        else
        {
            //Fecha um caixa aberto
            if(c.getStatus())
            {
                LbStatus.setText("Fechado");
                c.setStatus(false);
                DAO.update(c);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Caixa fechado");
                alert.setHeaderText(null);
                alert.setContentText("O caixa foi fechado");
                alert.showAndWait();
            }
            //Avisa que ja esta fechado
            else
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Caixa fechado");
                alert.setHeaderText(null);
                alert.setContentText("O caixa já esta fechado");
                alert.showAndWait();
            }

        }
    }
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
        PnTitulo.setEffect(Shad);
        PnInicial.setEffect(Shad);
        PnStatus.setEffect(Shad);
        PnLucro.setEffect(Shad);
        PnTotal.setEffect(Shad);

    }

}
