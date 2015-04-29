
package lacysKioskLogicparts;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Messages entity class
 * @author Alisha
 */
@Entity
@Table(name = "Messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByMessageID", query = "SELECT m FROM Messages m WHERE m.messageID = :messageID"),
    @NamedQuery(name = "Messages.findByMessageType", query = "SELECT m FROM Messages m WHERE m.messageType = :messageType"),
    @NamedQuery(name = "Messages.findByTarget", query = "SELECT m FROM Messages m WHERE m.target = :target"),
    @NamedQuery(name = "Messages.findByContents", query = "SELECT m FROM Messages m WHERE m.contents = :contents")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "messageID")
    private Integer messageID;
    @Column(name = "messageType")
    private String messageType;
    @Column(name = "target")
    private String target;
    @Column(name = "contents")
    private String contents;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne
    private Products productID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne
    private Users userID;

    public Messages() {
    }

    //Auto-increment
    //public Messages(Integer messageID) {
    //    this.messageID = messageID;
    //}
    
    public Messages(String messageType, String target, String contents, Products productID, Users userID)
    {
        this.messageType = messageType;
        this.target = target;
        this.contents = contents;
        this.productID = productID;
        this.userID = userID;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.messageID);
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
        final Messages other = (Messages) obj;
        if (!Objects.equals(this.messageID, other.messageID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lacysKioskLogicparts.Messages[ messageID=" + messageID + " ]";
    }
    
}
