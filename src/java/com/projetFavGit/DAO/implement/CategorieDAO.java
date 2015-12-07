package com.projetFavGit.DAO.implement;

import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.projetFavGit.DAO.principal.DAO;
import com.projetFavGit.modele.Categorie;

public class CategorieDAO extends DAO<Categorie>{

	public CategorieDAO(Connection c) {
		super(c);
	}

	@Override
	public boolean create(Categorie x) {
		String req = "INSERT INTO categorie (idcat,nomcat,email) "+
				"VALUES ("+x.getIdcat()+",'"+x.getNomcat()+"','"+x.getEmail()+"')";
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

	public Categorie read(int idc) 
	{
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery("SELECT * FROM categorie WHERE idcat = '"+idc+"'");
                if (r.next())
                {
                    Categorie c = new Categorie(   r.getInt("idcat"),
                                                r.getString("nomcat"),
						r.getString("email"));
						
           
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
	public boolean update(Categorie x) {
		Statement stm = null;
		try 
		{
			String req = "UPDATE categorie SET nomcat = '"+x.getNomcat()+"', nom = '"+x.getEmail()+"'" +
							" WHERE idcat = '"+x.getIdcat()+"'";		
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
	public List<Categorie> findAll() 
	{
		List<Categorie> liste = new LinkedList<Categorie>();
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM categorie");
			while (r.next())
			{
				 Categorie c = new Categorie( r.getInt("idcat"),
                                                r.getString("nomcat"),
						r.getString("email"));
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
        
   @Override
	public boolean delete(Categorie x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM categorie WHERE cat='"+x.getIdcat()+"'");
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
        
            
   //@Override
	public boolean delete(int x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM categorie WHERE cat='"+x+"'");
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
            
        
        
      /* public static function findmax()
		{
			$requete = 'SELECT max(idcat) FROM categorie';
				$cnx = Database::getInstance();
				
			//	$res = $cnx->query($requete);
			 $res1=$cnx->query($requete);
			$idmax1=$res1->fetchColumn(); 
			return $idmax1+1; 
		
		}	
 
	public static function find($id)
	{
		$db = Database::getInstance();

		$pstmt = $db->prepare("SELECT * FROM categorie WHERE idcat = :x");//requête paramétrée par un paramètre x.
		$pstmt->execute(array(':x' => $id));
		
		$result = $pstmt->fetch(PDO::FETCH_OBJ);
		$p = new Categorie();

		if ($result)
		{
			$p->setIdcat($result->idcat);
			$p->setNomcat($result->nomcat);
			$p->setEmail($result->email);
			$pstmt->closeCursor();
			return $p;
		}
		$pstmt->closeCursor();
		return null;
	}
	
	public function delete($x) {
		$request = "DELETE FROM categorie WHERE idcat = '".$x."'";
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
        
       */ 
        
        
        
        
       // @Override
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
        
        
	}


