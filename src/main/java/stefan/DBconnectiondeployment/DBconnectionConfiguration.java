package stefan.DBconnectiondeployment;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import stefan.DBconnectiondeployment.service.OrderServiceImplementation;;

@Configuration
@ComponentScan(basePackages = "stefan.DBconnectiondeployment")
public class DBconnectionConfiguration {

	@Autowired
	private Bus bus;
	
	@Autowired
	OrderServiceImplementation dbservice;

	@Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Arrays.<Object>asList(dbservice));
        endpoint.setAddress("/api");
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }
}
