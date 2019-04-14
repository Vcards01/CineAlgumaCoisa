package Model;
import java.time.LocalDate;
public class Caixa {

    private String data;
    private double valorInicial;
    private double lucro;
    private double valorAtual;

    public Caixa(String data, double valorInicial, double lucro, double valorAtual)
    {
        this.data = data;
        this.valorInicial = valorInicial;
        this.lucro = lucro;
        this.valorAtual = valorAtual;

    }
    public  Caixa()
    {

    }
    public void AbrirCaixa(float ValorInicial)
    {
        this.valorInicial=ValorInicial;
        lucro = 0;
        valorAtual = valorInicial + lucro;
        data = LocalDate.now().toString();
    }
    public void RetirarValor(double valor)
    {
        valorAtual -= valor;
    }
    public void AddValor(double valor)
    {
        valorAtual += valor;
        lucro= valorAtual - valorInicial;
    }
    public void FecharCaixa()
    {
        lucro = valorAtual - valorInicial;
    }
    //Getters e Setters

    public String getData() {
        return data;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public double getLucro() {
        return lucro;
    }

    public double getValorAtual() {
        return valorAtual;
    }

}
