package cpp.cs3560.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cpp.cs3560.model.Shipper;

@Controller
public class WebController {

	/**
	 * Default One Time Passphrase Length
	 */
	private static final int OTP_LENGTH = 20;

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

		/*
		 * Handle updated OfficeHours
		 */
		if ((username == null) && (passphrase == null)) {
			ModelAndView postModels = new ModelAndView("edit");
			postModels.addObject("message", "Test Post method");
			return postModels;
		}

		/*
		 * Username && passphrase verification
		 */
		Shipper shipper = ModelController.getInstance().getShipper(username, passphrase);
		if (shipper != null) {
			ModelAndView editModels = new ModelAndView("edit");
			editModels.addObject("shipper", shipper);
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
