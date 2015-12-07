<%-- 
    Document   : ajouter
    Created on : Oct 31, 2015, 10:08:09 PM
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
              Id lien: <input type="text" name="idLien" value="" />
              <br />
              Titre: <input type="text" name="titre" value="" />
              <br />
              Adresse: <input type="text" name="adresse" value="" />
              <br />
              Nom catégorie: <input type="text" name="nomCat" value="" />
              <br />
              <input name="action" value="ajouter" type="hidden" />
              <input type="submit" value="Ajouter" />
             
             </form>
    </body>
</html>
