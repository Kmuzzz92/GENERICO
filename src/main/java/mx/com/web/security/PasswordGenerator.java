package mx.com.web.security;

import java.io.Serializable; 

public interface PasswordGenerator extends Serializable {

	public String generate();
	
	public String Generate(String nuePass);

}