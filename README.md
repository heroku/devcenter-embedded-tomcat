# Convert a Java Web Application to Use Embedded Tomcat

This tutorial will show you how to convert a Java web application to use embedded Tomcat.

## Prerequisites

* Basic Java knowledge, including an installed version of the JVM and Maven.
* Basic Git knowledge, including an installed version of Git.
* A Java web application. If you don't have one follow the first step to create an example. Otherwise skip that step.

## Create an application if you don't already have one

    :::term
    $ mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
    ...
    [INFO] Generating project in Interactive mode
    Define value for property 'groupId': : com.example
    Define value for property 'artifactId': : helloworld
    
(you can pick any groupId or artifactId). You now have a complete Java web app in the `helloworld` directory.

If you want to skip the conversion steps and start with an app that already uses embedded tomcat you can clone the finished sample and then skip to the 'Deploy Your Application to Heroku' section:

    :::term
    $ git clone git@github.com:heroku/devcenter-embedded-tomcat.git

## Add tomcat  dependencies

In your pom.xml you'll need to add the embedded Tomcat dependencies:

        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-core</artifactId>
            <version>7.0.22</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-logging-juli</artifactId>
            <version>7.0.22</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            <version>7.0.22</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jasper</artifactId>
            <version>7.0.22</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jasper-el</artifactId>
            <version>7.0.22</version>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat</groupId>
            <artifactId>tomcat-jsp-api</artifactId>
            <version>7.0.22</version>
        </dependency>

If you're not using jsp pages you don't need the last 3 entries, just the first 3.

Your application is probably being packaged as a war. We want to package this as an executable jar file so we'll need to remove the packaging element:

    <packaging>war</packaging>

Add the appassembler plugin to your pom.xml:

            <!-- The maven app assembler plugin will generate a script that sets up the classpath and runs your project -->
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>appassembler-maven-plugin</artifactId>
                <version>1.1.1</version>
                <configuration>
                    <assembleDirectory>target</assembleDirectory>
                    <programs>
                        <program>
                            <mainClass>Main</mainClass>
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

The appassembler plugin generates a launch script that automatically sets up your classpath and calls your main method (created below) to launch your application.

## Add a Launcher Class

Create a file called Main.java in your src/main/java directory and put the following in it:

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
 
## Run your Application

To generate the start scripts simply run:

    :::term
    $ mvn package

And then simply run the script:

    :::term
    $ sh target/bin/webapp

That's it. Your application should start up on port 8080 and is now more portable and erosion resistant!

# Deploy your Application to Heroku

## Create a Procfile

You declare how you want your application executed in `Procfile` in the project root. Create this file with a single line:

    :::term
    web: sh target/bin/webapp

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


