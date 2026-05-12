public class Main {
    public static void main(String[] args) {

        ControleFinanceiro controleFinanceiro = new ControleFinanceiro();

        controleFinanceiro.adicionarTransacao("Alomoço", 18, TipoTransacao.DESPESA);
        controleFinanceiro.adicionarTransacao("Salario", 1467.45, TipoTransacao.RECEITA);

        controleFinanceiro.listarTransacoes();
        //controleFinanceiro.removerTransacao(1);
        //controleFinanceiro.listarTransacoes();

        System.out.println(controleFinanceiro.calcularSaldo());
    }
}