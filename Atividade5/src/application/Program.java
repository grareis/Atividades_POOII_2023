package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoDAO;

public class Program {

	public static void main(String[] args) {
		try {
			int opcao = 0;
			Scanner console = new Scanner(System.in);
			AlunoDAO alunoDAO = new AlunoDAO();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			do {
				System.out.println("####### Menu #######\n" 
						+ "1 - Cadastrar\n"
						+ "2 - Listar\n"
						+ "3 - Alterar\n"
						+ "4 - Excluir\n" 
						+ "5 - Sair\n" 
						+ "Opção:");

				opcao = Integer.parseInt(console.nextLine());

				switch (opcao) {
				case 1:
					System.out.println("\n ### Cadastrar Aluno ### \n\r");
					Aluno aluno = new Aluno();
					System.out.print("Nome: ");
					aluno.setNome(console.nextLine());

					System.out.print("Sexo: ");
					aluno.setSexo(console.nextLine());

					System.out.print("Data de Nascimento (dd-mm-aaaa): ");
					aluno.setDt_nasc(LocalDate.parse(console.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));

					alunoDAO.salvar(aluno);
					console.nextLine();
					System.out.println("\n\n\n\n");
					break;

				case 2:
					System.out.println("\n ### Listar Alunos ### \n\r");
					List<Aluno> alunos = alunoDAO.listar();
					for (Aluno a : alunos) {
						System.out.println("ID: " + a.getId());
						System.out.println("Nome: " + a.getNome());
						System.out.println("Sexo: " + a.getSexo());
						System.out.println("Data de Nascimento: " + a.getDt_nasc().format(formato));
						System.out.println();
					}
					break;

				case 3:
					System.out.println("\n ### Alterar Aluno ### \n\r");
					Aluno alunoAlterar = new Aluno();
					System.out.print("ID do aluno a ser alterado: ");
					int idAlterar = Integer.parseInt(console.nextLine());
					alunoAlterar.setId(idAlterar);

					System.out.print("Nome: ");
					alunoAlterar.setNome(console.nextLine());

					System.out.print("Sexo: ");
					alunoAlterar.setSexo(console.nextLine());

					System.out.print("Data de Nascimento (dd-mm-aaaa): ");
					alunoAlterar.setDt_nasc(LocalDate.parse(console.nextLine(), formato));

					alunoDAO.alterar(alunoAlterar);
					System.out.println("\n\n\n\n");
					break;

				case 4:
					System.out.println("\n ### Excluir Aluno ### \n\r");
					System.out.print("ID do aluno a ser excluído: ");
					int idExcluir = Integer.parseInt(console.nextLine());
					alunoDAO.apagar(idExcluir);
					System.out.println("\n\n\n\n");
					break;

				case 5:
					System.out.println("Encerrando o programa...");
					break;

				default:
					System.out.println("Opção inválida! Tente novamente.");
					break;
				}

			} while (opcao != 5);

			console.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
