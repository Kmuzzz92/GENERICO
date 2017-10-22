package mx.com.doo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Examenes_x_alumno{
	
	@NotNull @Min(1)
	private long idExamen_alumno;
	
	@NotNull @Min(1)
	private int idExamen;
	
	@NotEmpty
	private String usuario;
	
	@NotEmpty
	private Date fecha_asignacion;

	public long getIdExamen_alumno() {
		return idExamen_alumno;
	}

	public void setIdExamen_alumno(int idExamen_alumno) {
		this.idExamen_alumno = idExamen_alumno;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_asignacion() {
		return fecha_asignacion;
	}

	public void setFecha_asignacion(Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}

	@Override
	public String toString() {
		return "Examenes_x_alumno [idExamen_alumno=" + idExamen_alumno + ", idExamen=" + idExamen + ", usuario="
				+ usuario + ", fecha_asignacion=" + fecha_asignacion + "]";
	}
	
	
	
	
}