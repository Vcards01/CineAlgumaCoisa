package Model;

public class Sessao {
    private int id;
    private String horario;
    private Filme filme;
    private Sala sala;
    private int lugaresdisponiveis;
    private double precoEntrada;
    private int IngressosVendidos;

    public Sessao(int id, String horario, Filme filme, Sala sala) {
        this.id = id;
        this.horario = horario;
        this.filme = filme;
        this.sala = sala;
    }
    public  Sessao()
    {

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

    public double getPrecoEntrada() {
        return precoEntrada;
    }
    public void setPrecoEntrada(float precoEntrada) {
        this.precoEntrada = precoEntrada;
    }

    public int getIngressosVendidos() {
        return IngressosVendidos;
    }
    public void setIngressosVendidos(int ingressosVendidos) {
        IngressosVendidos = ingressosVendidos;
    }





}
