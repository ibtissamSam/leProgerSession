<%-- 
    Document   : ajouterCat
    Created on : Oct 31, 2015, 10:08:33 PM
    Author     : ibtissam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="./ctrl.do" method="POST">
              Id catégorie: <input type="text" name="idCat" value="" />
              <br />
              Nom Catégorie: <input type="text" name="nomCat" value="" />
              <br />
             
              <input name="action" value="ajouterCategorie" type="hidden" />
              <input type="submit" value="Ajouter" />
             
             </form>
    </body>
</html>
