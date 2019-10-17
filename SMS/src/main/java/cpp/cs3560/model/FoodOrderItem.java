package cpp.cs3560.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FoodOrderItem")
public class FoodOrderItem {

	@Id
	@Column(name = "FoodCode")
	private Integer foodCode;

	@Column(name = "OrderNumber")
	private Integer orderNumber;

	@Column(name = "Description")
	private String description;

	@Column(name = "Quantity")
	private Integer quantity;

	@Column(name = "SoldPrice")
	private Double soldPrice;

	@Column(name = "TrackingNumber")
	private Integer trackingNumber;

	public FoodOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodOrderItem(Integer foodCode, Integer orderNumber, String description, Integer quantity, Double soldPrice,
			Integer trackingNumber) {
		super();
		this.foodCode = foodCode;
		this.orderNumber = orderNumber;
		this.description = description;
		this.quantity = quantity;
		this.soldPrice = soldPrice;
		this.trackingNumber = trackingNumber;
	}

	/**
	 * @return the foodCode
	 */
	public Integer getFoodCode() {
		return foodCode;
	}

	/**
	 * @param foodCode the foodCode to set
	 */
	public void setFoodCode(Integer foodCode) {
		this.foodCode = foodCode;
	}

	/**
	 * @return the orderNumber
	 */
	public Integer getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the soldPrice
	 */
	public Double getSoldPrice() {
		return soldPrice;
	}

	/**
	 * @param soldPrice the soldPrice to set
	 */
	public void setSoldPrice(Double soldPrice) {
		this.soldPrice = soldPrice;
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

}
