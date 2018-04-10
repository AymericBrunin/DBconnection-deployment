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
	public Response getOneOrderLot(int id) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();

		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			//order.setStatus("notStarted");
			orders.add(order);
		});
		return Response.ok(mapper.writeValueAsString(orders.get(0).getLot())).header("Access-Control-Allow-Origin", "*").build();
	}


	@Override
	public Response getOneOrderType(int id) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();

		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			//order.setStatus("notStarted");
			orders.add(order);
		});
		return Response.ok(mapper.writeValueAsString(orders.get(0).getType())).header("Access-Control-Allow-Origin", "*").build();
	}


	@Override
	public Response getOneOrderDesc(int id) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();

		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			//order.setStatus("notStarted");
			orders.add(order);
		});
		return Response.ok(mapper.writeValueAsString(orders.get(0).getDescription())).header("Access-Control-Allow-Origin", "*").build();
	}


	@Override
	public Response getOneOrderStatus(int id) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();

		List<Order> orders=new ArrayList<>();
		orderRepository.findByOrder(id).forEach(order-> {
			//order.setStatus("notStarted");
			orders.add(order);
		});
		return Response.ok(mapper.writeValueAsString(orders.get(0).getStatus())).header("Access-Control-Allow-Origin", "*").build();
	}
	

}
