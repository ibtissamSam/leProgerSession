package com.projetFavGit.DAO.implement;

import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.projetFavGit.DAO.principal.DAO;
import com.projetFavGit.modele.Lien;

public class LienDAO extends DAO<Lien>{

	public LienDAO(Connection c) {
		super(c);
	}

	@Override
	public boolean create(Lien x) {
		String req = "INSERT INTO lien (idlien,titre,adresse,nomcat) "+
				"VALUES ("+x.getIdlien()+",'"+x.getTitre()+"','"+x.getAdresse()+"','"+x.getNomcat()+"')";
		Statement stm = null;
		try 
		{
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;
	}

	//public Membre read(int e)
	//{
		// TODO Auto-generated method stub
		//return this.read(""+id);
	//}

	public Lien read(int idl) 
	{
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery("SELECT * FROM lien WHERE idlien = '"+idl+"'");
                if (r.next())
                {
                    Lien c = new Lien(   r.getInt("idlien"),
                                                r.getString("titre"),
						r.getString("adresse"),
						r.getString("nomcat"));
						
           
                        r.close();
                        stm.close();
                        return c;
                }
            }
            catch (SQLException exp)
            {
            }
            return null;
	}
      
	@Override
	public boolean update(Lien x) {
		Statement stm = null;
		try 
		{
			String req = "UPDATE lien SET titre = '"+x.getTitre()+"', adresse = '"+x.getAdresse()+"', nomcat = '"+x.getNomcat()+"'" +
							" WHERE idlien = '"+x.getIdlien()+"'";		
			stm = cnx.createStatement(); 
			int n= stm.executeUpdate(req);
			if (n>0)
			{
				stm.close();
				return true;
			}
		}
		catch (SQLException exp)
		{
		}
		finally
		{
			if (stm!=null)
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return false;
	}

	@Override
	public List<Lien> findAll() 
	{
		List<Lien> liste = new LinkedList<Lien>();
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM lien");
			while (r.next())
			{
				 Lien c = new Lien( r.getInt("idlien"),
                                                r.getString("titre"),
						r.getString("adresse"),
						r.getString("nomcat"));
				liste.add(c);
			}
			r.close();
			stm.close();
		}
		catch (SQLException exp)
		{
		}
		return liste;
		}
        
      /*public static int findmax()
	{
		$requete = 'SELECT max(idlien) FROM lien';
			$cnx = Database::getInstance();
			
		//	$res = $cnx->query($requete);
		 $res1=$cnx->query($requete);
		$idmax1=$res1->fetchColumn(); 
		return $idmax1+1; 
	
	}	
  
   public static function getPage($numPage, $taillePage)
	{
		try {
			$liste = new ListLien();
		    
			$debut = ($numPage - 1)*$taillePage;
		
			$requete = 'SELECT * FROM lien LIMIT '.$debut.', '.$taillePage;
			$cnx = Database::getInstance();
			
			$res = $cnx->query($requete);
		    foreach($res as $row) {
				$p = new Lien();
				$p->loadFromRecord($row);
				$liste->add($p);
		    }
			$res->closeCursor();
		    $cnx = null;
			return $liste;
		} catch (PDOException $e) {
		    print "Error!: " . $e->getMessage() . "<br/>";
		    return $liste;
		}	
	}	
     
     public static function find($id)
	{
		$db = Database::getInstance();

		$pstmt = $db->prepare("SELECT * FROM lien WHERE idlien = :x");
		$pstmt->execute(array(':x' => $id));
		
		$result = $pstmt->fetch(PDO::FETCH_OBJ);
		$p = new Lien();

		if ($result)
		{
			$p->setIdlien($result->idlien);
			$p->setTitre($result->titre);
			$p->setAdresse($result->adresse);
			$p->setnomcat($result->nomcat);
			$pstmt->closeCursor();
			return $p;
		}
		$pstmt->closeCursor();
		return null;
	}	   
        
    public function delete($x) {
    $request = "DELETE FROM lien WHERE idlien = '".$x->getIdlien()."'";
    try
    {
      $db = Database::getInstance();
      return $db->exec($request);
    }
    catch(PDOException $e)
    {
      throw $e;
    }
  }
        
  */     // @Override
       /* public static Membre find(String eml)
	{
		List<Membre> liste = new LinkedList<Membre>();
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM membre WHERE email = eml");
			while (r.next())
			{
		        Membre p = new Membre();
		        if ($result)
		        { p.setEmail(result.email);
			p.setPass(resul.pass);
			p.setPrenom(result.prenom);
			p.setNom(result.nom);
			pstmt.closeCursor();
			return p;
		}
		$pstmt->closeCursor();
		return null;
	}	
        
        
        */
        
        
        
        
        @Override
	public boolean delete(Lien x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM lien WHERE idlien='"+x.getIdlien()+"'");
                        if (n>0)
                        {
                                stm.close();
                                return true;
                        }
                }
                catch (SQLException exp)
                {
                }
                finally
                {
                        if (stm!=null)
                        try {
                                stm.close();
                        } catch (SQLException e) 
                        {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }			
                }
                return false;
	}
        
}


