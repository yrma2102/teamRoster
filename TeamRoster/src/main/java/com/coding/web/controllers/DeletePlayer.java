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

import com.coding.web.models.Player;
import com.coding.web.models.Roster;
import com.coding.web.models.Team;

/**
 * Servlet implementation class DeletePlayer
 */
@WebServlet("/DeletePlayer")
public class DeletePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int teamid = (int)(session.getAttribute("idTeam" ));
		Roster lista = (Roster) session.getAttribute("listTeams");
		int idPlayer = Integer.parseInt(request.getParameter("id"));
		int idTeam = (int)(session.getAttribute("idTeam"));
		ArrayList <Team> listaTeam = lista.getTeamsList();
		Team team = listaTeam.stream().filter(a -> a.getId() == idTeam).collect(Collectors.toList()).get(0);
		Player player =  team.getPlayersList().stream().filter(a -> a.getId() == idPlayer).collect(Collectors.toList()).get(0);
		team.getPlayersList().remove(player);
		response.sendRedirect("Teams?id="+teamid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
