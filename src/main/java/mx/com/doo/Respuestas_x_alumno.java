package mx.com.doo;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Respuestas_x_alumno{
	
	@Override
	public String toString() {
		return "Respuestas_x_alumno [idRespuesta_alumno=" + idRespuesta_alumno + ", idExamen=" + idExamen
				+ ", idPregunta=" + idPregunta + ", idRespuesta=" + idRespuesta + ", fecha_respuesta=" + fecha_respuesta
				+ ", usuario=" + usuario + "]";
	}

	public int getIdRespuesta_alumno() {
		return idRespuesta_alumno;
	}

	public void setIdRespuesta_alumno(int idRespuesta_alumno) {
		this.idRespuesta_alumno = idRespuesta_alumno;
	}

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public Date getFecha_respuesta() {
		return fecha_respuesta;
	}

	public void setFecha_respuesta(Date fecha_respuesta) {
		this.fecha_respuesta = fecha_respuesta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@NotNull @Min(1)
	private int idRespuesta_alumno;
	
	@NotNull @Min(1)
	private int idExamen;
	
	@NotNull @Min(1)
	private int idPregunta;
	
	@NotNull @Min(1)
	private int idRespuesta;
	
	@NotEmpty
	private Date fecha_respuesta;
	
	@NotEmpty
	private String usuario;
}