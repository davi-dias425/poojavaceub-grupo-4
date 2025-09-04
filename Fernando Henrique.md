classDiagram
direction TB
    class Produto {
	    -nome: string
	    -descricao: string
	    -preco: float
	    -estoque: int
	    -marca: string
	    -modelo: string
    }

    class Instrumento {
    }

    class Metais {
	    -tipoPistao: string
    }

    class Percussao {
	    -tipo: string
    }

    class Acessorio {
	    -tipoAcessorio: string
    }

    class Usuario {
	    -nome: string
	    -email: string
	    -senha: string
    }

    class Cliente {
	    -cpf: string
	    -endereco: string
    }

    class Funcionario {
	    -matricula: string
	    -cargo: string
    }

    class Cordas {
	    -numeroCordas: int
        -tipodeCorda: string
    }

    Instrumento <|-- Produto
    Acessorio <|-- Produto
    Cordas <|-- Instrumento
    Metais <|-- Instrumento
    Percussao <|-- Instrumento
    Cliente <|-- Usuario
    Funcionario <|-- Usuario

