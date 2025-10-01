

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void cadastrarProduto(Produto p) {
        produtos.add(p);
        System.out.println("Produto cadastrado: " + p.getNome());
    }

    public Produto consultarProduto(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
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
            if (v.getId() == idVenda) {
                return v;
            }
        }
        return null;
    }

    public void listarProdutos() {
        System.out.println("\n--- Produtos cadastrados ---");
        for (Produto p : produtos) {
            p.exibirDetalhes();
        }
    }

    public void listarVendas() {
        System.out.println("\n--- Vendas realizadas ---");
        for (Venda v : vendas) {
            System.out.println("Venda ID: " + v.getId() + " | Valor total: R$ " + v.getValorTotal());
        }
    }
}

