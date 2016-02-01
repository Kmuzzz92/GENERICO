package mx.com.web.security;

/*
 $LastChangedDate: $ 
 $LastChangedRevision: $ 
 $LastChangedBy: $
 */
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

/**
 * @author Sergio Gutierrez
 * @version 1.0.0
 * @created 15-Dic-2011 04:23:49 p.m.
 */
public interface PasswordGenerator extends Serializable {

	/**
	 * Returns a password generated based on password validation rules
	 * 
	 * @since 1.0.0
	 * @return the password
	 * @throws NoSuchAlgorithmException 
	 */
	public String generate();

}