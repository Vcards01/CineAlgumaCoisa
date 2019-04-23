package Model;

public class Sessao {
    private int id;
    private String horario;
    private Filme filme;
    private Sala sala;
    private int lugaresdisponiveis;
    private int IngressosVendidos;
    private double precoEntradaInteira;
    private double precoEntradaMeia;

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

    public int getLugaresdisponiveis() {
        return lugaresdisponiveis;
    }
    public void setLugaresdisponiveis(int lugaresdisponiveis) {
        this.lugaresdisponiveis = lugaresdisponiveis;
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
}
