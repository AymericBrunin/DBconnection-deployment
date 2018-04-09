package stefan.DBconnectiondeployment.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import stefan.DBconnectiondeployment.order.Order;
import stefan.DBconnectiondeployment.order.OrderRepository;


@Api("/laserengraver")
@Path("/laserengraver")
@Component
@PropertySource("classpath:application.yml")
public class OrderServiceImplementation implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	
	@Override
	public Response getAllOrders() throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		List <Order> orders= new ArrayList<Order>();
		orderRepository.getEngravingOrders("GRAVIERT")
		.forEach(order-> {
			order.setStatus("notStarted");
			orders.add(order);
		});
		return Response.ok(mapper.writeValueAsString(orders)).header("Access-Control-Allow-Origin", "*").build();
		
	}
	
	
	@Override
	public Response getOneOrder(int id) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
		
		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			order.setStatus("notStarted");
			orders.add(order);
		});
		
		return Response.ok(mapper.writeValueAsString(orders)).header("Access-Control-Allow-Origin", "*").build();
	}
	
	
	@Override
	public void updateStatus(int id,String status) {
		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			order.setStatus(status);
			orders.add(order);
		});
		orderRepository.save(orders.get(0));
	}


	@Override
	public void deleteOrder(int id) {
		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			order.setStatus("Done");
			orders.add(order);
		});
		orderRepository.delete(orders.get(0));
		
	}


	@Override
	public int getOneOrderLot(int id){
		//ObjectMapper mapper=new ObjectMapper();	
		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			order.setStatus("notStarted");
			orders.add(order);
		});
		return orders.get(0).getLot();
	}


	@Override
	public String getOneOrderType(int id){
		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			order.setStatus("notStarted");
			orders.add(order);
		});
		return orders.get(0).getType();
	}


	@Override
	public String getOneOrderDesc(int id){
		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			order.setStatus("notStarted");
			orders.add(order);
		});
		return orders.get(0).getDescription();
	}


	@Override
	public String getOneOrderStatus(int id){
		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			order.setStatus("notStarted");
			orders.add(order);
		});
		return orders.get(0).getStatus();
	}
	

}
