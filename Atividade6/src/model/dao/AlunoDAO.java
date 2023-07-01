package model.dao;

import model.entities.Aluno;

import java.util.List;

public interface AlunoDAO {
    void insert(Aluno aluno);
    void update(Aluno aluno);
    void deleteById(int id);
    Aluno findById(int id);
    List<Aluno> findAll();
}
