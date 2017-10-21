package mx.com.web.security;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	protected Logger log = Logger.getLogger(UrlAuthenticationSuccessHandler.class);
	 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
 
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            log.trace("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    /** Builds the target URL according to the logic defined in the main class Javadoc. */
    protected String determineTargetUrl(Authentication authentication) {
        Date date = new Date();
        String permisos = "";
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
        	permisos = permisos.concat(grantedAuthority.toString()+",");
        }
        log.trace("El usuario: "+authentication.getName()+" ha ingresado al sistema a las: "+hourdateFormat.format(date));
    	if(permisos.contains("ROLE_USER")){
    		return "/alumno";
    	}else if(permisos.contains("ROLE_PROFE")){
    		return "/profesor/examenes";
    	}else if(permisos.contains("ROLE_ADMIN")){
    		return "/admin/grupos";
    	}else{
    		return "/403";
    	}
    }
 
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}