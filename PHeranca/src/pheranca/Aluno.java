package pheranca;

import java.io.Serializable;
import java.util.Calendar;

public class Aluno extends Pessoa implements Serializable {

    private Curso curso;
    public static int numAlunos;

    public Aluno(int numero, String nome, String morada, Calendar dataNasc, Calendar dataEntrada, Curso curso) {
        super(numero, nome, morada, dataNasc, dataEntrada);
        this.curso = curso;
        numAlunos++;
    }

    @Override
    public boolean validarIdade() {
        if (idade < 17) {
            return INVALIDO;
        }
        return VALIDO;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Aluno :");
        str.append(super.toString());
        str.append("\n\t").append(curso);

        return str.toString();
    }
}
