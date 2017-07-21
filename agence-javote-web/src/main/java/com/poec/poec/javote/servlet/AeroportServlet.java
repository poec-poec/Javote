package com.poec.poec.javote.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poecpoec.agence.dao.AeroportDao;
import com.poecpoec.agence.model.Aeroport;

/**
 * Servlet implementation class AeroportServlet
 */

@WebServlet(urlPatterns = { "/aeroport" })

public class AeroportServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private AeroportDao       aeroportDao      = new AeroportDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AeroportServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        String id = request.getParameter("id");
        if (id == null)
        {
            afficherAeroports(request, response);

        }
        else
        {
            afficherDetail(request, response);
        }
    }

    // Afficher la liste des aeroport
    private void afficherAeroports(HttpServletRequest request, HttpServletResponse response)
    {
        List<Aeroport> aeroports = aeroportDao.findAll();

        // Ajouter un attribut de la requette nomme clients

        request.setAttribute("aeroports", aeroports);

        // Dispatcher vers la page JSP

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/aeroports.jsp");

        try
        {
            dispatcher.forward(request, response);
        }
        catch (ServletException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * -------------------------------------------------
     */

    private void afficherDetail(HttpServletRequest request, HttpServletResponse response)
    {
        // je lis l'Id mon Aeroport selon la ville
        String aeroportId = request.getParameter("id");
        int myAeroportId = Integer.parseInt(aeroportId);

        // Récuperation de l'aeroport dans la base de donnee en fonction de son
        // Id
        Aeroport aeroport = aeroportDao.findById(myAeroportId);

        // Placer notre client dans la requette

        request.setAttribute("aeroport", aeroport);

        // Envoyer notre aeroport à notre jsp : aeroport.jsp

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/aeroport.jsp");

        try
        {
            dispatcher.forward(request, response);
        }
        catch (ServletException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * --------------------------------------
     */

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
