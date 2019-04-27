package DataBaseSimulation;

import Model.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FilmesDataBase {
    private ArrayList<Filme> FilmesSimulation = new ArrayList<Filme>();
    private Filme f1 = new Filme(1,"Vingadores: Guerra Infinita", " Fantasia/Filme de ficção", "Homem de Ferro, Thor, Hulk e os Vingadores se unem para combater seu inimigo mais poderoso, o maligno Thanos.Em uma missão para coletar todas as seis pedras infinitas,Thanos planeja usá-las para infligir sua vontade maléfica sobre a realidade.",
                      "2h 40m","Resources/Capas/InfinityWar.jpg");
    private Filme f2 = new Filme(2,"Vingadores: Ultimato","Fantasia/Filme de ficção","Após Thanos eliminar metade das criaturas vivas,\n os Vingadores têm de lidar com a perda de amigos e entes queridos.\n Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram\n a resistência contra o titã louco.",
            "3h 1m","Resources/Capas/EndGame.jpg");
    private Filme f3 = new Filme(3,"Shazam", " Fantasia/Filme de ficção", "Billy Batson tem apenas 14 anos de idade, mas recebeu de um antigo mago o dom de se transformar em um super-herói adulto chamado Shazam. Ao gritar a palavra SHAZAM!, o adolescente se transforma nessa sua poderosa versão adulta para se divertir e testar suas habilidades.",
            "2h 12m","Resources/Capas/Shazan.jpg");
    private Filme f4 = new Filme(4,"Dumbo","Fantasia/Aventura","Holt Farrier é uma ex-estrela de circo que retorna da guerra e encontra seu mundo virado de cabeça para baixo. O circo em que trabalhava está passando por grandes dificuldades, e ele fica encarregado de cuidar de um elefante recém-nascido, cujas orelhas gigantes fazem dele motivo de piada. No entanto, os filhos de Holt descobrem que o pequeno elefante é capaz de uma façanha enorme: voar.",
            "1h 52m","Resources/Capas/Dumbo.jpg");
    private Filme f5 = new Filme(5,"Bohemian Rhapsody", "Drama/Biografia", "Freddie Mercury, Brian May, Roger Taylor e John Deacon formam a banda de rock Queen em 1970. Quando o estilo de vida agitado de Mercury começa a sair de controle, o grupo precisa encontrar uma forma de lidar com o sucesso e os excessos de seu líder.",
            "2h 13m","Resources/Capas/Queen.jpg");


    public FilmesDataBase() throws FileNotFoundException {
    }
    public ArrayList<Filme> getSimulation(){
        FilmesSimulation.add(f1);
        FilmesSimulation.add(f2);
        FilmesSimulation.add(f3);
        FilmesSimulation.add(f4);
        FilmesSimulation.add(f5);
        SetSessões();
        return FilmesSimulation;
    }
    public void SetSessões()
    {

        Sala s1 = new Sala(1,40);
        Sala s2 = new Sala(2,20);
        Sala s3 = new Sala(3,30);
        sessao(f1,f2,f3,f4,f5,s1,s2,s3);
    }
    public void OcuparSala2(Sessao s)
    {
        s.AddLugares(new Lugares(1,true));
        s.AddLugares(new Lugares(2,false));
        s.AddLugares(new Lugares(3,false));
        s.AddLugares(new Lugares(4,false));
        s.AddLugares(new Lugares(5,false));
        s.AddLugares(new Lugares(6,false));
        s.AddLugares(new Lugares(7,false));
        s.AddLugares(new Lugares(8,false));
        s.AddLugares(new Lugares(9,true));
        s.AddLugares(new Lugares(10,true));
        s.AddLugares(new Lugares(11,true));
        s.AddLugares(new Lugares(12,false));
        s.AddLugares(new Lugares(13,true));
        s.AddLugares(new Lugares(14,false));
        s.AddLugares(new Lugares(15,false));
        s.AddLugares(new Lugares(16,false));
        s.AddLugares(new Lugares(17,true));
        s.AddLugares(new Lugares(18,true));
        s.AddLugares(new Lugares(19,true));
        s.AddLugares(new Lugares(20,true));
    }
    public void OcuparSala3(Sessao s)
    {
        s.AddLugares(new Lugares(1,false));
        s.AddLugares(new Lugares(2,false));
        s.AddLugares(new Lugares(3,false));
        s.AddLugares(new Lugares(4,false));
        s.AddLugares(new Lugares(5,false));
        s.AddLugares(new Lugares(6,false));
        s.AddLugares(new Lugares(7,false));
        s.AddLugares(new Lugares(8,true));
        s.AddLugares(new Lugares(9,true));
        s.AddLugares(new Lugares(10,true));
        s.AddLugares(new Lugares(11,false));
        s.AddLugares(new Lugares(12,true));
        s.AddLugares(new Lugares(13,false));
        s.AddLugares(new Lugares(14,false));
        s.AddLugares(new Lugares(15,false));
        s.AddLugares(new Lugares(16,true));
        s.AddLugares(new Lugares(17,true));
        s.AddLugares(new Lugares(18,true));
        s.AddLugares(new Lugares(19,true));
        s.AddLugares(new Lugares(20,true));
        s.AddLugares(new Lugares(21,true));
        s.AddLugares(new Lugares(22,false));
        s.AddLugares(new Lugares(23,true));
        s.AddLugares(new Lugares(24,false));
        s.AddLugares(new Lugares(25,false));
        s.AddLugares(new Lugares(26,false));
        s.AddLugares(new Lugares(27,true));
        s.AddLugares(new Lugares(28,true));
        s.AddLugares(new Lugares(29,true));
        s.AddLugares(new Lugares(30,true));
    }
    public void OcuparSala1(Sessao s)
    {
        s.AddLugares(new Lugares(1,true));
        s.AddLugares(new Lugares(2,false));
        s.AddLugares(new Lugares(3,false));
        s.AddLugares(new Lugares(4,false));
        s.AddLugares(new Lugares(5,false));
        s.AddLugares(new Lugares(6,false));
        s.AddLugares(new Lugares(7,false));
        s.AddLugares(new Lugares(8,false));
        s.AddLugares(new Lugares(9,true));
        s.AddLugares(new Lugares(10,true));
        s.AddLugares(new Lugares(11,true));
        s.AddLugares(new Lugares(12,false));
        s.AddLugares(new Lugares(13,true));
        s.AddLugares(new Lugares(14,false));
        s.AddLugares(new Lugares(15,false));
        s.AddLugares(new Lugares(16,false));
        s.AddLugares(new Lugares(17,true));
        s.AddLugares(new Lugares(18,true));
        s.AddLugares(new Lugares(19,true));
        s.AddLugares(new Lugares(20,true));
        s.AddLugares(new Lugares(20,true));
        s.AddLugares(new Lugares(21,true));
        s.AddLugares(new Lugares(21,false));
        s.AddLugares(new Lugares(22,true));
        s.AddLugares(new Lugares(23,false));
        s.AddLugares(new Lugares(24,false));
        s.AddLugares(new Lugares(25,false));
        s.AddLugares(new Lugares(26,true));
        s.AddLugares(new Lugares(27,true));
        s.AddLugares(new Lugares(28,true));
        s.AddLugares(new Lugares(29,true));
        s.AddLugares(new Lugares(30,true));
        s.AddLugares(new Lugares(31,true));
        s.AddLugares(new Lugares(32,false));
        s.AddLugares(new Lugares(33,true));
        s.AddLugares(new Lugares(34,false));
        s.AddLugares(new Lugares(35,false));
        s.AddLugares(new Lugares(36,false));
        s.AddLugares(new Lugares(37,true));
        s.AddLugares(new Lugares(38,true));
        s.AddLugares(new Lugares(39,true));
        s.AddLugares(new Lugares(40,true));
    }
    private void sessao(Filme f1,Filme f2,Filme f3,Filme f4,Filme f5,Sala s1,Sala s2,Sala s3)
    {
        //Guerra Infinita
        Sessao se1 = new Sessao(1, "14:30", f1, s1,22.00,11.00);
        Sessao se2 = new Sessao(2, "16:00", f1, s2,20.00,10.00);
        //Ultimato
        Sessao se3 = new Sessao(3, "19:30", f2, s3,25.00,12.50);
        Sessao se4 = new Sessao(4, "21:00", f2, s1,30.00,15.00);
        //Shazan
        Sessao se5 = new Sessao(5, "19:45", f3, s2,21.00,10.50);
        Sessao se6 = new Sessao(6, "22:45", f3, s3,21.00,10.50);
        //Dumbo
        Sessao se7 = new Sessao(7, "21:45", f4, s1,21.00,10.50);
        Sessao se8 = new Sessao(8, "13:45", f4, s2,21.00,10.50);
        //Queen
        Sessao se9 = new Sessao(9, "17:45", f5, s3,21.00,10.50);
        Sessao se10 = new Sessao(10, "16:45", f5, s1,21.00,10.50);
        f1.AddSessao(se1);
        f1.AddSessao(se2);
        f2.AddSessao(se3);
        f2.AddSessao(se4);
        f3.AddSessao(se5);
        f3.AddSessao(se6);
        f4.AddSessao(se7);
        f4.AddSessao(se8);
        f5.AddSessao(se9);
        f5.AddSessao(se10);
        OcuparSala1(se1);
        OcuparSala2(se2);
        OcuparSala3(se3);
        OcuparSala1(se4);
        OcuparSala2(se5);
        OcuparSala3(se6);
        OcuparSala1(se7);
        OcuparSala2(se8);
        OcuparSala3(se9);
        OcuparSala1(se10);

    }
    public Lugares GetAssento(int id,Sessao s)
    {
        System.out.println(id);
        ArrayList<Lugares> l = s.getLugares();
        for(int i=0;i<l.size();i++)
        {
            System.out.println(l.get(i).getId());
            if(id==l.get(i).getId())
            {
                return l.get(i);
            }
        }
        return null;
    }
}
