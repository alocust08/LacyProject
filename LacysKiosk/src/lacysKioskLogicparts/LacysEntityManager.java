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
import javax.swing.JOptionPane;
import lacysKioskGUIparts.MainPage;

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
    
    public List<Products> getAllProducts()
    {
        return (List<Products>) em.createNamedQuery("Products.findAll").getResultList();
        
    }
    
    public List<Products> getProductsByCategory(String category)
    {
        return (List<Products>) em.createNamedQuery("Products.findByCategory").setParameter("category", category).getResultList();
    }
    
    public Products findProductbyName(String name)
    {
        Products product;
        
        try
        {
            product = (Products) em.createNamedQuery("Products.findByProductName").setParameter("productName", name).getSingleResult();
        }
        catch (Exception ex)
        {
            product = null;
        }
        
        return product;
    }
    
    public Users findUserByID(int userID)
    {
        Users aUser = (Users) em.createNamedQuery("Users.findByUserID").setParameter("userID", userID).getSingleResult();
        return aUser;
        
    }
    
    public Users findUser(String name)
    {
        List<Users> tempList;
        Users tempUser;
        
        tempList = (List<Users>) em.createNamedQuery("Users.findByUserName").setParameter("userName", name).getResultList();
        
        if (tempList.isEmpty() || tempList == null)
        {
            tempUser = null;
        }
        else 
            tempUser = tempList.get(0);
        
        return tempUser;     
    }
    
    
    public boolean login(String username, String password)
    {
        boolean loggedIn = false;
        
        Users tempUser = findUser(username);
        
        if (tempUser != null)
        {
            if(tempUser.getUserPassword().equals(password))
            {
                loggedIn = true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Password did not match.", "Log In Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No such user found in system.", "Log In Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return loggedIn;
    }
    
    public void addFeedback(String text)
    {
        em.getTransaction().begin();
        Messages message = new Messages("Message", "Store", text, null, MainPage.getUser());
        em.persist(message);
        em.getTransaction().commit(); 
    }
    
    public void addReview(String text, Products product)
    {
        em.getTransaction().begin();
        Messages message = new Messages("Feedback", "Product", text, product, MainPage.getUser());
        em.persist(message);
        em.getTransaction().commit();
    }
    
    public void addCustomer(String name, String password)
    {
        em.getTransaction().begin();
        Users user = new Users(name, password, 0.00, "Customer");
        em.persist(user);
        em.getTransaction().commit();
    }
    
    public void addOrder(ShoppingCart cart, String address)
    {
        em.getTransaction().begin();
        Orders order = new Orders(111111.0, address, MainPage.getUser());
        em.persist(order);
        for (ShoppingCartItem cartItem: cart.getCartItems())
        {
            Products product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();
            //Add each shopping cart item to the order details table
            OrderDetailsPK detailPK = new OrderDetailsPK(order.getOrderID(), product.getProductID());
            OrderDetails detail = new OrderDetails(detailPK, product.getUnitPrice(), quantity, product, order);
            
            int newInStock = product.getUnitsInStock() - quantity; //update in stock value of product
            product.setUnitsInStock(newInStock);
            em.persist(detail);
        }
        
        em.getTransaction().commit();
    }
    
    public void addProduct(Products product)
    {
        em.getTransaction().begin();
        Products newProduct = new Products(product.getProductName(), product.getUnitPrice(), product.getUnitsInStock(), 
                                            0, product.getCategory(), product.getDescription(), 0.0);
        em.persist(newProduct);
        em.getTransaction().commit();
    }
    
    public void updateProduct()
    {
        
    }
    
    public void deleteProduct()
    {
        
    }
    
    
}
