package ma.fstt.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.LignedeCommandeDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LignedeCommande;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class ECommande
 */
@WebServlet("*.cmd")
public class ECommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	CommandeDAO cdao;
	@Inject
	Commande cm;
	@Inject
	LignedeCommande lc;
	@Inject
	LignedeCommandeDAO ldao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ECommande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p=request.getServletPath();
		
		if(p.equals("/delete.cmd"))
		{
			try {
				 cdao=new CommandeDAO();
				cm=new Commande();
				cm.setId(Integer.parseInt(request.getParameter("val")));
				
				cdao.delete(cm);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/details.cmd"))
		{
			
			try {
				cdao=new CommandeDAO();
				cm=cdao.getById(Integer.parseInt(request.getParameter("val")));
				request.setAttribute("cmd", cm);
				List<Produit> lp=cdao.ListParcmd(cm);
				ArrayList<Integer> quantite = new ArrayList<Integer>();
				for (int i=0 ; i< lp.size(); i++)
				{
					Produit pr=lp.get(i);					
					quantite.add(cdao.quantitep(pr, cm)); 
					
				}
				request.setAttribute("qt",quantite);
				System.out.println("lp : "+lp);
				request.setAttribute("produits",lp);
				request.getRequestDispatcher("detailscmd.jsp").forward(request, response);
			} catch (Exception e) {
			}
		}
		else if(p.equals("/add.cmd"))
		{
			
			cm=new Commande();
			cm.setId_client(Integer.parseInt(request.getParameter("id_client")));
			try {
				cdao=new CommandeDAO();
				cdao.save(cm);
				Commande cmd = cdao.getlast();
				request.setAttribute("cmd",cmd);
				request.getRequestDispatcher("addptocmd.jsp").forward(request, response);
				
			}
			
			catch(Exception e){}
		}
		else if(p.equals("/addp.cmd"))
		{
			
			LignedeCommande lc=new LignedeCommande();
			lc.setId_cmd(Integer.parseInt(request.getParameter("id_cmd")));
			lc.setId_produit(Integer.parseInt(request.getParameter("id_produit")));
			lc.setQuantite(Integer.parseInt(request.getParameter("qt")));
			try {
				LignedeCommandeDAO ld=new LignedeCommandeDAO();
				ld.save(lc);
				cdao=new CommandeDAO();
				cm = cdao.getById(Integer.parseInt(request.getParameter("id_cmd")));
				request.setAttribute("cmd",cm);
				request.getRequestDispatcher("addptocmd.jsp").forward(request, response);
				
			}
			
			catch(Exception e){}
		}
		
		if(p.equals("/editaddptocmd.cmd"))
		{
			try {
			
			cdao=new CommandeDAO();
			cm=cdao.getById(Integer.parseInt(request.getParameter("id_cmd")));
			request.setAttribute("cmd", cm);
			List<Produit> lp=cdao.ListParcmd(cm);
			ArrayList<Integer> quantite = new ArrayList<Integer>();
			for (int i=0 ; i< lp.size(); i++)
			{
				Produit pr=lp.get(i);				
				quantite.add(cdao.quantitep(pr, cm)); 
			}
			request.setAttribute("qt",quantite);
			System.out.println("lp : "+lp);
			request.setAttribute("produits",lp);
			LignedeCommande lc=new LignedeCommande();
			lc.setId_cmd(Integer.parseInt(request.getParameter("id_cmd")));
			lc.setId_produit(Integer.parseInt(request.getParameter("id_produit")));
			lc.setQuantite(Integer.parseInt(request.getParameter("qt")));
			
			LignedeCommandeDAO ld=new LignedeCommandeDAO();
			ld.save(lc);
			request.getRequestDispatcher("detailscmd.jsp").forward(request, response);
				
			}
			
			catch(Exception e){}
		}
		
		if(p.equals("/deletep.cmd"))
		{
			try {
				cdao=new CommandeDAO();
				Produit a=new Produit();
				cm=new Commande();
				a.setId(Integer.parseInt(request.getParameter("val1")));
				cm.setId(Integer.parseInt(request.getParameter("id")));
				cdao.deletefromcmd(a, cm);
				List<Produit> lp=cdao.ListParcmd(cm);
				ArrayList<Integer> quantite = new ArrayList<Integer>();
				for (int i=0 ; i< lp.size(); i++)
				{
					Produit pr=lp.get(i);					
					quantite.add(cdao.quantitep(pr, cm)); 
				}
				request.setAttribute("qt",quantite);
				request.setAttribute("cmd", cm);
				request.setAttribute("produits",lp);
				request.getRequestDispatcher("detailscmd.jsp").forward(request, response);
			} catch (Exception e) {
			}
		}
		
			try {
				cdao = new CommandeDAO();
				List<Commande> lcmd=cdao.List();
				request.setAttribute("commandes",lcmd);
				if(!response.isCommitted())
				request.getRequestDispatcher("EspaceCommande.jsp").forward(request, response);
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
		String p=request.getServletPath();
	try {
		cdao = new CommandeDAO();
		List<Commande> lcmd=cdao.List();
		request.setAttribute("commandes",lcmd);
		request.getRequestDispatcher("EspaceCommande.jsp").forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
