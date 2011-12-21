package launch;
import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import servlet.HelloServlet;

public class Main {

    public static void main(String[] args) throws Exception {

        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();

        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        tomcat.setPort(Integer.valueOf(webPort));

        Context ctx = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        //the context object can be used to configure your server with settings that would normally go in your context.xml
        //ctx.setUseHttpOnly(true);
        
        System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();  
    }
}
