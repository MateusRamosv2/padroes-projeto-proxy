package proxy;

import java.util.Arrays;
import java.util.List;

public class RelatorioFinanceiroReal implements IRelatorioFinanceiro {

    private String dataFechamento;
    private String statusCaixa;
    private Double totalCartao;
    private Double totalDinheiro;


    public RelatorioFinanceiroReal(String dataFechamento, String statusCaixa, Double totalCartao, Double totalDinheiro) {
        this.dataFechamento = dataFechamento;
        this.statusCaixa = statusCaixa;
        this.totalCartao = totalCartao;
        this.totalDinheiro = totalDinheiro;
    }


    public RelatorioFinanceiroReal(String dataFechamento) {
        this.dataFechamento = dataFechamento;
        RelatorioFinanceiroReal objetoBd = BDRestaurante.getRelatorio(dataFechamento);
        this.statusCaixa = objetoBd.statusCaixa;
        this.totalCartao = objetoBd.totalCartao;
        this.totalDinheiro = objetoBd.totalDinheiro;
    }

    @Override
    public List<String> obterResumoDiario() {
        return Arrays.asList("Data: " + this.dataFechamento, "Status: " + this.statusCaixa);
    }

    @Override
    public List<Double> obterFaturamentoDetalhado(Usuario usuarioLogado) {
        return Arrays.asList(this.totalCartao, this.totalDinheiro);
    }
}