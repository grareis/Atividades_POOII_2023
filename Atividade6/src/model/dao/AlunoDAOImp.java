package model.dao;

import model.entities.Aluno;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImp implements AlunoDAO {

    private static List<Aluno> alunos = new ArrayList<>();
    private static int nextId = 1;

    public AlunoDAOImp(Connection conexao) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void insert(Aluno aluno) {
        aluno.setIdAluno(nextId);
        alunos.add(aluno);
        nextId++;
    }

    @Override
    public void update(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getIdAluno() == aluno.getIdAluno()) {
                a.setNomeAluno(aluno.getNomeAluno());
                a.setIdade(aluno.getIdade());
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getIdAluno() == id) {
                alunos.remove(aluno);
                return;
            }
        }
    }

    @Override
    public Aluno findById(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getIdAluno() == id) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        return alunos;
    }
}

