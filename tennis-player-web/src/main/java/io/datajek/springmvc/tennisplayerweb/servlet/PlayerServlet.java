package io.datajek.springmvc.tennisplayerweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/player.do")
public class PlayerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<head>" +
//                "<title>Player DB</title>" +
//                "</head>");
//        out.println("<body>" +
//                "<H2>Welcome to the Tennis Players database!</H2>" +
//                "</body>");
//        out.println("</html>");
        String playerName = req.getParameter("name");
        System.out.println(playerName);
        req.setAttribute("name", playerName);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/welcome.jsp");
        requestDispatcher.forward(req, resp);
    }
}
