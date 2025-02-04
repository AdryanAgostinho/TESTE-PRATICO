package controller;

import model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(String nome) {
        funcionarios.removeIf(f -> f.nome.equals(nome));
    }

    public void aumentarSalarios(BigDecimal percentual) {
        funcionarios.forEach(f -> f.aumentarSalario(percentual));
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> aniversariantesMes(int... meses) {
        return funcionarios.stream()
                .filter(f -> Arrays.stream(meses).anyMatch(m -> f.dataNascimento.getMonthValue() == m))
                .collect(Collectors.toList());
    }

    public Funcionario obterFuncionarioMaisVelho() {
        return funcionarios.stream().min(Comparator.comparingInt(Funcionario::getIdade)).orElse(null);
    }

    public List<Funcionario> listarOrdenadosPorNome() {
        return funcionarios.stream().sorted(Comparator.comparing(f -> f.nome)).collect(Collectors.toList());
    }

    public BigDecimal calcularTotalSalarios() {
        return funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<String> calcularSalariosMinimos(BigDecimal salarioMinimo) {
        return funcionarios.stream()
                .map(f -> f.nome + " ganha " + f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP) + " salários mínimos.")
                .collect(Collectors.toList());
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
