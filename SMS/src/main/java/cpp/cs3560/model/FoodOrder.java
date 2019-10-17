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
@Table(name = "FoodOrder")
public class FoodOrder {

	@Id
	@Column(name = "OrderNumber")
	private Integer orderNumber;

	@Column(name = "OrderDateTime")
	private String orderDateTime;

	@Column(name = "TotalAmount")
	private Double totalAmount;

	@Column(name = "Tax")
	private Double tax;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "OrderNumber")
	private Set<FoodOrderItem> foodOrderItems;

	public FoodOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodOrder(Integer orderNumber, String orderDateTime, Double totalAmount, Double tax,
			Set<FoodOrderItem> foodOrderItems) {
		super();
		this.orderNumber = orderNumber;
		this.orderDateTime = orderDateTime;
		this.totalAmount = totalAmount;
		this.tax = tax;
		this.foodOrderItems = foodOrderItems;
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
	 * @return the orderDateTime
	 */
	public String getOrderDateTime() {
		return orderDateTime;
	}

	/**
	 * @param orderDateTime the orderDateTime to set
	 */
	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	/**
	 * @return the totalAmount
	 */
	public Double getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the tax
	 */
	public Double getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Double tax) {
		this.tax = tax;
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
