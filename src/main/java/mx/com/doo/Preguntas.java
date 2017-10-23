package mx.com.doo;

import java.util.Arrays;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Preguntas{
	
	@NotNull @Min(1)
	private long idPregunta;
	
	@NotEmpty
	private String texto;
	
	@NotEmpty
	private String usuario;
	
	@NotNull @Min(1)
	private int nivel;
	
	@NotNull @Min(1)
	private int tema;
	
	@NotEmpty
	private Respuestas respuestas[];
	
	private long respuesta;
	
	public Respuestas[] getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Respuestas[] respuestas) {
		this.respuestas = respuestas;
	}

	public long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public long getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(long respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Preguntas [idPregunta=" + idPregunta + ", texto=" + texto + ", usuario=" + usuario + ", nivel=" + nivel
				+ ", tema=" + tema + ", respuestas=" + Arrays.toString(respuestas) + ", respuesta=" + respuesta + "]";
	}
	
}