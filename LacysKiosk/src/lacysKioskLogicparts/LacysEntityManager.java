
package lacysKioskLogicparts;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;
import lacysKioskGUIparts.MainPage;

/**
 * EntityManager class
 * In the future this should probably be split up to multiple individual entity managers for each entity class
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
    
    
    public List<Orders> getAllOrders()
    {
        return (List<Orders>) em.createNamedQuery("Orders.findAll").getResultList();
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
    
    public Users findUser(String name) //Find by name
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
    
    //Having some problem with the autopopulating in the tables, so created these methods to get the last id number
    //for a few of the entity classes
    public int getLastOrderID()
    {
        int num = 0;
        
        List<Orders> ordersList = em.createQuery("SELECT o FROM Orders o Order by o.orderID").getResultList();
        int total = ordersList.size();
        num = ordersList.get(total - 1).getOrderID();
        
        return num;
    }
    
    public int getLastProductID()
    {
        int num = 0;
        List<Products> productsList = em.createQuery("SELECT p FROM Products p Order by p.productID").getResultList();
        int total = productsList.size();
        num = productsList.get(total - 1).getProductID();
        return num;
    }
    
    public int getLastFeedbackID()
    {
        int num = 0;
        List<Messages> messageList = em.createQuery("SELECT m FROM Messages m Order by m.messageID").getResultList();
        int total = messageList.size();
        num = messageList.get(total - 1).getMessageID();
        return num;
    }
    
    public List<Messages> getAllStoreMessages()
    {
        return (List<Messages>) em.createNamedQuery("Messages.findByTarget").setParameter("target", "Store").getResultList();  
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
        int newNum = getLastFeedbackID() + 1;
        em.getTransaction().begin();
        Messages message = new Messages("Message", "Store", text, null, MainPage.getUser());
        message.setMessageID(newNum);
        em.persist(message);
        em.getTransaction().commit(); 
    }
    
    public void addReview(String text, Products product)
    {
        int newNum = getLastFeedbackID() + 1;
        em.getTransaction().begin();
        Messages message = new Messages("Feedback", "Product", text, product, MainPage.getUser());
        message.setMessageID(newNum);
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
        int newNum = getLastOrderID() + 1;
        em.getTransaction().begin();
        Orders order = new Orders(1430203356.0, address, MainPage.getUser());
        order.setOrderID(newNum);
        em.persist(order);
        em.flush();
        em.refresh(order);
        
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
            em.flush();
        }
        em.getTransaction().commit();
    }
    
    
    public void addProduct(Products product)
    {
        int newNum = getLastProductID() + 1;
        em.getTransaction().begin();
        Products newProduct = new Products(product.getProductName(), product.getUnitPrice(), product.getUnitsInStock(), 
                                            0, product.getCategory(), product.getDescription(), 0.0);
        newProduct.setProductID(newNum);
        em.persist(newProduct);
        em.getTransaction().commit();
    }
    
    public void updateProduct(Products changedProduct)
    {
        Products theProduct = (Products) em.createNamedQuery("Products.findByProductID").setParameter("productID", changedProduct.getProductID()).getSingleResult();
        em.getTransaction().begin();
        theProduct.setProductName(changedProduct.getProductName());
        theProduct.setUnitPrice(changedProduct.getUnitPrice());
        theProduct.setUnitsInStock(changedProduct.getUnitsInStock());
        theProduct.setDescription(changedProduct.getDescription());
        theProduct.setCategory(changedProduct.getCategory());
        em.persist(theProduct);
        em.getTransaction().commit();
    }
    
    public void deleteProduct(Products product)
    {
        Products theProduct = (Products) em.createNamedQuery("Products.findByProductID").setParameter("productID", product.getProductID()).getSingleResult();
        em.getTransaction().begin();
        em.remove(theProduct);
        em.getTransaction().commit();
    }
    
    
}
