package cpp.cs3560.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.RandomStringUtils;

import com.sun.mail.smtp.SMTPTransport;

public class MailHelper {

	/**
	 * GMAIL SMTP
	 */
	private static final String SMTP_SERVER = "smtp.gmail.com";

	/**
	 * User name for demo only
	 */
	private static final String USERNAME = "maibach.external@gmail.com";

	/**
	 * Pass phrase for demo only
	 */
	private static final String PASSPHRASE = "gautruc1503";

	/**
	 * Email address for demo only
	 */
	private static final String FROM = "maibach.external@gmail.com";

	/**
	 * Default CC_EMAIL_ADDRESS for management only
	 */
	private static final String CC = "hah.ptit@gmail.com";

	/**
	 * Office Hours email subject
	 */
	private static final String SUBJECT = "[CPP-CS3560]: SMS Passphrase Reset!";

	/**
	 * Office Hours email content
	 */
	private static final String CONTENT = "\n\nThank you for applying for SMS. Please use the above passphrase to login to your account. Your username is the same BroncoID."
			+ "\n\n" + "Thank You!\n\n" + "The CS3560 Team\n";

	/**
	 * An email session management
	 */
	private Session session;

	/**
	 * An mail message
	 */
	private Message message;

	/**
	 * MailHelper Singleton pattern
	 */
	private static MailHelper mailHelper = null;

	/**
	 * A default constructor for settings up email configuration
	 */
	private MailHelper() {
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", SMTP_SERVER); // optional, defined in SMTPTransport
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		session = Session.getInstance(prop, null);
		message = new MimeMessage(session);

	}

	public void send(String recipient, String emailAddress, String otp) {

		try {
			message.setFrom(new InternetAddress(FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress, false));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(CC, false));
			message.setSubject(SUBJECT);
			message.setText("\n\nDear " + recipient + "\n\nYour OTP is " + otp + CONTENT);
			message.setSentDate(new Date());

			// Get SMTPTransport
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			t.connect(SMTP_SERVER, USERNAME, PASSPHRASE);
			t.sendMessage(message, message.getAllRecipients());
			t.close();

		} catch (MessagingException e) {
			System.err.println(e.toString());
		}
	}

	/**
	 * Singleton Access Method
	 * 
	 * @return a instance of MailHelper
	 */
	public static MailHelper getInstance() {
		if (mailHelper == null) {
			mailHelper = new MailHelper();
		}
		return mailHelper;
	}

	public static void main(String[] args) {

		System.out.println(RandomStringUtils.random(20, true, true));

	}
}
