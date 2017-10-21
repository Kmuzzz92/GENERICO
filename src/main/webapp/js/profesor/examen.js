function Respuesta(){
	this.texto="";
	this.idPregunta=0;
	this.orden=0;
	this.correcto=false;
}

function Pregunta(){
	this.idExamen=0;
	this.texto="";
	this.respuestas=[];
}

function Examen(){
	this.nombre="";
	this.descripcion="";
	this.activo=0;
	this.fecha_creacion= new Date();
	this.preguntas=[];
}