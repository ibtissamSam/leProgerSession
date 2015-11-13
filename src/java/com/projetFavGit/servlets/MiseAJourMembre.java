/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.projetFavGit.servlets;

import com.projetFavGit.DAO.implement.MembreDAO;
import com.projetFavGit.modele.Membre;
import com.projetFavGit.util.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Génie Franklin
 */
public class MiseAJourMembre extends HttpServlet {

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
               String prenomMembre = request.getParameter("prenomMembre"), // Est-ce que ce sera AUTOINCREMENT??
               nomMembre = request.getParameter("nomMembre"),
               motDePasse = request.getParameter("motdepasse");
               
               Connexion.setUrl(this.getServletContext().getInitParameter("URLbaseDonnees"));
               MembreDAO dao = new MembreDAO(Connexion.getInstance());
               Membre leMembre = new Membre();
               leMembre.setEmail(((Membre)session.getAttribute("connecte")).getEmail());
               leMembre.setNom(nomMembre);
               leMembre.setPrenom(prenomMembre);
               
                if (dao.update(leMembre)){
            
            request.setAttribute("message", "Mise à jour réussie avec succès");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/index.jsp");
            r.forward(request, response);
            return;        
            }
                else {
            
            request.setAttribute("message", "Erreur de mise à jour");
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
