package cpp.cs3560.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import cpp.cs3560.model.Shipment;
import cpp.cs3560.model.Shipper;

/**
 * 
 * @author haohuynh
 * 
 *         A Hibernate controller to manage all Data Access Objects
 */
public class ModelController {

	/**
	 * Hibernate Configuration File Name
	 */
	private static final String HIBERNATE_CONF_FILE = "hibernate.cfg.xml";

	/**
	 * Hibernate Running Package
	 */
	private static final String HIBERNATE_PACKAGE = "cpp.cs3560.model";

	/**
	 * A salt for the SHA-512
	 */
	private static final String SALT = "FiveStartUsersFall2019";

	/**
	 * CPP email post fix
	 */
	private static final String EMAIL_POSTFIX = "@cpp.edu";

	/**
	 * Multiple delimiters R.E.
	 */
	private static final String DELIMITERS = "[\\s\\t\\[\\]\\{\\}\\(\\)\\*\\/.,!@_#$:]+";

	/**
	 * A session factory for the class Shipper <-> table Shipper
	 */
	@SuppressWarnings("unused")
	private static SessionFactory shipperFactory;

	/**
	 * A session factory for the class Shipment <-> table Shipment
	 */
	@SuppressWarnings("unused")
	private static SessionFactory shipmentFactory;

	/**
	 * A singleton Hibernate Model Controller
	 */
	private static ModelController modelController = null;

	/**
	 * A default constructor for initializing all the factories
	 */
	@SuppressWarnings("deprecation")
	private ModelController() {
		/**
		 * Initializing all the factories for Hibernate framework
		 */
		shipperFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(Shipper.class).buildSessionFactory();

		shipmentFactory = new Configuration().configure(HIBERNATE_CONF_FILE).addPackage(HIBERNATE_PACKAGE)
				.addAnnotatedClass(Shipment.class).buildSessionFactory();

	}

	/**
	 * Singleton Access Method
	 * 
	 * @return a instance of ModelController
	 */
	public static ModelController getInstance() {
		if (modelController == null) {
			modelController = new ModelController();
		}
		return modelController;
	}

	/**
	 * To find a shipper that have the Bronco ID and password like username and
	 * passphrase
	 */
	@SuppressWarnings("unchecked")
	public static Shipper getShipper(String username, String passphrase) {
		Session session = shipperFactory.openSession();
		Transaction tx = null;
		Shipper shipper = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Shipper.class);

			criteria.add(Restrictions.like("emailAddress", username + EMAIL_POSTFIX));

			for (Iterator<Shipper> iterator = criteria.list().iterator(); iterator.hasNext();) {
				shipper = ((Shipper) iterator.next());
				if (!getHashedPassphrase(passphrase).equals(shipper.getPassPhrase())) {
					shipper = null;
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.err.println(e.toString());
		} catch (Exception ee) {
			System.err.println(ee.toString());
		} finally {
			session.close();
		}
		return shipper;
	}

	/**
	 * To find a shipper having the Bronco ID like username and update his/her info
	 */
	public static Shipper updateShipper(String username, String otp) {
		Session session = shipperFactory.openSession();
		Transaction tx = null;
		Shipper shipper = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Shipper.class);

			criteria.add(Restrictions.like("emailAddress", username + EMAIL_POSTFIX));

			shipper = ((Shipper) criteria.list().iterator().next());

			if (shipper != null) {
				shipper.setPassPhrase(getHashedPassphrase(otp));
				session.update(shipper);
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			return null;
		} catch (Exception ee) {
			return null;
		} finally {
			session.close();
		}
		return shipper;
	}

	/**
	 * To find a shipper that satisfies the seaching criteria
	 */
	@SuppressWarnings("unchecked")
	public static Set<Shipper> listShipper() {
		Session session = shipperFactory.openSession();
		Transaction tx = null;
		Set<Shipper> results = new HashSet<Shipper>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Shipper.class);

			for (Iterator<Shipper> iterator = criteria.list().iterator(); iterator.hasNext();) {
				results.add(((Shipper) iterator.next()));

			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			return new HashSet<Shipper>();

		} catch (Exception ee) {
			return new HashSet<Shipper>();

		} finally {
			session.close();
		}
		return results;
	}

	/**
	 * To find a new shipment in the system
	 */
	@SuppressWarnings("unchecked")
	public static Set<Shipment> listNewShipment() {
		Session session = shipmentFactory.openSession();
		Transaction tx = null;
		Set<Shipment> results = new HashSet<Shipment>();

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Shipment.class);

			criteria.add(Restrictions.like("shippingStatus", WebController.NEW_SHIPMENT));

			for (Iterator<Shipment> iterator = criteria.list().iterator(); iterator.hasNext();) {
				results.add(((Shipment) iterator.next()));

			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			return new HashSet<Shipment>();

		} catch (Exception ee) {
			return new HashSet<Shipment>();

		} finally {
			session.close();
		}
		return results;
	}

	/**
	 * Hash the pass phrase into a hashed code
	 * 
	 * @param passphrase
	 * 
	 */
	public static String getHashedPassphrase(String passphrase) {
		String hashedCode = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(SALT.getBytes(StandardCharsets.UTF_8));

			byte[] bytes = messageDigest.digest(passphrase.getBytes(StandardCharsets.UTF_8));
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			hashedCode = stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e.toString());
		}
		return hashedCode;
	}

	public static void main(String[] args) {
		Shipper shipper = ModelController.getInstance().getShipper("hahuynh", "asd");
		System.out.println(shipper.getShipments());
	}

}
