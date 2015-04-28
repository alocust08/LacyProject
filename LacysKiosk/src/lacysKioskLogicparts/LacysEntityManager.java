/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lacysKioskLogicparts;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alisha
 */
public class LacysEntityManager {
    
    @PersistenceContext
    EntityManagerFactory emf;
    EntityManager em;
    
    public LacysEntityManager()
    {
        emf = Persistence.createEntityManagerFactory("LacysKioskPU");
        em = emf.createEntityManager();
    }
    
    public List<Inventory> getAllProducts()
    {
        return (List<Inventory>) em.createNamedQuery("Inventory.findAll").getResultList();
        
    }
    
    public List<Inventory> getProductsByCategory(String category)
    {
        return (List<Inventory>) em.createNamedQuery("Inventory.findByItemCategory").setParameter("itemCategory", category).getResultList();
    }
    
    public Inventory findProductbyName(String name)
    {
        Inventory product;
        
        try
        {
            product = (Inventory) em.createNamedQuery("Inventory.findByItemName").setParameter("itemName", name).getSingleResult();
        }
        catch (Exception ex)
        {
            product = null;
        }
        
        return product;
    }
    
    public List<Messages> getReviewsByProduct(int prodId)
    {
        return (List<Messages>) em.createNamedQuery("Messages.findByTarget").setParameter("target", prodId).getResultList(); 
    }
    
    public Users findUserByID(int userID)
    {
        Users aUser = (Users) em.createNamedQuery("Users.findByUserID").setParameter("userID", userID).getSingleResult();
        return aUser;
        
    }
    
    public Users findUser(String name)
    {
        Users tempUser;
        try 
        {
            tempUser = (Users) em.createNamedQuery("Users.findByUserName").setParameter("userName", name).getSingleResult();
        }
        catch (NoResultException nrex)
        {
            tempUser = null;
        }
        catch(NonUniqueResultException nurex)
        {
            tempUser = null;
        }
        catch(Exception ex)
        {
            tempUser = null;
        }
        
        return tempUser;     
    }
    
    public String findPassword(String id)
    {
        String tempPswd;
        try
        {
            String query = "SELECT u.UserName FROM Users u WHERE u.userID = :userID";
            tempPswd = (String) em.createQuery(query).setParameter("userID", id).getSingleResult();
        }
        catch (NoResultException nrex)
        {
            tempPswd = null;
        }
        catch(NonUniqueResultException nurex)
        {
            tempPswd = null;
        }
        catch(Exception ex)
        {
            tempPswd = null;
        }
       return tempPswd; 
    
    }
}
