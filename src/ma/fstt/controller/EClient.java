package ma.fstt.controller;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;

/**
 * Servlet implementation class EClient
 */
@WebServlet("*.c")
public class EClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject
	ClientDAO cd;
	@Inject
	Client c;
    public EClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getServletPath();
		
		
		if(p.equals("/delete.c"))
		{
			try {
				cd=new ClientDAO();
				c=new Client();
				c.setId(Integer.parseInt(request.getParameter("val")));
				cd.delete(c);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/edit.c"))
		{
			try {
				cd=new ClientDAO();
				c=cd.getById(Integer.parseInt(request.getParameter("val")));
				request.setAttribute("c", c);
				request.getRequestDispatcher("editc.jsp").forward(request, response);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/add.c"))
		{
			
			c=new Client(request.getParameter("nom"),request.getParameter("prenom"),Integer.parseInt(request.getParameter("age")),request.getParameter("adresse"));
			try {
			ClientDAO cd=new ClientDAO();
			cd.save(c);
			}
			catch(Exception e){}
		}
			
		try {
				cd = new ClientDAO();
				List<Client> lc=cd.List();
				request.setAttribute("clients",lc);
				if(!response.isCommitted())
				request.getRequestDispatcher("EspaceClient.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getServletPath();
  if(p.equals("/confirmedit.c"))
  {
	  Client c=new Client(Integer.parseInt(request.getParameter("id")),request.getParameter("nom"),request.getParameter("prenom"),Integer.parseInt(request.getParameter("age")),request.getParameter("adresse"));
	  try {
			ClientDAO cd=new ClientDAO();
			cd.update(c);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
  }
  ClientDAO cd;
	try {
		cd = new ClientDAO();
		List<Client> lc=cd.List();
		request.setAttribute("clients",lc);
		request.getRequestDispatcher("EspaceClient.jsp").forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
