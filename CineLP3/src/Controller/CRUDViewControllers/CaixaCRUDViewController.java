package Controller.CRUDViewControllers;

import DataBase.CaixaDAO;
import Model.Caixa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaixaCRUDViewController {
    @FXML
    public TextField txtValorInicial;
    //DAO Do caixa
    private CaixaDAO DAO = new CaixaDAO();

    //Seta o valor inicial que tem no caixa
    @FXML
    public void Continue(ActionEvent event)
    {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyy");
        Caixa c = DAO.read(formatarDate.format(data));
        c.AbrirCaixa(Double.parseDouble(txtValorInicial.getText()));
        DAO.update(c);
        Stage tela = (Stage)txtValorInicial.getScene().getWindow();
        tela.close();
    }

}
