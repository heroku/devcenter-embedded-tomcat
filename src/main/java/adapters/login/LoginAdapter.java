
package adapters.login;

import javax.servlet.http.HttpServletRequest;


public interface LoginAdapter {
  
 String login(HttpServletRequest request) throws Exception;
 
 void verificarLogin(HttpServletRequest request) throws  Exception;
    
    
    
}
