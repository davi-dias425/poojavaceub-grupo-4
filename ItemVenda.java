public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public double calcularSubtotal() {
        return this.produto.getPreco() * this.quantidade;
    }
}
