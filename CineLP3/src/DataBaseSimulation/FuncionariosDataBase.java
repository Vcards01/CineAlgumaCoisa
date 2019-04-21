package DataBaseSimulation;

import Model.Funcionario;

import java.util.ArrayList;

public class FuncionariosDataBase {
    private ArrayList<Funcionario> FuncionariosSimulation = new ArrayList<Funcionario>();
    private  Funcionario f1 = new Funcionario("123","Victor",123,"VictorUser","Atendente");
    private  Funcionario f2 = new Funcionario("123","Victor",123,"VictorAdmin","Administrador");
    private  Funcionario f3 = new Funcionario("123","Rodrigo",123,"RodrigoUser","Atendente");
    private  Funcionario f4 = new Funcionario("123","Rodrigo",123,"RodrigoAdmin","Administrador");
    private  Funcionario f5 = new Funcionario("123","Lucas",123,"LucasUser","Atendente");
    private  Funcionario f6 = new Funcionario("123","Lucas",123,"LucasAdmin","Administrador");

    public ArrayList<Funcionario> getSimulation()
    {

        FuncionariosSimulation.add(f1);
        FuncionariosSimulation.add(f2);
        FuncionariosSimulation.add(f3);
        FuncionariosSimulation.add(f4);
        FuncionariosSimulation.add(f5);
        FuncionariosSimulation.add(f6);
        return FuncionariosSimulation;
    }
}
