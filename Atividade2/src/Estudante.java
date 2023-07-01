import java.util.ArrayList;

public class Estudante {
    private String nome;
    private ArrayList<Orientador> orientadores;

    public Estudante(String nome) {
        this.nome = nome;
        this.orientadores = new ArrayList<Orientador>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Orientador> getOrientadores() {
        return orientadores;
    }

    public void addOrientador(Orientador orientador) throws Throwable {
        if (this.orientadores.size() >= 2) {
            throw new LimiteOrientadorException("Estudante já possui o número máximo de orientadores.");
        }
        orientador.addEstudante(this);
        this.orientadores.add(orientador);
    }

    public void removeOrientador(Orientador orientador) {
        orientador.removeEstudante(this);
        this.orientadores.remove(orientador);
    }

    public static class LimiteOrientadorException extends RuntimeException {
        public LimiteOrientadorException(String message) {
            super(message);
        }

    }
 }