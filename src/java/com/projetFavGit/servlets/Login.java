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
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Chargement du pilote :
            Class.forName(this.getServletContext().getInitParameter("piloteJDBC"));
            
        } catch (ClassNotFoundException ex) {
            request.setAttribute("message", "Impossible de charger le pilote");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);
        }
        Connexion.setUrl(this.getServletContext().getInitParameter("URLbaseDonnees"));
        String  u = request.getParameter("email"),
                p = request.getParameter("pass");     
        if (u==null || u.trim().equalsIgnoreCase(""))
        {
            //Utilisateur non saisi :
            request.setAttribute("message", "email obligatoire");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);
            return;
        }
        
        MembreDAO mDAO=new MembreDAO(Connexion.getInstance());
        Membre member=mDAO.read(u.trim());
        if (member!=null){
           if (member.getPass().equals(p))
                {
                    //Connexion OK
                  
                    HttpSession session = request.getSession(true);
                    member.setPass("*****");//pour sécurité.
                    session.setAttribute("connecte", member);
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/pageMembre.jsp");
                    r.forward(request, response);
                    ///return;
                }
                else
                {
                    //Mot de passe incorrect
                    request.setAttribute("message", "Mot de passe incorrect.");
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
                    r.forward(request, response);
                }
        }
        else{
            //Utilisateur inexistant
            request.setAttribute("message", "email "+u+" inexistant.");
            RequestDispatcher r = this.getServletContext().getRequestDispatcher("/login.jsp");
            r.forward(request, response);
        }
     }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
