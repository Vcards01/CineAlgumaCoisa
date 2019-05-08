package DataBaseSimulation;

import Model.Filme;
import Model.Produto;

import java.util.ArrayList;

public class ProdutosDAO {

    private Produto p1 = new Produto(1,10,"Pipoca Pequena","Comida",8.50);
    private Produto p2 = new Produto(2,5,"Pipoca Media ","Comida",10.00);
    private Produto p3 = new Produto(3,7,"Pipoca Grande","Comida",12.50);
    private Produto p4 = new Produto(4,14,"Pipoca Doce","Comida",10.00);
    private Produto p5 = new Produto(5,2,"Coca Cola 350ml","Bebida",5.00);
    private Produto p6 = new Produto(6,8,"Coca Cola 600ml","Bebida",8.50);
    private Produto p7 = new Produto(7,15,"Fanta Uva 350ml","Bebida",8.50);
    private Produto p8 = new Produto(8,6,"Chocolate","Comida",8.50);
    private Produto p9 = new Produto(9,8,"Bala","Doce",8.50);
    private Produto p10 = new Produto(10,7,"Halls","Bala",8.50);


    public Produto read(int id)
    {
        for(int i=0;i<getProduto().size();i++)
        {
            if(id==getProduto().get(i).getId())
            {
                return getProduto().get(i);
            }
        }
        return null;
    }

    public ArrayList<Produto> getProduto()
    {
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);
        produtos.add(p4);
        produtos.add(p5);
        produtos.add(p6);
        produtos.add(p7);
        produtos.add(p8);
        produtos.add(p9);
        produtos.add(p10);
        return produtos;
    }
}
