package Gerenciador;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nomeCurso;
    private int cargaHoraria;
    private Professor professor;
    private List<Estudante> estudantes;

    public Curso(String nomeCurso, int cargaHoraria, Professor professor) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.estudantes = new ArrayList<>();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void adicionarEstudante(Estudante estudante) {
        this.estudantes.add(estudante);
    }

    public List<Estudante> listarEstudantes() {
        return estudantes;
    }
}
