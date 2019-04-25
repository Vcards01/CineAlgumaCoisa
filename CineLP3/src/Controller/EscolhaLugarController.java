package Controller;

import Model.Sala;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EscolhaLugarController implements Initializable {
    @FXML
    private AnchorPane PnCine;
    @FXML
    private AnchorPane PnPoltronasEsc;
    @FXML
    private AnchorPane PnPoltronasDi;
    private Sala sala ;
    private Image Ocupada = new Image("Resources/CadeiraOcupada.png");
    private Image Livre = new Image("Resources/CadeiraLivre.png");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setSala(Sala s)
    {
        int lugares=s.getQtddLugares()/2;
        int id=0;
        int pular=1;
        int y=14;
        int x=0;
        boolean ocupado =false;
        for(int i=0;i<lugares ;i++)
        {
            ImageView  b= new ImageView();
            b.setLayoutX(90.0*x);
            b.setLayoutY(y);
            b.setImage(Livre);
            PnPoltronasEsc.getChildren().add(b);
            if(pular==5)
            {
                y=y+70;
                x=0;
                pular=1;
                id++;
                continue;
            }
            id++;
            x++;
            pular++;

        }

        pular=1;
        y=14;
        x=0;

        for(int i=0;i<lugares ;i++)
        {
            ImageView  b= new ImageView();

            b.setLayoutX(90.0*x);
            b.setLayoutY(y);
            b.setImage(Livre);
            b.setOnMouseClicked(event -> {
                if(b.getImage().equals(Livre))
                {
                    b.setImage(Ocupada);
                }
                else {
                    b.setImage(Livre);
                }

            });
            PnPoltronasDi.getChildren().add(b);
            if(pular==5)
            {
                y=y+70;
                x=0;
                pular=1;
                id++;
                continue;
            }
            id++;
            x++;
            pular++;

        }
        System.out.println(id);
    }


    public void Ocupar(ActionEvent event,ImageView b)
    {
        b.setImage(Ocupada);
    }
    public void setLugares()
    {

    }
}
