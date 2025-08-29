```mermaid
classDiagram
  class Pessoa {
    - nome: string
    - idade: int
    + cumprimentar(): void
  }



classDiagram
  class Pessoa {
    - nome: string
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




