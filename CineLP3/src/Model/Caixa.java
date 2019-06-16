package Model;
public class Caixa {

    private String data;
    private double valorInicial;
    private double lucro;
    private double valorAtual;
    private boolean status;

    public Caixa(String data, double valorInicial, double lucro, double valorAtual)
    {
        this.data = data;
        this.valorInicial = valorInicial;
        this.lucro = lucro;
        this.valorAtual = valorAtual;

    }
    public Caixa(String data, double valorInicial, double lucro, double valorAtual,boolean status)
    {
        this.data = data;
        this.valorInicial = valorInicial;
        this.lucro = lucro;
        this.valorAtual = valorAtual;
        this.status=status;

    }
    public  Caixa()
    {

    }
    public void AbrirCaixa(double ValorInicial)
    {
        this.valorInicial=ValorInicial;
        lucro = 0;
        valorAtual = valorInicial + lucro;
    }
    public void AddValor(double valor)
    {
        valorAtual += valor;
        lucro= valorAtual - valorInicial;
    }
    //Getters
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

    public boolean getStatus() {
        return status;
    }
    //Setters
    public void setStatus(boolean status) {
        this.status = status;
    }
}
