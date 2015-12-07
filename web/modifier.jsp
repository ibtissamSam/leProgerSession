<%-- 
    Document   : modifier
    Created on : Oct 31, 2015, 10:10:12 PM
    Author     : ibtissam
--%>

<%@page import="com.projetFavGit.modele.Lien"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier un lien</title>
    </head>
    <body>
        <%
        List<Lien> listeLiens = (List<Lien>)request.getAttribute("listeLiens");
        %>
        <h1>Modifier un lien</h1>
        <select name="Liens">
             <%
            for(int i = 0; i<listeLiens.size();i++)
            {
                %>
                <option><%=listeLiens.get(i).getTitre()%></option>
                <%
            
            }
        %>
        </select>
    </body>
</html>
