package Controller.CRUDViewControllers;

import Model.Filme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML
    public void fileChooser(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        File f =fc.showOpenDialog(null);
        if(f!=null)
        {
            String url = f.getPath();
            url = url.replace("\\","/");
            Image img = new Image("file:///"+url);
            ImgCapa.setImage(img);

        }
    }
    @FXML
    public void Cancel(ActionEvent event)
    {
        Stage janela = (Stage)TxtTitulo.getScene().getWindow();
        janela.close();

    }

}
