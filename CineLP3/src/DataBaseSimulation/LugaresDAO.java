package DataBaseSimulation;

import Model.Lugares;
import Model.Sessao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class LugaresDAO {
    private SessaoDAO SDAO = new SessaoDAO();
    private ArrayList<Lugares>lugares = new ArrayList<>();

    public LugaresDAO() throws FileNotFoundException {
        CreateLugares();
    }

    //Sessão 1
    private void CreateLugares()
    {
        for(int i=0;i<40;i++) {
            lugares.add(new Lugares(i+1, false, SDAO.read(1)));
            lugares.add(new Lugares(i+1, false, SDAO.read(4)));
            lugares.add(new Lugares(i+1, true,SDAO.read(7)));
        }
        for(int i=0;i<50;i++) {
            lugares.add(new Lugares(i+1, false, SDAO.read(2)));
            lugares.add(new Lugares(i+1, false, SDAO.read(5)));
            lugares.add(new Lugares(i+1, false, SDAO.read(8)));
          }
        for(int i=0;i<60;i++) {
            lugares.add(new Lugares(i+1, false, SDAO.read(3)));
            lugares.add(new Lugares(i+1, false, SDAO.read(6)));
            lugares.add(new Lugares(i+1, true, SDAO.read(9)));
        }
        for (int i=0;i<39;i++)
        {
            lugares.add(new Lugares(i+1, true, SDAO.read(10)));
        }
        lugares.add(new Lugares(40,false,SDAO.read(10)));

    }
    public ArrayList<Lugares> getLugares()
    {
      return lugares;
    }
    public  ArrayList<Lugares> FindBySessao(Sessao s)
    {
        ArrayList<Lugares> lugares = new ArrayList<>();
        for(int i=0;i<getLugares().size();i++)
        {
            if(getLugares().get(i).getSessao().getId()==s.getId())
            {
                lugares.add(getLugares().get(i));
            }
        }
        return lugares;
    }

}
