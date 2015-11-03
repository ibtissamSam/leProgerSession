package com.projetFavGit.modele;

public class Lien
{

  private int idlien =7;
  private String titre = "google";
  private String adresse = "";
  private String nomcat = "AAA";
  
    public Lien(int idlien)
    {
       this.idlien = idlien;	  
    }
    public Lien(int idlien, String title, String adresse, String nomcat)
    {
       this.idlien = idlien;
       this.titre = title;	
       this.adresse = adresse;	
       this.nomcat = nomcat;	
        
    }
    public int getIdlien()
	{
	  return this.idlien;
	}
    public void setIdlien(int idl)
	{
	 this.idlien = idlien;
	}
	/*public String getEmail()
	{
	  return this.email;
	}
	
	public void setEmail(String eml)
	{
		this.eml = eml;
	}
        */
  
	public String getTitre()
	{
		return this.titre;
	}
	
	public void setTitre(String titre)
	{
			this.titre = titre;
	}

	public String getAdresse()
	{
			return this.adresse;
	}
	
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
	
	public String getNomcat()
	{
	       return this.nomcat;
	}
	
	public void setNomcat(String nomcat)
	{
		this.nomcat = nomcat;
	}

	public String __toString()
	{
		//return "lien[".$this->idl.",".$this->ttre.",".$this->adr.",".$this->eml."]";
		//return $this->nomcat.",".$this->ttre.",".$this->adr ;

		return this.idlien+","+this.titre+","+this+adresse+","+this.nomcat;
	}
	public void affiche()
	{
	  this.__toString();
          //out.println
	}
	/*public void loadFromRecord(String ligne)
	{
		this.idl = ligne["idlien"];
		this.ttre = ligne["titre"];
		this.adr = ligne["adresse"];
		this.nomcat = ligne["nomcat"];
	}	
        */
        
        
}
