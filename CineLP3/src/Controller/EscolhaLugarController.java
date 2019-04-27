package Controller;

import DataBaseSimulation.FilmesDataBase;
import Model.Filme;
import Model.Lugares;
import Model.Sala;
import Model.Sessao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javax.lang.model.type.NullType;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EscolhaLugarController implements Initializable {
    @FXML
    private AnchorPane PnCine;
    @FXML
    private AnchorPane PnPoltronasEsc;
    @FXML
    private AnchorPane PnPoltronasDi;
    private Image Ocupada = new Image("Resources/CadeiraOcupada.png");
    private Image Livre = new Image("Resources/CadeiraLivre.png");
    private int id=1;//Id de cada botão
    private int pular=1;//Contador para pular de fileira
    private int y=14;//Valor da coordenada Y
    private int x=0;//Valor da coordenada X
    private int lado=0;
    private ArrayList<ImageView>Poltronas = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void SetTela(Sessao s) throws FileNotFoundException {

        for (int i = 0; i < s.getSala().getQtddLugares(); i++) {
            ImageView b = new ImageView();
            b.setId(Integer.toString(id));
            b.setLayoutX(90.0 * x);
            b.setLayoutY(y);
            b.setImage(Livre);
            b.setOnMouseClicked(event -> {
                if (b.getImage().equals(Livre)) {
                    b.setImage(Ocupada);
                } else {
                    b.setImage(Livre);

                }
            });
            if (i < s.getSala().getQtddLugares() / 2) {
                PnPoltronasEsc.getChildren().add(b);
            } else if (i >= s.getSala().getQtddLugares() / 2) {
                if (lado == 0) {
                    x = 0;
                    y = 14;//Valor da coordenada Y
                    b.setLayoutX(90.0 * x);
                    b.setLayoutY(y);
                    pular = 1;//Contador para pular de fileira
                    lado = 1;
                }
                PnPoltronasDi.getChildren().add(b);
            }
            if (pular == 5) {
                y = y + 70;
                x = 0;
                pular = 1;
                id++;
                Poltronas.add(b);
                continue;
            }
            id++;
            x++;
            pular++;
            Poltronas.add(b);
            ocuparlugares(s);
        }
        System.out.println(Poltronas.size());
    }
   private void ocuparlugares(Sessao s)
    {

        ArrayList<Lugares> sessao = s.getLugares();
        if (!sessao.isEmpty()) {
            for (int i = 0; i < Poltronas.size(); i++) {
                if (Poltronas.get(i).getId().equals(Integer.toString(sessao.get(i).getId()))) {
                    if (sessao.get(i).isOcupado()) {
                        Poltronas.get(i).setImage(Ocupada);
                        Poltronas.get(i).setOnMouseClicked(event -> {
                            System.out.println("Lugar ja ocupado");
                        });
                    }
                }
            }
        }
    }


}
