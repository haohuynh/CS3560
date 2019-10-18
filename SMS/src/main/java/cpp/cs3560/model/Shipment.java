package cpp.cs3560.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Shipment")
public class Shipment {

	@Id
	@Column(name = "TrackingNumber")
	private Integer trackingNumber;

	@Column(name = "DateTimeReceive")
	private String dateTimeReceive;

	@Column(name = "DateTimeDelivery")
	private String dateTimeDelivery;

	@Column(name = "DeliveryLocation")
	private String deliveryLocation;

	@Column(name = "ContactName")
	private String contactName;

	@Column(name = "ContactPhoneNumber")
	private String contactPhoneNumber;

	@Column(name = "Cost")
	private Double cost;

	@Column(name = "BroncoID")
	private String broncoID;

	@Column(name = "ShippingStatus")
	private String shippingStatus;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "TrackingNumber")
	private Set<FoodOrderItem> foodOrderItems;

	public Shipment(Integer trackingNumber, String dateTimeReceive, String dateTimeDelivery, String deliveryLocation,
			String contactName, String contactPhoneNumber, Double cost, String broncoID, String shippingStatus,
			Set<FoodOrderItem> foodOrderItems) {
		super();
		this.trackingNumber = trackingNumber;
		this.dateTimeReceive = dateTimeReceive;
		this.dateTimeDelivery = dateTimeDelivery;
		this.deliveryLocation = deliveryLocation;
		this.contactName = contactName;
		this.contactPhoneNumber = contactPhoneNumber;
		this.cost = cost;
		this.broncoID = broncoID;
		shippingStatus = shippingStatus;
		this.foodOrderItems = foodOrderItems;
	}

	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the trackingNumber
	 */
	public Integer getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(Integer trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	/**
	 * @return the dateTimeReceive
	 */
	public String getDateTimeReceive() {
		return dateTimeReceive;
	}

	/**
	 * @param dateTimeReceive the dateTimeReceive to set
	 */
	public void setDateTimeReceive(String dateTimeReceive) {
		this.dateTimeReceive = dateTimeReceive;
	}

	/**
	 * @return the dateTimeDelivery
	 */
	public String getDateTimeDelivery() {
		return dateTimeDelivery;
	}

	/**
	 * @param dateTimeDelivery the dateTimeDelivery to set
	 */
	public void setDateTimeDelivery(String dateTimeDelivery) {
		this.dateTimeDelivery = dateTimeDelivery;
	}

	/**
	 * @return the deliveryLocation
	 */
	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	/**
	 * @param deliveryLocation the deliveryLocation to set
	 */
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return the contactPhoneNumber
	 */
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	/**
	 * @param contactPhoneNumber the contactPhoneNumber to set
	 */
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	/**
	 * @return the cost
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	/**
	 * @return the broncoID
	 */
	public String getBroncoID() {
		return broncoID;
	}

	/**
	 * @param broncoID the broncoID to set
	 */
	public void setBroncoID(String broncoID) {
		this.broncoID = broncoID;
	}

	/**
	 * @return the shippingStatus
	 */
	public String getShippingStatus() {
		return shippingStatus;
	}

	/**
	 * @param shippingStatus the shippingStatus to set
	 */
	public void setShippingStatus(String shippingStatus) {
		shippingStatus = shippingStatus;
	}

	/**
	 * @return the foodOrderItems
	 */
	public Set<FoodOrderItem> getFoodOrderItems() {
		return foodOrderItems;
	}

	/**
	 * @param foodOrderItems the foodOrderItems to set
	 */
	public void setFoodOrderItems(Set<FoodOrderItem> foodOrderItems) {
		this.foodOrderItems = foodOrderItems;
	}

}
