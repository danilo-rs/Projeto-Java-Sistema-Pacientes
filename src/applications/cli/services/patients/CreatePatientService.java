package applications.cli.services.patients;

import java.util.Scanner;

import domains.patient.Patient;
import domains.patient.PatientRepository;

public class CreatePatientService {
	public static void run() {
		// Criar um novo paciente...
		
		// 1. Coleta as informações que serão salvas
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe o nome do paciente:");
		String name = scanner.nextLine();
		
		System.out.println("Informe o e-mail do paciente:");
		String email = scanner.nextLine();
		
		System.out.println("Informe o CPF do paciente:");
		String document = scanner.nextLine();
		
		
		// 2. Salva o novo paciente
		PatientRepository r = new PatientRepository();
		Patient p1 = r.createNewPatient(name, email, document);
		
		System.out.println("");
		
		if (p1 == null) {
			System.out.println("Erro ao criar paciente");
			return;
		}
		System.out.println("OK. Paciente com o ID #"+ p1.getId()+ "criado com sucesso!");
	}

}
