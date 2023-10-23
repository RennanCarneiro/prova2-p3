public class ClienteEspecial extends Cliente {
    private int pontos;
    private double saldoDeCompras;
    public ClienteEspecial(String nome, int idade, String cpf, String endereco, boolean bomCliente,
            Item[] carrinhoDeCompras, int totalItemsNoCarrinho, int pontos, double saldoDeCompras) {
        super(nome, idade, cpf, endereco, bomCliente, carrinhoDeCompras, totalItemsNoCarrinho);
        this.pontos = pontos;
        this.saldoDeCompras = saldoDeCompras;
    }
    public int getPontos() {
        return pontos;
    }
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    public double getSaldoDeCompras() {
        return saldoDeCompras;
    }
    public void setSaldoDeCompras(double saldoDeCompras) {
        this.saldoDeCompras = saldoDeCompras;
    }
    @Override
    public double finalizarCompra() {
        double totalCompra = super.finalizarCompra();
        double desconto = totalCompra * 0.05;

        if (saldoDeCompras > 100) {
            pontos += 5;
            saldoDeCompras -= 100;
        }

        if (pontos > 0) {
            int pontosNecessarios = (int) (totalCompra / 2); // 
            if (pontos >= pontosNecessarios) {
                pontos -= pontosNecessarios;
                return 0; // Compra feita com pontos, sem custo
            }
        }

        saldoDeCompras += desconto;
        return totalCompra - desconto;
    }
}
