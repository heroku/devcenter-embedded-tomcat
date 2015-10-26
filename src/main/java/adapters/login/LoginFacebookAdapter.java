
package adapters.login;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import javax.servlet.http.HttpServletRequest;


public class LoginFacebookAdapter implements LoginAdapter{

    @Override
    public String login(HttpServletRequest request) throws Exception {
        
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("", "");
        request.getSession().setAttribute("facebook", facebook);

        StringBuffer callbackUrl = request.getRequestURL();
        int index = callbackUrl.lastIndexOf("/");
        callbackUrl.replace(index, callbackUrl.length(), "").append("/login-facebook-callback");

        return facebook.getOAuthAuthorizationURL(callbackUrl.toString());

    }

    @Override
    public void verificarLogin(HttpServletRequest request) throws Exception {

        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");

        String oauthCode = request.getParameter("code");
        facebook.getOAuthAccessToken(oauthCode);
    }

  
    
    
}
