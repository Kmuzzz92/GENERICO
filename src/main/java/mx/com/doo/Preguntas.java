package mx.com.doo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Preguntas{
	
	@NotNull @Min(1)
	private int idPregunta;
	
	@NotEmpty
	private String texto;
	
	@NotNull
	private int idExamen;
	
	@NotEmpty
	private String Usuario;
	
	public String aux;

	public int getIdPregunta() {
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

	public int getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getAux() {
		return aux;
	}

	public void setAux(String aux) {
		this.aux = aux;
	}

	@Override
	public String toString() {
		return "Preguntas [idPregunta=" + idPregunta + ", texto=" + texto + ", idExamen=" + idExamen + ", Usuario="
				+ Usuario + ", aux=" + aux + "]";
	}
	
	
}