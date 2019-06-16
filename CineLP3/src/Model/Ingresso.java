package Model;

public class Ingresso {
    private int id;
    private Sessao sessão;
    private Filme filme;
    private Sala sala;
    private String horario;
    private String tipo;


    public Ingresso(int id, Sessao sessão, Filme filme, Sala sala, String horario,String tipo) {
        this.id = id;
        this.sessão = sessão;
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
        this.tipo=tipo;
     }

    public int getId() {
        return id;
    }

    public Sessao getSessão() {
        return sessão;
    }

    public Filme getFilme() {
        return filme;
    }

    public Sala getSala() {
        return sala;
    }

    public String getHorario() {
        return horario;
    }

    public String getTipo() {
        return tipo;
    }


}
