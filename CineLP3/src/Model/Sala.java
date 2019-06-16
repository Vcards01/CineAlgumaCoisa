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
    @Override
    public String toString()
    {
        return Integer.toString(id);
    }
    //Getters
    public int getId() {
        return id;
    }

    public int getQtddLugares() {
        return qtddLugares;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }
}
