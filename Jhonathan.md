```mermaid
classDiagram
    class Pedido {
        -id : int
        -data : Date
        -status : string
        +atualizarStatus(status: string) : void
    }
