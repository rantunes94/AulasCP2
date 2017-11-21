package pheranca;

import java.io.Serializable;
import java.util.Calendar;

public class FuncionarioDocente extends Funcionario implements Serializable {

    private String departamento;
    private String gabinete;
    public static int numDocentes;

    public FuncionarioDocente(int numero, String nome, String morada, Calendar dataNasc, Calendar dataEntrada, double salario, String departamento, String gabinete) {
        super(numero, nome, morada, dataNasc, dataEntrada, salario);
        this.departamento = departamento;
        this.gabinete = gabinete;
        numDocentes++;
    }

    @Override
    public boolean validarIdade() {
        if (idade < 21) {
            return INVALIDO;
        }
        return VALIDO;
    }

    public void aumentarSalario(int percentagem) {
        salario += salario * percentagem / 100;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Funcionário Docente: ");
        str.append(super.toString());
        str.append("\n\tDepartamento: ").append(departamento);
        str.append("\n\tGabinete: ").append(gabinete);
        return str.toString();
    }
}
