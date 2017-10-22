app.controller("alumnosCtrl", function($scope,$http,$httpParamSerializerJQLike){
	
	var ctrl = this;
	
	ctrl.grupos = [];
	
	this.inicia=function(){
		if(!jQuery.isEmptyObject(grupos)){
			ctrl.grupos = grupos;
		}
	}
	
	this.inicia();
	
	$(document).ready(function(){
        $(".collapse.g.in").each(function(){
        	$(this).siblings(".panel-heading").find(".glyphicon").addClass("glyphicon-minus").removeClass("glyphicon-plus");
        });
        $(".collapse.g").on('show.bs.collapse.g', function(){
        	$(this).parent().find(".glyphicon").removeClass("glyphicon-plus").addClass("glyphicon-minus");
        }).on('hide.bs.collapse.g', function(){
        	$(this).parent().find(".glyphicon").removeClass("glyphicon-minus").addClass("glyphicon-plus");
        });
    });
	
});