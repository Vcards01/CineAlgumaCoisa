package Model;

public class Ingresso {
    private int id;
    private Sessao sessão;
    private Filme filme;
    private Sala sala;
    private String horario;

    public Ingresso(int id, Sessao sessão, Filme filme, Sala sala, String horario) {
        this.id = id;
        this.sessão = sessão;
        this.filme = filme;
        this.sala = sala;
        this.horario = horario;
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
}
