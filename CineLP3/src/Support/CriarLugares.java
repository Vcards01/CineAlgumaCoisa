package Support;

import DataBase.LugarDAO;
import Model.Lugares;
import Model.Sala;
import Model.Sessao;

public class CriarLugares implements Runnable{

    Sessao s;

    public void SetSessao(Sessao s)
    {
        this.s=s;
    }

    @Override
    public void run() {
        for(int i=0;i<s.getSala().getQtddLugares();i++)
        {
            LugarDAO LDAO = new LugarDAO();
            Lugares l = new Lugares(i+1,false,s);
            LDAO.create(l);
            System.out.println(i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
