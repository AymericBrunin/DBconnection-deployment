package stefan.DBconnectiondeployment.order;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//
@Repository
public interface OrderRepository extends CrudRepository<Order,Integer>{
	
	//use to link this query to this method linking :text to the String text parameter.
	@Query("SELECT t FROM Order t WHERE t.type LIKE %:text%")
	public List<Order> getEngravingOrders(@Param("text") String text);
	
	
	//@Query("SELECT t FROM Order t WHERE t.order = ?:id")
	public List<Order> findByOrder(/*@Param("id")*/ int id);
}
