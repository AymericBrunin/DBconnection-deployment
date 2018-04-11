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
	/**
	 * The Bus is the central place in CXF. Its primary responsibility is providing access to the different extensions (such as the DestinationFactoryManager,
	 *  ConduitFactoryManager, BindingFactoryManager, etc). Depending on the implementation of the Bus it may also be responsible for wiring up the CXF internals.
	 */
	@Autowired
	private Bus bus;
	
	/**
	 * Refers to stefan.DBconnectondeployment.service package OrderServiceImplementation.java
	 */
	@Autowired
	OrderServiceImplementation dbservice;
	
	/**
	 * Methode qui retourne un serveur 
	 * @return
	 */
	@Bean
    public Server rsServer() {
		//Une extension de bus
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        //Sets the resource beans. If this is set then the JAX-RS runtime will not be responsible for the life-cycle of resource classes.
        // Arrays.<Objct>asList(dbservice) - the list of resource instances
        endpoint.setServiceBeans(Arrays.<Object>asList(dbservice));
        // address est un attribut hérité de AbstractEndpointFactory
        endpoint.setAddress("/api");
        // ajoute une liste d'objet heritant de la classe Feature A VOIR ON COMPREND PAS
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        //crée et retourne l'instance JAX-RS Server
        return endpoint.create();
    }
}
