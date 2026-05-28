import exceptions.ControleFinanceiroException;

import model.TipoTransacao;
import service.ControleFinanceiro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ControleFinanceiro controleFinanceiro = new ControleFinanceiro();

        int opcao;

        do {

            opcao = menu(input);

            switch (opcao) {

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

                    removerTransacao(controleFinanceiro, lerID(input));

                    break;

                case 6:
                    int opcaoEdicao;

                    int id = lerID(input);

                    do {

                        opcaoEdicao = menuEditarTransacao(input);

                        switch (opcaoEdicao) {

                            case 1:
                                editarDescricao(controleFinanceiro, id, lerDescricao(input));

                                break;
                            case 2:
                                editarValor(controleFinanceiro, id, lerValor(input));

                                break;
                            case 3:
                                alterarTipo(controleFinanceiro, id);

                                break;
                            case 0:
                                System.out.println("Editar transação fechado.");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opcaoEdicao != 0);

                    break;

                case 7:
                    buscarTransacao(controleFinanceiro, lerID(input));

                    break;
                case 0:
                    System.out.println("Programa finalizado!");

                    break;

                default:
                    System.out.println("Opcão inválida! ");
            }
        } while (opcao != 0);
    }

    private static int menu(Scanner input) {
        System.out.println("1 - Adicionar receita");
        System.out.println("2 - Adicionar despesa");
        System.out.println("3 - Listar");
        System.out.println("4 - Saldo");
        System.out.println("5 - Remover");
        System.out.println("6 - Editar transação");
        System.out.println("7 - Buscar transação");
        System.out.println("0 - Sair");

        return lerOpcao(input);
    }

    private static int lerOpcao(Scanner input) {
        int opcao;

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

        return opcao;
    }

    private static void adicionarTransacao(ControleFinanceiro controleFinanceiro, String descricao, double valor, TipoTransacao tipo) {
        try {
            controleFinanceiro.adicionarTransacao(descricao, valor, tipo);
            System.out.println("Transação adicionada.");
        } catch (ControleFinanceiroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerTransacao(ControleFinanceiro controleFinanceiro, int id) {
        try {
            controleFinanceiro.removerTransacao(id);
            System.out.println("Transação removida.");
        } catch (ControleFinanceiroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String lerDescricao(Scanner input) {

        String descricao;

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

        double valor;

        while (true) {
            System.out.print("Valor: ");

            try {
                valor = input.nextDouble();

                if (valor <= 0) {
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

    private static int lerID(Scanner input) {
        int id;

        while (true) {

            System.out.print("ID: ");

            try {
                id = input.nextInt();

                if (id <= 0) {
                    System.out.println("ID não pode ser nulo ou negativo! " + "ID informado: " + id);
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida! Digite apenas números.");
            } finally {
                input.nextLine();
            }
        }

        return id;
    }

    private static int menuEditarTransacao(Scanner input){
        System.out.println("1 - Editar descrição");
        System.out.println("2 - Editar Valor");
        System.out.println("3 - Editar tipo transação");
        System.out.println("0 - Sair");

        return lerOpcao(input);
    }

    private static void editarDescricao(ControleFinanceiro controleFinanceiro, int id, String descricao){
        try {
            controleFinanceiro.alterarDescricao(id, descricao);
            System.out.println("Descrição alterada.");
        } catch (ControleFinanceiroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void editarValor(ControleFinanceiro controleFinanceiro, int id, double valor){
        try {
            controleFinanceiro.alterarValor(id, valor);
            System.out.println("Valor alterado");
        } catch (ControleFinanceiroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void alterarTipo(ControleFinanceiro controleFinanceiro, int id){
        try {
            controleFinanceiro.alterarTipo(id);
            System.out.println("Tipo de transação alterado");
        } catch (ControleFinanceiroException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarTransacao(ControleFinanceiro controleFinanceiro, int id){
        try {
            System.out.println(controleFinanceiro.buscarTransacao(id));
        } catch (ControleFinanceiroException e) {
            System.out.println(e.getMessage());
        }
    }
}