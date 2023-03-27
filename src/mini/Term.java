package mini;

public class Term {
	
	private String id;
	private int month;
	
	public Term() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Term(String id, int month) {
		super();
		this.id = id;
		this.month = month;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Term [id=" + id + ", month=" + month + "]";
	}
	
	

}
