package com.projetFavGit.modele;

public class Membre 
{
        private String email = "AAA";
	private String pass = "";
	private String prenom = "";
        private String nom = "";
	
	//constructeurs
        public Membre() // pour la mise à jour des membres
	{
	}
        
	public Membre(String email)
	{
		//this.numero =numero;
		this.email = email;
       //         this.catalogueDefaut=catalogueDefaut;
	}
        public Membre(String email, String pass, String nom, String prenom)
	{
		//this.numero =numero;
		this.email = email;
                this.pass = pass;
                this.nom = nom;
                this.prenom = prenom;
       //         this.catalogueDefaut=catalogueDefaut;
	}
     
        public String getEmail()
	{
	       return email;
	}
        public void setEmail(String email)
	{
	   this.email = email;	
		
	}
	
        
	public String getPass()
	{
	return pass;
	}
	
	public void setPass(String pass)
	{
	    this.pass = pass;
	}

	public String getPrenom()
	{
	    return prenom;
	}
	
	public void setPrenom(String prenom)
	{
	    this.prenom = prenom;
	}
	
    public String getNom()
	{
	    return nom;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	


	public String __toString()
	{
		return this.email;
		//"membre[".$this->email.",".$this->prenom.",".$this->nom."]";
	}
	public void affiche()
	{
		 this.__toString();
                  //out.println
	}
	/* public void loadFromRecord(ligne)
	{
		this.email = ligne["email"];
		this.pass = ligne["pass"];
		this.prenom = ligne["prenom"];
		this.nom = ligne["nom"];
	}	
	*/
	
	
	
}
