# trabalho de classes

## código completo
```java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum Categoria {
    CORDAS,
    PERCUSSAO,
    VENTO,
    ACESSORIOS
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

    public void setNome(String nome) { this.nome = nome; }
    public void setPreco(double preco) { this.preco = preco; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

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

    public String getTipo() { return tipo; }
    public String getMarca() { return marca; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setMarca(String marca) { this.marca = marca; }

    @Override
    public void exibirDetalhes() {
        System.out.printf("Código: %d | Instrumento: %s | Marca: %s | Tipo: %s | Preço: R$ %.2f | Categoria: %s%n",
                getCodigo(), getNome(), marca, tipo, getPreco(), getCategoria());
    }
}

class Acessorio extends Produto {
    private String material;

    public Acessorio(int codigo, String nome, double preco, Categoria categoria, String material) {
        super(codigo, nome, preco, categoria);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    @Override
    public void exibirDetalhes() {
        System.out.printf("Código: %d | Acessório: %s | Material: %s | Preço: R$ %.2f | Categoria: %s%n",
                getCodigo(), getNome(), material, getPreco(), getCategoria());
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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.subtotal = calcularSubtotal();
    }
}

class Venda {
    private int id;
    private Date data;
    private List<ItemVenda> itens;
    private double valorTotal;

    public Venda(int id, Date data) {
        this.id = id;
        this.data = (data == null) ? new Date() : data;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public int getId() { return id; }
    public Date getData() { return data; }
    public List<ItemVenda> getItens() { return itens; }
    public double getValorTotal() { return valorTotal; }

    public void adicionarProduto(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        itens.add(item);
        calcularTotal();
    }

    public void calcularTotal() {
        valorTotal = 0.0;
        for (ItemVenda item : itens) {
            valorTotal += item.getSubtotal();
        }
    }

    public void exibirItens() {
        System.out.println("Venda ID: " + id + " | Data: " + data);
        for (ItemVenda item : itens) {
            item.getProduto().exibirDetalhes();
            System.out.printf("  Quantidade: %d | Subtotal: R$ %.2f%n",
                    item.getQuantidade(), item.getSubtotal());
        }
        System.out.printf("  Valor total: R$ %.2f%n", valorTotal);
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

    public int getId() { return id; }
    public String getNome() { return nome; }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto consultarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }

    public Venda gerarVenda(int idVenda) {
        Venda venda = new Venda(idVenda, new Date());
        vendas.add(venda);
        return venda;
    }

    public Venda consultarVenda(int idVenda) {
        for (Venda v : vendas) {
            if (v.getId() == idVenda) return v;
        }
        return null;
    }

    public void exibirProdutosCadastrados() {
        System.out.println("=== Produtos cadastrados ===");
        for (Produto p : produtos) {
            p.exibirDetalhes();
        }
    }

    public void exibirVendas() {
        System.out.println("=== Vendas realizadas ===");
        for (Venda v : vendas) {
            v.exibirItens();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Loja de Música ===");

        Funcionario f1 = new Funcionario(1, "João");

        Produto guitarra = new Instrumento(101, "Guitarra Stratocaster", 1500.00, Categoria.CORDAS, "Elétrica", "Fender");
        Produto violao = new Instrumento(102, "Violão Folk", 800.00, Categoria.CORDAS, "Acústico", "Yamaha");
        Produto baqueta = new Acessorio(201, "Baqueta", 50.00, Categoria.PERCUSSAO, "Madeira");
        Produto palheta = new Acessorio(202, "Palheta", 5.00, Categoria.ACESSORIOS, "Plástico");

        f1.cadastrarProduto(guitarra);
        f1.cadastrarProduto(violao);
        f1.cadastrarProduto(baqueta);
        f1.cadastrarProduto(palheta);

        f1.exibirProdutosCadastrados();

        Venda venda1 = f1.gerarVenda(1);
        venda1.adicionarProduto(guitarra, 1);
        venda1.adicionarProduto(baqueta, 2);

        System.out.println("\n=== Detalhes da venda 1 ===");
        venda1.exibirItens();

        System.out.println();
        f1.exibirVendas();

        System.out.println("\nConsulta produto código 101:");
        Produto p = f1.consultarProduto(101);
        if (p != null) p.exibirDetalhes();

        System.out.println("\nConsulta venda id 1:");
        Venda vConsulta = f1.consultarVenda(1);
        if (vConsulta != null) vConsulta.exibirItens();
    }
}










`````
## minha parte do código

# Código Funcionário

```java
1  import java.util.ArrayList;
2  import java.util.List;
3
4  public class Funcionario {
5      private int id;
6      private String nome;
7      private List<Produto> produtos;
8      private List<Venda> vendas;
9
10     public Funcionario(int id, String nome) {
11         this.id = id;
12         this.nome = nome;
13         this.produtos = new ArrayList<>();
14         this.vendas = new ArrayList<>();
15     }
16
17     public int getId() { return id; }
18     public String getNome() { return nome; }
19
20     public void cadastrarProduto(Produto produto) {
21         produtos.add(produto);
22     }
23
24     public Produto consultarProduto(int codigo) {
25         for (Produto p : produtos) {
26             if (p.getCodigo() == codigo) return p;
27         }
28         return null;
29     }
30
31     public Venda gerarVenda(int idVenda) {
32         Venda venda = new Venda(idVenda, new java.util.Date());
33         vendas.add(venda);
34         return venda;
35     }
36
37     public Venda consultarVenda(int idVenda) {
38         for (Venda v : vendas) {
39             if (v.getId() == idVenda) return v;
40         }
41         return null;
42     }
43
44     public void exibirProdutosCadastrados() {
45         System.out.println("=== Produtos cadastrados ===");
46         for (Produto p : produtos) {
47             p.exibirDetalhes();
48         }
49     }
50
51     public void exibirVendas() {
52         System.out.println("=== Vendas realizadas ===");
53         for (Venda v : vendas) {
54             v.exibirItens();
55         }
56     }
57 }

