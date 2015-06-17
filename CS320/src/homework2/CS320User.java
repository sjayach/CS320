package homework2;

public class CS320User {
	private String first;
	private String last;
	private String email;
	private String password;
	
	public CS320User(String first, String last, String email, String password) {
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
		
	}
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return first +" " +last;
	}
	

}
