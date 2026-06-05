package proxy;

import java.util.List;

public interface IRelatorioFinanceiro {
    List<String> obterResumoDiario();
    List<Double> obterFaturamentoDetalhado(Usuario usuarioLogado);
}