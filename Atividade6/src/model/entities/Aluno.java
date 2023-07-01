package model.entities;

import java.util.Objects;

public class Aluno {

    private Integer idAluno;
    private String nomeAluno;
    private String matricula;

    public Aluno() {

    }

    public Aluno(Integer idAluno, String nomeAluno, String matricula) {
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno [idAluno=" + idAluno + ", nomeAluno=" + nomeAluno + ", matricula=" + matricula + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        return Objects.equals(matricula, other.matricula);
    }

	public Object getIdade() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdade(Object idade) {
		// TODO Auto-generated method stub
		
	}
}
