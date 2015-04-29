/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lacysKioskLogicparts;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Alisha
 */
@Embeddable
public class OrderDetailsPK implements Serializable {

    private int orderID;
    private int productID;
    
    
    
    public OrderDetailsPK() {
    }

    public OrderDetailsPK(int orderId, int productId) {
        this.orderID = orderId;
        this.productID = productId;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.orderID);
        hash = 23 * hash + Objects.hashCode(this.productID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetailsPK other = (OrderDetailsPK) obj;
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetailsPK{" + "orderID=" + orderID + ", productID=" + productID + '}';
    }
    
}
