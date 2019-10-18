package cpp.cs3560.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cpp.cs3560.model.Shipment;
import cpp.cs3560.model.Shipper;

@Controller
public class WebController {

	/**
	 * Default One Time Passphrase Length
	 */
	private static final int OTP_LENGTH = 20;

	/**
	 * One of Four Shipping Status
	 */
	private static final String COMPLETED_SHIPMENT = "Completed";

	/**
	 * One of Four Shipping Status
	 */
	private static final String CLOSING_SHIPMENT = "Closing";

	/**
	 * One of Four Shipping Status
	 */
	private static final String ASSIGNED_SHIPMENT = "Delivery Pending";

	/**
	 * One of Four Shipping Status
	 */
	public static final String NEW_SHIPMENT = "In-Transit";

	/**
	 * A valid shipper
	 */
	private Shipper shipper;

	/**
	 * Faculties want to reset their passwords
	 * 
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String showResetPage() {
		return "reset";
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView processReset(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = null;
		String otp = RandomStringUtils.random(OTP_LENGTH, true, true);

		Shipper shipper = ModelController.getInstance().updateShipper(request.getParameter("username"), otp);

		if (shipper != null) {
			MailHelper.getInstance().send(shipper.getName(), shipper.getEmailAddress(), otp);
			mv = new ModelAndView("login");
			mv.addObject("message", "Please check your email for a new passphrase: ");
			mv.addObject("email", shipper.getEmailAddress());
		} else {
			mv = new ModelAndView("reset");
			mv.addObject("error", "Your Bronco ID does not exist in this system!");
		}

		return mv;
	}

	/**
	 * Faculties request the login page
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	/**
	 * Handle login process
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView processLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String passphrase = request.getParameter("passphrase");
		Set<Shipment> assignedShipments = new HashSet<Shipment>();
		Set<Shipment> closingShipments = new HashSet<Shipment>();
		Set<Shipment> completeShipments = new HashSet<Shipment>();

		/*
		 * Handle updated SMS
		 */
		if ((username == null) && (passphrase == null)) {
			String newTrackingNumber = request.getParameter("assign");
			String oldTrackingNumber = request.getParameter("edit");
			ModelAndView postModels = new ModelAndView("edit");

			if (newTrackingNumber != null) {
				Shipment newShipment = ModelController.getInstance().getShipment(Integer.valueOf(newTrackingNumber));
				if (newShipment != null) {
					newShipment.setShippingStatus(ASSIGNED_SHIPMENT);
					newShipment.setBroncoID(shipper.getBroncoID());
					ModelController.getInstance().updateShipment(newShipment);
					shipper = ModelController.getInstance().getShipper(shipper.getEmailAddress());
				}

			} else if (oldTrackingNumber != null) {

				String receiveStamp = request.getParameter("receiveStamp");
				String deliveryStamp = request.getParameter("deliveryStamp");

				if (receiveStamp.equals("") || deliveryStamp.equals("")) {
					postModels.addObject("message", "Please enter all the DateTimes!");
				} else {
					
					if (deliveryStamp.compareTo(receiveStamp) < 0) {
						postModels.addObject("message", "Delivery DateTime!");
					} else {
						
						Shipment oldShipment = ModelController.getInstance()
								.getShipment(Integer.valueOf(oldTrackingNumber));

						if (oldShipment != null) {
							oldShipment.setDateTimeReceive(receiveStamp);
							oldShipment.setDateTimeDelivery(deliveryStamp);
							oldShipment.setShippingStatus(CLOSING_SHIPMENT);
							ModelController.getInstance().updateShipment(oldShipment);
							shipper = ModelController.getInstance().getShipper(shipper.getEmailAddress());
						}

					}
				}

			}
			
			Set<Shipment> shipments = shipper.getShipments();

			for (Shipment shipment : shipments) {
				if (shipment.getShippingStatus().equals(COMPLETED_SHIPMENT)) {
					completeShipments.add(shipment);

				} else if (shipment.getShippingStatus().equals(CLOSING_SHIPMENT)) {
					closingShipments.add(shipment);

				} else { // Assigned Shipments
					assignedShipments.add(shipment);
				}
			}

			postModels.addObject("shipper", shipper);
			postModels.addObject("completeShipments", completeShipments);
			postModels.addObject("closingShipments", closingShipments);
			postModels.addObject("assignedShipments", assignedShipments);
			postModels.addObject("newShipments", ModelController.getInstance().listNewShipment());
			return postModels;
		}

		/*
		 * Username && passphrase verification
		 */
		shipper = ModelController.getInstance().getShipper(username, passphrase);
		if (shipper != null) {
			ModelAndView editModels = new ModelAndView("edit");
			Set<Shipment> shipments = shipper.getShipments();

			for (Shipment shipment : shipments) {
				if (shipment.getShippingStatus().equals(COMPLETED_SHIPMENT)) {
					completeShipments.add(shipment);

				} else if (shipment.getShippingStatus().equals(CLOSING_SHIPMENT)) {
					closingShipments.add(shipment);

				} else { // Assigned Shipments
					assignedShipments.add(shipment);
				}
			}

			editModels.addObject("shipper", shipper);
			editModels.addObject("completeShipments", completeShipments);
			editModels.addObject("closingShipments", closingShipments);
			editModels.addObject("assignedShipments", assignedShipments);
			editModels.addObject("newShipments", ModelController.getInstance().listNewShipment());
			return editModels;
		}

		/*
		 * Handle invalid validation
		 */
		ModelAndView loginModel = new ModelAndView("login");
		loginModel.addObject("error", "Invalid Username/Passphrase!");
		return loginModel;

	}

}
