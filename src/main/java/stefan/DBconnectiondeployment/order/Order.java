package stefan.DBconnectiondeployment.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VW_ABARBEITUNGSLISTE")
public class Order {

	@Column(name="AS_AA080_MENGE")
	private int lot;
	
	@Id
	@Column(name="CH_ID")
	private int order;
	
	@Column(name="ART_NR")
	private String type;

	@Column(name="AS_AA065_ANWEISUNG")
	private String description;

	@Column(name="AS_SCHRITT")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getLot() {
		return lot;
	}

	public void setLot(int lot) {
		this.lot = lot;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		description = description.replace("<p>", "");
		description = description.replace("</p>", "");
		description = description.replace("<br />", "");
		description = description.replace(";", "");
		
		return description;
	}

	public void setDescription(String description) {
		
		this.description = description;
	}
	
    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

	public boolean equals(Object u) {
		return this.order == ((Order) u).order || this.lot == ((Order) u).lot
				|| description.equals(((Order) u).description);
	}

	public String toString() {
		return "(Object): " + order + "," + description + ", type : " + type + ". Lot : " + lot + ", Status: " + status;
	}
	
	public String[] toArray(){
    	String[] result = new String[getColumnCount()];
    	result[0] = ""+getOrder();
    	result[1] = ""+getLot();
    	result[2] = getType();
    	result[3] = getDescription();
    	result[4] = getStatus();
    	return result;
    }

}
