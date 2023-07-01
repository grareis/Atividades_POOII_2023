package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoDAO {

    Connection con;
    String sql;
    PreparedStatement pst;
    
    public void salvar(Aluno a) throws SQLException {
        try {
            con = db.getConexao();
            sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES (?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, a.getNome());
            pst.setString(2, a.getSexo());
            pst.setDate(3, java.sql.Date.valueOf(a.getDt_nasc()));
            pst.executeUpdate();
            System.out.println("\nCadastro do aluno realizado com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pst.close();
            db.closeConexao();
        }
    }
    
    public List<Aluno> listar() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        try {
            con = db.getConexao();
            sql = "SELECT * FROM aluno";
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo"));
                LocalDate dt_nasc = rs.getDate("dt_nasc").toLocalDate();
                aluno.setDt_nasc(dt_nasc);
                alunos.add(aluno);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pst.close();
            db.closeConexao();
        }
        return alunos;
    }
    
    public void apagar(int id) throws SQLException {
        try {
            con = db.getConexao();
            sql = "DELETE FROM aluno WHERE id=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("\nAluno removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pst.close();
            db.closeConexao();
        }
    }
    
    public void alterar(Aluno a) throws SQLException {
        try {
            con = db.getConexao();
            sql = "UPDATE aluno SET nome=?, sexo=?, dt_nasc=? WHERE id=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, a.getNome());
            pst.setString(2, a.getSexo());
            pst.setDate(3, java.sql.Date.valueOf(a.getDt_nasc()));
            pst.setInt(4, a.getId());
            pst.executeUpdate();
            System.out.println("\nAluno alterado com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pst.close();
            db.closeConexao();
        }
    }
    
    public void redefinirSequencia(String tabela, String coluna) throws SQLException {
        try {
            con = db.getConexao();
            sql = "SELECT setval(pg_get_serial_sequence(?, ?), (SELECT MAX(id) FROM ?))";
            pst = con.prepareStatement(sql);
            pst.setString(1, tabela);
            pst.setString(2, coluna);
            pst.setString(3, tabela);
            pst.executeUpdate();
            System.out.println("\nSequência redefinida com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pst.close();
            db.closeConexao();
        }
    }
}
