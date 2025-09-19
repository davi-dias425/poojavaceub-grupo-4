## 🚀 Código Completo
Abaixo está o código completo em **um único arquivo (`LojaMusica.java`)** para facilitar a execução:

```java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum Categoria {
    CORDAS, PERCUSSAO, SOPRO, ELETRONICO, ACESSORIOS
}

abstract class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(int codigo, String nome, double preco, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public Categoria getCategoria() { return categoria; }

    public void setPreco(double preco) { this.preco = preco; }

    public abstract void exibirDetalhes();
}

class Instrumento extends Produto {
    private String tipo;
    private String marca;

    public Instrumento(int codigo, String nome, double preco, Categoria categoria, String tipo, String marca) {
        super(codigo, nome, preco, categoria);
        this.tipo = tipo;
        this.marca = marca;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Instrumento: " + getNome() + " - Marca: " + marca + " (" + tipo + ")");
    }
}

class Acessorio extends Produto {
    private String material;

    public Acessorio(int codigo, String nome, double preco, Categoria categoria, String material) {
        super(codigo, nome, preco, categoria);
        this.material = material;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Acessório: " + getNome() + " - Material: " + material);
    }
}

class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = calcularSubtotal();
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public double getSubtotal() { return subtotal; }
}

class Venda {
    private int id;
    private Date data;
    private List<ItemVenda> itens;
    private double valorTotal;

    public Venda(int id, Date data) {
        this.id = id;
        this.data = data;
        this.itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void adicionarProduto(Produto p, int qtd) {
        ItemVenda item = new ItemVenda(p, qtd);
        itens.add(item);
        calcularTotal();
    }

    public void calcularTotal() {
        valorTotal = 0;
        for (ItemVenda item : itens) {
            valorTotal += item.getSubtotal();
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void exibirItens() {
        System.out.println("=== Itens da Venda #" + id + " ===");
        for (ItemVenda item : itens) {
            item.getProduto().exibirDetalhes();
            System.out.println("Quantidade: " + item.getQuantidade() + " | Subtotal: R$ " + item.getSubtotal());
        }
        System.out.println("Valor total da venda: R$ " + valorTotal);
    }
}

class Funcionario {
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

```
# 📃 Produtos 

```

public abstract class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto(int codigo, String nome, double preco, Categoria categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public Categoria getCategoria() { return categoria; }

    public void setPreco(double preco) { this.preco = preco; }

    // Método abstrato para ser implementado pelas subclasses
    public abstract void exibirDetalhes();
}

public class Instrumento extends Produto {
    private String tipo;
    private String marca;

    public Instrumento(int codigo, String nome, double preco, Categoria categoria, String tipo, String marca) {
        super(codigo, nome, preco, categoria);
        this.tipo = tipo;
        this.marca = marca;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Instrumento: " + getNome() + " - Marca: " + marca + " (" + tipo + ")");
    }
}

public class Acessorio extends Produto {
    private String material;

    public Acessorio(int codigo, String nome, double preco, Categoria categoria, String material) {
        super(codigo, nome, preco, categoria);
        this.material = material;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Acessório: " + getNome() + " - Material: " + material);
    }
}
