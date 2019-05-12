package DataBaseSimulation;

import Model.Funcionario;

import java.util.ArrayList;

public class FuncionariosDAO {
    private ArrayList<Funcionario> FuncionariosSimulation = new ArrayList<Funcionario>();
    private  Funcionario f1 = new Funcionario("123","Victor",123,"VictorUser","Atendente",500.00);
    private  Funcionario f2 = new Funcionario("123","Victor",123,"VictorAdmin","Administrador",500.00);
    private  Funcionario f3 = new Funcionario("123","Rodrigo",123,"RodrigoUser","Atendente",500.00);
    private  Funcionario f4 = new Funcionario("123","Rodrigo",123,"RodrigoAdmin","Administrador",1500.00);
    private  Funcionario f5 = new Funcionario("123","Lucas",123,"LucasUser","Atendente",1500.00);
    private  Funcionario f6 = new Funcionario("123","Lucas",123,"LucasAdmin","Administrador",1500.00);

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
