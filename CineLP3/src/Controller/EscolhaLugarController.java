package Controller;

import DataBaseSimulation.LugaresDAO;
import Model.Lugares;
import Model.Sessao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class EscolhaLugarController implements Initializable {
    @FXML
    private AnchorPane PnFundo;
    @FXML
    private Label LbQtddIngressos;
    @FXML
    private AnchorPane PnPoltronasEsc;
    @FXML
    private AnchorPane PnPoltronasDi;
    //Imagem de cadeira Ocupada
    private Image Ocupada = new Image("Resources/CadeiraOcupada.png");
    //Imagem de cadeira Desocupada
    private Image Livre = new Image("Resources/CadeiraLivre.png");
    //Array de Poltronas
    private ArrayList<ImageView> Poltronas = new ArrayList<>();
    //Simulação de DAO de lugares
    private LugaresDAO LDAO = new LugaresDAO();
    //Quantidade de Ingressos Comprados pelo Cliente
    private int QuantidadeIngressos;
    private double precoIngressos;
    private ArrayList<ImageView> LugaresEscolhidos = new ArrayList<>();

    public EscolhaLugarController() throws FileNotFoundException {
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

//Configura todas as poltronas na tela
    @FXML
    public void SetLugares(Sessao s) throws FileNotFoundException {
        //Variaveis
        //Id de cada botão.
        int id = 1;
        //Contador para pular de fila.
        int pular = 1;
        //Valor da coordenada Y
        int layoutY = 14;
        //Valor da coordenada X
        int layoutX = 0;
        //Contador para mudar o lado das poltronas
        int change = 0;
        //Valor da coordenada X para os numeros
        int layoutXN = 20;
        //Font dos numeros
        Font font = Font.font("Arial", FontWeight.BOLD, 25);
        for (int i = 0; i < s.getSala().getQtddLugares(); i++) {

            //Settings dos assentos
            ImageView b = new ImageView();
            b.setId(Integer.toString(id));
            b.setLayoutX(90.5 * layoutX);
            b.setLayoutY(layoutY);
            b.setImage(Livre);
            //Settings dos numeros dos assentos
            Label LbNumeroCima = new Label();
            LbNumeroCima.setLayoutX(layoutXN);
            LbNumeroCima.setLayoutY(layoutY);
            LbNumeroCima.setFont(font);
            LbNumeroCima.setText(Integer.toString(id));
            //Set do evento de click no assento
            b.setOnMouseClicked(event -> {
                if (b.getImage().equals(Livre)) {
                    if (LugaresEscolhidos.size() < QuantidadeIngressos) {
                        LugaresEscolhidos.add(b);
                        b.setImage(Ocupada);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Limite de lugares por ingresso");
                        alert.setHeaderText(null);
                        alert.setContentText("Para escolher mais lugares compre mais ingressos.");
                        alert.showAndWait();
                    }
                } else {
                    LugaresEscolhidos.remove(b);
                    b.setImage(Livre);
                }
            });
            //Setting eventos para os numeros
            LbNumeroCima.setOnMouseClicked(event -> {
                if (b.getImage().equals(Livre)) {
                    if (LugaresEscolhidos.size() < QuantidadeIngressos) {
                        LugaresEscolhidos.add(b);
                        b.setImage(Ocupada);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Limite de lugares por ingresso");
                        alert.setHeaderText(null);
                        alert.setContentText("Para escolher mais lugares compre mais ingressos.");
                        alert.showAndWait();
                    }
                } else {
                    LugaresEscolhidos.remove(b);
                    b.setImage(Livre);
                }
            });
            //Verifica e Adiciona Assentos e numeros do lado esquerdo
            if (i < s.getSala().getQtddLugares() / 2) {

                PnPoltronasEsc.getChildren().add(b);
                PnPoltronasEsc.getChildren().add(LbNumeroCima);
            }
            //Verifica e Adiciona Assentos e numeros do lado direito
            else if (i >= s.getSala().getQtddLugares() / 2) {
                if (change == 0) {
                    //Reset das variaveis para começar o lado direito
                    layoutX = 0;
                    layoutY = 14;
                    layoutXN = 20;
                    LbNumeroCima.setLayoutX(layoutXN);
                    LbNumeroCima.setLayoutY(layoutY);
                    b.setLayoutX(90.0 * layoutX);
                    b.setLayoutY(layoutY);
                    pular = 1;//Contador para pular de fileira
                    change = 1;
                }
                PnPoltronasDi.getChildren().add(b);
                PnPoltronasDi.getChildren().add(LbNumeroCima);
            }
            //Faz a verificação para pular de linha
            if (pular == s.getSala().getQtddLugares() / 10) {
                layoutY = layoutY + 70;//Pulou pra a fila de baixo
                layoutX = 0; //Resetou o eixo X
                layoutXN = 20;//Resetou o eixo X dos numeros
                pular = 1; //Resetou o contador para pular fila
                id++;
                Poltronas.add(b);
                continue;
            }
            layoutXN = layoutXN + 90; //Incremeto no eixo X dos numeros
            id++;
            layoutX++; //incremento no eixo X
            pular++; //incremento no contador para pular fila
            Poltronas.add(b);
        }
        OcuparLugares(s);
    }
//Verifica quais lugares estão ocupados
    private void OcuparLugares(Sessao s) {
        s.setLugares(LDAO.FindBySessao(s));
        if (!s.getLugares().isEmpty()) {
            for (int i = 0; i < Poltronas.size(); i++) {
                if (Integer.parseInt(Poltronas.get(i).getId()) == s.getLugares().get(i).getId()) {
                    if (s.getLugares().get(i).isOcupado()) {
                        Poltronas.get(i).setImage(Ocupada);
                        Poltronas.get(i).setOnMouseClicked(event -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Lugar Ocupado");
                            alert.setHeaderText(null);
                            alert.setContentText("Escolha um dos lugares disponiveis");
                            alert.showAndWait();
                        });
                    }
                }
            }
        }
    }
//Pega a quantidade de ingressos comprados
    public void SetIngressos(double quantidade, double valor) {
        QuantidadeIngressos = (int) quantidade;
        LbQtddIngressos.setText(Integer.toString(QuantidadeIngressos));
        precoIngressos = valor;
    }
//Pega as mediadas do painel principal e configura a tela.
    public void SetMedidas(double h, double w) {
        PnFundo.setPrefWidth(w);
        PnFundo.setPrefHeight(h);
    }
//Retorna a quantidade de lugares que o usuario selecionou
    public int GetPoltronas()
    {
        return LugaresEscolhidos.size();
    }
}



