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
    <!-- Debut all -->
    <div id="all">
    <div id="entete">
                            <h1>MyFavs</h1>
            </div>	
      <!-- Debut main -->
        <div id="main">
        <?php
        include("menu.php");
        ?>
        <!-- Debut centre -->
        <div id="centre">
          <!-- Debut message -->
          <div id="message">
            <div id="photo"><img src="./style/image/Icon-Profil.png" alt="image"/></div> 
            <?php 
              require_once('./modele/classes/Membre.class.php');
              require_once('./modele/MembreDAO.class.php');
              $membre = new MembreDAO();
              $m = new Membre();
              $m = $membre->find($_SESSION["email"]);
              echo $m->getPrenom(); 
            ?>
            <a href="?action=parametre" id = "param"> Modifier</a>

            <br />
            <div id = "deconnexion"><a href="?action=deconnexion">D&eacuteconnexion</a></div>
          </div>
          <!-- fin message -->

          <!-- Debut menu2 -->
          <div id="menu2">
            <ul>
              <li><a href="#">Ajouter</a>
                <ul>
                  <li><a href="?action=ajouter">Lien</a></li>
                  <li><a href="?action=ajoutercat">Cat&eacutegorie</a></li>
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
            <?php
              require_once('./modele/CategorieDAO.class.php');  
              require_once('./modele/classes/ListeCategorie.class.php');

              $dao2 = new CategorieDAO();
              $liste = $dao2->findAll();
              $comptcat = 0;

              while ($liste->next()) {
                $p = $liste->getCurrent();
                if ($p!=null)
                {   
                  $categorie = explode(',',$p);
                  if ($categorie[1] == $_SESSION["email"])
                    { 
                      $comptcat++; 
                      echo "
                      <div id= 'listeCat'>
                      ".$categorie[0]." 
                      <a href='?action=pagemembre&catASupprimer=".$categorie[2]."' onclick='Supp(this.href); return(false);' >  <img src='./style/image/delete.png' alt='' /> </a> </br>
                      <a href='?action=modifiercat&catAModifier=".$categorie[2]."'>  <img src='./style/image/edit.png' alt='' /> </a>
                      </div> <br/>";
                    }

                  $dao3 = new LienDAO();
                  $liste3 = $dao3->findAll();

                  while ($liste3->next()) {
                    $p3 = $liste3->getCurrent();
                    if ($p3!=null)
                    {  
                      $lien= explode(',',$p3);
                      //  echo $lien[0];
                      if ($categorie[1] == $_SESSION["email"]) {
                        if ($categorie[0] == $lien[3])
                        { 
                          if ($lien[2] != null)
                          { 
                          echo "<figure>
                          <img src='./style/image/favoris.png' alt='' />
                          <figcaption><a href='".$lien[2]."'>".$lien[1]."</a>
                          <a href='?action=modifier&numAModifier=".$lien[0]."'>  <img  src='./style/image/edit.png' alt='' /> </a>
                          <a href='?action=supprimer&numASupprimer=".$lien[0]."' onclick='Supp(this.href); return(false);'> <img src='./style/image/delete.png' alt='' /></a>
                          </figcaption>
                          </figure>";
                          }
                        } 
                      }
                    } 
                  } 

                }
              }
              if ($comptcat == 0 )
                echo "Vous n'avez aucune cat&eacute;gorie pour le moment. <a href='?action=ajoutercat'>Ajoutez-en une</a>";
            ?>
          </div>
          <!--             Fin de l'affichage des catégories et des liens du membre      -->
          </div>
          <!-- fin centre -->
        </div>
        <!-- Fin main-->
      <?php
      include("footer.php");
      ?>
    </div>
    <!-- Fin all -->

  </body>
</html>






