classDiagram
  class Pessoa {
    - nome: string
    - idade: int
    + cumprimentar(): void
  }

  class Aluno {
    - matricula: string
    + assistirAula(): void
  }

  class Professor {
    - salario: float
    + darAula(): void
  }

  Pessoa <|-- Aluno
  Pessoa <|-- Professor
