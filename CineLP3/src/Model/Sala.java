package Model;

import java.util.ArrayList;

public class Sala {
    private String nome;
    private int id;
    private int qtddLugares;
    private ArrayList<Sessao> sessoes= new ArrayList<Sessao>();

    public Sala(String nome, int id, int qtddLugares) {
        this.nome = nome;
        this.id = id;
        this.qtddLugares = qtddLugares;
    }
    public Sala()
    {

    }
    public void AddSessao(Sessao s)
    {
        sessoes.add(s);
    }
    public void RmvSessao(Sessao s)
    {
        sessoes.remove(s);
    }
    //Getters e Setters


    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getQtddLugares() {
        return qtddLugares;
    }

    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }
}
