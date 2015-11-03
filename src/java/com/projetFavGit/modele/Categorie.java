package com.projetFavGit.modele;

public class Categorie
{
  private int idcat = 1;
  private String nomcat = "";
  private String email = "";

	
	public Categorie(String n)	//Constructeur
	{
		this.nomcat = n;
	}	
	public Categorie(int idcat, String nomcat, String email)	//Constructeur
	{
		this.idcat = idcat;
                this.nomcat = nomcat;
                this.email = email;
	}

	public int  getIdcat()
	{
	   return this.idcat;
	}
	
	public void setIdcat(int idcat)
	{
	    this.idcat = idcat;
	}

	public String getNomcat()
	{
	   return this.nomcat;
	}
	
	public void setNomcat(String nomcat)
	{
	   this.nomcat = nomcat;
	}
 	
	public String getEmail()
	{
	   return this.email;
	}
	
	public void setEmail(String email)
	{
	   this.email = email;
	}
	
	public String __toString()
	{
		return this.nomcat+","+this.email+","+this.idcat;
	}
	public void affiche()
	{
		this.__toString();
                //out.println
	}
	/*public function loadFromRecord($ligne)
	{	
		
		$this->idcat = $ligne["idcat"];
		$this->nomcat = $ligne["nomcat"];
		$this->email = $ligne["email"];

		
	}	
        */
}
