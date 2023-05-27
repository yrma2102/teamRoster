package com.coding.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coding.web.models.Roster;
import com.coding.web.models.Team;

/**
 * Servlet implementation class DeleteTeam
 */
@WebServlet("/DeleteTeam")
public class DeleteTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Roster lista = (Roster) session.getAttribute("listTeams");
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList <Team> listaTeam = lista.getTeamsList();
		Team team = listaTeam.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
		listaTeam.remove(team);
		response.sendRedirect("Home");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
