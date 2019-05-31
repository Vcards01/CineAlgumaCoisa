package Model;

public class Venda {
    private String hora;
    private String data;
    private double Valor;
    private int idVenda;

    public Venda( int idVenda,String data,String hora, double valor) {
        this.hora = hora;
        this.data = data;
        Valor = valor;
        this.idVenda = idVenda;
    }
    public Venda(String data,String hora, double valor) {
        this.hora = hora;
        this.data = data;
        Valor = valor;
    }
    //Getters

    public String getHora() {
        return hora;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return Valor;
    }

    public int getIdVenda() {
        return idVenda;
    }

    //Setters
    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
}
