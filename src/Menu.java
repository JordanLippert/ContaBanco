import java.util.Scanner;
public class Menu {

    private Banco banco;
    private Scanner scanner;

    public Menu(Banco banco){
        this.banco = banco;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu(){
        int opcao;
        while (true){
            System.out.println("\nBem Vindo ao " + banco.getNome() + "\n\tAgência: " + banco.getNumero());
            System.out.println("O seu Banco Universitário!\n O que você deseja \n");
            System.out.println("1. Criar Conta");
            System.out.println("2. Criar Conta Especial");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Emitir Extrato");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    criarConta();
                    break;

                case 2:
                    criarContaESP();
                    break;

                case 3:
                    depositar();
                    break;

                case 4:
                    sacar();
                    break;

                case 5:
                    transferir();
                    break;

                case 6:
                    emitirExtrato();
                    break;

                case 7:
                    System.out.println("Até mais...");
                    scanner.close();
                    return;

                default:
                    System.out.println("OPÇÃO INVÁLIDA! Tente novamente.");
            }
        }
    }

    private void criarConta(){
        System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();
        banco.criarConta(saldoInicial);
        System.out.println("Conta criada com Sucesso!");
    }

    private void criarContaESP(){
        System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();
        System.out.print("Digite o limite da conta: ");
        double limite = scanner.nextDouble();
        banco.criarContaESP(saldoInicial,limite);
        System.out.println("Conta criada com Sucesso!");
    }

    private void depositar(){
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Digite o valor a depositar: ");
        double valor = scanner.nextDouble();
        banco.depositar(numeroConta, valor);
    }

    private void sacar(){
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Digite o valor a sacar:");
        double valor = scanner.nextDouble();
        banco.sacar(numeroConta, valor);
    }

    private void transferir() {
        System.out.print("Digite o número da conta de origem: ");
        int contaOrigem = scanner.nextInt();
        System.out.print("Digite o número da conta de destino: ");
        int contaDestino = scanner.nextInt();
        System.out.print("Digite o valor a transferir: ");
        double valor = scanner.nextDouble();
        banco.transferir(contaOrigem, contaDestino, valor);
    }

    private void emitirExtrato(){
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        String extrato = banco.emitirExtrato(numeroConta);
        System.out.println(extrato);
    }
}
