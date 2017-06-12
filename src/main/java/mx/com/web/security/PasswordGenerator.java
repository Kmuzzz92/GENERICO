package mx.com.web.security;

/*
 $LastChangedDate: $ 
 $LastChangedRevision: $ 
 $LastChangedBy: $
 */
import java.io.Serializable;

public interface PasswordGenerator extends Serializable {

	
	public String generate();

}