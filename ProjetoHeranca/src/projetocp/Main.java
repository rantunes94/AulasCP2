package projetocp;

import util.Consola;

import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args){
        int op;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        do {
            op = menu();
            switch (op) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        } while (op != 9);

    }

    public static int menu() {
        System.out.println("\n1.Adicionar Curso");
        System.out.println("2.Adicionar Aluno");
        System.out.println("3.Adicionar FuncionarioDocente");
        System.out.println("4.Adicionar Não FuncionarioDocente");
        System.out.println("5.Atualizar salário dos funcionários");
        System.out.println("6.Motrar cursos");
        System.out.println("7.Mostrar recursos humanos");
        System.out.println("8.Estatísticas");
        System.out.println("9.Sair");
        int opcao = Consola.lerInt("Qual a opção: ", 1, 9);
        return opcao;
    }
}


