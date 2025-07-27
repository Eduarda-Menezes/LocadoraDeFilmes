package LocadoraDeFilmes.Testes;
/*
import LocadoraDeFilmes.Modelos.Cliente;
public class Main {
    public static void main(String[] args) {
        // Criando um cliente válido
        Cliente cliente1 = new Cliente(1, "Eduarda Menezes", "12345678901", "81999999999",
                "eduarda@email.com", "Rua das Flores, 123", "15/03/2000");

        System.out.println("---- Teste de Cliente ----");
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("CPF: " + cliente1.getCpf());
        System.out.println("CPF Válido? " + (cliente1.validarCPF() ? "Sim" : "Não"));
        System.out.println("Email: " + cliente1.getEmail());

        // Testando alteração de dados
        cliente1.setEmail("novoemail@email.com");
        System.out.println("Email atualizado: " + cliente1.getEmail());

        // Testando CPF inválido
        cliente1.setCpf("1234");
        System.out.println("Novo CPF: " + cliente1.getCpf());
        System.out.println("CPF Válido? " + (cliente1.validarCPF() ? "Sim" : "Não"));
    }
}

import LocadoraDeFilmes.Modelos.Filme;

public class Main {
    public static void main(String[] args) {
        Filme filme1 = new Filme("Matrix", "Ficção Científica", 1999, "16");
        Filme filme2 = new Filme("Toy Story", "Animação", 1995, "Livre");

        filme1.exibirInfo();
        System.out.println(); // linha em branco
        filme2.exibirInfo();
    }
}


import LocadoraDeFilmes.Modelos.Funcionario;

public class Main {
    public static void main(String[] args) {
        // Criando os funcionários
        Funcionario funcionario1 = new Funcionario(1, "Carlos Silva", "11991234567", "Atendente");
        Funcionario funcionario2 = new Funcionario(2, "Fernanda Costa", "21998887766", "Gerente");
        Funcionario funcionario3 = new Funcionario(3, "João Mendes", "31997885432", "Estoquista");

        // Exibindo os dados de cada funcionário
        System.out.println("Funcionário 1:");
        System.out.println("ID: " + funcionario1.getId());
        System.out.println("Nome: " + funcionario1.getNome());
        System.out.println("Telefone: " + funcionario1.getTelefone());
        System.out.println("Função: " + funcionario1.getFuncao());
        System.out.println();

        System.out.println("Funcionário 2:");
        System.out.println("ID: " + funcionario2.getId());
        System.out.println("Nome: " + funcionario2.getNome());
        System.out.println("Telefone: " + funcionario2.getTelefone());
        System.out.println("Função: " + funcionario2.getFuncao());
        System.out.println();

        System.out.println("Funcionário 3:");
        System.out.println("ID: " + funcionario3.getId());
        System.out.println("Nome: " + funcionario3.getNome());
        System.out.println("Telefone: " + funcionario3.getTelefone());
        System.out.println("Função: " + funcionario3.getFuncao());
    }
}


import LocadoraDeFilmes.Modelos.Filme;
import LocadoraDeFilmes.Modelos.TipoDeFilme;

public class Main {
    public static void main(String[] args) {
        // Tipo 1: Matrix
        TipoDeFilme tipoMatrix = new TipoDeFilme("Matrix", 136, "Ficção Científica");
        tipoMatrix.adicionarFilmeAoEstoque(new Filme());
        tipoMatrix.adicionarFilmeAoEstoque(new Filme());

        // Tipo 2: Titanic
        TipoDeFilme tipoTitanic = new TipoDeFilme("Titanic", 195, "Romance");
        tipoTitanic.adicionarFilmeAoEstoque(new Filme());

        // Tipo 3: Toy Story
        TipoDeFilme tipoToyStory = new TipoDeFilme("Toy Story", 81, "Animação");
        tipoToyStory.adicionarFilmeAoEstoque(new Filme());
        tipoToyStory.adicionarFilmeAoEstoque(new Filme());
        tipoToyStory.adicionarFilmeAoEstoque(new Filme());

        // Verificando os estoques
        System.out.println("Estoque de Matrix: " + tipoMatrix.getQtd() + " cópias.");
        System.out.println("Estoque de Titanic: " + tipoTitanic.getQtd() + " cópias.");
        System.out.println("Estoque de Toy Story: " + tipoToyStory.getQtd() + " cópias.");

        // Verificar um ID específico
        System.out.println(tipoMatrix.verificarPorId(0)); // deve funcionar se o filme 0 foi adicionado aqui
        System.out.println(tipoToyStory.verificarPorId(5)); // tentativa de buscar outro
    }
}


import LocadoraDeFilmes.Modelos.Multa;

public class Main {
    public static void main(String[] args) {
        // Valor padrão da multa por dia
        float valorPorDia = 2.50f;

        // Cliente 1: 3 dias de atraso
        Multa multa1 = new Multa(1, 3, valorPorDia);

        // Cliente 2: 8 dias de atraso
        Multa multa2 = new Multa(2, 8, valorPorDia);

        // Cliente 3: 12 dias de atraso
        Multa multa3 = new Multa(3, 12, valorPorDia);

        // Exibir os dados
        System.out.println("Multa 1 - ID: " + multa1.getId() + ", Dias de atraso: " + multa1.getDiasAtraso()
                + ", Valor total: R$" + multa1.getValorTotal());

        System.out.println("Multa 2 - ID: " + multa2.getId() + ", Dias de atraso: " + multa2.getDiasAtraso()
                + ", Valor total: R$" + multa2.getValorTotal());

        System.out.println("Multa 3 - ID: " + multa3.getId() + ", Dias de atraso: " + multa3.getDiasAtraso()
                + ", Valor total: R$" + multa3.getValorTotal());
    }
}


import LocadoraDeFilmes.Modelos.Cliente;
import LocadoraDeFilmes.Modelos.Multa;

public class Main {
    public static void main(String[] args) {
        // Criando clientes
        Cliente cliente1 = new Cliente(1, "Ana Souza", "11122233344", "11999999999", "ana@email.com", "Rua A, 123", "15/06/1990");
        Cliente cliente2 = new Cliente(2, "Bruno Lima", "22233344455", "11988888888", "bruno@email.com", "Av. B, 456", "23/09/1985");
        Cliente cliente3 = new Cliente(3, "Carla Mendes", "33344455566", "11977777777", "carla@email.com", "Trav. C, 789", "02/12/2000");

        // Criando e adicionando multas para cada cliente
        cliente1.adicionarMulta(new Multa(1, 3, 2.50f));  // R$7.50
        cliente1.adicionarMulta(new Multa(2, 2, 2.50f));  // R$5.00

        cliente2.adicionarMulta(new Multa(3, 5, 3.00f));  // R$15.00

        cliente3.adicionarMulta(new Multa(4, 10, 1.50f)); // R$15.00
        cliente3.adicionarMulta(new Multa(5, 4, 1.50f));  // R$6.00

        // Exibindo dados dos clientes e suas multas
        exibirMultasCliente(cliente1);
        exibirMultasCliente(cliente2);
        exibirMultasCliente(cliente3);
    }

    public static void exibirMultasCliente(Cliente cliente) {
        System.out.println("Cliente: " + cliente.getNome() + " (ID: " + cliente.getId() + ")");
        for (Multa multa : cliente.getMultas()) {
            System.out.println(" - Multa ID: " + multa.getId() +
                    " | Dias atraso: " + multa.getDiasAtraso() +
                    " | Valor total: R$" + multa.getValorTotal());
        }
        System.out.println("Total de multas: R$" + cliente.calcularTotalMultas());
        System.out.println("------------------------------------------------------");
    }
}


import LocadoraDeFilmes.Modelos.*;

public class Main {
    public static void main(String[] args) {
        // Criar funcionário que gera o relatório
        Funcionario funcionario = new Funcionario(1, "Marcos Silva");

        // Criar um cliente com locações simuladas
        Cliente cliente = new Cliente(
                1, "Joana Pereira", "12345678900", "11990000000",
                "joana@email.com", "Rua Exemplo, 45", "10/10/1995"
        );

        // Criar algumas solicitações de aluguel simuladas
        SolicitacaoDeAluguel aluguel1 = new SolicitacaoDeAluguel("01/07/2025", "05/07/2025");
        SolicitacaoDeAluguel aluguel2 = new SolicitacaoDeAluguel("10/07/2025", "12/07/2025");

        // Registrar essas locações no cliente
        cliente.adicionarLocacao(aluguel1);
        cliente.adicionarLocacao(aluguel2);

        // Criar o relatório
        Relatorio relatorio = new Relatorio(101, "Locações por Cliente", "Julho 2025", funcionario);

        // Gerar os dados do relatório
        var locacoes = relatorio.gerarLocacoesPorCliente(cliente);
        relatorio.setDados(locacoes);

        // Imprimir o relatório
        System.out.println("===== RELATÓRIO =====");
        System.out.println("Tipo: " + relatorio.getTipo());
        System.out.println("Período: " + relatorio.getPeriodo());
        System.out.println("Data de geração: " + relatorio.getDataGeracao());
        System.out.println("Gerado por: " + relatorio.getGeradoPor().getNome());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Locações:");

        for (SolicitacaoDeAluguel loc : locacoes) {
            System.out.println(" - Alugado em: " + loc.getDataInicio() + " | Devolução: " + loc.getDataFim());
        }

        System.out.println("=======================");
    }
}
*/

