package mini;

public class Member {
	
	//필드
	private String id;
	private String name;
	private String phone;
	private String home;
	private int month;
	


	public Member(String id, String name, String phone, String home, int month) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.home = home;
		this.month = month;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", phone=" + phone + ", home=" + home + ", month=" + month + "]";
	}
	
	
	
	
	

}
