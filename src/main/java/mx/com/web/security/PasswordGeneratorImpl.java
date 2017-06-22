package mx.com.web.security;

/*
 $LastChangedDate: $ 
 $LastChangedRevision: $ 
 $LastChangedBy: $
 */

//import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class represents the implementation of Password Generator Interface
 * 
 * Random password generator
 * @author Victor Garcia
 * @version 1.0.0 created on: December 19 2011
 * 
 */

@Service
@Transactional(readOnly=true)
public class PasswordGeneratorImpl implements PasswordGenerator {

	/**
	 * @since 1.0.0
	 */

	private static final long serialVersionUID = 810877727051961206L;
	
	/**
	 * @since 1.0.0
	 */
	private static final Logger log = Logger.getLogger(PasswordGeneratorImpl.class);

	/**
	 * Data dictionary for password generation
	 * 
	 * @since 1.0.0
	 */

	private static final String alphabet = "JybLtWzc%D8ZCE01Bw/5a@e,3$R;A(Yko|2_GP#h&i-6HF4mdSxKIXsfQrTvVjg7Oq)l+9pM";

	/**
	 * Password length
	 * 
	 * @since 1.0.0
	 */

	private int passlength = 5;


	/**
	 * Get password length
	 * 
	 * <p style="color:red"><span style="font-weight:bold;">Notice:</span> Default length is 12</p>
	 * @since 1.0.0
	 * @return
	 */
	public int getPasslength() {
		return passlength;
	}

	/**
	 * Set password length
	 * 
	 * @since 1.0.0
	 * @param password length
	 */

	public void setPasslength(int passlength) {
		this.passlength = passlength;
	}

	/**
	 * Generate random password
	 * 
	 * @since 1.0.0
	 */
	@Override
	public String generate() {
		log.trace("Generating password");
		Random random = null;

		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			log.trace("Using secure mechanism");
		} catch (NoSuchAlgorithmException e) {
			random = new Random(810877727051961206L);
			log.trace("Using default mechanism");
		}

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < passlength; i++) {
			if (log.isTraceEnabled()) {
				log.trace(String.format("\t\tIteration: %d", i));
			}
			int tmp = random.nextInt(alphabet.length());
			char c = alphabet.charAt(tmp);
			sb.append(c);
		}
		
		return sb.toString();
	}

	public String Generate(String nuePass){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(nuePass);
	}
}
