package DataBaseSimulation;

import Model.Filme;
import Model.Funcionario;
import Model.Sala;
import Model.Sessao;

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
        Sala s2 = new Sala(2,40);
        Sala s3 = new Sala(3,30);
        Sessao se1 = new Sessao(1, "14:30", f1, s1,22.00,11.00);
        Sessao se2 = new Sessao(2, "16:00", f1, s2,20.00,10.00);
        Sessao se3 = new Sessao(3, "19:30", f1, s3,25.00,12.50);
        Sessao se4 = new Sessao(4, "21:00", f1, s1,30.00,15.00);
        Sessao se5 = new Sessao(5, "14:45", f1, s2,21.00,10.50);
        f1.AddSessao(se1);
        f1.AddSessao(se2);
        f1.AddSessao(se3);
        f1.AddSessao(se4);
        f1.AddSessao(se5);
        f2.AddSessao(se1);
        f2.AddSessao(se2);
        f2.AddSessao(se3);
        f2.AddSessao(se4);
        f2.AddSessao(se5);
        f3.AddSessao(se1);
        f3.AddSessao(se2);
        f3.AddSessao(se3);
        f3.AddSessao(se4);
        f3.AddSessao(se5);
        f4.AddSessao(se1);
        f4.AddSessao(se2);
        f4.AddSessao(se3);
        f4.AddSessao(se4);
        f4.AddSessao(se5);
        f5.AddSessao(se1);
        f5.AddSessao(se2);
        f5.AddSessao(se3);
        f5.AddSessao(se4);
        f5.AddSessao(se5);

    }

}
