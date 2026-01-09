package Gerenciador;

import java.util.List;

public class Relatorio {

    public static String gerarRelatorioCurso(Curso curso) {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Curso: ").append(curso.getNomeCurso()).append("\n");
        relatorio.append("Carga Horária: ").append(curso.getCargaHoraria()).append(" horas\n");
        relatorio.append("Professor: ").append(curso.getProfessor().getNome()).append("\n");
        relatorio.append("Estudantes Matriculados:\n");

        List<Estudante> estudantes = curso.listarEstudantes();
        for (Estudante estudante : estudantes) {
            relatorio.append("- ").append(estudante.exibirDados()).append("\n");
        }

        return relatorio.toString();
    }
}
