/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetFavGit.servlets;


import com.projetFavGit.DAO.implement.LienDAO;
import com.projetFavGit.modele.Lien;
import com.projetFavGit.util.Connexion;
//import com.projetFavGit.DAO.implement.LienDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ibtissam
 */
@WebServlet(name = "AjouterAction", urlPatterns = {"/AjouterAction"})
public class AjouterAction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            //paramètres envoyés pour l'incertion d'un nouveau lien dans la BD
            String id = request.getParameter("idLien");
            String titre = request.getParameter("titre"),
                    adresse = request.getParameter("adresse"),
                    nomCat = request.getParameter("nomCat");
            //conversion du id en int pour la base de données
            if( id == null )
                out.print("Le id du lien est null");
            int leID = Integer.parseInt(id);
            Class.forName( request.getServletContext().getInitParameter("piloteJDBC"));
            Connexion.setUrl(this.getServletContext().getInitParameter("URLbaseDonnees"));
            LienDAO dao = new LienDAO(Connexion.getInstance());
            Lien leLien = new Lien(leID,titre,adresse,nomCat);
            if (dao.create(leLien)){
                
                request.setAttribute("message", "Nouveau lien favori ajouté");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/pageMembre.jsp");
                r.forward(request, response);
                return;
                
            }
            else {
                
                request.setAttribute("message", "ERREUR lien non ajouté");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/pageMembre.jsp");
                r.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AjouterAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
