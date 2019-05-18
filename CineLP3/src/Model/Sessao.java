package Model;

import java.util.ArrayList;

public class Sessao {
    private int id;
    private String horario;
    private Filme filme;
    private Sala sala;
    private int qtddVendidos;
    private int lugaresDisponiveis;
    private double precoEntradaInteira;
    private double precoEntradaMeia;
    private ArrayList<Lugares> lugares= new ArrayList<>();

    public Sessao(int id, String horario, Filme filme, Sala sala,double precoEntradaInteira,double precoEntradaMeia) {
        this.id = id;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.qtddVendidos=0;
        this.lugaresDisponiveis= sala.getQtddLugares();
        this.precoEntradaInteira=precoEntradaInteira;
        this.precoEntradaMeia=precoEntradaMeia;

    }
    public Sessao(int id, String horario, Filme filme, Sala sala,int qtddVendidos,double precoEntradaInteira,double precoEntradaMeia,int lugaresDisponiveis) {
        this.id = id;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
        this.qtddVendidos=qtddVendidos;
        this.lugaresDisponiveis=lugaresDisponiveis;
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

    public int getqtddVendidos() {
        return qtddVendidos;
    }
    public void setQtddVendidos(int ingressosVendidos) {
        qtddVendidos = ingressosVendidos;
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

    public int getLugaresDisponiveis() {
        return lugaresDisponiveis;
    }
}
