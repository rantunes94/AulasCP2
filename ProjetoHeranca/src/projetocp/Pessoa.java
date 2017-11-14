package projetocp;

import java.util.Calendar;

public abstract class Pessoa implements Anos {
    protected int numero;
    protected String nome;
    protected String morada;
    protected Calendar dataNascimento;
    protected Calendar dataEntrada;

    public Pessoa(int numero, String nome, String morada, Calendar dataNascimento, Calendar dataEntrada) {
        this.numero = numero;
        this.nome = nome;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
        this.dataEntrada = dataEntrada;
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

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");

        str.append("\n\tNúmero: ").append(numero);
        str.append("\n\tNome: ").append(nome);
        str.append("\n\tMorada: ").append(morada);


        // para aprensetar uma data no TESTE é ASSIM!!!
        str.append("\n\t\tData de nascimento: ").
                append(dataNascimento.get(Calendar.DATE)).
                append("-").append(dataNascimento.get(Calendar.MONTH)).
                append("-").append(dataNascimento.get(Calendar.YEAR));

        str.append("\n\t\tData de entrada: ").
                append(dataEntrada.get(Calendar.DATE)).
                append("-").append(dataEntrada.get(Calendar.MONTH)).
                append("-").append(dataEntrada.get(Calendar.YEAR));
        str.append("\n\t\tIdade: ").append(calcularIdade());
        str.append("\n\t\tAnos de servico: ").append(calcularAnos());

        return str.toString();// aqui tem de ser str e não super.toString()
    }


    public  int calcularIdade() {
        int anos;
        Calendar dataAtual= Calendar.getInstance();
        anos= dataAtual.get(Calendar.YEAR)-dataNascimento.
                get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR)<
                dataNascimento.get(Calendar.DAY_OF_YEAR) )
            anos --;

        return anos;
    }

    @Override
    public int calcularAnos() {
        int anos;
        Calendar dataAtual= Calendar.getInstance();
        anos= dataAtual.get(Calendar.YEAR)-dataEntrada.
                get(Calendar.YEAR);
        if (dataAtual.get(Calendar.DAY_OF_YEAR)<
                dataEntrada.get(Calendar.DAY_OF_YEAR) )
            anos --;

        return anos;
    }

    public abstract boolean validarIdade();// ao meter o metodo abrastact aqui la em cima a classe tambem tem de ser abstract
    // o metodo é abstract quando nao está implementado na super
}
