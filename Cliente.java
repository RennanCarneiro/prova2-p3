public class Cliente{
    private String nome;
    private int idade;
    private String cpf;
    private String endereco;
    private boolean bomCliente;
    private Item[] carrinhoDeCompras = new Item[100];
    private int totalItemsNoCarrinho = 0;
   
    public Cliente(String nome, int idade, String cpf, String endereco, boolean bomCliente, Item[] carrinhoDeCompras,
            int totalItemsNoCarrinho) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.bomCliente = bomCliente;
        this.carrinhoDeCompras = carrinhoDeCompras;
        this.totalItemsNoCarrinho = totalItemsNoCarrinho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isBomCliente() {
        return bomCliente;
    }

    public void setBomCliente(boolean bomCliente) {
        this.bomCliente = bomCliente;
    }

    public Item[] getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }

    public void setCarrinhoDeCompras(Item[] carrinhoDeCompras) {
        this.carrinhoDeCompras = carrinhoDeCompras;
    }

    public int getTotalItemsNoCarrinho() {
        return totalItemsNoCarrinho;
    }

    public void setTotalItemsNoCarrinho(int totalItemsNoCarrinho) {
        this.totalItemsNoCarrinho = totalItemsNoCarrinho;
    }

    public void adicionar(Item item) {
        if (totalItemsNoCarrinho < 100) {
            carrinhoDeCompras[totalItemsNoCarrinho] = item;
            totalItemsNoCarrinho++;
        }
    }

    public void cancelar(int codigoProduto) {
        for (int i = 0; i < totalItemsNoCarrinho; i++) {
            if (carrinhoDeCompras[i].getCodigo() == codigoProduto) {
                for (int j = i; j < totalItemsNoCarrinho - 1; j++) {
                    carrinhoDeCompras[j] = carrinhoDeCompras[j + 1];
                }
                totalItemsNoCarrinho--;
            }
        }
    }
    public double finalizarCompra() {
        double totalCompra = 0;
        for (int i = 0; i < totalItemsNoCarrinho; i++) {
            totalCompra += carrinhoDeCompras[i].getValor();
            carrinhoDeCompras[i].setQuantidadeEmEstoque(1);
           // carrinhoDeCompras[i].quantidadeEmEstoque--;
        }
        totalItemsNoCarrinho = 0;
        return totalCompra;
    }   
}