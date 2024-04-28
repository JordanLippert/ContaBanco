import java.util.Scanner;

public class Banco {

    private String nome = "BankVali";
    private int numero = 1964;
    private final static int MAX_CONTAS = 5;
    private int numContas;
    private ContaCorrente [] contas;

    public Banco(){
        this.nome = nome;
        this.numero = numero;
        this.contas = new ContaCorrente[MAX_CONTAS];
    }

    public String getNome(){
        return nome;
    }

    public int getNumero(){
        return numero;
    }

    public void criarConta(double saldoInicial){
        ContaCorrente novaConta = new ContaCorrente(saldoInicial);
        if (numContas < this.contas.length){
            this.contas[numContas] = novaConta;
            numContas++;
        }
        else {
            throw new RuntimeException("Limite de contas atingido! ");
        }
    }

    public void criarContaESP(double saldoInicial, double limite){
        ContaCorrente novaContaESP = new ContaCorrente(saldoInicial, limite);
        if (numContas < this.contas.length){
            this.contas[numContas] = novaContaESP;
            numContas++;
        }
        else {
            throw new RuntimeException("Limite de contas atingido! ");
        }
    }

    public void depositar(int conta, double valor){
        if (conta >= 0 && conta < numContas){
            ContaCorrente contaCorrente = contas[conta];
            System.out.print("Digite novamente o valor do depósito: ");
            Scanner scanner = new Scanner(System.in);
            valor = scanner.nextDouble();

            if (valor > 0){
                contaCorrente.depositar(valor);
                System.out.print("Depósito de: R$" + valor + " realizado com sucesso!");
            }
            else {
                System.out.print("Valor de depósito Inválido! ");
            }
            scanner.close();
        }
        else {
            System.out.print("Número de conta Inválido! ");
        }

    }

    public String emitirExtrato(int conta){
        if (conta >= 0 && conta < numContas){
            ContaCorrente contaCorrente = contas[conta];
            String extrato = "Extrato da Conta: \n";
            extrato += "Número da Conta: " + contaCorrente.getNumeroConta() + "\n";
            extrato += "Saldo: " + contaCorrente.emitirExtrato();
            return extrato;
        }
        else {
            System.out.print("Número de conta Inválido! ");
        }
        return " ";
    }

    private ContaCorrente localizarConta(int conta){
        if (conta >= 0 && conta < numContas){
            return contas[conta];
        }
        else {
            return null;
        }
    }

    public void sacar(int conta, double valor){
        if (conta >= 0 && conta < numContas){
            ContaCorrente contaCorrente = contas[conta];

            if (contaCorrente.getSaldo() >= valor){
                System.out.print("Digite novamente o valor de saque: ");
                Scanner scanner = new Scanner(System.in);
                valor = scanner.nextDouble();
                contaCorrente.sacar(valor);
                System.out.print("Saque de R$" + valor + " realizado com sucesso!");
            }
            else {
                System.out.print("Saldo insuficiente para realizar saque! ");
            }
        }
        else {
            System.out.print("Número de conta Inválido! ");
        }
    }

    public void transferir(int contaOrigem, int contaDestino, double valor){
        if (contaOrigem >= 0 && contaOrigem < numContas && contaDestino >= 0 && contaDestino < numContas){
            ContaCorrente origem = contas[contaOrigem];
            ContaCorrente destino = contas[contaDestino];

            if (origem.getSaldo() >= valor){
                System.out.print("Digite novamente o valor de transferência: ");
                Scanner scanner = new Scanner(System.in);
                valor = scanner.nextDouble();
                origem.sacar(valor);
                destino.depositar(valor);
                System.out.print("Transferência de R$" + valor + " realizada com sucesso da conta: " + contaOrigem + " para a conta: " + contaDestino);
            }
            else {
                System.out.print("Saldo Insuficiente na conta origem para realizar a transferência! ");
            }
        }
        else {
            System.out.print("Número de conta Inválido! ");
        }
    }
}