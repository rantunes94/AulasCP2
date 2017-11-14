package projetocp;

import java.util.Calendar;

public class FuncionarioNaoDocente extends Funcionario{

    public FuncionarioNaoDocente(int numero, String nome, String morada, Calendar dataNascimento, Calendar dataEntrada, double salario) {
        super(numero, nome, morada, dataNascimento, dataEntrada, salario);
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder("");
        str.append("Funcionário não docente: ");
        str.append(super.toString());
        return str.toString();
    }
}
