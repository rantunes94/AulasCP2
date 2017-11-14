package projetocp;

import java.util.Calendar;

public class FuncionarioDocente extends Funcionario{
    private String gabinete;
    private String departamento;


    public FuncionarioDocente(int numero, String nome, String morada, Calendar dataNascimento, Calendar dataEntrada, double salario, String gabinete, String departamento) {
        super(numero, nome, morada, dataNascimento, dataEntrada, salario);
        this.gabinete = gabinete;
        this.departamento = departamento;

    }

    public String getGabinete() {
        return gabinete;
    }

    public void setGabinete(String gabinete) {
        this.gabinete = gabinete;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder("");
        str.append("Funcionário docente: ");
        str.append(super.toString());
        str.append("\n\tGabinete: ").append(gabinete); // vai buscar o toString do curso
        str.append("\n\tDepartamento: ").append(departamento);
        return str.toString();
    }
}
