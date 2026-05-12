//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ControleFinanceiro controleFinanceiro = new ControleFinanceiro();

        //controleFinanceiro.adicionarTransacao("Alomoço", 18, TipoTransacao.DESPESA);
        //controleFinanceiro.adicionarTransacao("Salario", 1467.45, TipoTransacao.RECEITA);

        controleFinanceiro.listarTransacoes();
    }
}