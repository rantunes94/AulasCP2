package projetocp;

import java.util.Calendar;

public abstract class Aluno extends Pessoa{
    private Curso curso;

    public Aluno(int numero, String nome, String morada, Calendar dataNascimento, Calendar dataEntrada, Curso curso) {
        super(numero, nome, morada, dataNascimento, dataEntrada);
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder("");
        str.append("Aluno: ");
        str.append(super.toString());
        str.append(curso); // vai buscar o toString do curso

        return str.toString();
    }

    @Override
    public boolean validarIdade() {
        if(calcularIdade()<17)
            return INVALIDO;
        return VALIDO;
    }
}
