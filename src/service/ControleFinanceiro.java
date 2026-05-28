package service;

import exceptions.ControleFinanceiroException;
import exceptions.DescricaoVaziaException;
import exceptions.IdInvalidoException;
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

    public void adicionarTransacao(String descricao, double valor, TipoTransacao tipoTransacao) throws ControleFinanceiroException {
        if (descricao.trim().isEmpty()) throw new DescricaoVaziaException(descricao);

        if (valor <= 0) throw new ValorInvalidoException(valor);

        this.atualId++;

        Transacao transacao = new Transacao(atualId, descricao, valor, tipoTransacao);
        transacaoMap.put(atualId, transacao);
    }

    public void removerTransacao(int id) throws ControleFinanceiroException{

        if (id <= 0) throw new IdInvalidoException(id);

        if (this.transacaoMap.containsKey(id)){
            this.transacaoMap.remove(id);
        } else {
            System.out.println("Transação não encontrada!");
        }
    }

    public void listarTransacoes(){
        if (!this.transacaoMap.isEmpty()) {
            for (Map.Entry<Integer, Transacao> entry: this.transacaoMap.entrySet()){
                System.out.println(entry.getValue());;
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

    public Transacao buscarTransacao(int id) throws ControleFinanceiroException{
        if (id <= 0) throw new IdInvalidoException(id);

        Transacao transacao = this.transacaoMap.get(id);

        if (transacao == null){
            System.out.println("Transação não encontrada.");
            return null;
        }

        return transacao;
    }

    public void alterarDescricao(int id, String descricao) throws ControleFinanceiroException{
        if (descricao.trim().isEmpty()) throw new DescricaoVaziaException(descricao);

        Transacao transacao = buscarTransacao(id);

        if (transacao == null) return;

        transacao.atualizarDescricao(descricao);
    }

    public void alterarValor(int id, double valor) throws ControleFinanceiroException {

        if (valor <= 0) throw new ValorInvalidoException(valor);

        Transacao transacao = buscarTransacao(id);

        if (transacao == null) return;

        transacao.atualizarValor(valor);
    }

    public void alterarTipo(int id) throws ControleFinanceiroException{

        Transacao transacao = buscarTransacao(id);

        if (transacao == null) return;

        if (transacao.getTipo() == TipoTransacao.RECEITA){
            transacao.atualizarTipo(TipoTransacao.DESPESA);
        } else {
            transacao.atualizarTipo(TipoTransacao.RECEITA);
        }

    }

    public void listarReceita(){
        boolean receitaEncontrada = false;

        for (Map.Entry<Integer, Transacao> entry : this.transacaoMap.entrySet()){
            if (entry.getValue().getTipo() == TipoTransacao.RECEITA){
                System.out.println(entry.getValue());
                receitaEncontrada = true;
            }
        }

        if (!receitaEncontrada){
            System.out.println("Nenhuma receita cadastrada.");
        }
    }

    public void listarDespesa(){
        boolean despesaEncontrada = false;

        for (Map.Entry<Integer, Transacao> entry : this.transacaoMap.entrySet()){
            if (entry.getValue().getTipo() == TipoTransacao.RECEITA){
                System.out.println(entry.getValue());
                despesaEncontrada = true;
            }
        }

        if (!despesaEncontrada){
            System.out.println("Nenhuma receita cadastrada.");
        }
    }


}
