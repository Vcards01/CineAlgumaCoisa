package DataBaseSimulation;
import Model.Sala;

import java.util.ArrayList;

public class SalasDataBase {
    private ArrayList<Sala> SalasSimulation = new ArrayList<Sala>();
    Sala s1 = new Sala(1,40);
    Sala s2 = new Sala(2,40);
    Sala s3 = new Sala(3,30);

    public ArrayList<Sala> getSimulation(){
        SalasSimulation.add(s1);
        SalasSimulation.add(s2);
        SalasSimulation.add(s3);
        return SalasSimulation;
    }
}
