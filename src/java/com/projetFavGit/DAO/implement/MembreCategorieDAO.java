package com.projetFavGit.DAO.implement;

import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.projetFavGit.DAO.principal.DAO;
import com.projetFavGit.modele.MembreCategorie;

public class MembreCategorieDAO extends DAO<MembreCategorie>{

	public MembreCategorieDAO(Connection c) {
		super(c);
	}

	@Override
	public boolean create(MembreCategorie x) {
		String req = "INSERT INTO MembreCategorie (`cat' ,'email') "+
				"VALUES ('"+x.getCat()+"','"+x.getEmail()+"')";
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

	public MembreCategorie read(int idc) 
	{
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery("SELECT * FROM MembreCategorie WHERE cat = '"+idc+"'");
                if (r.next())
                {
                    MembreCategorie c = new MembreCategorie(   r.getString("cat"),
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
        public boolean delete(MembreCategorie x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM MembreCategorie WHERE cat='"+x.getCat()+"'");
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
        
            public boolean delete(String x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM MembreCategorie WHERE cat='"+x+"'");
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
      
        
	
        
   /*   public static function find($id)
	{
		$db = Database::getInstance();

		$pstmt = $db->prepare("SELECT * FROM membrecategorie WHERE email = :x");
		$pstmt->execute(array(':x' => $id));
		
		$result = $pstmt->fetch(PDO::FETCH_OBJ);
		$p = new MembreCategorie($id);

		if ($result)
		{
			$p->setIdcat($result->idcat);
			$p->setIdlien($result->idlien);
			$c = new MembreCategorieDAO();
			$p = $c->find($p->getIdlien());
			$pstmt->closeCursor();
			return $p;
		}
		$pstmt->closeCursor();
		return null;
	}	

		public function create($x) {
		$request = "INSERT INTO membrecategorie (email,idcat)".
				" VALUES ('".$x->getEmail()."','".$x->getCat()."')"; 
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
	@Override
	public boolean update(MembreCategorie x) {
		Statement stm = null;
		try 
		{
			String req = "UPDATE categorie SET cat = '"+x.getCat()+"'" +
							" WHERE idcat = '"+x.getEmail()+"'";		
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
	public List<MembreCategorie> findAll() 
	{
		List<MembreCategorie> liste = new LinkedList<MembreCategorie>();
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM MembreCategorie");
			while (r.next())
			{
				 MembreCategorie c = new MembreCategorie( r.getString("cat"),
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


