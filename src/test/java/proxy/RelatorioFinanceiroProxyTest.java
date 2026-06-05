package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioFinanceiroProxyTest {

    @BeforeEach
    void setUp() {

        BDRestaurante.addRelatorio("2026-06-04", new RelatorioFinanceiroReal("2026-06-04", "CAIXA BATIDO", 1500.50, 450.00));
    }

    @Test
    void devePermitirQueQualquerUmVejaOResumoDiario() {
        RelatorioFinanceiroProxy proxy = new RelatorioFinanceiroProxy("2026-06-04");


        assertEquals(Arrays.asList("Data: 2026-06-04", "Status: Caixa verificado"), proxy.obterResumoDiario());
    }


    @Test
    void devePermitirQueGerenteVejaOFaturamento() {
        Usuario gerente = new Usuario("Marco Antônio (Dono)", true);
        RelatorioFinanceiroProxy proxy = new RelatorioFinanceiroProxy("2026-06-04");

        assertEquals(Arrays.asList(1500.50, 450.00), proxy.obterFaturamentoDetalhado(gerente));
    }

    @Test
    void deveLancarExcecaoAoTentarVerFaturamentoSendoFuncionarioComum() {
        Usuario garcom = new Usuario("Tony Stark (Garçom)", false);
        RelatorioFinanceiroProxy proxy = new RelatorioFinanceiroProxy("2026-06-04");

        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            proxy.obterFaturamentoDetalhado(garcom);
        });

        assertEquals("Acesso Negado: Apenas gerentes podem visualizar o faturamento.", excecao.getMessage());
    }

}