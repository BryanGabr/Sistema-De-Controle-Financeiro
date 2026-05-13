import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao = 0;

        String descricao = "";
        double valor = 0;

        ControleFinanceiro controleFinanceiro = new ControleFinanceiro();

        do {
            System.out.println("1 - Adicionar receita");
            System.out.println("2 - Adicionar despesa");
            System.out.println("3 - Listar");
            System.out.println("4 - Saldo");
            System.out.println("5 - Remover");
            System.out.println("0 - Sair");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao){

                case 1:
                    System.out.print("Descrição: ");
                    descricao = input.nextLine();

                    System.out.print("Valor: ");
                    valor = input.nextDouble();
                    input.nextLine();

                    controleFinanceiro.adicionarTransacao(descricao, valor, TipoTransacao.RECEITA);
                    break;

                case 2:
                    System.out.print("Descrição: ");
                    descricao = input.nextLine();

                    System.out.print("Valor: ");
                    valor = input.nextDouble();
                    input.nextLine();

                    controleFinanceiro.adicionarTransacao(descricao, valor, TipoTransacao.DESPESA);
                    break;

                case 3:
                    controleFinanceiro.listarTransacoes();
                    break;

                case 4:
                    System.out.print("Saldo: R$ " + controleFinanceiro.calcularSaldo());

                    break;

                case 5:
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    controleFinanceiro.removerTransacao(id);

                    break;

                case 0:
                    System.out.println("Programa finalizado!");

                    break;

                default:
                    System.out.println("Opcão inválida! ");
            }
        } while (opcao != 0);
    }
}