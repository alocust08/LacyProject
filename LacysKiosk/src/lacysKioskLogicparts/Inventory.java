/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lacysKioskLogicparts;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alisha
 */
@Entity
@Table(name = "Inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByItemID", query = "SELECT i FROM Inventory i WHERE i.itemID = :itemID"),
    @NamedQuery(name = "Inventory.findByItemCategory", query = "SELECT i FROM Inventory i WHERE i.itemCategory = :itemCategory"),
    @NamedQuery(name = "Inventory.findByItemName", query = "SELECT i FROM Inventory i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Inventory.findByItemQuantity", query = "SELECT i FROM Inventory i WHERE i.itemQuantity = :itemQuantity"),
    @NamedQuery(name = "Inventory.findByItemPrice", query = "SELECT i FROM Inventory i WHERE i.itemPrice = :itemPrice"),
    @NamedQuery(name = "Inventory.findByItemRating", query = "SELECT i FROM Inventory i WHERE i.itemRating = :itemRating"),
    @NamedQuery(name = "Inventory.findByItemDescription", query = "SELECT i FROM Inventory i WHERE i.itemDescription = :itemDescription")})
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ItemID")
    private int itemID;
    @Basic(optional = false)
    @Column(name = "ItemCategory")
    private String itemCategory;
    @Basic(optional = false)
    @Column(name = "ItemName")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "ItemQuantity")
    private int itemQuantity;
    @Basic(optional = false)
    @Column(name = "ItemPrice")
    private double itemPrice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ItemRating")
    private Double itemRating;
    @Column(name = "ItemDescription")
    private String itemDescription;

    public Inventory() {
    }

    public Inventory(int itemID, String itemCategory, String itemName, int itemQuantity, double itemPrice) {
        this.itemID = itemID;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }
    
    public Inventory(int itemID, String itemCategory, String itemName, int itemQuantity, double itemPrice, 
                        double itemRating, String itemDescription) {
        this.itemID = itemID;
        this.itemCategory = itemCategory;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.itemRating = itemRating;
        this.itemDescription = itemDescription;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getItemRating() {
        return itemRating;
    }

    public void setItemRating(Double itemRating) {
        this.itemRating = itemRating;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.itemID;
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
        final Inventory other = (Inventory) obj;
        if (this.itemID != other.itemID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lacysKioskLogicparts.Inventory[ inventoryPK=" + itemID + " ]";
    }
    
}
