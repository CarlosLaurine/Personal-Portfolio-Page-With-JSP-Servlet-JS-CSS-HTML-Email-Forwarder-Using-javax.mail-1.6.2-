package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email_forwarder.EmailForwarder;

// TODO: Auto-generated Javadoc
/**
 * The Class MailServlet.
 */
@WebServlet("/mailInfo")
public class MailServlet extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new mail servlet.
	 */
	public MailServlet() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Do post.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String msgMail = "";

		if (action.equals("receive")) {
			// First, verify the SMTP settings of the test email account

			try {

				// Setting StringBuilder object to Build the Email Content with inner HTML
				StringBuilder emailTxtSB = new StringBuilder();

				emailTxtSB.append("<h3>Hi, <b>" + request.getParameter("name")
						+ "</b>!</h3> <br/> <h4>It is a pleasure to meet you. Let me introduce myself: <br/><br/><br/> I'm Carlos Pinho, a Brazilian Independent <bold>Java Developer</bold> and <bold>Software Engineering Student</bold></h4> <br>");
				emailTxtSB.append(
						"<h4>I suppose you much probably have already seen my <b><a target=\"_blank\" href = \"https://carloslaurinedev.com\" style=\"color: #dc143c; text-decoration: none; \"> Personal Page </a></b>, so let's step up to some Additional Info:</h4>  <br>");
				emailTxtSB.append("<h4>You are now receiving Access to my Portfolio!</h4><br>");
				emailTxtSB.append(
						"<a target=\"_blank\" href = \"https://drive.google.com/file/d/14cANkgL1XbkRoQA47f5LtW3NR9Op0P2l/view?usp=sharing\" style=\"color: #2525a7; padding:14px 25px; text-align: center; text-decoration: none; display: inline-block; border-radius:15px; font-size:25px; font-family:courier; border: 4px solid black; background-color:#dc143c \"> Access my Resume </a> ");
				emailTxtSB.append(
						"<a target=\"_blank\" href = \"https://www.linkedin.com/in/carlos-laurine-a58267144\" style=\"color: #2525a7; padding:14px 25px; text-align: center; text-decoration: none; display: inline-block; border-radius:15px; font-size:25px; font-family:courier; border: 4px solid black; background-color:#dc143c \"> Access my LinkedIn </a><br/><br/> ");
				emailTxtSB.append(
						"<a target=\"_blank\" href = \"https://github.com/CarlosLaurine\" style=\"color: #2525a7; padding:14px 25px; text-align: center; text-decoration: none; display: inline-block; border-radius:15px; font-size:25px; font-family:courier; border: 4px solid black; background-color:#dc143c \"> Access my GitHub </a>");

				emailTxtSB.append(
						"<a target=\"_blank\" href = \"https://www.instagram.com/cv_laurine/?hl=pt-br\" style=\"color: #2525a7; padding:14px 25px; text-align: center; text-decoration: none; display: inline-block; border-radius:15px; font-size:25px; font-family:courier; border: 4px solid black; background-color:#dc143c \"> Access my Instagram </a><br/><br/><br/>");

				// Setting Virtual Signature at the Email Footer

				emailTxtSB.append(
						"<b><span style=\"font-size:12px\">Att.: Carlos Laurine - Java Web Independent Developer</span></b><br/>");
				emailTxtSB.append(
						"<b><span style=\"font-size:12px\">Contact Number - +55 (71) 99318-7816 </span></b><br/><br/>");

				emailTxtSB.append("Sent to you by JavaMail 1.6.2");

				EmailForwarder forwarder = new EmailForwarder(request.getParameter("email"),
						"Carlos Laurine - Freelancer Java Web Independent Dev", "Java Web Fullstack Developer's Page",
						emailTxtSB.toString());
				forwarder.sendEmail(true);
				msgMail = "Email Succesfully Sent! Go check your Mailbox";

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				msgMail = "Invalid Mail Address! Please Re-Insert your Info";

			}

		}

		else if (action.equals("send")) {

			try {

				// Setting StringBuilder object to Build the Email Content with inner HTML
				StringBuilder emailTxtSB = new StringBuilder();

				emailTxtSB.append("<h3>Hi, <b>" + "Carlos!" + "</b>!</h3> <b> " + request.getParameter("name")
						+ "</b> <span style=\"color: #2525a7;\">wants to contact you!<span/> <br/> <h4>Email Subject:<h4/> <span style=\"color: #2525a7;\">"
						+ request.getParameter("subject")
						+ "<span/> <br/> <h4>Email Content:</h4> <span style=\"color: #2525a7;\">"
						+ request.getParameter("textbody") + "<span/> <br/><br/><br/>");

				// Setting Virtual Signature at the Email Footer

				emailTxtSB.append("<b><span style=\"font-size:12px; color: #2525a7;\">Sent By: "
						+ request.getParameter("email") + "</span></b><br/>");

				emailTxtSB.append(
						"<span style=\"color: #2525a7; text-style:italic;\">Sent to you by JavaMail 1.6.2<span/>");

				EmailForwarder forwarder = new EmailForwarder("vitorlaurinepinho@gmail.com",
						request.getParameter("name"), request.getParameter("subject"), emailTxtSB.toString());
				forwarder.sendEmail(true);

				msgMail = "Email Succesfully Sent! I'll be in touch Soon!";

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				msgMail = "Invalid Mail Address! Please Re-Insert your Info";
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("mailMsg", msgMail);
		rd.forward(request, response);

	}

}
