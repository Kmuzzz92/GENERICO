package mx.com.doo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Respuestas{
	
	@NotNull @Min(1)
	private int idRespuestas;
	
	@NotEmpty
	private String texto;
	
	@NotNull @Min(1)
	private int idPregunta;
	
	@NotNull @Min(1)
	private int orden;
	
	@NotNull
	private boolean correcto;
	
	@NotEmpty
	private String usuario;

	public int getIdRespuestas() {
		return idRespuestas;
	}

	public void setIdRespuestas(int idRespuestas) {
		this.idRespuestas = idRespuestas;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Respuestas [idRespuestas=" + idRespuestas + ", texto=" + texto + ", idPregunta=" + idPregunta
				+ ", orden=" + orden + ", correcto=" + correcto + ", usuario=" + usuario + "]";
	}
	
	
}