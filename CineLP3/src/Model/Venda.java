package Model;

import java.util.ArrayList;

public class Venda {
    private String hora;
    private String data;
    private double Valor;
    private int idVenda;
    private ArrayList<Ingresso>ingressos= new ArrayList<Ingresso>();
    private ArrayList<Produto>produtos= new ArrayList<Produto>();

    public Venda(String hora, String data, double valor, int idVenda) {
        this.hora = hora;
        this.data = data;
        Valor = valor;
        this.idVenda = idVenda;
    }
    public Venda(){

    };

    public void AddIngresso(Ingresso i)
    {
        ingressos.add(i);
    }
    public void RmvIngresso(Ingresso i)
    {
       ingressos.remove(i);
    }
    public void AddProduto(Produto p)
    {
        produtos.add(p);
    }
    public void RmvProduto(Produto p)
    {
        produtos.remove(p);
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

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
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
