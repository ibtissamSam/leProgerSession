/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetFavGit.servlets;

import com.projetFavGit.DAO.implement.CategorieDAO;
import com.projetFavGit.DAO.implement.LienDAO;
import com.projetFavGit.modele.Categorie;
import com.projetFavGit.modele.Lien;
import com.projetFavGit.modele.Membre;
import com.projetFavGit.util.Connexion;
//import com.projetFavGit.servlets.LoginAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ibtissam
 */
@WebServlet(name = "AjouterActionCat", urlPatterns = {"/AjouterActionCat"})
public class AjouterActionCat extends HttpServlet {

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
               HttpSession session = request.getSession(true);
               String idCat = request.getParameter("idCat"); // Est-ce que ce sera AUTOINCREMENT??
               String nom = request.getParameter("nomCat");
                      
               
               //conversion du id en int pour la base de données
               int leID = Integer.parseInt(idCat);
        Connexion.setUrl(this.getServletContext().getInitParameter("URLbaseDonnees"));
        CategorieDAO dao = new CategorieDAO(Connexion.getInstance());
        
        Categorie laCat = new Categorie();
        laCat.setIdcat(leID);
        laCat.setNomcat(nom);
        
        // ici je vais chercher le courriel de la personne connectée pour l'inclure dans la BD
        laCat.setEmail(((Membre)session.getAttribute("connecte")).getEmail());
         
        if (dao.create(laCat)){
            
            request.setAttribute("message", "Nouvelle catégorie ajoutée");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
            r.forward(request, response);
            return;
        
        }
        else {
            
            request.setAttribute("message", "la catégorie existe déjà");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
            r.forward(request, response);
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
