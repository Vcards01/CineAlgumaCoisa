package Model;

public class Produto {
    private int id;
    private int quantidade;
    private String nome;
    private String tipo;
    private double preco;
    private int quantidadeDeVenda;

    public Produto(int id, int quantidade, String nome, String tipo, double preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        quantidadeDeVenda=0;
    }
    public Produto( int quantidade, String nome, String tipo, double preco) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        quantidadeDeVenda=0;
    }
    public Produto(int id, int quantidade, String nome, String tipo, double preco, int quantidadeDeVenda) {
        this.id = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidadeDeVenda=quantidadeDeVenda;
    }
    public  Produto()
    {

    }
    //Getters
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

    public int getQuantidadeDeVenda() {
        return quantidadeDeVenda;
    }
    //Setters
    public void setQuantidadeDeVenda(int quantidadeDeVenda) {
        this.quantidadeDeVenda = quantidadeDeVenda;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }
}
