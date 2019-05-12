package Model;

import java.util.ArrayList;

public class Funcionario {
    private String cpf;
    private String nome;
    private int senha;
    private String usuario;
    private String tipo;
    private double salario;
    private int qtddVendas;

    public Funcionario(String cpf, String nome, int senha, String usuario, String tipo, double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.tipo = tipo;
        this.salario=salario;
        qtddVendas=20;
    }
    public Funcionario(String cpf, String nome, int senha, String usuario, String tipo,double salario,int qtddVendas) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.tipo = tipo;
        this.salario=salario;
        this.qtddVendas=qtddVendas;
    }
    public  Funcionario()
    {

    }

    //Getters

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQtddVendas() {
        return qtddVendas;
    }

    public double getSalario() {
        return salario;
    }
    //Setters

    public void setQtddVendas(int qtddVendas) {
        this.qtddVendas = qtddVendas;
    }
}
