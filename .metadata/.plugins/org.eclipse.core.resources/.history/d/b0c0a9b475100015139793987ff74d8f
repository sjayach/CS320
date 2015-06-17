package mediaStore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LendPage
 */
@WebServlet("/LendPage")
public class LendPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		List<MediaBean> lendlist = (List<MediaBean>) context.getAttribute("MediContext");
		int id = Integer.parseInt(request.getParameter("id"));
		for(int i=0; i<lendlist.size() ;i++) {
			if (id == lendlist.get(i).getId()) {
				request.setAttribute("lend", lendlist.get(i));
				System.out.println("Lend id " + lendlist.get(i).getId());
				break;
			}
		}
		request.getRequestDispatcher("/WEB-INF/Lend.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("bname");
		int id = Integer.parseInt(request.getParameter("hiddenid"));
		Date date = new Date();
		String time = date.toString();
		ServletContext context = this.getServletContext();
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
			String query ="UPDATE Media SET isLoan=1,Borrowed='" +name+ "',lentDate='" +time+"' WHERE id="+id;
			statement.executeUpdate(query);
			System.out.println("Query" +query);
			connection.close();
			response.sendRedirect("DisplayMedia");
		}catch (Exception e) {}
	}

}
