package view;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import model.dao.DisciplinaDAO;
import model.dao.FactoryDAO;
import model.entities.Disciplina;

public class TelaDisciplina {

    static DisciplinaDAO disciplinaDao = FactoryDAO.createDisciplinaDAO();

    @SuppressWarnings("resource")
    public static Scanner menuDisciplina(Scanner console) throws InterruptedException, ParseException {

        int opcao = 0;
        do {
            System.out.println("\n\n### Tela: Disciplina ###");
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
                    System.out.println("Inválido!");
                    TimeUnit.SECONDS.sleep(1);
            }
        } while (opcao != 0);
        return console;
    }

    private static Scanner cadastrar(Scanner console) throws ParseException {

        Disciplina d = new Disciplina();

        System.out.println("\n\n### Disciplina-Cadastrar ###");
        System.out.println("=========================");

        System.out.print("|     Nome: ");
        d.setNomeDisciplina(console.nextLine());

        System.out.print("|     Carga Horária: ");
        d.setCargaHoraria(console.nextInt());
        console.nextLine();

        System.out.println("=========================");

        disciplinaDao.insert(d);

        console.nextLine();
        return console;
    }

    private static Scanner listar(Scanner console) {

        List<Disciplina> disciplinas = disciplinaDao.findAll();

        System.out.println("\n\n### Disciplina-Listar ###");
        System.out.println("=========================");

        for (Disciplina d : disciplinas) {
            System.out.println("|     ID: " + d.getIdDisciplina());
            System.out.println("|     Nome: " + d.getNomeDisciplina());
            System.out.println("|     Carga Horária: " + d.getCargaHoraria());
            System.out.println("=========================");
        }

        console.nextLine();
        return console;
    }

    private static Scanner alterar(Scanner console) {

        System.out.println("\n\n### Disciplina-Alterar ###");
        System.out.println("=========================");

        System.out.print("|     Digite o ID da Disciplina: ");
        int id = console.nextInt();
        console.nextLine();

        Disciplina d = disciplinaDao.findById(id);

        if (d == null) {
            System.out.println("Disciplina não encontrada!");
        } else {
            System.out.print("|     Novo Nome: ");
            d.setNomeDisciplina(console.nextLine());

            System.out.print("|     Nova Carga Horária: ");
            d.setCargaHoraria(console.nextInt());
            console.nextLine();

            disciplinaDao.update(d);
            System.out.println("Disciplina atualizada com sucesso!");
        }

        console.nextLine();
        return console;
    }

    private static Scanner excluir(Scanner console) {

        System.out.println("\n\n### Disciplina-Excluir ###");
        System.out.println("=========================");

        System.out.print("|     Digite o ID da Disciplina: ");
        int id = console.nextInt();
        console.nextLine();

        Disciplina d = disciplinaDao.findById(id);

        if (d == null) {
            System.out.println("Disciplina não encontrada!");
        } else {
            disciplinaDao.deleteById(id);
            System.out.println("Disciplina excluída com sucesso!");
        }

        console.nextLine();
        return console;
    }
}
