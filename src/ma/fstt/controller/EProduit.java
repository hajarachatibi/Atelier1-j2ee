package ma.fstt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Commande;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class EProduit
 */
@WebServlet("*.p")
public class EProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	ProduitDAO pdao;
	@Inject
	Produit pd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String p=request.getServletPath();
		
		if(p.equals("/delete.p"))
		{
			try {
				pdao=new ProduitDAO();
				pd=new Produit();
				pd.setId(Integer.parseInt(request.getParameter("val")));
				pdao.delete(pd);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/edit.p"))
		{
			try {
				pdao=new ProduitDAO();
				pd=pdao.getById(Integer.parseInt(request.getParameter("val")));
				request.setAttribute("c", pd);
				request.getRequestDispatcher("editp.jsp").forward(request, response);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/add.p"))
		{
			
			pd=new Produit(request.getParameter("libelle"),Double.parseDouble(request.getParameter("prix")));
			try {
			pdao=new ProduitDAO();
			pdao.save(pd);
			}
			catch(Exception e){}
		}
			try {
				pdao = new ProduitDAO();
				List<Produit> lp=pdao.List();
				System.out.println("lp : "+lp);
				request.setAttribute("produits",lp);
				if(!response.isCommitted())
				request.getRequestDispatcher("EspaceProduit.jsp").forward(request, response);
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
  if(p.equals("/confirmedit.p"))
  {
	   pd=new Produit(Integer.parseInt(request.getParameter("id")),request.getParameter("libelle"),Double.parseDouble(request.getParameter("prix")));
	  try {
			 pdao=new ProduitDAO();
			pdao.update(pd);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
  }

	try {
		pdao = new ProduitDAO();
		List<Produit> lc=pdao.List();
		request.setAttribute("produits",lc);
		request.getRequestDispatcher("EspaceProduit.jsp").forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
