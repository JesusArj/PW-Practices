package business.DTOs;

public class UsersLogDTO {
	private String mail;
	private String passwd;
	
	public UsersLogDTO() {
		
	}
	
	public UsersLogDTO(String mail, String passwd) {
		this.mail = mail;
		this.passwd = passwd;
	}
	
	public String getMail() {
		return this.mail;
	}
	public String getPasswd() {
		return this.passwd;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
