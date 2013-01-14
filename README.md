# Create a Java Web Application using Embedded Tomcat

This tutorial will show you how to create a simple Java web application using embedded Tomcat.

## Prerequisites

* Basic Java knowledge, including an installed version of the JVM and Maven.
* Basic Git knowledge, including an installed version of Git.
* A Java web application. If you don't have one follow the first step to create an example. Otherwise skip that step.

## Skip The Application Creation

If you want to skip the creation steps you can clone the finished sample and then skip to the 'Deploy Your Application to Heroku' section:

    :::term
    $ git clone git@github.com:heroku/devcenter-embedded-tomcat.git

## Create your pom.xml

Create a folder to hold your app and create a file called pom.xml in the root of that folder with the following contents:

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>com.heroku.sample</groupId>
      <artifactId>embeddedTomcatSample</artifactId>
      <version>1.0-SNAPSHOT</version>
      <name>embeddedTomcatSample Maven Webapp</name>
      <url>http://maven.apache.org</url>
      <properties>
        <tomcat.version>7.0.34</tomcat.version>
      </properties>
      <dependencies>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-core</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-logging-juli</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jasper</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jasper-el</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jsp-api</artifactId>
            <version>${tomcat.version}</version>
        </dependency>
      </dependencies>
      <build>
        <finalName>embeddedTomcatSample</finalName>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>appassembler-maven-plugin</artifactId>
                <version>1.1.1</version>
                <configuration>
                    <assembleDirectory>target</assembleDirectory>
                    <programs>
                        <program>
                            <mainClass>launch.Main</mainClass>
                            <name>webapp</name>
                        </program>
                    </programs>
                </configuration>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>assemble</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
      </build>
    </project>
    
This pom.xml defines the dependencies that you'll need to run Tomcat in an embedded mode. 

The last 3 entries are only required for applications that use JSP files. If you use this technique for an application that doesn't use JSPs then you can just include the first 3 dependencies.

There is also a single plugin defined. The appassembler plugin generates a launch script that automatically sets up your classpath and calls your main method (created below) to launch your application.

## Add a Launcher Class

Create a file called Main.java in your src/main/java/launch directory and put the following in it:

    :::java
    package launch;
    
    import java.io.File;
    import org.apache.catalina.startup.Tomcat;

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
    
            tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
            System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
    
            tomcat.start();
            tomcat.getServer().await();  
        }
    }
    
## Add a Servlet

Create a file called HelloServlet.java in the src/main/java/servlet directory and put the following into it:

    :::java
    package servlet;
    
    import java.io.IOException;
    
    import javax.servlet.ServletException;
    import javax.servlet.ServletOutputStream;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    @WebServlet(
            name = "MyServlet", 
            urlPatterns = {"/hello"}
        )
    public class HelloServlet extends HttpServlet {
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            ServletOutputStream out = resp.getOutputStream();
            out.write("hello heroku".getBytes());
            out.flush();
            out.close();
        }
        
    }
    
This is simple Servlet that uses annotations to configure itself.

## Add a JSP

Create a file called index.jsp in the src/main/webapp directory:

    <html>
        <body>
            <h2>Hello Heroku!</h2>
        </body>
    </html>
 
## Run your Application

To generate the start scripts simply run:

    :::term
    $ mvn package

And then simply run the script:

    :::term
    $ sh target/bin/webapp

That's it. Your application should start up on port 8080. You can see the JSP at http://localhost:8080 and the servlet and http://localhost:8080/hello

# Deploy your Application to Heroku

## Create a Procfile

You declare how you want your application executed in `Procfile` in the project root. Create this file with a single line:

    :::term
    web: sh target/bin/webapp

## Optionally Choose a JDK
By default, OpenJDK 1.6 is installed with your app. However, you can choose to use a newer JDK by specifying `java.runtime.version=1.7` in the `system.properties` file.

Here's what a `system.properties` file looks like:

    :::term
    java.runtime.version=1.7

You can specify 1.6, 1.7, or 1.8 (1.8 is in beta) for Java 6, 7, or 8 (with lambdas), respectively.

## Deploy to Heroku

Commit your changes to Git:

    :::term
    $ git add .
    $ git commit -m "Ready to deploy"

Create the app on the Cedar stack:

    :::term
    $ heroku create --stack cedar
    Creating high-lightning-129... done, stack is cedar
    http://high-lightning-129.herokuapp.com/ | git@heroku.com:high-lightning-129.git
    Git remote heroku added

Deploy your code:

    :::term
    Counting objects: 227, done.
    Delta compression using up to 4 threads.
    Compressing objects: 100% (117/117), done.
    Writing objects: 100% (227/227), 101.06 KiB, done.
    Total 227 (delta 99), reused 220 (delta 98)

    -----> Heroku receiving push
    -----> Java app detected
    -----> Installing Maven 3.0.3..... done
    -----> Installing settings.xml..... done
    -----> executing .maven/bin/mvn -B -Duser.home=/tmp/build_1jems2so86ck4 -s .m2/settings.xml -DskipTests=true clean install
           [INFO] Scanning for projects...
           [INFO]                                                                         
           [INFO] ------------------------------------------------------------------------
           [INFO] Building petclinic 0.1.0.BUILD-SNAPSHOT
           [INFO] ------------------------------------------------------------------------
           ...
           [INFO] ------------------------------------------------------------------------
           [INFO] BUILD SUCCESS
           [INFO] ------------------------------------------------------------------------
           [INFO] Total time: 36.612s
           [INFO] Finished at: Tue Aug 30 04:03:02 UTC 2011
           [INFO] Final Memory: 19M/287M
           [INFO] ------------------------------------------------------------------------
    -----> Discovering process types
           Procfile declares types -> web
    -----> Compiled slug size is 62.7MB
    -----> Launching... done, v5
           http://pure-window-800.herokuapp.com deployed to Heroku

Congratulations! Your web app should now be up and running on Heroku. Open it in your browser with:

    :::term  
    $ heroku open


