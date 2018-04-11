package stefan.DBconnectiondeployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import stefan.DBconnectiondeployment.establishConnection.Launch;

@SpringBootApplication
//An opinionated WebApplicationInitializer to run a SpringApplication from a traditional WAR deployment.
//Binds Servlet, Filter and ServletContextInitializer beans from the application context to the server.
public class DBconnectionDeploymentApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//launch the ssh connection (tho')
		Launch.SSHConnect();
		//Add more sources (configuration classes and components) to this application.
		return application.sources(DBconnectionDeploymentApplication.class);
	}

	public static void main(String[] args) {
		//With a primary sources to load here a DBconnectionConfiguration, and 
		// a list of application arguments.
		SpringApplication.run(DBconnectionConfiguration.class, args);
	}
}
