
package lacysKioskLogicparts;

/**
 * ShoppingCartItem class
 * @author Alisha
 */
public class ShoppingCartItem {
    
    Products product;
    int quantity;
    
    public ShoppingCartItem(){}     
    
    public ShoppingCartItem(Products product){ //Constructor with Inventory object passed in
        
        this.product = product;
        quantity = 1;
    }
  
    public ShoppingCartItem(Products product, int quantity) //Inventory object and quantity of object passed in
    {
        this.product = product;
        this.quantity = quantity;
    }
    
    //Setters and Getters
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
