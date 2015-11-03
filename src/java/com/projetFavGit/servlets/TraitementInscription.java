/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetFavGit.servlets;

import com.projetFavGit.DAO.implement.MembreDAO;
import com.projetFavGit.modele.Membre;
import com.projetFavGit.util.Connexion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trauko
 */
public class TraitementInscription extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try {
                //Chargement du pilote :
                Class.forName(this.getServletContext().getInitParameter("piloteJDBC"));

            } catch (ClassNotFoundException ex) {
                request.setAttribute("message", "Impossible de charger le pilote");
                RequestDispatcher r = this.getServletContext().getRequestDispatcher("/connexion.jsp");
                r.forward(request, response);
            }
            Connexion.setUrl(this.getServletContext().getInitParameter("URLbaseDonnees"));
          
          String reponse="";
          String u = request.getParameter("email");
          String p = request.getParameter("pass");
          String cp = request.getParameter("prenom");
          String c = request.getParameter("nom");
         
          if ("".equals(u))
          {
           reponse="Email obligatoire";   
          }
          else if ("".equals(p)){reponse="Mot de passe obligatoire";  }
          else if ("".equals(cp)){reponse="Prenom obligatoire";  }
         // else if (!cp.equals(p)){reponse="Le deux mot de passe ne sont pas égaux";  }
          else if ("".equals(c)){reponse="nom obligatoire";  }
            else
            {  MembreDAO mDAO=new MembreDAO(Connexion.getInstance());
               Membre membre=new Membre(u,p,cp,c);
               String dispatcher; 
               if(mDAO.read(u)==null) {
                   mDAO.create(membre);
                   dispatcher="/connexion.jsp";
                   reponse="";
                }
                else {
                  reponse="Nom d'utilisateur non disponible";
                  dispatcher="/inscription.jsp";
                }
                request.setAttribute("reponseAjoutMembre", reponse);
                RequestDispatcher r = this.getServletContext().getRequestDispatcher(dispatcher);
                r.forward(request, response);
                return;
                
            }
            request.setAttribute("reponseAjoutMembre", reponse);
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/inscription.jsp");
            r.forward(request, response);
        
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
    @Override
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
