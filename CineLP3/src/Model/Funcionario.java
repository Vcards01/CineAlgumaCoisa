package Model;

import java.util.ArrayList;

public class Funcionario {
    private String cpf;
    private String nome;
    private int senha;
    private String usuario;
    private String tipo;

    public Funcionario(String cpf, String nome, int senha, String usuario, String tipo) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.tipo = tipo;
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
}
