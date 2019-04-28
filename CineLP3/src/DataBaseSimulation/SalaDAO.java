package DataBaseSimulation;

import Model.Sala;

import java.util.ArrayList;

public class SalaDAO {

   private Sala s1 = new Sala(1,40);
   private Sala s2 = new Sala(2,50);
   private Sala s3 = new Sala(3,60);

   public Sala read(int id)
   {
       for(int i=0;i<getSalas().size();i++)
       {
           if(getSalas().get(i).getId()==id)
           {
               return getSalas().get(i);
           }
       }
       return null;
   }
   public ArrayList<Sala> getSalas()
   {
       ArrayList<Sala>salas = new ArrayList<>();
       salas.add(s1);
       salas.add(s2);
       salas.add(s3);
       return salas;
   }
}
