package Controller.CRUDViewControllers;

import Controller.TableGerControllers.TableGerFilmeController;
import DataBase.FilmeDAO;
import Model.Filme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FilmesCRUDViewController implements Initializable {
    @FXML
    public ComboBox CbGenero;
    @FXML
    public TextField TxtId;
    @FXML
    public TextField TxtTitulo;
    @FXML
    public TextArea TxtSinopse;
    @FXML
    public TextField TxtDuracao;
    @FXML
    public ImageView ImgCapa;
    //URL da imagem
    private String url;
    //Controlador da tela anterior
    private TableGerFilmeController controller;
    //Verificar se é editavel
    private boolean editavel = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FillComboBox();
        TxtId.setEditable(false);
    }
   private void FillComboBox()
   {
       ArrayList<String> Generos = new ArrayList<>();
       Generos.add("Ação");
       Generos.add("Animação");
       Generos.add("Aventura");
       Generos.add("AComédia");
       Generos.add("Biografia");
       Generos.add("Documentário");
       Generos.add("Fantasia/Ação");
       Generos.add("Ficção científica");
       Generos.add("Romance");
       Generos.add("Suspense");
       Generos.add("Terror ");
       ObservableList<String> generos = FXCollections.observableArrayList(Generos);
       CbGenero.setItems(generos);
   }
   //Abre em modo edição
    public void OpenEditable(Filme f)
    {
        editavel=true;
        TxtId.setText(Integer.toString(f.getId()));
        TxtDuracao.setText(f.getDuracao());
        TxtTitulo.setText(f.getNome());
        TxtSinopse.setText(f.getSinopse());
        ImgCapa.setImage(f.getImage());
        CbGenero.setValue(f.getGenero());
    }
    //Seleciona o arquivo imagem
    @FXML
    public void fileChooser(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File f =fc.showOpenDialog(null);
        if(f!=null)
        {
            url = f.getPath();
            url = url.replace("\\","/");
            Image img = new Image("file:///"+url);
            ImgCapa.setImage(img);

        }
    }
    public void SetController(TableGerFilmeController controller)
    {
        this.controller = controller;
    }
    @FXML
    public void Cancel(ActionEvent event)
    {
        Stage janela = (Stage)TxtTitulo.getScene().getWindow();
        janela.close();

    }
    @FXML
    public void Save(ActionEvent event)
    {
       if(TxtTitulo.getText().isEmpty()||CbGenero.getValue()==null||TxtDuracao.getText().isEmpty())
       {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Campos em branco");
           alert.setHeaderText(null);
           alert.setContentText("Não deixe nenhum campo em branco!");
           alert.showAndWait();
       }
       else
       {
           FilmeDAO DAO = new FilmeDAO();
           Filme f = new Filme(TxtTitulo.getText(),CbGenero.getValue().toString(),TxtSinopse.getText(),TxtDuracao.getText(),"file:///"+url);
           //Salva um novo filme
           if(!editavel)
           {
               DAO.create(f);
           }
           //Edita um filme
           else
           {
               f.setId(Integer.parseInt(TxtId.getText()));
               DAO.update(f);
           }
           controller.SetTable();
           Stage janela = (Stage)TxtTitulo.getScene().getWindow();
           janela.close();
       }


    }
}
