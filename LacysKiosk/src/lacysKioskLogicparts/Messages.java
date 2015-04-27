/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lacysKioskLogicparts;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@Table(name = "Messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByMessageID", query = "SELECT m FROM Messages m WHERE m.messageID = :messageID"),
    @NamedQuery(name = "Messages.findByMessageType", query = "SELECT m FROM Messages m WHERE m.messageType = :messageType"),
    @NamedQuery(name = "Messages.findByUserID", query = "SELECT m FROM Messages m WHERE m.userID = :userID"),
    @NamedQuery(name = "Messages.findByTarget", query = "SELECT m FROM Messages m WHERE m.target = :target"),
    @NamedQuery(name = "Messages.findByContents", query = "SELECT m FROM Messages m WHERE m.contents = :contents")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MessageID")
    private int messageID;
    @Basic(optional = false)
    @Column(name = "MessageType")
    private int messageType;
    @Basic(optional = false)
    @Column(name = "UserID")
    private int userID;
    @Column(name = "Target")
    private Integer target;
    @Basic(optional = false)
    @Column(name = "Contents")
    private String contents;

    public Messages() {
    }

    public Messages(int messageID, int messageType, int userID, String contents) {
        this.messageID = messageID;
        this.messageType = messageType;
        this.userID = userID;
        this.contents = contents;
    }
    
    public Messages(int messageID, int messageType, int userID, Integer target, String contents) {
        this.messageID = messageID;
        this.messageType = messageType;
        this.userID = userID;
        this.target = target;
        this.contents = contents;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.messageID;
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
        if (this.messageID != other.messageID) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "lacysKioskLogicparts.Messages[ messagesID=" + messageID + " ]";
    }
    
}
