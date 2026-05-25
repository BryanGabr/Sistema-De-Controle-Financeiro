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

    private void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    private void setValor(double valor) {
        this.valor = valor;
    }

    public void atualizarDescricao(String descricao) {
        this.setDescricao(descricao);
    }

    public void atualizarValor(double valor){
        this.setValor(valor);
    }

    public void atualizarTipo(TipoTransacao tipoTransacao){
        this.setTipo(tipoTransacao);
    }

    @Override
    public String toString() {
        return "[" + id +"] " + descricao + " - R$ " + valor + " (" + tipo + ")";
    }

}
