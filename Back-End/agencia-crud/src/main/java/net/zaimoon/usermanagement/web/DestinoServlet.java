package net.zaimoon.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zaimoon.usermanagement.dao.DestinoDAO;
import net.zaimoon.usermanagement.model.Destino;


@WebServlet("/")
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DestinoDAO destinoDAO;   
    
    
    
   
    
    
    public DestinoServlet() {
        this.destinoDAO = new DestinoDAO();
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertDestino(request, response);
				break;
			case "/delete":
				deleteDestino(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateDestino(request, response);
				break;
			default:
				listDestino(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
		
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void insertDestino(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String uf = request.getParameter("uf");
		String country = request.getParameter("country");
		Destino newDestino = new Destino(nome, uf, country);
		destinoDAO.insert(newDestino);
		response.sendRedirect("list");
	}	
	
	
	
	  private void deleteDestino(HttpServletRequest request, HttpServletResponse
	  response) throws SQLException, IOException { int id =
	  Integer.parseInt(request.getParameter("id")); destinoDAO.deleteDesTinos(id);
	  response.sendRedirect("list");
	  
	  }
	 
	
	
	
	
	
	


	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Destino existingDestino = destinoDAO.select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("destino", existingDestino);
		dispatcher.forward(request, response);

	}

	private void updateDestino(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String uf = request.getParameter("uf");
		String country = request.getParameter("country");

		Destino destino = new Destino(id, nome, uf, country);
		destinoDAO.update(destino);
		response.sendRedirect("list");
	}

	
	
	private void listDestino(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Destino> listDestino = destinoDAO.selectALLDestinos();
		request.setAttribute("listDestino", listDestino);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}
	
}

	
	


