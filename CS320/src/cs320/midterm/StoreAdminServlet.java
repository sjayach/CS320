package cs320.midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/midterm/StoreAdmin")
public class StoreAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
	
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		if (context.getAttribute("Inventory") == null) {
			ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
			items.add(new InventoryItem("ipod", "apple products", 500.0, 2));
			context.setAttribute("Inventory", items);
			
		}
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean name = false;
		boolean desc = false;
		boolean price = false;
		boolean all = false;
		ServletContext context = this.getServletContext();
		String query = request.getParameter("query");
		
		ArrayList<InventoryItem> items =
				(ArrayList<InventoryItem>) context.getAttribute("Inventory");
		
		if (request.getParameter("action") != null && request.getParameter("action").equals("remove")){
			try{
				int id = Integer.parseInt(request.getParameter("id"));
				for (InventoryItem item : items){
					if (item.getId() == id){
						items.remove( item );
						break;
					}
					
				}
			}catch( Exception e ){
				// Nothing to do
			}
		}
		
		if (request.getParameter("selectbox") != null && request.getParameter("selectbox").equals("Name") ) {
			name = true;
		}
		if (request.getParameter("selectbox") != null && request.getParameter("selectbox").equals("Description") ) {
			desc = true;
		}
		
		if (request.getParameter("selectbox") != null && request.getParameter("selectbox").equals("Price") ) {
			price = true;
		}
		
		if (request.getParameter("selectbox") != null && request.getParameter("selectbox").equals("All") ) {
			all = true;
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Inventory</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		/*
		out.println("	<form action=\"StoreAdminServlet\" method=\"post\">");
		
		out.println("      <input type=\"text\" placeholder=\"Search\" name=\"search\" />");
		
		out.println("       <select name=\"selectbox\">");
		out.println("           <option value=\"Name\">Name</option>");
		out.println("           <option value=\"Description\">Description</option>");
		out.println("           <option value=\"Price\">Price</option>");
		out.println("           <option value=\"All\">All</option>");
		out.println("       </select>");
		
		out.println("      <input class=\"btn btn-success\" type=\"submit\" value=\"Search\" />");
		
		out.println("   </form");
		*/
		out.println("	<form action=\"StoreAdmin\" method=\"get\">");
		out.println("      <input type=\"text\" placeholder=\"Search Term\" name=\"query\" />");	
		out.println("       <select name=\"selectbox\">");
		out.println("           <option value=\"Name\">Name</option>");
		out.println("           <option value=\"Description\">Description</option>");
		out.println("           <option value=\"Price\">Price</option>");
		out.println("           <option value=\"All\">All</option>");
		out.println("       </select>");
		out.println("      <input class=\"btn btn-success\" type=\"submit\" value=\"Search\" />");
		out.println("	</form>");
		out.println("<hr />");
		out.println("<br />");
		
		out.println("   <table class=\"table table-striped table-hover table-bordered\">");
		out.println("     <tr>");
		out.println("       <th>Name</th>");
		out.println("       <th>Description</th>");
		out.println("       <th>Price</th>");
		out.println("       <th>Inventory</th>");
		out.println("       <th>&nbsp;</th>");
		out.println("       <th>&nbsp;</th>");
		out.println("     </tr>");
		//ServletContext context = this.getServletContext();
		//ArrayList<InventoryItem> items = (ArrayList<InventoryItem>) context.getAttribute("Inventory");
		
		for(InventoryItem item : items) {
			
			if ((query == null) || (query != null && name && item.getName().contains(query)) 
					|| (query != null && desc && item.getDescription().contains(query)) 
					|| (query != null && price && item.getPrice() == Double.parseDouble(query))) {
			out.println("     <tr>");
			out.println("          <td>"+item.getName()+"</td>");
			out.println("          <td>"+item.getDescription()+"</td>");
			out.println("          <td>"+item.getPrice()+"</td>");
			out.println("          <td>"+item.getQuantity()+"</td>");
			out.println("          <td><a href=\"edit?action=change&id=" + item.getId() + "\">Edit</a></td>");
			out.println("          <td><a href=\"StoreAdmin?action=remove&id=" + item.getId() + "\">Delete</a></td>");
			out.println("     </tr>");
			}
		}
		out.println("     </table>");
		
		out.println("</br>");
		out.println("<a href=\"add\"> Add inventory</a>");

		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
