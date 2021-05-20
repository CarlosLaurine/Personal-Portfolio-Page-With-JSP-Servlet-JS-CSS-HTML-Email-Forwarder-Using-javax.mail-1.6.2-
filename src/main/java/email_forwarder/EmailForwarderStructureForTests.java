package email_forwarder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class EmailForwarderStructureForTests.
 */
public class EmailForwarderStructureForTests {

	/** The user name. */
	private String userName = "vitorlaurinepinho@gmail.com";
	
	/** The password. */
	private String password = "Megadeth@3625";

	/** The addresses list. */
	private String addressesList = "carlos.pinho@ucsal.edu.br, cvpinhofsa@gmail.com, vitorlaurinepinho@gmail.com";
	
	/** The sender name. */
	private String senderName = "Carlos Laurine - Java Web Developer";
	
	/** The email subject. */
	private String emailSubject = "Test Java Email with javax.mail";
	
	/** The email text. */
	private String emailText = "Hello, this is a Default Test Email from Carlos Laurine!!";

	/**
	 * Instantiates a new email forwarder structure for tests.
	 */
	public EmailForwarderStructureForTests() {

	}

	/**
	 * Instantiates a new email forwarder structure for tests.
	 *
	 * @param addressesList the addresses list
	 * @param senderName the sender name
	 * @param emailSubject the email subject
	 * @param emailText the email text
	 */
	public EmailForwarderStructureForTests(String addressesList, String senderName, String emailSubject, String emailText) {
		this.addressesList = addressesList;
		this.senderName = senderName;
		this.emailSubject = emailSubject;
		this.emailText = emailText;
	}

	/*
	 * Setting the Sending Method with a boolean Parameter to define whether the
	 * email will have HTML content or not, since the sending process will vary
	 * according to this information
	 */

