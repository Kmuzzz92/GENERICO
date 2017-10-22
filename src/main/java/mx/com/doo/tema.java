package mx.com.doo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class tema{

	@NotNull @Min(1)
	private int idTema;
	
	@NotEmpty
	private String nombre;

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "tema [idTema=" + idTema + ", nombre=" + nombre + "]";
	}
	
	
}


