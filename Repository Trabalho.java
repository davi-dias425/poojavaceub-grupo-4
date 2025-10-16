package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryMemoria {
    private List<Cliente> lista = new ArrayList<>();
    private int proximoId = 1;

    public Cliente adicionar(Cliente c) {
        c.setId(proximoId++);
        lista.add(c);
        return c;
    }

    public List<Cliente> listar() {
        return lista;
    }

    public Cliente buscarPorId(int id) {
        for (Cliente c : lista) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public boolean atualizar(int id, String nome, String telefone, String email) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            c.setNome(nome);
            c.setTelefone(telefone);
            c.setEmail(email);
            return true;
        }
        return false;
    }

    public boolean removerPorId(int id) {
        Cliente c = buscarPorId(id);
        if (c != null) {
            lista.remove(c);
            return true;
        }
        return false;
    }
}





package repository;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositoryMemoria {
    private List<Funcionario> lista = new ArrayList<>();
    private int proximoId = 1;

    public Funcionario adicionar(Funcionario f) {
        f.setId(proximoId++);
        lista.add(f);
        return f;
    }

    public List<Funcionario> listar() {
        return lista;
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario f : lista) {
            if (f.getId() == id) return f;
        }
        return null;
    }

    public boolean atualizar(int id, String nome, double salario, String matricula) {
        Funcionario f = buscarPorId(id);
        if (f != null) {
            f.setNome(nome);
            f.setSalario(salario);
            f.setMatricula(matricula);
            return true;
        }
        return false;
    }

    public boolean removerPorId(int id) {
        Funcionario f = buscarPorId(id);
        if (f != null) {
            lista.remove(f);
            return true;
        }
        return false;
    }
}




package repository;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryMemoria {
    private List<Produto> lista = new ArrayList<>();
    private int proximoId = 1;

    public Produto adicionar(Produto p) {
        p.setId(proximoId++);
        lista.add(p);
        return p;
    }

    public List<Produto> listar() {
        return lista;
    }

    public Produto buscarPorId(int id) {
        for (Produto p : lista) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public boolean atualizar(int id, String nome, double preco, int qtd) {
        Produto p = buscarPorId(id);
        if (p != null) {
            p.setNome(nome);
            p.setPreco(preco);
            p.setQuantidadeEmEstoque(qtd);
            return true;
        }
        return false;
    }

    public boolean removerPorId(int id) {
        Produto p = buscarPorId(id);
        if (p != null) {
            lista.remove(p);
            return true;
        }
        return false;
    }
}
