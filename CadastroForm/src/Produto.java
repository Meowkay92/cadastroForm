public class Produto {
    private String nome;
    private String descricaoProduto;
    private double valor;
    private boolean disponivelParaVenda;


    public Produto(String nome, String descricaoProduto, double valor, boolean disponivelParaVenda) {
        this.nome = nome;
        this.descricaoProduto = descricaoProduto;
        this.valor = valor;
        this.disponivelParaVenda = disponivelParaVenda;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public double getValor() {
        return valor;
    }

    public boolean isDisponivelParaVenda() {
        return disponivelParaVenda;
    }
}
