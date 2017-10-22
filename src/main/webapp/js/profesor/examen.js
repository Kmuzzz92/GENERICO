function Respuesta(){
	this.texto="";
	this.orden=0;
	this.correcto=false;
	this.idPregunta=0;
}

function Pregunta(){
	this.texto="";
	this.respuestas=[];
	this.nivel=0;
	this.tema=0;
}

function Examen(){
	this.idExamen=0;
	this.nombre="";
	this.fecha_creacion= new Date();
	this.preguntas=[];
}