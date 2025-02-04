# Teste Prático de Programação - Java

## Descrição
Este projeto consiste em um sistema desenvolvido em Java para gerenciar uma lista de funcionários de uma indústria, realizando diversas operações como inserção, remoção, atualização salarial, agrupamento por função, ordenação alfabética e cálculos de salário médio e idades.

## Estrutura do Projeto
O projeto é dividido nas seguintes classes:

### 1. `Pessoa`
- `nome` (String) - Nome da pessoa.
- `dataNascimento` (LocalDate) - Data de nascimento da pessoa.

### 2. `Funcionario` (extende `Pessoa`)
- `salario` (BigDecimal) - Salário do funcionário.
- `funcao` (String) - Cargo do funcionário.

### 3. `FuncionarioController`
- Gerencia a lista de funcionários e implementa os métodos para as operações solicitadas.

### 4. `Principal`
- Classe principal que executa o programa e exibe um menu interativo.

## Funcionalidades Implementadas
1. Inserir todos os funcionários conforme tabela original.
2. Remover o funcionário "João" da lista.
3. Imprimir todos os funcionários com:
    - Data no formato `dd/MM/yyyy`.
    - Salários formatados com separador de milhar como ponto e decimal como vírgula.
4. Aplicar um aumento de 10% no salário de todos os funcionários.
5. Agrupar os funcionários por função e exibir a lista agrupada.
6. Exibir os funcionários que fazem aniversário nos meses de outubro e dezembro.
7. Identificar e imprimir o funcionário com a maior idade.
8. Ordenar e exibir a lista de funcionários em ordem alfabética.
9. Calcular e exibir o total de todos os salários somados.
10. Exibir quantos salários mínimos cada funcionário recebe, considerando o valor de R$ 1212,00.

