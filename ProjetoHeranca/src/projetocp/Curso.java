package projetocp;

import java.util.Calendar;

public class Curso implements Anos{
    private  int numero;
    private String nome;
    private String abreviatura;
    private Calendar dataInicioFuncionamento;

    public Curso(int numero, String nome, String abreviatura, Calendar dataInicioFuncionamento) {
        this.numero = numero;
        this.nome = nome;
        this.abreviatura = abreviatura;
        this.dataInicioFuncionamento = dataInicioFuncionamento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Calendar getDataInicioFuncionamento() {
        return dataInicioFuncionamento;
    }

    public void setDataInicioFuncionamento(Calendar dataInicioFuncionamento) {
        this.dataInicioFuncionamento = dataInicioFuncionamento;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("\n\tCurso: ");
        str.append("\n\t\tNúmero: ").append(numero);
        str.append("\n\t\tNome: ").append(nome);
        str.append("\n\t\tAbreviatura: ").append(abreviatura);

        // para aprensetar uma data no TESTE é ASSIM!!!
        str.append("\n\t\tData de ínicio de funcionamento: ").
                append(dataInicioFuncionamento.get(Calendar.DATE)).
                append("-").append(dataInicioFuncionamento.get(Calendar.MONTH)).
                append("-").append(dataInicioFuncionamento.get(Calendar.YEAR));
        str.append("\n\t\tAnos de funcionamento: ").append(calcularAnos());


        return str.toString();// aqui tem de ser str e não super.toString()
    }

    @Override
    public int calcularAnos() {
        int anos;
        Calendar dataAtual= Calendar.getInstance();
        anos= dataAtual.get(Calendar.YEAR)-dataInicioFuncionamento.
                get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR)<
                dataInicioFuncionamento.get(Calendar.DAY_OF_YEAR) )
            anos --;

        return anos;
    }
}
