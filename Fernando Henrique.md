classDiagram
    
    class Usuario {
        -nome: string
        -email: string
        -senha: string
    }

    class Cliente {
        -cpf: int
        -endereco: string
    }

    class Funcionario {
        -matricula: int
        -cargo: string
    }

    
    class Produto {
        -nome: string
        -preco: int
        -estoque: int
    }

    class Instrumento {
        -marca: string
        -modelo: string
    }

    class Cordas {
        -numeroCordas: int
    }

    
    Cliente <|-- Usuario
    Funcionario <|-- Usuario
    Instrumento <|-- Produto
    Cordas <|-- Instrumento
