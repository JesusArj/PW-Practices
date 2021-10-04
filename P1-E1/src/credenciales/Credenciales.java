package credenciales;

public class Credenciales {
	private String User;
	private String Passwd;
	
	public Credenciales(String User, String Passwd) {
		this.User = User;
		this.Passwd = Passwd;
	}
	public Credenciales() {
	}
	public void setUser(String User) {
		this.User = User;
	}
	public void setPasswd(String Passwd) {
		this.Passwd = Passwd;
	}
	public String getUser() {
		return this.User;
	}
	public String getPasswd() {
		return this.Passwd;
	}
}
