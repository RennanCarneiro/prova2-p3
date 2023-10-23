import java.util.Scanner;
public class Funcionario extends ClienteEspecial {
    private String setor;
    private int id;
    private double salario;
    Scanner sc = new Scanner(System.in);
    public Funcionario(String nome, int idade, String cpf, String endereco, boolean bomCliente,
            Item[] carrinhoDeCompras, int totalItemsNoCarrinho, int pontos, double saldoDeCompras, String setor, int id,
            double salario) {
        super(nome, idade, cpf, endereco, bomCliente, carrinhoDeCompras, totalItemsNoCarrinho, pontos, saldoDeCompras);
        this.setor = setor;
        this.id = id;
        this.salario = salario;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void renovarEstoque(Item item) {
        int quantidade = sc.nextInt();
    
        item.setQuantidadeEmEstoque(item.getQuantidadeEmEstoque()+quantidade);
        // quantidadeEstoque += quantidade
    }

    public void bloquearItem(Item item) {   
    if (item.isDisponibilidade() == true){
        item.setDisponibilidade(false);
    }else item.setDisponibilidade(true);
    }
}

