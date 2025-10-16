import model.*;
import repository.*;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    static FuncionarioRepositoryMemoria repoFunc = new FuncionarioRepositoryMemoria();
    static ProdutoRepositoryMemoria repoProd = new ProdutoRepositoryMemoria();
    static ClienteRepositoryMemoria repoCli = new ClienteRepositoryMemoria();

    public static void main(String[] args) {
        int opc;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1) Gerenciar Funcionários");
            System.out.println("2) Gerenciar Produtos");
            System.out.println("3) Gerenciar Clientes");
            System.out.println("4) Cadastrar Cliente (atalho)");
            System.out.println("5) Cadastrar Produto (atalho)");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    menuFuncionario();
                    break;
                case 2:
                    menuProduto();
                    break;
                case 3:
                    menuCliente();
                    break;
                case 4:
                    cadastrarCliente();
                    break;
                case 5:
                    cadastrarProduto();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opc != 0);
    }

    // ---------------- FUNCIONÁRIO ----------------
    static void menuFuncionario() {
        int op;
        do {
            System.out.println("\n--- Funcionários ---");
            System.out.println("1) Cadastrar");
            System.out.println("2) Listar");
            System.out.println("3) Buscar por ID");
            System.out.println("4) Atualizar por ID");
            System.out.println("5) Excluir por ID");
            System.out.println("0) Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionario();
                    break;
                case 4:
                    atualizarFuncionario();
                    break;
                case 5:
                    excluirFuncionario();
                    break;
            }
        } while (op != 0);
    }

    static void cadastrarFuncionario() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Salário: ");
        double salario = sc.nextDouble();
        sc.nextLine();
        System.out.print("Matrícula: ");
        String mat = sc.nextLine();

        Funcionario f = new Funcionario(nome, salario, mat);
        repoFunc.adicionar(f);
        System.out.println("✅ Funcionário cadastrado com sucesso!");
    }

    static void listarFuncionarios() {
        for (Funcionario f : repoFunc.listar()) System.out.println(f);
    }

    static void buscarFuncionario() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Funcionario f = repoFunc.buscarPorId(id);
        System.out.println(f != null ? f : "❌ ID não encontrado.");
    }

    static void atualizarFuncionario() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo salário: ");
        double sal = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nova matrícula: ");
        String mat = sc.nextLine();

        if (repoFunc.atualizar(id, nome, sal, mat))
            System.out.println("✅ Atualizado com sucesso!");
        else
            System.out.println("❌ ID não encontrado.");
    }

    static void excluirFuncionario() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (repoFunc.removerPorId(id))
            System.out.println("✅ Removido!");
        else
            System.out.println("❌ ID não encontrado.");
    }

    // ---------------- PRODUTO ----------------
    static void menuProduto() {
        int op;
        do {
            System.out.println("\n--- Produtos ---");
            System.out.println("1) Cadastrar");
            System.out.println("2) Listar");
            System.out.println("3) Buscar por ID");
            System.out.println("4) Atualizar por ID");
            System.out.println("5) Excluir por ID");
            System.out.println("0) Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    buscarProduto();
                    break;
                case 4:
                    atualizarProduto();
                    break;
                case 5:
                    excluirProduto();
                    break;
            }
        } while (op != 0);
    }

    static void cadastrarProduto() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        Produto p = new Produto(nome, preco, qtd);
        repoProd.adicionar(p);
        System.out.println("✅ Produto cadastrado!");
    }

    static void listarProdutos() {
        for (Produto p : repoProd.listar()) System.out.println(p);
    }

    static void buscarProduto() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Produto p = repoProd.buscarPorId(id);
        System.out.println(p != null ? p : "❌ ID não encontrado.");
    }

    static void atualizarProduto() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo preço: ");
        double preco = sc.nextDouble();
        System.out.print("Nova quantidade: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        if (repoProd.atualizar(id, nome, preco, qtd))
            System.out.println("✅ Atualizado!");
        else
            System.out.println("❌ ID não encontrado.");
    }

    static void excluirProduto() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (repoProd.removerPorId(id))
            System.out.println("✅ Produto removido!");
        else
            System.out.println("❌ ID não encontrado.");
    }

    // ---------------- CLIENTE ----------------
    static void menuCliente() {
        int op;
        do {
            System.out.println("\n--- Clientes ---");
            System.out.println("1) Cadastrar");
            System.out.println("2) Listar");
            System.out.println("3) Buscar por ID");
            System.out.println("4) Atualizar por ID");
            System.out.println("5) Excluir por ID");
            System.out.println("0) Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    atualizarCliente();
                    break;
                case 5:
                    excluirCliente();
                    break;
            }
        } while (op != 0);
    }

    static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Telefone: ");
        String tel = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente c = new Cliente(nome, tel, email);
        repoCli.adicionar(c);
        System.out.println("✅ Cliente cadastrado!");
    }

    static void listarClientes() {
        for (Cliente c : repoCli.listar()) System.out.println(c);
    }

    static void buscarCliente() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Cliente c = repoCli.buscarPorId(id);
        System.out.println(c != null ? c : "❌ ID não encontrado.");
    }

    static void atualizarCliente() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Novo nome: ");
        String nome = sc.nextLine();
        System.out.print("Novo telefone: ");
        String tel = sc.nextLine();
        System.out.print("Novo email: ");
        String email = sc.nextLine();

        if (repoCli.atualizar(id, nome, tel, email))
            System.out.println("✅ Atualizado!");
        else
            System.out.println("❌ ID não encontrado.");
    }

    static void excluirCliente() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (repoCli.removerPorId(id))
            System.out.println("✅ Removido!");
        else
            System.out.println("❌ ID não encontrado.");
    }
}

