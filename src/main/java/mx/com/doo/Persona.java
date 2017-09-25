package mx.com.doo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Persona {
	

	@NotNull @Min(0)
	private int id;

	@NotEmpty @Size(min=6,max=20)
	private String username;
	
	@NotEmpty @Email
	private String email;
	
	@NotEmpty @Size(min=6,max=20)
	private String nombre;
	
	@NotEmpty @Size(min=6,max=20)
	private String paterno;
	
	@NotEmpty @Size(min=6,max=20)
	private String materno;
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@NotNull @Past
	private Date edad;
	
	@NotNull @Min(0)
	private int grupo;
	
	@NotEmpty @Size(min=6,max=20)
	private String contrasena;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public Date getEdad() {
		return edad;
	}
	public void setEdad(Date edad) {
		this.edad = edad;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", username=" + username + ", email=" + email + ", nombre=" + nombre + ", paterno="
				+ paterno + ", materno=" + materno + ", edad=" + edad + ", grupo=" + grupo + ", contrasena="
				+ contrasena + "]";
	}	
}