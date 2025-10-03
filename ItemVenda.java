puclic class ItemVenda {
  private Produto produto;
  private int quantidade;

  public ItemVenda(Produto produto, int quantidade) {
    this.produto = produto;
    this.quantidade = quantidade;
     
      }
  public double calcular Subtotal() {
    precoDoProduto = this.produto.getPreco();
    double subtotalCalculado = precoDoProduto * this.quantidade;
        return subtotalCalculado;
    }
}
