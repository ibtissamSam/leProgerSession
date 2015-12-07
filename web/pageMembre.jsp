<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

  <head>
    <title>MyFavs - Gestion de favoris</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    <link href="./style/styleMembre.css"
        rel="stylesheet"
        type="text/css" />
             <style type="text/css">
      .show {display: none; }
      .hide:focus + .show {display: inline; }
      .hide:focus { display: none; }
      .hide:focus ~ #list { display:none; }
      @media print { .hide, .show { display: none; } }
 </style>
    <script type="text/javascript">
     function Supp(link){
      if(confirm('Confirmer la suppression ?')){
       document.location.href = link;
      }
     }
    </script>
  </head>

  <body >
      <%
      if (request.getAttribute("message")!=null)
        {
            out.println("<p class=\"errorMessage\">"+request.getAttribute("message")+"</p>");
        }
      %>
    <!-- Debut all -->
    <div id="all">
    <div id="entete">
                            <h1>MyFavs</h1>
            </div>	
      <!-- Debut main -->
        <div id="main">
        <!-- Debut centre -->
        <div id="centre">
          <!-- Debut message -->
          <div id="message">
            <div id="photo"><img src="./style/image/Icon-Profil.png" alt="image"/></div> 
            
          
            <a href="?action=afficherLien"> Modifier lien</a>
            <br />
            <a href="modifiercat.jsp"> Modifier categorie</a>
          

            <br />
            <div id = "deconnexion"><a href="?action=deconnexion">D&eacuteconnexion</a></div>
          </div>
          <!-- fin message -->

          <!-- Debut menu2 -->
          <div id="menu2">
            <ul>
              <li><a href="#">Ajouter</a>
                <ul>
                  <li><a href="ajouter.jsp">Lien</a></li>
                  <li><a href="ajouterCat.jsp">Cat&eacutegorie</a></li>
                </ul>
              </li>

              <li><a href="?action=partager">Partager une cat&eacutegorie</a></li>
              <li><a href="?action=afficherpartager">Vos cat&eacutegories partag&eacutees</a></li>
              <li><a href="?action=partagevue">Cat&eacutegories partag&eacutees avec vous</a></li>
            </ul>
          </div>
          <!-- fin menu2 -->
          <!--              Debut affichage des catégories et des liens du membre      -->
          <div id = "listeCategories"> 
          </div>
          <!--             Fin de l'affichage des catégories et des liens du membre      -->
          </div>
          <!-- fin centre -->
        </div>
        <!-- Fin main-->
    </div>
    <!-- Fin all -->

  </body>
</html>






