
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
 * @author Alisha Locust
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.userID = :userID"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "Users.findByUserBalance", query = "SELECT u FROM Users u WHERE u.userBalance = :userBalance"),
    @NamedQuery(name = "Users.findByUserPrivilege", query = "SELECT u FROM Users u WHERE u.userPrivilege = :userPrivilege")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserID")
    private int userID;
    @Basic(optional = false)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "UserPassword")
    private String userPassword;
    @Basic(optional = false)
    @Column(name = "UserBalance")
    private double userBalance;
    @Column(name = "UserPrivilege")
    private Integer userPrivilege;

    public Users() {
    }
    
    public Users(int userID, String userName, String userPassword, double userBalance) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userBalance = userBalance;
    }
    
    public Users(int userID, String userName, String userPassword, double userBalance, Integer userPrivilege) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userBalance = userBalance;
        this.userPrivilege = userPrivilege;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public Integer getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(Integer userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.userID;
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
        final Users other = (Users) obj;
        if (this.userID != other.userID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lacysKioskLogicparts.Users[ userID=" + userID + " ]";
    }
    
}
