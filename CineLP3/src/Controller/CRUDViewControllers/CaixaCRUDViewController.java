package Controller.CRUDViewControllers;

import DataBase.CaixaDAO;
import Model.Caixa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        if(txtValorInicial.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos em branco");
            alert.setHeaderText(null);
            alert.setContentText("Não deixe nenhum campo em branco!");
            alert.showAndWait();
        }
        else
        {
            if(!CheckNumber(txtValorInicial.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Valor invalido");
                alert.setHeaderText(null);
                alert.setContentText("Apenas numeros são permitidos!");
                alert.showAndWait();
            }
            else
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

    }
    public boolean CheckNumber( String s ) {
        // cria um array de char
        char[] c = s.toCharArray();
        boolean d = true;
        for ( int i = 0; i < c.length; i++ ){
            // verifica se o char não é um dígito
            if(c[i]=='.')
            {
                continue;
            }
            else if ( !Character.isDigit( c[ i ] ) ) {
                d = false;
                break;
            }
        }
        return d;
    }

}
