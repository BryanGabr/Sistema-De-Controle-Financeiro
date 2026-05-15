package model;

public class Transacao {
    private int id;
    private String descricao;
    private double valor;
    private TipoTransacao tipo;

    public Transacao(int id, String descricao, double valor, TipoTransacao tipo) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[" + id +"] " + descricao + " - R$ " + valor + " (" + tipo + ")";
    }

}
