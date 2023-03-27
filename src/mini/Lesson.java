package mini;

public class Lesson {

	private String subject;
	


	public Lesson(String subject) {
		this.subject = subject;
	}



	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	@Override
	public String toString() {
		return "Lesson [subject=" + subject + "]";
	}

	
	
	

}
