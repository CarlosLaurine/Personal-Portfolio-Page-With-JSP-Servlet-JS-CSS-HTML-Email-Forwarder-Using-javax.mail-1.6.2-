package email_forwarder;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	@org.junit.Test

	public void testEmail() {

		// First, verify the SMTP settings of the test email account

		try {

			// Setting StringBuilder object to Build the Email Content with inner HTML
			StringBuilder emailTxtSB = new StringBuilder();

			emailTxtSB.append("Hello!! <br><br>");
			emailTxtSB.append("You are now receiving Access to the Carlos Pinho's Portfolio!<br><br>");
			emailTxtSB.append("To perform your First Access to the Platform, click on the Button below<br><br>");
			emailTxtSB.append(
					"<a target=\"_blank\" href = \"CarlosLaurine.github.io\" style=\"color: #2525a7; padding:14px 25px; text-align: center; text-decoration: none; display: inline-block; border-radius:15px; font-size:25px; font-family:courier; border: 4px solid green; background-color:#99DA39 \"> Access Page </a><br><br>");

			// Setting Virtual Signature at the Email Footer

			emailTxtSB.append(
					"<b><span style=\"font-size:8px\">Att.: Carlos Laurine - Java Web Fullstack Developer</span></b>");

			EmailForwarder forwarder = new EmailForwarder("cvpinhofsa@gmail.com",
					"Carlos Laurine - Freelancer Java Web Fullstack Dev", "Java Web Fullstack Developer's Page",
					emailTxtSB.toString());
			forwarder.sendEmailWithAttachedFile(true);

			/*
			 * OBS: Since this is a JUnit Test, it executes and right after kills the
			 * process. In order to avoid the Email Sending process to be interrupted in
			 * particular cases in which it performs more slowly, it is possible to use the
			 * following commented Test Command to put the Thread to Sleep during a chosen
			 * Set of Milliseconds in order to assure that the Thread will Run through its
			 * Completion before the test Kills it
			 */

			Thread.sleep(15000);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
