package com.coding.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coding.web.models.Roster;
import com.coding.web.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameterMap().containsKey("id")) {
	            int id = Integer.parseInt(request.getParameter("id"));
	            Roster lista = (Roster) session.getAttribute("listTeams");
	            //team
	            ArrayList <Team> listaTeam = lista.getTeamsList();
	    		Team team = listaTeam.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
	    		
	            session.setAttribute("idTeam",team.getId() );
	            request.setAttribute("idTeam",team.getId() );
	            request.setAttribute("nameTeam",team.getName() );
	            request.setAttribute("listPlayer", team.getPlayersList());
	            
	            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/TeamInfo.jsp");
	            view.forward(request, response);
	        }else {
	        	RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewTeam.jsp");	
	        	view.forward(request, response);
	        }
		//RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewTeam.jsp");
        //view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		Team x = new Team(name);
		Roster list = (Roster) session.getAttribute("listTeams");
		if(list== null) {
			Roster lista = new Roster();
			lista.addTeam(x);
			session.setAttribute("listTeams",lista);
		}else {
			Roster lista = (Roster) session.getAttribute("listTeams");
			lista.addTeam(x);
			session.setAttribute("listTeams",lista);
		}
		response.sendRedirect("Home");  
	}

}
