<style type="text/css">
      .show {display: none; }
      .hide:focus + .show {display: inline; }
      .hide:focus { display: none; }
      .hide:focus ~ #list { display:none; }
      @media print { .hide, .show { display: none; } }
 </style>


<div id="menu">
	<a href="#" class="hide">Menu &uarr;</a>
         <a href="#" class="show">Menu &darr;</a>
			<ul id="list">
				
							
<?php
	if (!ISSET($_SESSION)) session_start();
	if (ISSET($_SESSION["email"]))
	{
?>
				<li>
					<a href="?action=pagemembre">Accueil</a>
				</li>
				<li>
					<a  href="?action=page">Nos Favoris</a>
				</li>	
	<?php	
	}
	else
	{
?>			
				<li>
					<a href="?action=presentation">Accueil</a>
				</li>
				<li>
					<a  href="?action=page">Nos Favoris</a>
				</li>
				<li>
					<a  href="?action=connecter">Se connecter</a>
				</li>
				<li>
					<a  href="?action=inscription">S'inscrire</a>
				</li>	

<?php	
	}
?>			
		
			</ul>
		</div>

