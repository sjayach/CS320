package finalPractise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/WEB-INF/jsp/practise/Login.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		String host = "cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu47";
		String username = "cs320stu47";
		String password = "..7qX4#g";
		
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		
		try{
			// Dynamically include the MySQL Driver
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			
			// Instantiate the Driver
			Driver driver = new org.gjt.mm.mysql.Driver();
			
			// Connect to the Database
			Connection connection = 
					DriverManager.getConnection(url, username, password);
			
			// Create a Statement
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM Login WHERE username='" + user +"' AND password='" + pass +"'";
			ResultSet resultSet = statement.executeQuery(query);
			boolean success = false;
			boolean isAdmin = false;
			while(resultSet.next()) {
				isAdmin=resultSet.getBoolean("isAdmin");
				success = true;
			}
			connection.close();
			if (success) {
				if(isAdmin)
					response.sendRedirect("Admin");
				else
					response.sendRedirect("User");
			} else
				request.setAttribute("ErrorLogin", "Invalid Username/Password");
			doGet(request,response);
		} catch(Exception e) {}
		
	}

}
