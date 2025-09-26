
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
