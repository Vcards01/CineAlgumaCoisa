package DataBaseSimulation;

import Model.Filme;
import Model.Sessao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SessaoDAO {
    FilmesDAO FDAO = new FilmesDAO();
    SalaDAO SDAO = new SalaDAO();
    private Sessao s1 = new Sessao(1, "14:30", FDAO.read(1), SDAO.read(1),22.00,11.00);
    private Sessao s2 = new Sessao(2, "16:00", FDAO.read(1), SDAO.read(2),20.00,10.00);
    //Ultimato
    private Sessao s3 = new Sessao(3, "19:30", FDAO.read(2), SDAO.read(3),25.00,12.50);
    private Sessao s4 = new Sessao(4, "21:00", FDAO.read(2), SDAO.read(1),30.00,15.00);
    //Shazan
    private Sessao s5 = new Sessao(5, "19:45", FDAO.read(3),SDAO.read(2),21.00,10.50);
    private Sessao s6 = new Sessao(6, "22:45", FDAO.read(3), SDAO.read(3),21.00,10.50);
    //Dumbo
    private Sessao s7 = new Sessao(7, "21:45", FDAO.read(4), SDAO.read(1),21.00,10.50);
    private Sessao s8 = new Sessao(8, "13:45", FDAO.read(4), SDAO.read(2),21.00,10.50);
    //Queen
    private Sessao s9 = new Sessao(9, "17:45", FDAO.read(5), SDAO.read(3),21.00,10.50);
    private Sessao s10 = new Sessao(10, "16:45", FDAO.read(5), SDAO.read(1),21.00,10.50);

    public Sessao read (int id)
    {

        for(int i=0;i<getSessao().size();i++) {
            if (getSessao().get(i).getId()==id)
            {
                return getSessao().get(i);
            }
        }
        return null;
    }
    public ArrayList<Sessao> findbyFilme(Filme f)
    {
        ArrayList<Sessao>sessoes = new ArrayList<>();
        for(int i=0;i<getSessao().size();i++) {
            if (f.getId()==getSessao().get(i).getFilme().getId())
            {
                sessoes.add(getSessao().get(i));
            }
        }
        return sessoes;
    }
    public ArrayList<Sessao> getSessao()
    {
        ArrayList<Sessao>sessoes = new ArrayList<>();
        sessoes.add(s1);
        sessoes.add(s2);
        sessoes.add(s3);
        sessoes.add(s4);
        sessoes.add(s5);
        sessoes.add(s6);
        sessoes.add(s7);
        sessoes.add(s8);
        sessoes.add(s9);
        sessoes.add(s10);
        return sessoes;
    }


    public SessaoDAO() throws FileNotFoundException {
    }
}
