package applications.cli;
import java.util.Scanner;

import applications.cli.services.patients.CreatePatientService;
import applications.cli.services.patients.FindPatientByIdService;
import applications.cli.services.patients.ListAllPatientsService;
import applications.cli.services.patients.RemovePatientByIdService;
import applications.cli.services.patients.UpdatePatientByIdService;

public class App {

	static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("SISTEMA DE GESTAO DE PACIENTES");
		System.out.println("*******************************");
		System.out.println("");

		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("");
			System.out.println("O que você deseja fazer? Escolha um número:");
			System.out.println("");
			System.out.println("1. Listar todos os pacientes");
			System.out.println("2. Cria um novo paciente");
			System.out.println("3. Consultar um paciente");
			System.out.println("4. Alterar um paciente");
			System.out.println("5. Deletar um paciente");
			System.out.println("6. Sair");

			int selectedOption = scanner.nextInt();

			if (selectedOption == 6) {
				System.out.println("Sistema finalizado com sucesso.");
				break;
			}
			
			controller(selectedOption);
		}

		scanner.close();
	}

	private static void controller(int option) {

		switch (option) {
		case 1:
			// Listar todos os pacientes
			ListAllPatientsService.run();
			break;

		case 2:
			//Invoca o servico de criação do paciente
			CreatePatientService.run();
			break;
		case 3:
			//Invoca o servico de consulta de paciente pro ID.
			FindPatientByIdService.run();
			break;

		case 4:
			// Alterar um paciente
			UpdatePatientByIdService.run();
			break;

		case 5:
			// Deletar um paciente
			RemovePatientByIdService.run();
			break;

		default:
			System.out.println("Opção inválida.");
			break;
		}
	}
}
