package com.sahib.returnFormat;

public class RequestFormat {
	public String id;
	public String firstname;
	public String lastname;
	public String email;
	public String password;
	@Override
	public String toString() {
		return "RequestFormat [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + "]";
	}
	public RequestFormat(String id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	

}
