package pheranca;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestaoRH {

    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<FuncionarioDocente> docentes = new ArrayList<>();
    private ArrayList<FuncionarioNaoDocente> naoDocentes = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarCurso(Curso c) {
        /*
        // se fosse pedido o preenchimento automatico do número do curso
        if (cursos.isEmpty()) {
            c.setNumero(1);
        } else {
            c.setNumero(cursos.size() + 1);
            // se se puder apagar cursos - c.setNumero(cursos.get(cursos.size()-1).getNumero()+1);
        }
        */
        cursos.add(c);
    }

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
        pessoas.add(a);
    }

    public void adicionarDocente(FuncionarioDocente d) {
        docentes.add(d);
        funcionarios.add(d);
        pessoas.add(d);
    }

    public void adicionarNaoDocente(FuncionarioNaoDocente nd) {
        naoDocentes.add(nd);
        funcionarios.add(nd);
        pessoas.add(nd);
    }

    public String mostrarCursos() {
        StringBuilder str = new StringBuilder();
        if (cursos.isEmpty()) {
            str.append("Não há cursos inseridos!");
        } else {
            for (int i = 0; i < cursos.size(); i++) {
                str.append("Curso: ").append(cursos.get(i)).append("\n");
            }
        }
        return str.toString();
    }

    public String mostrarRH() {
        StringBuilder str = new StringBuilder();
        if (pessoas.isEmpty()) {
            str.append("Não há pessoas inseridas!");
        } else {
            for (int i = 0; i < pessoas.size(); i++) {
                str.append(pessoas.get(i)).append("\n");
            }
        }
        return str.toString();
    }

    public String mostrarRH2() {
        StringBuilder str = new StringBuilder();
        if (alunos.isEmpty() && docentes.isEmpty()
                && naoDocentes.isEmpty()) {
            str.append("Não há pessoas inseridas!");
        } else {
            if (!alunos.isEmpty()) {
                str.append("Alunos: \n");
                for (int i = 0; i < alunos.size(); i++) {
                    str.append(alunos.get(i)).append("\n");
                }
            }
            if (!docentes.isEmpty()) {
                str.append("Docentes: \n");
                for (int i = 0; i < docentes.size(); i++) {
                    str.append(docentes.get(i)).append("\n");
                }
            }
            if (!naoDocentes.isEmpty()) {
                str.append("Não Docentes: \n");
                for (int i = 0; i < naoDocentes.size(); i++) {
                    str.append(naoDocentes.get(i)).append("\n");
                }
            }
        }
        return str.toString();
    }

    public String mostrarRH3() {
        StringBuilder str = new StringBuilder();
        if (pessoas.isEmpty()) {
            str.append("Não há pessoas inseridas!");
        } else {
            if (Aluno.numAlunos != 0) {
                str.append("Alunos: \n");
                for (int i = 0; i < pessoas.size(); i++) {
                    if (pessoas.get(i) instanceof Aluno) {
                        str.append(pessoas.get(i)).append("\n");
                    }
                }
            }
            if (FuncionarioDocente.numDocentes != 0) {
                str.append("Docentes: \n");
                for (int i = 0; i < pessoas.size(); i++) {
                    if (pessoas.get(i) instanceof FuncionarioDocente) {
                        str.append(pessoas.get(i)).append("\n");
                    }
                }
            }
            if (FuncionarioNaoDocente.numNaoDocentes != 0) {
                str.append("Não Docentes: \n");
                for (int i = 0; i < pessoas.size(); i++) {
                    if (pessoas.get(i) instanceof FuncionarioNaoDocente) {
                        str.append(pessoas.get(i)).append("\n");
                    }
                }
            }
        }
        return str.toString();
    }

    public String mostrarEstatisticas() {
        StringBuilder str = new StringBuilder();
        int conta;
        str.append("\nNúmero de cursos: ").append(cursos.size());
        str.append("\nNúmero de alunos: ").append(alunos.size());
        str.append("\nNúmero de docentes: ").append(docentes.size());
        str.append("\nNúmero de não docentes: ").append(naoDocentes.size());
         

        /*str.append("\nNúmero de cursos: ").append(Curso.numCursos);
         str.append("\nNúmero de alunos: ").append(Aluno.numAlunos);
         str.append("\nNúmero de docentes: ").append(Docente.numDocentes);
         str.append("\nNúmero de não docentes: ").append(NaoDocente.numNaoDocentes);
         */
         
        /*str.append("\nNúmero de cursos: ").append(cursos.size());
        conta = 0;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof Aluno) {
                conta++;
            }
        }
        str.append("\nNúmero de alunos: ").append(conta);

        conta = 0;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof FuncionarioDocente) {
                conta++;
            }
        }
        str.append("\nNúmero de docentes: ").append(conta);

        conta = 0;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof FuncionarioNaoDocente) {
                conta++;
            }
        }
        str.append("\nNúmero de não docentes: ").append(conta);
        */
         
        return str.toString();
    }

    public void aumentarSalario(int percentagem) {
        /*
         for (int i = 0; i < docentes.size(); i++) {
            docentes.get(i).aumentarSalario(percentagem);
         }
         */
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i) instanceof FuncionarioDocente) {
                ((FuncionarioDocente) pessoas.get(i)).aumentarSalario(percentagem);
            }
        }

    }

    public int pesquisarCurso(int numero) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;

    }

    public Curso obterCurso(int pos) {
        return cursos.get(pos);
    }

    public void gravarFicheiro() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Dados_RH.dat"));
            out.writeObject(cursos);
            out.writeObject(pessoas);
            out.writeObject(alunos);
            out.writeObject(funcionarios);
            out.writeObject(docentes);
            out.writeObject(naoDocentes);
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void lerFicheiro() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Dados_RH.dat"));
            cursos = (ArrayList<Curso>) in.readObject();
            pessoas = (ArrayList<Pessoa>) in.readObject();
            alunos = (ArrayList<Aluno>) in.readObject();
            funcionarios = (ArrayList<Funcionario>) in.readObject();
            docentes = (ArrayList<FuncionarioDocente>) in.readObject();
            naoDocentes = (ArrayList<FuncionarioNaoDocente>) in.readObject();

            Curso.numCursos = cursos.size();
            Aluno.numAlunos = alunos.size();
            FuncionarioDocente.numDocentes = docentes.size();
            FuncionarioNaoDocente.numNaoDocentes = naoDocentes.size();

            in.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
