package pheranca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import util.Consola;

public class Main {

    public static SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    public static GestaoRH grh = new GestaoRH();

    /*Para simplificação deste exercício não foram efetuadas validações de campos únicos */

    public static void main(String[] args) {
        int op, percentagem;
        grh.lerFicheiro();
        do {
            op = menu();
            switch (op) {
                case 1:
                    inserirCurso();
                    break;
                case 2:
                    if (Curso.numCursos != 0) {
                        inserirAluno();
                    } else {
                        System.err.println("Não há cursos inseridos!");
                    }
                    break;
                case 3:
                    inserirDocente();
                    break;
                case 4:
                    inserirNaoDocente();
                    break;
                case 5:
                    if (FuncionarioDocente.numDocentes != 0) {
                        percentagem = Consola.lerInt("Indique a percentagem a aumentar: ", 1, 100);
                        grh.aumentarSalario(percentagem);
                        System.out.println("Salário aumentado com sucesso!");
                    } else {
                        System.err.println("Não há docentes inseridos!");
                    }
                    break;
                case 6:
                    System.out.println(grh.mostrarCursos());
                    break;
                case 7:
                    System.out.println(grh.mostrarRH3());
                    break;
                case 8:
                    System.out.println(grh.mostrarEstatisticas());
                    break;
                case 0:
                    System.out.println("O programa terminou...");
            }
            if (op != 0) {
                Consola.sc.nextLine();
            }
        } while (op != 0);
        grh.gravarFicheiro();
    }

    public static int menu() {
        System.out.println("1.Adicionar Curso");
        System.out.println("2.Adicionar Aluno");
        System.out.println("3.Adicionar Docente");
        System.out.println("4.Adicionar Não Docente");
        System.out.println("5.Atualizar salário dos funcionários");
        System.out.println("6.Motrar cursos");
        System.out.println("7.Mostrar recursos humanos");
        System.out.println("8.Estatísticas");
        System.out.println("0.Sair");
        int opcao = Consola.lerInt("Qual a opção: ", 0, 8);
        return opcao;
    }

    public static void inserirCurso() {
        int numero;
        String nome, abreviatura, dataI;
        Calendar dataInicioFunc = new GregorianCalendar();
        int errodi;

        numero = Consola.lerInt("Indique o número do curso: ", 1, 100);
        nome = Consola.lerString("Indique o nome do curso: ");
        abreviatura = Consola.lerString("Indique a abreviatura do curso: ");

        do {
            errodi = 0;
            try {

                dataI = Consola.lerString("Indique a data de início de funcionamento do curso (dd-mm-yyyy): ");
                dataInicioFunc.setTime(formato.parse(dataI));
            } catch (ParseException e) {
                errodi = 1;

                System.err.println("Data de início de funcionamento com formato inválido!");
            }
        } while (errodi == 1);

        Curso c = new Curso(numero, nome, abreviatura, dataInicioFunc);

        grh.adicionarCurso(c);
        System.out.println("Curso inserido com sucesso!");

    }

    public static void inserirAluno() {
    
    }

    public static void inserirDocente() {
        int numero;
        String nome, morada, dataN, dataI, departamento, gabinete;
        double salario;
        Calendar dataNasc = new GregorianCalendar();
        Calendar dataEntrada = new GregorianCalendar();
        int errodn = 0, errode = 0;

        numero = Consola.lerInt("Indique o número do docente: ", 1, 100);
        nome = Consola.lerString("Indique o nome do docente: ");
        morada = Consola.lerString("Indique a morada do docente: ");

        do {
            errodn = 0;
            try {
                dataN = Consola.lerString("Indique a data de nascimento do docente (dd-mm-yyyy): ");
                dataNasc.setTime(formato.parse(dataN));
            } catch (ParseException e) {
                errodn = 1;
                System.err.println("Data de nascimento com formato inválido!");
            }
        } while (errodn == 1);

        do {
            errode = 0;
            try {

                dataI = Consola.lerString("Indique a data de entrada do docente (dd-mm-yyyy): ");
                dataEntrada.setTime(formato.parse(dataI));
            } catch (ParseException e) {
                errode = 1;

                System.err.println("Data de entrada com formato inválido!");
            }
        } while (errode == 1);

        salario = Consola.lerDouble("Indique o salario do docente: ", 500, 5000);
        departamento = Consola.lerString("Indique o departamento do docente: ");
        gabinete = Consola.lerString("Indique o gabinete do docente: ");

        FuncionarioDocente d = new FuncionarioDocente(numero, nome, morada, dataNasc, dataEntrada, salario, departamento, gabinete);

        if (d.validarIdade()) {
            grh.adicionarDocente(d);
            System.out.println("Docente introduzido com sucesso!");
        } else {
            System.err.println("Docente com idade inválida!");
        }

    }

    public static void inserirNaoDocente() {
     
    }

}
