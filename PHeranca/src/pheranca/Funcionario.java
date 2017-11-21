package pheranca;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Funcionario extends Pessoa implements Serializable {

    protected double salario;

    public Funcionario(int numero, String nome, String morada, Calendar dataNasc, Calendar dataEntrada, double salario) {
        super(numero, nome, morada, dataNasc, dataEntrada);
        this.salario = salario;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    public abstract boolean validarIdade();

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("\n\tSalário: ").append(salario);
        return str.toString();
    }

}
