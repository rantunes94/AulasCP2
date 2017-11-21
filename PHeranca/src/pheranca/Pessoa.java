package pheranca;

import java.io.Serializable;
import java.util.Calendar;

public abstract class Pessoa implements Anos, Serializable {

    protected int numero;
    protected String nome;
    protected String morada;
    protected Calendar dataNasc;
    protected Calendar dataEntrada;
    protected int idade;
    protected int anos;

    public Pessoa(int numero, String nome, String morada, Calendar dataNasc, Calendar dataEntrada) {
        this.numero = numero;
        this.nome = nome;
        this.morada = morada;
        this.dataNasc = dataNasc;
        this.dataEntrada = dataEntrada;
        idade = calcularIdade();
        anos = calcularAnos();
    }

    public abstract boolean validarIdade();

    @Override
    public int calcularAnos() {
        int anos;
        Calendar dataAtual = Calendar.getInstance();
        anos = dataAtual.get(Calendar.YEAR) - dataEntrada.
                get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR)
                < dataEntrada.get(Calendar.DAY_OF_YEAR)) {
            anos--;
        }

        return anos;
    }

    private int calcularIdade() {
        int anos;
        Calendar dataAtual = Calendar.getInstance();
        anos = dataAtual.get(Calendar.YEAR) - dataNasc.
                get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR)
                < dataNasc.get(Calendar.DAY_OF_YEAR)) {
            anos--;
        }

        return anos;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\n\tNúmero: ").append(numero);
        str.append("\n\tNome: ").append(nome);
        str.append("\n\tMorada: ").append(morada);
        str.append("\n\tData Nascimento: ").
                append(dataNasc.get(Calendar.DATE)).
                append("-").append((dataNasc.get(Calendar.MONTH) + 1)).
                append("-").append(dataNasc.get(Calendar.YEAR));
        str.append("\n\tIdade: ").append(idade);
        str.append("\n\tAnos de Serviço: ").append(anos);

        return str.toString();
    }

}
