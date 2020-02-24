package applications.cli.services.patients;

import java.util.Scanner;

import domains.patient.Patient;
import domains.patient.PatientRepository;

public class UpdatePatientByIdService {

	public static void run() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o código do paciente");
		int codigo = scanner.nextInt();
		
		PatientRepository r = new PatientRepository();
		Patient p = r.findById(codigo);
		scanner.nextLine();
		System.out.println("Novo nome do paciente: ("+ p.getName() +"):");
		String name = scanner.nextLine();
		
		System.out.println("Novo email do paciente: ("+ p.getEmail() +"):");
		String email = scanner.nextLine();
		
		System.out.println("Novo CPF do paciente: ("+ p.getDocument() +"):");
		String document = scanner.nextLine();
		
		r = new PatientRepository();
		r.updateById(codigo, name, document, email);
		
		System.out.println("OK. Paciente atualizado com sucesso.");
	}
}
