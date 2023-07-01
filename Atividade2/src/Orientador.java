import java.util.ArrayList;

import javax.naming.LimitExceededException;

public class Orientador {
    private String nome;
    private ArrayList<Estudante> estudantes;

    public Orientador(String nome) {
        this.nome = nome;
        this.estudantes = new ArrayList<Estudante>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void addEstudante(Estudante estudante) throws Throwable, Throwable {
        if (this.estudantes.size() >= 3) {
            throw new LimitExceededException("Orientador já possui o número máximo de estudantes.");
        }
        estudante.addOrientador(this);
        this.estudantes.add(estudante);
    }

    public void removeEstudante(Estudante estudante) {
        estudante.removeOrientador(this);
        this.estudantes.remove(estudante);
    }


	public void addOrientador(Orientador orientador) {
				
	}

	@Override
	public String toString() {
		return " nome: " + nome + " ||";
	}
}


