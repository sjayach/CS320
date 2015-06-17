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

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/midterm/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isNameEmpty = request.getAttribute("isNameEmpty") != null;
		boolean isDescEmpty = request.getAttribute("isDescEmpty") != null;
		boolean isPriceNegative = request.getAttribute("isPriceNegative") != null;
		boolean isQuantityNegative = request.getAttribute("isQuantityNegative") != null;
		
		
		String name = "";
		String description = "";
		double price = 0.0;
		int quantity = 0;
		boolean form_success = true;
		
		if (request.getAttribute("formSuccess") != null)
			form_success = (boolean) request.getAttribute("formSuccess");
		
		if (!isNameEmpty) {
			name = (request.getAttribute("name")) == null ? "" : request.getAttribute("name").toString();
		}
		
		if (!isDescEmpty) {
			description = (request.getAttribute("description")) == null ? "" : request.getAttribute("description").toString();
			System.out.println("description is " +description + "form success" + form_success);
		}
		
		if (!isPriceNegative) {
			price = (request.getAttribute("price")) == null ? 0.0 : Double.parseDouble(request.getAttribute("price").toString());
		}
		
		if (!isQuantityNegative) {
			quantity = ((request.getAttribute("quantity")) == null ? 0 : Integer.parseInt(request.getAttribute("quantity").toString()));
		}
		
		
		if (form_success && !name.equals("") && !description.equals("") &&
				!(price <= 0.0) && !(quantity <= 0)) {
			ServletContext context = this.getServletContext();
			ArrayList<InventoryItem> items =
				(ArrayList<InventoryItem>) context.getAttribute("Inventory");
			items.add(new InventoryItem(name,description,price,quantity));
			System.out.println("added successfully");
			response.sendRedirect("StoreAdmin");
		}
		
		System.out.println("Description "+isDescEmpty + isQuantityNegative + description + quantity);
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
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Add Inventory</h1>");
		out.println("	</div>");
		out.println("	<form action=\"add\" method=\"post\">");
		out.println("       Name:<input type=\"text\" value=\"" + (isNameEmpty ? "" : name) + "\" placeholder=\"Name\" name=\"name\" />");
		if(isNameEmpty) 
			out.println("				<p class=\"text-danger\">Name should not be Empty</p>");
		out.println("	    <br />");
		out.println("		<br />");
		out.println("		Description: <br /> <textarea name=\"description\"  placeholder=\"Description\"cols=\"20\" rows=\"5\"></textarea>");
		if(isDescEmpty) 
			out.println("				<p class=\"text-danger\">Description should not be Empty</p>");
		out.println("		<br />");
		out.println("		<br />");
		out.println("       Price:<input type=\"value\" value=\"" + (isPriceNegative ? 0.0 : price) + "\" placeholder=\"Price\" name=\"price\" />");
		if (isPriceNegative)
			out.println("				<p class=\"text-danger\">Price should not be Negative</p>");
		out.println("		<br />");
		out.println("		<br />");
		out.println("       Quantity: <input type=\"value\" value=\"" + (isQuantityNegative ? 0 : quantity) + "\" placeholder=\"Quantity\" name=\"quantity\" />");
		if (isQuantityNegative)
			out.println("				<p class=\"text-danger\">Quantity should not be Negative</p>");
		out.println("		<br />");
		out.println("		<br />");
		out.println("       <input class=\"btn btn-success\" type=\"submit\" value=\"Add\" />");
		out.println("	</form>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String desc = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		boolean form_success  = true;
		
		if (name.trim().length() == 0) {
			request.setAttribute("isNameEmpty", true);
			form_success = false;
		} else {
			request.setAttribute("name", name);
		}
		
		if (desc.trim().length() == 0) {
			request.setAttribute("isDescEmpty", true);
			form_success = false;
		}else {
			request.setAttribute("description", desc);
			System.out.println(desc);
		}
		if (price <= 0) {
			request.setAttribute("isPriceNegative", true);
			form_success = false;
		} else {
			request.setAttribute("price", price);
		}
		
		if (quantity <= 0) {
			request.setAttribute("isQuantityNegative", true);
			form_success = false;
		} else {
			request.setAttribute("quantity", quantity);
			System.out.println(quantity);
		}
		request.setAttribute("formSuccess", form_success);
		
		doGet(request, response);
		
			
		
	}

}
