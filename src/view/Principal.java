package view;

import controller.FuncionarioController;
import model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        Scanner scanner = new Scanner(System.in);

        // Adicionando funcionários
        controller.adicionarFuncionario(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        controller.adicionarFuncionario(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        controller.adicionarFuncionario(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        controller.adicionarFuncionario(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        controller.adicionarFuncionario(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        controller.adicionarFuncionario(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        controller.adicionarFuncionario(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        controller.adicionarFuncionario(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        controller.adicionarFuncionario(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        controller.adicionarFuncionario(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Remover funcionário João");
            System.out.println("2 - Imprimir funcionários");
            System.out.println("3 - Aumentar salários em 10%");
            System.out.println("4 - Imprimir funcionários agrupados por função");
            System.out.println("5 - Imprimir aniversariantes de outubro e dezembro");
            System.out.println("6 - Imprimir funcionário mais velho");
            System.out.println("7 - Imprimir funcionários em ordem alfabética");
            System.out.println("8 - Imprimir total dos salários");
            System.out.println("9 - Imprimir quantos salários mínimos cada um ganha");
            System.out.println("0 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> controller.removerFuncionario("João");
                case 2 -> controller.getFuncionarios().forEach(System.out::println);
                case 3 -> controller.aumentarSalarios(new BigDecimal("0.10"));
                case 4 -> controller.agruparPorFuncao().forEach((funcao, lista) -> {
                    System.out.println("\n" + funcao + ":");
                    lista.forEach(System.out::println);
                });
                case 5 -> controller.aniversariantesMes(10, 12).forEach(System.out::println);
                case 6 -> {
                    Funcionario maisVelho = controller.obterFuncionarioMaisVelho();
                    if (maisVelho != null) System.out.println(maisVelho.nome + " - " + maisVelho.getIdade() + " anos");
                }
                case 7 -> controller.listarOrdenadosPorNome().forEach(System.out::println);
                case 8 -> System.out.println("Total dos salários: R$ " + controller.calcularTotalSalarios());
                case 9 -> controller.calcularSalariosMinimos(new BigDecimal("1212.00")).forEach(System.out::println);
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida!");
            }
        }
    }

}
