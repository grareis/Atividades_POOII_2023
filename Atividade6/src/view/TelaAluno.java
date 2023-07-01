package view;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.dao.AlunoDAO;
import model.dao.AlunoDAOImp;
import model.dao.FactoryDAO;
import model.entities.Aluno;

public class TelaAluno {

    static AlunoDAO alunoDao = FactoryDAO.createAlunoDAO();

    @SuppressWarnings("resource")
    public static Scanner menuAluno(Scanner console) throws InterruptedException, ParseException {

        int opcao = 0;
        do {
            System.out.println("\n\n### Tela: Aluno ###");
            System.out.println("=========================");
            System.out.println("|     1 - Cadastrar     |");
            System.out.println("|     2 - Listar        |");
            System.out.println("|     3 - Alterar       |");
            System.out.println("|     4 - Excluir       |");
            System.out.println("|     0 - Retornar      |");
            System.out.println("=========================");
            System.out.print("Opção -> ");
            opcao = console.nextInt();
            console.nextLine();

            switch (opcao) {
                case 1:
                    console = cadastrar(console);
                    break;
                case 2:
                    console = listar(console);
                    break;
                case 3:
                    console = alterar(console);
                    break;
                case 4:
                    console = excluir(console);
                    break;
                case 0:
                    console = TelaPrincipal.menuPrincipal(console);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    TimeUnit.SECONDS.sleep(1);
            }
        } while (opcao != 0);
        return console;
    }

    private static Scanner cadastrar(Scanner console) throws ParseException {

        Aluno a = new Aluno();

        System.out.println("\n\n### Aluno-Cadastrar ###");
        System.out.println("=========================");

        System.out.print("|     Nome: ");
        a.setNome(console.nextLine());

        System.out.print("|     Matrícula: ");
        a.setMatricula(console.nextLine());

        System.out.println("=========================");

        alunoDao.insert(a);

        console.nextLine();
        return console;
    }

    private static Scanner listar(Scanner console) {

        List<Aluno> alunos = alunoDao.findAll();

        System.out.println("\n\n### Aluno-Listar ###");
        System.out.println("=========================");

        for (Aluno a : alunos) {
            System.out.println("|     ID: " + a.getId());
            System.out.println("|     Nome: " + a.getNome());
            System.out.println("|     Matrícula: " + a.getMatricula());
            System.out.println("=========================");
        }

        console.nextLine();
        return console;
    }

    private static Scanner alterar(Scanner console) {

        System.out.println("\n\n### Aluno-Alterar ###");
        System.out.println("=========================");

        System.out.print("|     Digite o ID do Aluno: ");
        int id = console.nextInt();
        console.nextLine();

        Aluno a = alunoDao.findById(id);

        if (a == null) {
            System.out.println("Aluno não encontrado!");
        } else {
            System.out.print("|     Novo Nome: ");
            a.setNome(console.nextLine());

            System.out.print("|     Nova Matrícula: ");
            a.setMatricula(console.nextLine());

            alunoDao.update(a);
            System.out.println("Aluno atualizado com sucesso!");
        }

        console.nextLine();
        return console;
    }

    private static Scanner excluir(Scanner console) {

        System.out.println("\n\n### Aluno-Excluir ###");
        System.out.println("=========================");

        System.out.print("|     Digite o ID do Aluno: ");
        int id = console.nextInt();
        console.nextLine();

        Aluno a = alunoDao.findById(id);

        if (a == null) {
            System.out.println("Aluno não encontrado!");
        } else {
            alunoDao.deleteById(id);
            System.out.println("Aluno excluído com sucesso!");
        }

        console.nextLine();
        return console;
    }

	public static Scanner menuAluno(Scanner console, AlunoDAOImp alunoDAOImp) {
		// TODO Auto-generated method stub
		return null;
	}
}
