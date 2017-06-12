package mx.com.web.security;

/*
 $LastChangedDate: $ 
 $LastChangedRevision: $ 
 $LastChangedBy: $
 */
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;


public interface PasswordGenerator extends Serializable {

	
	public String generate();

}