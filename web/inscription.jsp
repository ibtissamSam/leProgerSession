<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>MyFavs - Gestion de favoris</title>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <link href="./style/styleConnexionInscription.css"
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
    <!-- Debut
    // JavaScript pris sur le site: "http://www.java.scripts-fr.com"
    // Double-enter form element script- by Jon Caws joncaws@btinternet.com

    var fieldalias="mot de passe"

    function verify(element1, element2)
     {
      var passed=false

       if (element1.value=='')
       {
        alert("Veuillez entrer votre "+fieldalias+" dans le premier champ!")
        element1.focus()
       }

       else if (element2.value=='')
       {
        alert("Veuillez confirmer votre "+fieldalias+" dans le second champ!")
        element2.focus()
       }

       else if (element1.value!=element2.value)
    
       {
        alert("Les deux "+fieldalias+" ne condordent pas")
   
        element1.select()
       }

       else{
       passed=true
         alert("Inscription effectuée avec succès")
     }
       return passed
     }
  </script> 

  <SCRIPT LANGUAGE='JavaScript'>
  function confirm() {
  alert("I am an alert box!");
  }
  </SCRIPT>

</head>

<body>

  <div id="all">
        <div id="entete">
                     <h1>MyFavs</h1>
     </div>
    <div id="main">

     
        
        
       <div id="menu">
	<a href="#" class="hide">Menu &uarr;</a>
         <a href="#" class="show">Menu &darr;</a>
			<ul id="list">
				
			<li>
					<a href="index.jsp">Accueil</a>
				</li>
				<li>
					<a  href="page.jsp">Nos Favoris</a>
				</li>
				<li>
					<a  href="login.jsp">Se connecter</a>
				</li>
				<li>
					<a  href="inscription.jsp">S'inscrire</a>
				</li>	

	
			</ul>
		</div>


        

      <div id="centre">
        <a href="index.jsp" id ="retour">   &laquo; Retour</a>

      

        <h2> Inscription </h2> 
        <div id = 'inscription'>
    
          <div id = 'image'>
              <img src="./style/image/new.png" alt="image" width = '100' height = '95'/>
          </div>
          
          <form method="post" action="ctrl.do" onSubmit="return verify(this.pass, this.pass2)" autocomplete="on" >

            <input type="email" name="email" size="25" placeholder="me@example.com" value="" required autofocus/><br />
        

            <input type="password" name="pass" size="25" required placeholder = "Mot de passe"/>
            <input type="password" name="pass2" size="25" placeholder = "Confirmation mot de passe" required/>
            <input type="text" name="prenom" size="25" placeholder = "Prenom" required/>
            <input type="text" name="nom" size="25" placeholder = "Nom"/>
             <% if (request.getAttribute("reponseAjoutMembre") != null) {
                                        out.println("<strong>" + (String) request.getAttribute("reponseAjoutMembre") + "</strong>");
                                    }
                                %> 
            <div align="center"> 
              <p class="submit">
                      <input type="submit" name="bOkInscription" value="S'inscrire" />
                           <input type="hidden" name="action" value="inscription" />
               <!--  <button type="submit"  value = 'annuler' formnovalidate>Annuler</button> -->
              </p>  
            </div>

          </form>

        </div>
      </div>

    </div>
   <div id="pieddepage"> 
 Syst&egrave;me de gestion de favoris. &copy; Con&ccedil;u et r&eacute;alis&eacute; par Ibtissam El Madi & Marie Betis. Tous droits r&eacute;serv&eacute;s.
</div>
  </div>

</body>
</html>

