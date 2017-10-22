package mx.com.doo;

import java.util.Arrays;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Examenes{
	
	@NotNull @Min(1)
	private int idExamen;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String usuario;
	
	@NotEmpty
	private Date fecha_creacion;
	 
	private Preguntas [] preguntas;
	
	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Preguntas [] getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Preguntas [] preguntas) {
		this.preguntas = preguntas;
	}

	@Override
	public String toString() {
		return "Examenes [idExamen=" + idExamen + ", nombre=" + nombre + ", usuario="
				+ usuario + ", fecha_creacion=" + fecha_creacion + ", preguntas="
				+ Arrays.toString(preguntas) + "]";
	}
}