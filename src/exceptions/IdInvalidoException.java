package exceptions;

public class IdInvalidoException extends ControleFinanceiroException {
    private int id;

    public IdInvalidoException(int id) {
        super("ID não pode ser nulo ou negativo! " + "ID informado: " + id);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
