class Agenda {
	
    private Contato[] contatos;

    public Agenda(int tamanho) {
        contatos = new Contato[tamanho];
    }

    public void adicionarContato(Contato novoContato) {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] == null) {
                contatos[i] = novoContato;
                break;
            }
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato != null && contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void excluirContato(String nome) {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null && contatos[i].getNome().equals(nome)) {
                contatos[i] = null;
                break;
            }
        }
    }
}