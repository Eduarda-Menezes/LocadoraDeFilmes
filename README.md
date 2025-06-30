# 📽️ Sistema de Locadora de Filmes

Sistema de gerenciamento completo para locadoras de filmes, com funcionalidades de cadastro, controle de estoque, locações, devoluções, relatórios e análise de clientes.

---

## ✅ Funcionalidades do Sistema

### 1. Cadastro de Clientes
- Armazena nome completo, CPF, telefone, e-mail e endereço.
- Permite consultar, editar e excluir cadastros.
- Validação de CPF e endereço durante o cadastro.
- Geração de histórico de atrasos por cliente.
- Classificação de clientes inadimplentes como "maus clientes".

### 2. Cadastro de Filmes
- Registra título, gênero, ano de lançamento, classificação indicativa e quantidade em estoque.
- Permite consulta, edição e exclusão.
- Bloqueio de locações com base na classificação etária do filme.

### 3. Cadastro de Funcionários
- Armazena nome, CPF, cargo, tipo de contrato e salário.
- Permite consultar, editar e excluir dados.
- Validação de CPF.

### 4. Locação de Filmes
- Permite locação de um ou mais filmes por cliente.
- Registra cliente, filmes alugados, data de locação e data prevista de devolução.
- Realiza validações automáticas:
  - Verificação de estoque.
  - Restrições de faixa etária.
  - Limite de quantidade de filmes por locação.
- Geração de comprovante digital com todos os dados da locação.

### 5. Devolução de Filmes
- Atualiza automaticamente o estoque.
- Calcula multa por atraso com base nos dias em atraso.
- Registra atraso no histórico do cliente.
- Envia notificação por e-mail em caso de devolução em atraso.

### 6. Cancelamento de Locações
- Permitido apenas para locações ativas sem retirada de filmes.
- Solicita justificativa obrigatória para auditoria.
- Não permite cancelamento de locações já finalizadas ou com devolução confirmada.

### 7. Simulação de Valor da Locação
- Mostra o valor estimado antes da confirmação da locação, com base na quantidade de filmes e dias selecionados.

### 8. Avisos por E-mail
- Envia automaticamente um lembrete de devolução um dia antes do vencimento.
- Envia aviso de atraso caso o prazo não seja cumprido.

---

## 📊 Relatórios

- **Filmes Mais Alugados**: identifica os títulos com maior saída.
- **Clientes Mais Ativos**: mostra os que mais alugam filmes.
- **Locações por Cliente**: exibe todas as locações feitas por um cliente.
- **Locações Pendentes**: lista locações em andamento ou em atraso, com nome do cliente, filmes e datas.
- **Clientes por Faixa Etária**: separa os cadastros por grupo etário.
- **Melhor Mês**: aponta o mês com maior número de locações finalizadas.

---

## 🔒 Regras e Validações

- Validação de CPF no cadastro de clientes e funcionários.
- Validação do endereço informado no cadastro.
- Restrições de locação por idade com base na classificação indicativa dos filmes.
- Verificação de estoque e cancelamento automático caso não haja unidades disponíveis.
- Justificativa obrigatória para cancelamentos de locação.
- Bloqueio automático de clientes com histórico negativo de atrasos.

---

## 📄 Comprovante de Locação

Ao final do processo de locação, o sistema gera um comprovante digital contendo:
- Dados do cliente.
- Lista de filmes alugados.
- Data da locação.
- Data prevista de devolução.
- Valor total estimado.
- Opção de salvar ou imprimir o documento.

---

## 🧠 Análise de Comportamento do Cliente

- Histórico de devoluções.
- Identificação de clientes com atrasos frequentes.
- Classificação automática de comportamento (pontual ou inadimplente).
- Restrição de novas locações para clientes inadimplentes.

---

Este sistema foi projetado para atender com eficiência as necessidades de uma locadora de filmes moderna, garantindo controle sobre os processos de locação, clientes, estoque e análise de desempenho.


 
