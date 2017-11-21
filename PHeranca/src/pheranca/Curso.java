package pheranca;

import java.io.Serializable;
import java.util.Calendar;

public class Curso implements Anos, Serializable {

    private int numero;
    private String nome;
    private String abreviatura;
    private Calendar dataInicioFunc;
    private int anos;
    public static int numCursos;

    public Curso(int numero, String nome, String abreviatura, Calendar dataInicioFunc) {
        this.numero = numero;
        this.nome = nome;
        this.abreviatura = abreviatura;
        this.dataInicioFunc = dataInicioFunc;
        anos = calcularAnos();
        numCursos++;
    }

    @Override
    public int calcularAnos() {
        int anos;
        Calendar dataAtual = Calendar.getInstance();
        anos = dataAtual.get(Calendar.YEAR) - dataInicioFunc.get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR) < dataInicioFunc.get(Calendar.DAY_OF_YEAR)) {
            anos--;
        }

        return anos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Curso: ");
        str.append(numero).append(" - ");
        str.append(abreviatura).append(" - ");
        str.append(nome).append(" - ");
        str.append(dataInicioFunc.get(Calendar.DATE)).append("/");
        str.append((dataInicioFunc.get(Calendar.MONTH) + 1)).append("/");
        str.append(dataInicioFunc.get(Calendar.YEAR)).append(" - ");
        str.append(anos).append(" anos");

        return str.toString();
    }
}
