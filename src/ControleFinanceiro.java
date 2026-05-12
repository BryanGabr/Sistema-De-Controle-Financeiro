import java.util.HashMap;
import java.util.Map;

public class ControleFinanceiro {
    private Map<Integer, Transacao> transacaoMap;
    private int atualId;

    public ControleFinanceiro() {
        this.transacaoMap = new HashMap<>();
        this.atualId = 0;
    }

    public void adicionarTransacao(String descricao, double valor, TipoTransacao tipo){
        this.atualId++;

        Transacao transacao = new Transacao(atualId, descricao, valor, tipo);
        this.transacaoMap.put(atualId, transacao);
    }

    public void listarTransacoes(){
        if (!this.transacaoMap.isEmpty()) {
            System.out.println(this.transacaoMap);
        } else {
            System.out.println("Lista vazia!");
        }

    }
}
