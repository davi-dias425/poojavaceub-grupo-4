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

    class Cordas {
        -numeroCordas: int
        -tipodeCorda: string
        +getNumeroCordas(): int
        +trocarCorda(): void
    }

    Produto <|-- Instrumento
    Produto <|-- Acessorio
    Instrumento <|-- Cordas
    Instrumento <|-- Metais
    Instrumento <|-- Percussao
    Usuario <|-- Cliente
    Usuario <|-- Funcionario
