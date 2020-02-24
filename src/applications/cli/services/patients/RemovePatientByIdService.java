package applications.cli.services.patients;

import java.util.Scanner;

import domains.patient.Patient;
import domains.patient.PatientRepository;

public class RemovePatientByIdService {
	
	public static void run() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe o código do cliente:");
		int codigo = scanner.nextInt();
		
		PatientRepository r = new PatientRepository();
		r.removeById(codigo);
		System.out.println("Paciente deletado com sucesso.");
	}
}
