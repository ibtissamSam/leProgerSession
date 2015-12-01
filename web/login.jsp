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
				 <a href="index.jsp" id = "retour">   &laquo; Retour</a>

				
				<h2> Connexion </h2>
				<div id = 'connexion'>
					
					
					<div id = 'image'>
						<img src="./style/image/about-icon-md.png" alt="image" width = '100' height = '95'/>
					</div>
					
					
						<form action="ctrl.do" method="post" autocomplete="on">

						<input type="email" name="email" size="25" placeholder="me@example.com" value="" required autofocus/>
						<br />
					

						<input type="password" name="pass" size="25" placeholder="Mot de passe" required/>
						<br />
						
						<br />

						<div align="center">
							<p class="submit">
								<input name="action" value="login" type="hidden" />
                                                                &nbsp; <% if(request.getAttribute("message")!=null){
                             out.println((String)request.getAttribute("message"));
                            }
                         %>
								<button type="submit" value = "login" >Connexion</button>
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

