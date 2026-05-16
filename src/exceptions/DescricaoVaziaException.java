package exceptions;

public class DescricaoVaziaException extends ControleFinanceiroException {
    private String descricao;

    public DescricaoVaziaException(String descricao) {
        super("Descrição não foi informada! ");
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
