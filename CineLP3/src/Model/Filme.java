package Model;
import java.util.ArrayList;

public class Filme {
    private int id;
    private String nome;
    private String genero;
    private String sinopse;
    private String duracao;
    private int qtddVendida;
    private ArrayList<Sessao> sessoes= new ArrayList<Sessao>();

    public Filme(int id, String nome, String genero, String sinopse, String duracao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.duracao = duracao;
    }
    public Filme(){

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
}
