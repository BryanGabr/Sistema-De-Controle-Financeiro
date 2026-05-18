import exceptions.ControleFinanceiroException;

import model.TipoTransacao;
import service.ControleFinanceiro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int opcao = 0;

        ControleFinanceiro controleFinanceiro = new ControleFinanceiro();

        do {
            System.out.println("1 - Adicionar receita");
            System.out.println("2 - Adicionar despesa");
            System.out.println("3 - Listar");
            System.out.println("4 - Saldo");
            System.out.println("5 - Remover");
            System.out.println("0 - Sair");

            while (true) {
                System.out.print("Opcão: ");

                try {
                    opcao = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida! Digite apenas números.");
                } finally {
                    input.nextLine();
                }
            }

            switch (opcao){

                case 1:

                    adicionarTransacao(controleFinanceiro, lerDescricao(input), lerValor(input), TipoTransacao.RECEITA);

                    break;

                case 2:

                    adicionarTransacao(controleFinanceiro, lerDescricao(input), lerValor(input), TipoTransacao.DESPESA);

                    break;

                case 3:
                    controleFinanceiro.listarTransacoes();
                    break;

                case 4:
                    System.out.print("Saldo: R$ " + controleFinanceiro.calcularSaldo());

                    break;

                case 5:

                    while (true) {

                        System.out.print("ID: ");

                        try {
                            int id = input.nextInt();

                            controleFinanceiro.removerTransacao(id);

                            break;

                        } catch (ControleFinanceiroException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: Entrada inválida! Digite apenas números.");
                        } finally {
                            input.nextLine();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado!");

                    break;

                default:
                    System.out.println("Opcão inválida! ");
            }
        } while (opcao != 0);
    }

    private static void adicionarTransacao(ControleFinanceiro controleFinanceiro, String descricao, double valor, TipoTransacao tipo){
        try {
            controleFinanceiro.adicionarTransacao(descricao, valor, tipo);
        } catch (ControleFinanceiroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String lerDescricao(Scanner input){

        String descricao = "";

        while (true) {
            System.out.print("Descrição: ");

            descricao = input.nextLine();

            if (descricao.trim().isEmpty()) {
                System.out.println("Descrição não foi informada! ");
                continue;
            }

            break;
        }

        return descricao;
    }

    private static double lerValor(Scanner input) {

        double valor = 0;

        while (true) {
            System.out.print("Valor: ");

            try {
                valor = input.nextDouble();

                if (valor <=  0) {
                    System.out.println("Valor não pode ser nulo ou negativo! Valor informado: R$ " + valor);
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Digite apenas números.");
            } finally {
                input.nextLine();
            }
        }

        return valor;
    }
}