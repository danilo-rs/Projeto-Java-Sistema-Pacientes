package applications.cli.services.patients;
import java.util.List;

import domains.patient.Patient;
import domains.patient.PatientRepository;

public class ListAllPatientsService {
	public static void run() {
		PatientRepository p = new PatientRepository();
		List<Patient> patients = p.getPatients();
		
		if (patients == null) {
			System.out.println("Não há pacientes cadastrados.");
			return;
		}
		//para cada pacientes em pacientes	
		for (Patient patient : patients) {
			String str = "";
			
			str += "Nome: " + patient.getName() + "\n";
			str += "E-mail: " + patient.getEmail() + "\n";
			str += "Document: " + patient.getDocument() + "\n";
			str += "------------------------------------" +"\n";
			
			System.out.println(str);
		}
	}
}
