package applications.cli.services.patients;

import java.util.Scanner;

import domains.patient.Patient;
import domains.patient.PatientRepository;

public class FindPatientByIdService {
	public static void run() {
		Scanner scanner = new Scanner (System.in);
		
		//Consultar um paciente
		System.out.println("Informe o c�digo do paciente:");
		int codigo = scanner.nextInt();
		
		//Ir ao reposit�rio, requisitar o paciente com o c�digo informado
		PatientRepository r = new PatientRepository();
		Patient p = r.findById(codigo);
		
		if (p == null) {
			System.out.println("Paciente n�o encontrado.");
			return;
		}
		
		System.out.println("");
		System.out.println("===========================");
		System.out.println("ID: "+ p.getId());
		System.out.println("Nome: "+ p.getName());
		System.out.println("CPF: "+ p.getDocument());
		System.out.println("E-mail: "+ p.getEmail());
		System.out.println("===========================");
	}
}
