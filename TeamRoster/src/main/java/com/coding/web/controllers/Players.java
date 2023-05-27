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
import com.coding.web.models.Player;

/**
 * Servlet implementation class Players
 */
@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Players() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/NewPlayer.jsp");	
    	view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String firts_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String age_r = request.getParameter("age");
		int age = Integer.parseInt(age_r);
		Player x = new Player(firts_name,last_name,age);
		Roster lista = (Roster) session.getAttribute("listTeams");
		int teamid = (int)(session.getAttribute("idTeam" ));
		ArrayList <Team> listaTeam = lista.getTeamsList();
		Team team = listaTeam.stream().filter(a -> a.getId() == teamid).collect(Collectors.toList()).get(0);
			team.addPlayer(x);
			session.setAttribute("listTeams",lista);
		response.sendRedirect("Teams?id="+teamid);  
	}

}
