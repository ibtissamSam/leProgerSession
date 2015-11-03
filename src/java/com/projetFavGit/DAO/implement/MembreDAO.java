package com.projetFavGit.DAO.implement;

import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import com.projetFavGit.DAO.principal.DAO;
import com.projetFavGit.modele.Membre;

public class MembreDAO extends DAO<Membre>{

	public MembreDAO(Connection c) {
		super(c);
	}

	@Override
	public boolean create(Membre x) {
		String req = "INSERT INTO membre (`email','pass','prenom','nom') "+
				"VALUES ('"+x.getEmail()+"','"+x.getPass()+"','"+x.getPrenom()+"','"+x.getNom()+"')";
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

	public Membre read(String email) 
	{
            try 
            {
                Statement stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery("SELECT * FROM membre WHERE email = '"+email+"'");
                if (r.next())
                {
                    Membre c = new Membre(   r.getString("email"),
                                                r.getString("pass"),
						r.getString("nom"),
						r.getString("prenom"));
						
           
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
	public boolean update(Membre x) {
		Statement stm = null;
		try 
		{
			String req = "UPDATE membre SET pass = '"+x.getPass()+"', prenom = '"+x.getPrenom()+"', nom = '"+x.getNom()+"'" +
							" WHERE email = '"+x.getEmail()+"'";		
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
	public List<Membre> findAll() 
	{
		List<Membre> liste = new LinkedList<Membre>();
		try 
		{
			Statement stm = cnx.createStatement(); 
			ResultSet r = stm.executeQuery("SELECT * FROM membre");
			while (r.next())
			{
				 Membre c = new Membre( r.getString("email"),
                                                r.getString("pass"),
						r.getString("nom"),
						r.getString("prenom"));
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
        public boolean delete(Membre x) 
	{
                Statement stm = null;
                try 
                {
                        stm = cnx.createStatement(); 
                        int n= stm.executeUpdate("DELETE FROM membre WHERE email='"+x.getEmail()+"'");
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


