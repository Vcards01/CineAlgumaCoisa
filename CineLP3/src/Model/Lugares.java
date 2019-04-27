package Model;

public class Lugares {
    private int id;
    private boolean ocupado;

    public Lugares(int id, boolean ocupado) {
        this.id = id;
        this.ocupado = ocupado;
    }

    public int getId() {
        return id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
