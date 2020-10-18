package ui.controler;

import domain.database.DatabankenPlayers;
import domain.model.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    DatabankenPlayers databankenPlayers = new DatabankenPlayers();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naam = request.getParameter("naam");
        String nationaliteit = request.getParameter("nationaliteit");
        String team = request.getParameter("team");

        Player player = new Player(naam,nationaliteit,team);
        databankenPlayers.addPlayer(player);

        request.setAttribute("players",databankenPlayers.getSpelers());
        request.setAttribute("spelers_belgie", databankenPlayers.playersFromBelgium());

        RequestDispatcher view = request.getRequestDispatcher("lijst.jsp");
        view.forward(request,response);
    }
}
