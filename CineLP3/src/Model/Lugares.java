package Model;

public class Lugares {
    private int id;
    private Sessao sessao;
    private boolean ocupado;

    public Lugares(int id, boolean ocupado,Sessao sessao) {
        this.id = id;
        this.ocupado = ocupado;
        this.sessao=sessao;
    }
//Getters
    public Sessao getSessao() {
        return sessao;
    }

    public int getId() {
        return id;
    }

    public boolean isOcupado() {
        return ocupado;
    }
//Setters
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
