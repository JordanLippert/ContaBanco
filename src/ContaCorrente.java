import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {

    private boolean especial;
    private double limite;
    private int numero;
    private double saldo;
    private List<Movimentacao> movimentacoes;

    public ContaCorrente(double saldoInicial){
        this.numero = numero;
        this.saldo = saldoInicial;
        this.especial = false;
        this.movimentacoes = new ArrayList<>();
    }

    public ContaCorrente(double saldoInicial, double limite){
        this.numero = numero;
        this.saldo = saldoInicial;
        this.limite = limite;
        this.especial = true;
        this.movimentacoes = new ArrayList<>();
    }

    private void criarMovimentacao(String descricao, char tipo, double valor){
        Movimentacao movimentacao = new Movimentacao(descricao, tipo, valor);
        this.movimentacoes.add(movimentacao);
        movimentacao.getMovimentacao();
    }

    protected boolean depositar(double valor){
        if (valor > 0){
            this.saldo += valor;

            criarMovimentacao("Depósito", 'D', valor);
            return true;
        }
        else{
            System.out.print("Não foi possível realizar o depósito! ");
            return false;
        }
    }

    protected String emitirExtrato(){
        StringBuilder extrato = new StringBuilder();
        extrato.append("Extrato da Conta Corrente: \n");
        extrato.append("Número da Conta: ").append(this.numero).append("\n");
        extrato.append("Saldo Atual: ").append(this.saldo).append("\n");

        extrato.append("Movimentações: ");
        for (Movimentacao movimentacao: this.movimentacoes){
            extrato.append(movimentacao.toString()).append("\n");
        }
        return extrato.toString();
    }

    public int getNumeroConta(){
        return this.numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    protected boolean sacar(double valor){
        if (valor > 0){
            if (this.saldo >= valor){
            this.saldo -= valor;

            criarMovimentacao("Saque", 'S', valor);
            return true;
            }
            else {
                System.out.print("Saldo insuficiente para realizar o saque! ");
                return false;
            }
        }
        else {
            System.out.print("Valor de saque não é válido! ");
            return false;
        }
    }
}
