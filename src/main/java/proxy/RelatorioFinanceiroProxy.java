package proxy;

import java.util.List;

public class RelatorioFinanceiroProxy implements IRelatorioFinanceiro {

    private RelatorioFinanceiroReal relatorioReal;
    private String dataDesejada;

    public RelatorioFinanceiroProxy(String dataDesejada) {
        this.dataDesejada = dataDesejada;
    }

    @Override
    public List<String> obterResumoDiario() {

        if (this.relatorioReal == null) {
            this.relatorioReal = new RelatorioFinanceiroReal(this.dataDesejada);
        }
        return this.relatorioReal.obterResumoDiario();
    }

    @Override
    public List<Double> obterFaturamentoDetalhado(Usuario usuarioLogado) {

        if (!usuarioLogado.isGerente()) {
            throw new IllegalArgumentException("Acesso Negado: Apenas gerentes podem visualizar o faturamento.");
        }


        if (this.relatorioReal == null) {
            this.relatorioReal = new RelatorioFinanceiroReal(this.dataDesejada);
        }
        return this.relatorioReal.obterFaturamentoDetalhado(usuarioLogado);
    }
}