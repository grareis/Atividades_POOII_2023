package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.entities.Disciplina;

public class DisciplinaDAOImp implements DisciplinaDAO {

    private Connection conexao;

    public DisciplinaDAOImp(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void insert(Disciplina obj) {
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?, ?)";
            pst = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getNomeDisciplina());
            pst.setInt(2, obj.getCargaHoraria());
            int linhas = pst.executeUpdate();

            if (linhas > 0) {
                rs = pst.getGeneratedKeys();
                rs.next();
                obj.setIdDisciplina(rs.getInt(1));
                System.out.println(obj.toString() + " foi criada com sucesso!");
            } else {
                System.out.println("Não foi possível cadastrar a disciplina!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Disciplina obj) {
        // Implementação do método de atualização de disciplina

    }

    @Override
    public void deleteById(Integer id) {
        // Implementação do método de exclusão de disciplina

    }

    @Override
    public Disciplina findById(Integer id) {
        // Implementação do método de busca de disciplina por ID
        return null;
    }

    @Override
    public List<Disciplina> findAll() {
        // Implementação do método de busca de todas as disciplinas
        return null;
    }

}
