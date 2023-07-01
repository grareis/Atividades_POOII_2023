public class TesteAgenda {
	
    public static void main(String[] args) {
    	
        Agenda agenda = new Agenda(5);

        Contato contato1 = new Contato("Xuxa", "xuxameneghel@uol.com");
        Contato contato2 = new Contato("Sasha", "sashameneghel@uol.com");
        Contato contato3 = new Contato("Silvio", "silviosantos@uol.com");
        Contato contato4 = new Contato("Angelica", "angelica@gmail.com");

        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        agenda.adicionarContato(contato3);
        agenda.adicionarContato(contato4);

        String nomeBusca = "Silvio";
        Contato resultadoBusca = agenda.buscarContato(nomeBusca);
        if (resultadoBusca != null) {
            System.out.println("Contato encontrado: " + resultadoBusca.getNome() + " (" + resultadoBusca.getEmail() + ")");
        } else {
            System.out.println("Contato \"" + nomeBusca + "\" não encontrado!");
        }

        agenda.excluirContato("Silvio");

        String nomeBusca2 = "Shakira";
        resultadoBusca = agenda.buscarContato(nomeBusca2);
        if (resultadoBusca != null) {
            System.out.println("Contato encontrado: " + resultadoBusca.getNome() + " (" + resultadoBusca.getEmail() + ")");
        } else {
            System.out.println("Contato \"" + nomeBusca2 + "\" não encontrado!");
        }
    }
}
