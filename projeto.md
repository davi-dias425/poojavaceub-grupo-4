```mermaid
classDiagram
    direction TB

    class Produto {
        -nome: string
        -descricao: string
        -preco: float
        -estoque: int
        -marca: string
        -modelo: string
        +getPreco(): float
        +atualizarEstoque(quantidade: int): void
    }

    class Instrumento {
        +tocar(): void
        +afinar(): void
    }

    class Cordas {
        -numeroCordas: int
        -tipoCorda: string
        +getNumeroCordas(): int
        +trocarCorda(): void
    }

    class Metais {
        -tipoPistao: string
        +getTipoPistao(): string
        +limparBocal(): void
    }

    class Percussao {
        -tipo: string
        +getTipo(): string
        +trocarPele(): void
    }

    class Acessorio {
        -tipoAcessorio: string
        +getTipoAcessorio(): string
        +verificarCompatibilidade(instrumento: Instrumento): boolean
    }

    class Usuario {
        -nome: string
        -email: string
        -senha: string
        +getEmail(): string
        +fazerLogin(senha: string): boolean
    }

    class Cliente {
        -cpf: string
        -endereco: string
        +getCpf(): string
        +atualizarEndereco(novoEndereco: string): void
    }

    class Funcionario {
        -matricula: string
        -cargo: string
        +getMatricula(): string
        +promover(novoCargo: string): void
    }

    class Fornecedor {
        -id: int
        -nome: string
        -cnpj: string
        -contato: string
        +getContato(): string
        +atualizarDados(novoContato: string): void
    }

    class Pedido {
        -id : int
        -data : Date
        -status : string
        +atualizarStatus(status: string) : void
        +getStatus(): string
    }

    class Venda {
        -id: int
        -data: Date
        +gerarNotaFiscal(): string
        +getTotalVenda(): float
    }

    %% Relações de herança
    Produto <|-- Instrumento
    Produto <|-- Acessorio
    Instrumento <|-- Cordas
    Instrumento <|-- Metais
    Instrumento <|-- Percussao
    Usuario <|-- Cliente
    Usuario <|-- Funcionario

    %% Associações e composições
    Fornecedor "1" o-- "*" Produto : fornece
    Cliente "1" -- "*" Pedido : realiza
    Pedido "1" *-- "*" Produto : contém
    Venda "1" *-- "1" Pedido : registra
    Funcionario "1" -- "*" Venda : processa
