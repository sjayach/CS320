package homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Homework2/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean cookieFound = false;
		boolean sessionUpdated = false;
		String cookieValue = null;
		
		HttpSession session = request.getSession();
		if ( session.getAttribute("CurrentUser") == null ){
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies ) {
					if (cookie.getName().equals("Homework2")) {
						cookieFound = true;
						cookieValue = cookie.getValue();
						break;
					}
				}
			}
			if (cookieFound) {
				ServletContext context = this.getServletContext();
				ArrayList <CS320User> users = (ArrayList<CS320User>) context.getAttribute("HomeworkUsers");
				for(CS320User user : users) {
					
					MessageDigest digest = null;
					try {
						digest = MessageDigest.getInstance("SHA-256");
						byte[] hashedBytes = digest.digest(user.getEmail().getBytes("UTF-8"));
						StringBuffer stringBuffer = new StringBuffer();
						for (int i = 0; i < hashedBytes.length; i++) {
							stringBuffer.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16)
									.substring(1));
						}
						String hashedEmail = stringBuffer.toString();

						if (hashedEmail.equals(cookieValue)) {
							session.setAttribute("CurrentUser", user);
							sessionUpdated = true;
							break;
						}
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
			if (!sessionUpdated) {
				System.out.println("Session not updated cookie found "+ cookieFound);
				response.sendRedirect("Login");
				return;
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Welcome</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"jumbotron\">");

		
		CS320User user = (CS320User) session.getAttribute("CurrentUser");
		
		
		if (user.getName() != null)
			out.println("   <h1>Welcome, "+user.getName()+ "!</h1>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
