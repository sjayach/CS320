package cs320.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/databases/IntroToDatabases")
public class IntroToDatabases extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Construct the URL needed to connect to the database
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
			
			// Create the Query
			String query = "SELECT * FROM users";
				
			// Query the Database and get a reference to a Result Set
			ResultSet resultSet = statement.executeQuery(query);
			
			// Iterate over the result set and create beans (models)
			
			ArrayList<cs320.beans.DbUserBean> users = 
					new ArrayList<cs320.beans.DbUserBean>(); 
			
			while ( resultSet.next() ){
				int    uid   = resultSet.getInt("uid");
				String first = resultSet.getString("first");
				String last  = resultSet.getString("last");
				String email = resultSet.getString("email");
				String pw    = resultSet.getString("password");
				
				users.add( new cs320.beans.DbUserBean(uid, first, last, email, pw));				
			}
			
			// Tidy Up
			connection.close();
			
			
			// Attach the ArrayList to the request object
			request.setAttribute("users", users);
			
			request
				.getRequestDispatcher("/WEB-INF/jsp/sql/IntroToMySQL.jsp")
				.forward(request, response);
			
			
		}catch(Exception e){};
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




