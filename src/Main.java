import exceptions.ControleFinanceiroException;
import exceptions.ValorInvalidoException;
import model.TipoTransacao;
import service.ControleFinanceiro;

import java.util.InputMismatchException;
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
                    System.out.print("Descrição: ");
                    descricao = input.nextLine();

                    while (true) {
                        System.out.print("Valor: ");

                        try {
                            valor = input.nextDouble();

                            controleFinanceiro.adicionarTransacao(descricao, valor, TipoTransacao.RECEITA);

                            System.out.println("Transação realizada!");
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Erro: Entrada inválida! Digite apenas números.");
                        } catch (ControleFinanceiroException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            input.nextLine();
                        }

                    }

                    break;

                case 2:
                    System.out.print("Descrição: ");
                    descricao = input.nextLine();

                    while (true) {
                        System.out.print("Valor: ");

                        try {
                            valor = input.nextDouble();

                            controleFinanceiro.adicionarTransacao(descricao, valor, TipoTransacao.DESPESA);

                            System.out.println("Transação realizada!");
                            break;

                        } catch (InputMismatchException e) {
                            System.out.println("Erro: Entrada inválida! Digite apenas números.");
                        } catch (ControleFinanceiroException e) {
                            System.out.println(e.getMessage());
                        } finally {
                            input.nextLine();
                        }

                    }
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
}