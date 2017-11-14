package projetocp;

import java.util.Calendar;

public class Funcionario extends Pessoa {
    protected double salario;

    public Funcionario(int numero, String nome, String morada, Calendar dataNascimento, Calendar dataEntrada, double salario) {
        super(numero, nome, morada, dataNascimento, dataEntrada);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder();
        str.append(super.toString());
        str.append("\n\tSalário: ").append(salario);

        return str.toString();
    }
}
