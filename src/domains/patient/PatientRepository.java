package domains.patient;

import java.util.List;
import support.MemoryStorage;

public class PatientRepository {

	final String STORAGE_KEY = "PATIENTS";
	
	public static <T> List<T> castList(@SuppressWarnings("rawtypes") List list) {
		return list;
	}
	
	public List<Patient> getPatients() {
		List<Patient> patients = castList(MemoryStorage.select(STORAGE_KEY));
		return patients;
	}

	public Patient createNewPatient(String name, String email, String document) {
		Patient p = new Patient();
		p.setName(name);
		p.setEmail(email);
		p.setDocument(document);

		MemoryStorage.store("PATIENTS", p);
		return p;
	}

	public Patient updateById(int id, String name, String document, String email) {
		Patient p = new Patient();
		p.setId(id);
		p.setName(name);
		p.setDocument(document);
		p.setEmail(email);

		MemoryStorage.update(STORAGE_KEY, p);

		return p;
	}

	public Patient findById(int id) {
		return (Patient) MemoryStorage.find(STORAGE_KEY, id);
	}

	public boolean removeById(int id) {
		return MemoryStorage.delete(STORAGE_KEY, id);
		
	}

}
