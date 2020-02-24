package domains.patient;
import support.Entity;

public class Patient extends Entity {
	private String name;
	private String document;
	private String email;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	
	public String getDocument() {
		return this.document;
	}

	public void setEmail(String email) {
		// 1. verificar se o email possui @
		
		//if (email.contains("@") != true) {
			//throw new Exception("E-mail is invalid");
		//}
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
