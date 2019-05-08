package Controller;

import DataBaseSimulation.ProdutosDAO;
import Model.Filme;
import Model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import javax.lang.model.element.QualifiedNameable;
import java.net.URL;
import java.util.*;

public class VendaAlimentosController implements Initializable {
    public AnchorPane PnPrincipal;
    public TableView TabelaProduto;
    public TableColumn ColunaProdutoTP;
    public TableColumn ColunaTipoTP;
    public TableColumn ColunaPrecoTP;
    public TableColumn ColunaEstoqueTP;
    public TableView TabelaCarrinho;
    public TableColumn CProdutoCarrinho;
    public TableColumn CProdutoQuantidade;
    public TextField TxtTotal;
    public Button btnAdd;
    public Button BtnRmv;
    private double total=0;
    ArrayList<Produto> list = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SetTabelaVenda();
        SetTabelaCarrinho();
        Shadow();
    }
    public void SetTabelaVenda()
    {

        ColunaProdutoTP.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ColunaTipoTP.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        ColunaPrecoTP.setCellValueFactory(new PropertyValueFactory<>("preco"));
        ColunaEstoqueTP.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        TabelaProduto.setItems(GetProdutos());

    }
    public ObservableList<Produto> GetProdutos()
    {
        ProdutosDAO PDAO= new ProdutosDAO();
        ObservableList<Produto> Produtos = FXCollections.observableArrayList(PDAO.getProduto());
        return Produtos;
    }
    public void GetMedidas(Double h,double w)
    {
        PnPrincipal.setPrefWidth(w);
        PnPrincipal.setPrefHeight(h);
    }
    public void AddProduto(ActionEvent event)
    {


        Produto p = (Produto) TabelaProduto.getSelectionModel().getSelectedItem();

        if(list.isEmpty())
        {
           p.setQuantidadeDeVenda(1);
           list.add(p);

        }
        else
        {
            if(list.contains(p))
            {
                list.get(list.indexOf(p)).setQuantidadeDeVenda(p.getQuantidadeDeVenda()+1);

            }
            else
            {
                p.setQuantidadeDeVenda(1);
                list.add(p);

            }
        }
        SetTotal(p.getPreco(),true);
        Fill(list);
    }
    public void RmvProduto(ActionEvent evente)
    {
        Produto p = (Produto) TabelaCarrinho.getSelectionModel().getSelectedItem();
        if(list.isEmpty())
        {
            System.out.println("Sem produtos, colocar aviso dps");
        }
        else if(p==null)
        {
            System.out.println("Sem produtos selecionado, colocar aviso dps");
        }
       else
        {
            if(p.getQuantidadeDeVenda()>1)
            {
                list.get(list.indexOf(p)).setQuantidadeDeVenda(p.getQuantidadeDeVenda()-1);
            }
            else if(p.getQuantidadeDeVenda()==1)
            {
                list.remove(p);
            }
        }
        SetTotal(p.getPreco(),false);
        Fill(list);
    }
    public void SetTabelaCarrinho()
    {
        CProdutoCarrinho.setCellValueFactory(new PropertyValueFactory<>("nome"));
        CProdutoQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadeDeVenda"));
    }
    public void Fill(ArrayList<Produto> list)
    {
        ObservableList<Produto> Produtos = FXCollections.observableArrayList(list);
        TabelaCarrinho.getItems().removeAll(TabelaCarrinho.getItems());
        TabelaCarrinho.setItems(Produtos);

    }
    public void SetTotal(double valor,boolean operação)
    {
        if(operação)
        {
            total=total+valor;
            TxtTotal.setText(Double.toString(total));
        }
        else if ((!operação)&&(valor>0))
        {
            total=total-valor;
            TxtTotal.setText(Double.toString(total));
        }
        else if ((valor==0)&&(!operação))
        {
            TxtTotal.setText(Double.toString(0.0));
        }

    }
    public void Shadow()
    {
        DropShadow Shad = new DropShadow();
        Shad.setOffsetX(2);
        Shad.setOffsetY(4);
        Shad.setColor(Color.rgb(0, 0, 0));
        TabelaProduto.setEffect(Shad);
        TabelaCarrinho.setEffect(Shad);
        btnAdd.setEffect(Shad);
        BtnRmv.setEffect(Shad);
        TxtTotal.setEffect(Shad);
    }
    public void Finalizar(ActionEvent event)
    {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Venda finalizada");
        alert.setHeaderText(null);
        alert.setContentText("A venda no valor de R$"+TxtTotal.getText()+(",foi concluida com sucesso"));
        alert.showAndWait();
    }
    public void Cancelar(ActionEvent event)
    {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Venda cancelada");
        alert.setHeaderText(null);
        alert.setContentText("A venda no valor de R$"+TxtTotal.getText()+(",foi cancelada"));
        alert.showAndWait();
        TabelaCarrinho.getItems().removeAll(TabelaCarrinho.getItems());
        SetTotal(0,false);
    }


}
