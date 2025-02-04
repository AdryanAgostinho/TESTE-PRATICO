package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void aumentarSalario(BigDecimal percentual) {
        salario = salario.add(salario.multiply(percentual));
    }

    public String getFuncao() {
        return funcao;
    }

    public int getIdade() {
        return (int) ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }

    public String formatarSalario() {
        return String.format("%,.2f", salario);

    }

    @Override
    public String toString() {
        return toString(true);  // Chama o método com o parâmetro 'true' por padrão
    }

    public String toString(boolean incluirFuncao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resultado = nome + " - " + dataNascimento.format(formatter) + " - R$ " + formatarSalario();
        if (incluirFuncao) {
            resultado += " - " + funcao;  // Adiciona a função apenas quando necessário
        }
        return resultado;
    }
}
