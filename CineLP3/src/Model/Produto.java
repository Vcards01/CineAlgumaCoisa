package Model;

public class Produto {
    private int id;
    private int quantidade;
    private String nome;
    private String tipo;
    private double preco;

    public Produto(int id, int quantidade, String nome, String tipo, double preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }
    public  Produto()
    {

    }
    //Getters e Setters

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }
}
