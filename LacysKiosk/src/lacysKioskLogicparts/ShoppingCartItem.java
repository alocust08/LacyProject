/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lacysKioskLogicparts;

/**
 *
 * @author Alisha
 */
public class ShoppingCartItem {
    
    Inventory product;
    int quantity;
    
    public ShoppingCartItem(){}     
    
    public ShoppingCartItem(Inventory product){ //Constructor with Inventory object passed in
        
        this.product = product;
        quantity = 1;
    }
  
    public ShoppingCartItem(Inventory product, int quantity) //Inventory object and quantity of object passed in
    {
        this.product = product;
        this.quantity = quantity;
    }
    
    //Setters and Getters
    public Inventory getProduct() {
        return product;
    }

    public void setProduct(Inventory product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
