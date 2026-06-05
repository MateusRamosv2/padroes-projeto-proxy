package proxy;

import java.util.HashMap;
import java.util.Map;

public class BDRestaurante {
    private static Map<String, RelatorioFinanceiroReal> relatorios = new HashMap<>();

    public static RelatorioFinanceiroReal getRelatorio(String data) {
        return relatorios.get(data);
    }

    public static void addRelatorio(String data, RelatorioFinanceiroReal relatorio) {
        relatorios.put(data, relatorio);
    }
}