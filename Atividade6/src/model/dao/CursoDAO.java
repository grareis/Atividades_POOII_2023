package model.dao;

import model.entities.Curso;

import java.util.List;

public interface CursoDAO {
    void insert(Curso curso);
    void update(Curso curso);
    void deleteById(int id);
    Curso findById(int id);
    List<Curso> findAll();
}
