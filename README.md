# Padrões de Projeto - Proxy

---

## Estrutura do Projeto

- **Interface Base (Subject):** `IRelatorioFinanceiro` → Define o contrato comum que tanto o Objeto Real quanto o Proxy devem implementar. Isso garante que o Proxy possa ser passado para qualquer cliente que espere o objeto real.
- **Entidade de Validação:** `Usuario` → Classe que representa o usuário logado no sistema (ex: Garçom ou Gerente) e carrega as suas permissões de acesso.
- **Banco de Dados (Simulado):** `BDRestaurante` → Atua como o repositório de dados, guardando os relatórios fechados do sistema.
- **Objeto Real (Real Subject):** `RelatorioFinanceiroReal` → A classe que contém a verdadeira lógica de negócios e faz a carga pesada dos dados a partir do banco de dados. Os dados que ela manipula são sensíveis (faturamento detalhado).
- **O Interceptador (Proxy):** `RelatorioFinanceiroProxy` → Controla o acesso ao Objeto Real. Neste projeto, ele atua como um **Proxy de Segurança (Protection Proxy)**, barrando usuários sem privilégios de gerente de acessarem os dados de faturamento. Além disso, atua como um **Virtual Proxy**,(só instanciando o objeto real de banco de dados se a validação de segurança passar ou se os dados forem de fato requisitados).
- **Testes:** `RelatorioFinanceiroProxyTest` → Valida, através do JUnit, se as barreiras de segurança estão funcionando, garantindo que exceções (`IllegalArgumentException`) sejam lançadas adequadamente quando um funcionário sem permissão tenta acessar o faturamento, enquanto permite o acesso livre aos resumos diários básicos.

---

## Diagrama de Classes

Abaixo está o diagrama de classes representando a estrutura da implementação. O foco arquitetural deste diagrama é demonstrar como o `RelatorioFinanceiroProxy` se coloca entre o cliente e o `RelatorioFinanceiroReal`, implementando a mesma interface, mas exigindo a passagem e a validação do `Usuario` antes de delegar a chamada real.

<img width="656" height="607" alt="Diagrama - Proxy" src="https://github.com/user-attachments/assets/8cd96512-1183-4484-bd52-663cb9ae7139" />
