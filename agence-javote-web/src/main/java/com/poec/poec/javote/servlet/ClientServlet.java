package com.poec.poec.javote.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poecpoec.agence.dao.ClientDao;
import com.poecpoec.agence.model.Client;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet(urlPatterns = { "/client" })

public class ClientServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    ClientDao                 clientDao        = new ClientDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet()
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
        String id = request.getParameter("id");
        if (id == null)
        {
            afficherClients(request, response);
        }
        else
        {
            afficherProfil(request, response);
        }

    }

    // méthode servant à afficher la liste des clients
    private void afficherClients(HttpServletRequest request, HttpServletResponse response)
    {
        // Cretion d'une liste de client
        List<Client> clients = clientDao.findAll();

        // Ajout à un attribut de la requete nomme clients
        request.setAttribute("clients", clients);

        // Dispatche vers la page JSP

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/clients.jsp");

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

    // méthode qui sert à afficher le profil d'un client sellon son ID
    private void afficherProfil(HttpServletRequest request, HttpServletResponse response)
    {

    }

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
