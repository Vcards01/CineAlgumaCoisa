package Model;

import java.util.ArrayList;

public class Sala {
    private int id;
    private int qtddLugares;
    private ArrayList<Sessao> sessoes= new ArrayList<Sessao>();


    public Sala(int id, int qtddLugares) {
        this.id = id;
        this.qtddLugares = qtddLugares;
    }
    public Sala(int qtddLugares) {
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
    @Override
    public String toString()
    {
        return Integer.toString(id);
    }
    //Getters e Setters



    public int getId() {
        return id;
    }

    public int getQtddLugares() {
        return qtddLugares;
    }

    public ArrayList<Sessao> getSessoes() {
        return sessoes;
    }

    public void setId(int id) {
        this.id = id;
    }
}
