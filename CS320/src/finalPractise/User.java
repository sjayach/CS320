package finalPractise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			if(request.getParameter("add_cart") != null) {
				String [] check_box = request.getParameterValues("pick");
				if (check_box.length >= 3)
					request.setAttribute("MoreItems", "User cannot select more than 1 item at a time");
				else {
					for(String pick: check_box) {
						
						int id = Integer.parseInt(pick);
						String query = "SELECT quantity FROM items where id=" +id;
						ResultSet resultSet = statement.executeQuery(query);
						int quantity = 0;
						while(resultSet.next()) {
							quantity=resultSet.getInt("quantity");
						}
						quantity --;
						query="UPDATE items SET quantity="+quantity+" WHERE id=" +id;
						System.out.println("Update query" + query );
						statement.executeUpdate(query);
					}
				}
				
			}
			String query = "SELECT * FROM items";
			
			ResultSet resultSet = statement.executeQuery(query);
			List<ItemsBean> items = new ArrayList<ItemsBean> ();
			
			System.out.println("Query:" +query);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String description = resultSet.getString("description");
				int quantity = resultSet.getInt("quantity");
				double price = resultSet.getDouble("price");
				items.add(new ItemsBean(id,description, quantity,price));
				System.out.println(id + description);
			}
			connection.close();
			request.setAttribute("Items", items);
			
			
		} catch(Exception e) {}
			
		request
		.getRequestDispatcher("/WEB-INF/jsp/practise/User.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
