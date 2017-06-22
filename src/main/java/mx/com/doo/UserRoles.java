package mx.com.doo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserRoles{

	@NotEmpty @Size(min=6,max=20)
	public String username;
	
	@NotEmpty @Size(min=6,max=45)
	public String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserRoles [username=" + username + ", role=" + role + "]";
	}
	
	
}