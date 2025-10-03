import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario(1, "Carlos");

        Produto guitarra = new Instrumento(101, "Guitarra", 1500.00, Categoria.CORDAS, "Elétrica", "Fender");
        Produto baqueta = new Acessorio(102, "Baqueta", 50.00, Categoria.PERCUSSAO, "Madeira");

        funcionario.cadastrarProduto(guitarra);
        funcionario.cadastrarProduto(baqueta);

        funcionario.listarProdutos();

        Venda venda = funcionario.gerarVenda(1);
        venda.adicionarProduto(guitarra, 1);
        venda.adicionarProduto(baqueta, 2);

        venda.exibirItens();

        funcionario.listarVendas();
    }
}

