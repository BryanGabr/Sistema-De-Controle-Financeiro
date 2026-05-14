package service;

import exceptions.ControleFinanceiroException;
import exceptions.ValorInvalidoException;
import model.TipoTransacao;
import model.Transacao;

import java.util.HashMap;
import java.util.Map;

public class ControleFinanceiro {
    private Map<Integer, Transacao> transacaoMap;
    private int atualId;

    public ControleFinanceiro() {
        this.transacaoMap = new HashMap<>();
        this.atualId = 0;
    }

    public void adicionarTransacao(String descricao, double valor, TipoTransacao tipo) throws ControleFinanceiroException {
        this.atualId++;

        if (valor <= 0) throw new ValorInvalidoException("Valor não pode ser nulo ou negativo!", valor);

        Transacao transacao = new Transacao(atualId, descricao, valor, tipo);
        this.transacaoMap.put(atualId, transacao);
    }

    public void removerTransacao(int id){
        if (this.transacaoMap.containsKey(id)){
            this.transacaoMap.remove(id);
        } else {
            System.out.println("Transação não encontrada!");
        }
    }

    public void listarTransacoes(){
        if (!this.transacaoMap.isEmpty()) {
            for (Map.Entry<Integer, Transacao> entry: this.transacaoMap.entrySet()){
                System.out.println("ID: " + entry.getKey() + " | " + entry.getValue().getDescricao() + " | R$ " + entry.getValue().getValor() + " | " + entry.getValue().getTipo());
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public double calcularSaldo(){
        double receitas = 0;
        double despesas = 0;

        if(!this.transacaoMap.isEmpty()){
            for (Map.Entry<Integer, Transacao> entry : this.transacaoMap.entrySet()){
                if (entry.getValue().getTipo() == TipoTransacao.RECEITA) {
                    receitas += entry.getValue().getValor();
                } else if (entry.getValue().getTipo() == TipoTransacao.DESPESA){
                    despesas += entry.getValue().getValor();
                }
            }
        }
        return receitas - despesas;
    }

}
