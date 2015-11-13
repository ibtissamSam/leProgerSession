/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetFavGit.controleur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usager
 */
public class controleurFrontal extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if ("presentation".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/presentation");
            r.forward(request, response);
        }
        if ("afficher".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/afficher");
            r.forward(request, response);
        }
        if ("afficherfavmembre".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/afficherfavmembre");
            r.forward(request, response);
        }
        if ("connecter".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/connecter");
            r.forward(request, response);
        }
        if ("pagemembre".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/pagemembre");
            r.forward(request, response);
        }
        if ("modifier".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/modifier");
            r.forward(request, response);
        }
        if ("inscription".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/inscription");
            r.forward(request, response);
        }
        if ("page".equals(action)||"page2".equals(action)||"page3".equals(action)||"page4".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/afficher");
            r.forward(request, response);
        }
         if ("deconnexion".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/deconnexion");
            r.forward(request, response);
        }
          if ("ajouter".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ajouter");
            r.forward(request, response);
        }
        if ("supprimer".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/supprimer");
            r.forward(request, response);
        }
        if ("ajoutercat".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/ajoutercat");
            r.forward(request, response);
        }
        if ("partager".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/partager");
            r.forward(request, response);
        }
        if ("supprimercat".equals(action) || "ajouterCR".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/supprimercat");
            r.forward(request, response);
        }
        if ("modifiercat".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/modifiercat");
            r.forward(request, response);
        }
           if ("afficherpartager".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/afficherpartager");
            r.forward(request, response);
        }     
            if ("partagevue".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/partagevue");
            r.forward(request, response);
        }    
             if ("parametre".equals(action)){
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/parametre");
            r.forward(request, response);
        }    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

