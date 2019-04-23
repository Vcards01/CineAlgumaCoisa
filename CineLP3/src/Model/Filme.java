package Model;
import Main.Main;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Filme {
    private int id;
    private String nome;
    private String genero;
    private String sinopse;
    private String duracao;
    private int qtddVendida;
    private ArrayList<Sessao> sessoes= new ArrayList<Sessao>();
    private String Img;
    private Image image ;

    public Filme(int id, String nome, String genero, String sinopse, String duracao,String Img) throws FileNotFoundException {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
        this.Img=Img;
        image=new Image(Img);
    }
    public Filme()  {

    }
    public void AddSessao(Sessao s)
    {
        sessoes.add(s);
    }
    public void RmvSessao(Sessao s)
    {
        sessoes.remove(s);
    }
// Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getDuracao() {
        return duracao;
    }

    public int getQtddVendida() {
        return qtddVendida;
    }

    public void setQtddVendida(int qtddVendida) {
        this.qtddVendida = qtddVendida;
    }

    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    public Image getImage() {
        return image;
    }

    public String getImg() {
        return Img;
    }
    @Override
    public String toString()
    {
        return nome;
    }
}
