package mx.com.doo;

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
	private String descripcion;
	
	@NotEmpty
	private String usuario;
	
	@NotEmpty
	private Date fecha_creacion;
	
	@NotNull
	private boolean activo;
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "Examenes [idExamen=" + idExamen + ", nombre=" + nombre + ", descripcion=" + descripcion + ", usuario="
				+ usuario + ", fecha_creacion=" + fecha_creacion + ", activo=" + activo + "]";
	}
	
}