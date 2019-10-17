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
@Table(name = "Shipper")
public class Shipper {

	@Id
	@Column(name = "BroncoID")
	private String broncoID;

	@Column(name = "Name")
	private String name;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "EmailAddress")
	private String emailAddress;

	@Column(name = "PassPhrase")
	private String passPhrase;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "BroncoID")
	private Set<Shipment> shipments;

	public Shipper(String broncoID, String name, String phoneNumber, String emailAddress, String passPhrase,
			Set<Shipment> shipments) {
		super();
		this.broncoID = broncoID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.passPhrase = passPhrase;
		this.shipments = shipments;
	}

	public Shipper() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the passPhrase
	 */
	public String getPassPhrase() {
		return passPhrase;
	}

	/**
	 * @param passPhrase the passPhrase to set
	 */
	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}

	/**
	 * @return the shipments
	 */
	public Set<Shipment> getShipments() {
		return shipments;
	}

	/**
	 * @param shipments the shipments to set
	 */
	public void setShipments(Set<Shipment> shipments) {
		this.shipments = shipments;
	}

}
