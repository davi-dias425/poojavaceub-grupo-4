```mermaid
classDiagram
class Venda {
  -id: int
  -cliente: Cliente
  -data: Date
  +gerarNotaFiscal(): string
  +getTotalVenda(): float
}























