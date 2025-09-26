

# Código Funcionário

```java
1class Funcionario {
    private int id;
    private String nome;
    private List<Produto> produtos;
    private List<Venda> vendas;

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public void cadastrarProduto(Produto p) {
        produtos.add(p);
    }

    public Produto consultarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }

    public Venda gerarVenda(int idVenda) {
        Venda v = new Venda(idVenda, new java.util.Date());
        vendas.add(v);
        return v;
    }

    public Venda consultarVenda(int idVenda) {
        for (Venda v : vendas) {
            if (v.getId() == idVenda) return v;
        }
        return null;
    }

    public void listarProdutos() {
        System.out.println("=== Produtos cadastrados ===");
        for (Produto p : produtos) {
            p.exibirDetalhes();
            System.out.println("Preço: R$ " + p.getPreco() + " | Categoria: " + p.getCategoria());
        }
    }
}

public class LojaMusica {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario(1, "João");

        Produto guitarra = new Instrumento(101, "Guitarra", 1500.0, Categoria.CORDAS, "Cordas", "Fender");
        Produto baqueta = new Acessorio(201, "Baqueta", 50.0, Categoria.ACESSORIOS, "Madeira");

        f1.cadastrarProduto(guitarra);
        f1.cadastrarProduto(baqueta);

        Venda venda1 = f1.gerarVenda(1);
        venda1.adicionarProduto(guitarra, 1);
        venda1.adicionarProduto(baqueta, 2);

        System.out.println("\n--- Itens da venda ---");
        venda1.exibirItens();

        System.out.println("\n--- Produtos cadastrados ---");
        f1.listarProdutos();

        System.out.println("\n--- Consulta de venda ---");
        Venda vendaConsultada = f1.consultarVenda(1);
        if (vendaConsultada != null) {
            vendaConsultada.exibirItens();
        }
    }
}

