package Model;

import DataBaseSimulation.LugaresDAO;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Sessao {
    private int id;
    private String horario;
    private Filme filme;
    private Sala sala;
    private int IngressosVendidos;
    private double precoEntradaInteira;
    private double precoEntradaMeia;
    private ArrayList<Lugares> lugares= new ArrayList<>();

    public Sessao(int id, String horario, Filme filme, Sala sala,double precoEntradaInteira,double precoEntradaMeia) {
        this.id = id;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.precoEntradaInteira=precoEntradaInteira;
        this.precoEntradaMeia=precoEntradaMeia;

    }
    public  Sessao()
    {

    }
    public String toString()
    {
        return horario;
    }
    public void AddLugares(Lugares s)
    {
        lugares.add(s);
    }
    public void RmvLugares(Lugares s)
    {
        lugares.remove(s);
    }
    //Getters e Setters

    public int getId() {
        return id;
    }

    public String getHorario() {
        return horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setLugares(ArrayList<Lugares> lugares) {
        this.lugares = lugares;
    }

    public int getIngressosVendidos() {
        return IngressosVendidos;
    }
    public void setIngressosVendidos(int ingressosVendidos) {
        IngressosVendidos = ingressosVendidos;
    }
    public double getPrecoEntradaInteira() {
        return precoEntradaInteira;
    }
    public double getPrecoEntradaMeia() {
        return precoEntradaMeia;
    }
    public ArrayList<Lugares> getLugares() {
        return lugares;
    }

}
