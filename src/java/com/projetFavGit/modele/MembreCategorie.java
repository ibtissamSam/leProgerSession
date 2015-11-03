package com.projetFavGit.modele;

public class MembreCategorie
{
 	private String email = "";
	private String cat = "";
  
 public MembreCategorie(String n)	//Constructeur
	{
	  this.email = n;
	}	
 
  public MembreCategorie(String n, String cat)	//Constructeur
	{
	  this.email = n;
          this.cat = cat;
	}
	
	public String getEmail()
	{
	    return this.email;
	}
	
	public void setEmail(String email)
	{
	    this.email = email;
	}
        
	public String getCat()
	{
	     return this.cat;
	}
	
	public void setCat(String cat)
	{
	     this.cat= cat;
	}

	public String __toString()
	{
		return this.email+","+this.cat;
	}
	public void affiche()
	{
		this.__toString();
                // out.println
	}
	/* public function loadFromRecord($ligne)
	{
		$this->email = $ligne["email"];
		$this->cat= $ligne["idcat"];
	}
        */
}
