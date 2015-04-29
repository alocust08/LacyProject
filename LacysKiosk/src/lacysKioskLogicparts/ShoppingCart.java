
package lacysKioskLogicparts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * ShoppingCart class
 * @author Alisha
 */
public class ShoppingCart {
    
    HashMap < Integer, ShoppingCartItem> cart = null; //Hashmap to hold cart items, product ID is the key
    double subtotal, total, shipCost; //Values for order
    int numItems; //Number of items in cart
    double salesTax = 0.06; //The general sales tax value used for testing purposes for this program
    
    public ShoppingCart() 
    {
        //Sets up and initializes everything for the cart
        cart = new HashMap<>();
        subtotal = 0;
        total = 0;
        numItems = 0;
        shipCost = 0;
    }

    public List<ShoppingCartItem> getCartItems()
    {
        List<ShoppingCartItem> results = new ArrayList<>();
        results.addAll(cart.values());
        return results;
    }
    
    public ShoppingCartItem getSingleItem(String name) //Receives name of product to find in shopping cart items
    {
        ShoppingCartItem item = null;
        List<Integer> keyList = new ArrayList<Integer>();
        Set<Integer> keysSet = cart.keySet(); //Get set of keys in cart map
        
        for (Integer key : keysSet)
        {
            keyList.add(key);
        }
        
        for (int i = 0; i < cart.size(); i++) //Cycle through items in cart and see if any match the product name
        {
            item = cart.get(keyList.get(i));
            if (item.getProduct().getProductName().equals(name))
            {
                return item;
            }
        }
        return item; //Return null if can't find item
    }
    
    public void addItem(int prodId, Products product)
    {
        if (!cart.containsKey(prodId)) //If cart does not already contain product id, then add new item to cart
        {
            ShoppingCartItem item = new ShoppingCartItem(product);
            cart.put(prodId, item);
        }
        calcUpdate();
    }
    
    public void addMultipleItems(int prodId, Products product, int num)
    {
        if (!cart.containsKey(prodId))
        {
            ShoppingCartItem item = new ShoppingCartItem(product, num);
            cart.put(prodId, item);
        }
        calcUpdate();
    }
    
    public void removeItem(int prodId)
    {
        if (cart.containsKey(prodId)) //if product id is found in cart, remove item at that key
        {
            cart.remove(prodId);
        }
        calcUpdate();
    }
    
    public void updateItem(int prodID, int amount)
    {
        ShoppingCartItem cartItem = cart.get(prodID);
        cartItem.setQuantity(amount);
        calcUpdate();
    }
    
    
    private double calculateTotal()
    {
        double amount = 0.0;
        for (ShoppingCartItem item : getCartItems()) {
            
            Products cartItem = item.getProduct();
            amount += (item.getQuantity() * cartItem.getUnitPrice()); //accumulator for total amount
        }
        return amount;
    }
    
    private int calcNumItems()
    {
        int num = 0;
        for (ShoppingCartItem item : getCartItems()) {
            num += item.getQuantity(); //accumulator for number of items
        }

        return num;
    }
    
    private void calcUpdate() //set new subtotals, totals and number items
    {
        setSubtotal(calculateTotal());
        setTotal(calculateTotal());
        setNumItems(calcNumItems());
    }
    
    public double calcGrandTotal(){
        double theTotal = subtotal + (subtotal * salesTax) + shipCost;
        setTotal(theTotal);
        return theTotal;
    }
    public void clear()
    {
        cart.clear();
        numItems = 0;
        subtotal = 0;
        total = 0;
        shipCost = 0;
    }
    
    //Getters
    public HashMap<Integer, ShoppingCartItem> getCart() {
        return cart;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTotal() {
        return total;
    }

    public int getNumItems() {
        return numItems;
    }
    
    public double getShipCost() {
        return shipCost;
    }
    
    public double getSalesTax() {
        return salesTax;
    }

    //Setters
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }
    
    public void setShipCost(double shipCost) {
        this.shipCost = shipCost;
    }
    
}
