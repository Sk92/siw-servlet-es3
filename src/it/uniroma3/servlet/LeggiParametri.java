package it.uniroma3.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/processaDati")
public class LeggiParametri extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // gestione della RICHIESTA

        // leggo i parametri
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");

        // leggo (alcune) intestazioni http della richiesta
        String address = (String)request.getRemoteAddr();
        String host = (String)request.getRemoteHost();
        String userAgent = request.getHeader("User-Agent");

        request.setAttribute("NOME", nome);
        request.setAttribute("COGNOME", cognome);
        request.setAttribute("ADDRESS", address);
        request.setAttribute("HOST", host);
        request.setAttribute("USERAGENT", userAgent);

        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/mostraDati");
        requestDispatcher.forward(request, response);
    }


}
