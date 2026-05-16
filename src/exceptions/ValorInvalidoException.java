package exceptions;

public class ValorInvalidoException extends ControleFinanceiroException {
   private double valor;

  public ValorInvalidoException(double valor) {
    super("Valor não pode ser nulo ou negativo! " + "Valor informado: R$ " + valor);
    this.valor = valor;
  }

    public double getValor() {
        return valor;
    }

}