	/**
	 * Send email.
	 *
	 * @param containsHTML the contains HTML
	 * @throws Exception the exception
	 */
	public void sendEmail(boolean containsHTML) throws Exception {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); // Authorization
		properties.put("mail.smtp.starttls", "true"); // Authentication
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Setting Email Server (Google's Gmail)
		properties.put("mail.smtp.port", "465");// Setting Server Port (Standard Google Port 465)
		properties.put("mail.smtp.socketFactory.port", "465");// Specifying the Port to be Connected by the Socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Defining the Socket SMTP
																							// Connection Class

		// Setting an additional Security Authentication Property in order to match
		// Gmail Server's recent Demand Updates

		properties.put("mail.smtp.ssl.trust", "*"); // Setting Authentication with SSL Security

		// Setting javax.mail Session object to perform the Connection (Obtaining a
		// Session Object allowed to send Emails) through receiving the properties
		// Object

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, password);

			}

		});

		// Setting all the Email Addresses to which the mail will be sent in an
		// Address-type Array with a String using Colons as Separators

		Address[] targetMails = InternetAddress.parse(addressesList);

		// Linking the Message object with the Connection Session

		Message msg = new MimeMessage(session);

		// Building Message Configs

		msg.setFrom(new InternetAddress(userName, senderName)); // Setting the Sender (OBS: The second String Parameter
																// at InternetAddress' Constructor is the Sender name
																// which will appear at the Recipients' Mailbox)

		msg.setRecipients(Message.RecipientType.TO, targetMails); // Setting the Recipients

		msg.setSubject(emailSubject); // Setting the Email Subject ("CC:" or Header)

		// Performing the Message Object (Email) Submission

		if (containsHTML) {
			msg.setContent(emailText, "text/html; charset = utf-8"); // Setting the Message Content with the emailText
																		// wrapped in a DataHandler for the specified
																		// type (HTML)
		} else {
			msg.setText(emailText);// Setting the Email PURE Text Content
		}

		// E-mailing the Message (Forwarding)
		Transport.send(msg);

	}

	// Setting Sending Method to Dispatch Emails with Attached Files (in this case,
	// PDF Files)

	/*
	 * OBS: This Method is almost identical to the previous one, except for it split
	 * the email body in two parts (one of them with the PDF file stored and
	 * translated from the FileInputStream object returned from pdfSimulator()
	 * Method, and the other with the textual part), and gather them right after to
	 * perform the Submission
	 */

	/**
	 * Send email with attached file.
	 *
	 * @param containsHTML the contains HTML
	 * @throws Exception the exception
	 */
	public void sendEmailWithAttachedFile(boolean containsHTML) throws Exception {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); // Authorization
		properties.put("mail.smtp.starttls", "true"); // Authentication
		properties.put("mail.smtp.host", "smtp.gmail.com"); // Setting Email Server (Google's Gmail)
		properties.put("mail.smtp.port", "465");// Setting Server Port (Standard Google Port 465)
		properties.put("mail.smtp.socketFactory.port", "465");// Specifying the Port to be Connected by the Socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Defining the Socket SMTP
																							// Connection Class

		// Setting an additional Security Authentication Property in order to match
		// Gmail Server's recent Demand Updates

		properties.put("mail.smtp.ssl.trust", "*"); // Setting Authentication with SSL Security

		// Setting javax.mail Session object to perform the Connection (Obtaining a
		// Session Object allowed to send Emails) through receiving the properties
		// Object

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, password);

			}

		});

		// Setting all the Email Addresses to which the mail will be sent in an
		// Address-type Array with a String using Colons as Separators

		Address[] targetMails = InternetAddress.parse(addressesList);

		// Linking the Message object with the Connection Session

		Message msg = new MimeMessage(session);

		// Building Message Configs

		msg.setFrom(new InternetAddress(userName, senderName)); // Setting the Sender (OBS: The second String Parameter
																// at InternetAddress' Constructor is the Sender name
																// which will appear at the Recipients' Mailbox)

		msg.setRecipients(Message.RecipientType.TO, targetMails); // Setting the Recipients

		msg.setSubject(emailSubject); // Setting the Email Subject ("CC:" or Header)

		// Setting Email Body Part 1, which is the Textual one

		MimeBodyPart textBody = new MimeBodyPart();

		if (containsHTML) {
			textBody.setContent(emailText, "text/html; charset = utf-8"); // Setting the Message Content with the
																			// emailText wrapped in a DataHandler for
																			// the specified type (HTML)
		} else {
			textBody.setText(emailText);// Setting the Email PURE Text Content
		}

		// Setting PDF List
		List<FileInputStream> files = new ArrayList<FileInputStream>();

		files.add(pdfSimulator());
		files.add(pdfSimulator());
		files.add(pdfSimulator());
		files.add(pdfSimulator());

		// Generating Multipart Object to gather both Parts in one and set it at the
		// Message

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(textBody);

		int index = 0;

		for (FileInputStream fileinpInputStream2 : files) {

			// Setting Email Body Part 2, which is the one with the Attached File

			MimeBodyPart attachedFile = new MimeBodyPart();

			// Setting the PDF Simulator (or any other possible File Stored at a DataBase,
			// for instance)
			attachedFile
					.setDataHandler(new DataHandler(new ByteArrayDataSource(fileinpInputStream2, "application/pdf")));
			attachedFile.setFileName("emailattachment-" + index + ".pdf");

			// Gathering both Parts in one and setting it at the Message

			multipart.addBodyPart(attachedFile);

			index++;

		}

		msg.setContent(multipart);

		// E-mailing the Message (Forwarding)
		Transport.send(msg);

	}

	/*
	 * The following method simulates a PDF or any other file that can be sent as an
	 * attachment at the JavaMail. For instance, the file can be get through a
	 * DataBase in Base 64, can be a byte[], or a File Stream. It can be in a
	 * Database or in a Folder
	 * 
	 * OBS: The Method returns a Blank PDF with the Text from the Demo Paragraph
	 * hardcode-inserted below
	 */

	/**
	 * Pdf simulator.
	 *
	 * @return the file input stream
	 * @throws Exception the exception
	 */
	private FileInputStream pdfSimulator() throws Exception {

		Document doc = new Document();
		File file = new File("attachedFile.pdf");
		file.createNewFile();
		PdfWriter.getInstance(doc, new FileOutputStream(file));
		doc.open();
		doc.add(new Paragraph(
				"Content from the PDF attached through JavaMail, this Paragraph is from the PDF Document"));
		doc.close();

		// Returning the Blank PDF with the Text from the Demo Paragraph
		// in Byte Stream form to be Read and Converted at sendEmail

		return new FileInputStream(file);

	}
	

}
