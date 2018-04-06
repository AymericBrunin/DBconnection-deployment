package stefan.DBconnectiondeployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import stefan.DBconnectiondeployment.establishConnection.Launch;

@SpringBootApplication
public class DBconnectionDeploymentApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		Launch.SSHConnect();
		return application.sources(DBconnectionDeploymentApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DBconnectionConfiguration.class, args);
	}
}
