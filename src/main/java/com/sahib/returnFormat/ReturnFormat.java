package com.sahib.returnFormat;

public class ReturnFormat {
	public ReturnFormat(String id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	public String id;
	@Override
	public String toString() {
		return "ReturnFormat [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + "]";
	}
	public String firstname;
	public String lastname;
	public String email;
	public String password;

}
