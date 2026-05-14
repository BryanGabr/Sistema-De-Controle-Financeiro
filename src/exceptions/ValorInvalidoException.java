package exceptions;

public class ValorInvalidoException extends ControleFinanceiroException {
   private double valor;

  public ValorInvalidoException(String message, double valor) {
    super(message + "Valor informado: R$ " + valor);
    this.valor = valor;
  }

    public double getValor() {
        return valor;
    }
}
