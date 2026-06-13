package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.jbdc.DAO;
import com.model.javabeans.client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO dao;

    @Override
    public void init() throws ServletException {
        dao = new DAO("jdbc:mysql://localhost:3307/dbclient", "root", "");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "LIST";

        try {
            switch (action) {
                case "ADD": showAddForm(request,response); break;
                case "INSERT": insertClient(request,response); break;
                case "EDIT": showEditForm(request,response); break;
                case "UPDATE": updateClient(request,response); break;
                case "DELETE": deleteClient(request,response); break;
                case "SEARCH": searchClients(request,response); break; // ADD THIS LINE
                default: listClients(request,response); break;
            }
        } catch(SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<client> list = dao.listAllclient();
        request.setAttribute("listClients", list);
        request.getRequestDispatcher("listclient.jsp").forward(request,response);
    }

    // ADD THIS NEW METHOD
    private void searchClients(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<client> list = dao.searchClients(keyword);
        request.setAttribute("listClients", list);
        request.getRequestDispatcher("listclient.jsp").forward(request,response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addclient.jsp").forward(request,response);
    }

    private void insertClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        int age=Integer.parseInt(request.getParameter("age"));
        int id=Integer.parseInt(request.getParameter("id"));
        client c=new client(nom, prenom, id, age);
        dao.addclient(c);
        response.sendRedirect("ControlServlet?action=LIST");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        client c=dao.getclient(id);
        request.setAttribute("client", c);
        request.getRequestDispatcher("editclient.jsp").forward(request,response);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        int age=Integer.parseInt(request.getParameter("age"));
        client c=new client(nom, prenom, id, age);
        dao.updateclient(c);
        response.sendRedirect("ControlServlet?action=LIST");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        client c=new client();
        c.setId(id);
        dao.deleteclient(c);
        response.sendRedirect("ControlServlet?action=LIST");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}