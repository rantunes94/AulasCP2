package pheranca;

import java.io.Serializable;
import java.util.Calendar;

public class FuncionarioNaoDocente extends Funcionario implements Serializable {

    public static int numNaoDocentes;

    public FuncionarioNaoDocente(int numero, String nome, String morada, Calendar dataNasc, Calendar dataEntrada, double salario) {
        super(numero, nome, morada, dataNasc, dataEntrada, salario);
        numNaoDocentes++;
    }

    @Override
    public boolean validarIdade() {
        if (idade < 18) {
            return INVALIDO;
        }
        return VALIDO;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Funcionário Não Docente: ");
        str.append(super.toString());
        return str.toString();
    }
}
