/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lacysKioskLogicparts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static lacysKioskGUIparts.MainPage.DATABASE_URL;
import static lacysKioskGUIparts.MainPage.JDBC_DRIVER;


/**
 *
 * @author Alisha Locust
 */
public class Account 
{
    private String username;
    private String password;
    private int userID;
    private int privilege;
    private int num;
    
    public Account()
    {
        //put stuff here???
    }
    
    public Account(String name, String pswd)
    {
        username = name;
        password = pswd;
    }
    
    public Account(String name, String pswd, int userPriv)
    {
        username = name;
        password = pswd;
        privilege = userPriv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }
    
    public void createAccount(String name, String pswd)
    {
        Connection connection = null;
        Statement statement = null;
        String query = "SELECT * FROM USERS WHERE UserName = '" + name + "'";
        try
		{
			// load database driver class
			Class.forName(JDBC_DRIVER);
			// connect to database
			connection = DriverManager.getConnection(DATABASE_URL);

			// create statement to query database
			statement = connection.createStatement();
			// query the database and get the result set
			ResultSet resultSet = statement.executeQuery(query);
                        
                        if (resultSet.isBeforeFirst())
                        {
                            System.out.println("A user already has that username. Please choose another.");
                        }
                        else
                        {
                            //Set up new account
                            username = name;
                            password = pswd;
                            //figure out way to put in id and privileges
                            privilege = 0;
                        }
		}

		catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null, sqle.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
			sqle.printStackTrace();
			System.exit(1);
		}

		catch (ClassNotFoundException cnfe)
		{
			JOptionPane.showMessageDialog(null,cnfe.getMessage(),"Driver not Found", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		finally
		{
			try
			{
				statement.close();
				connection.close();
			}

			catch (SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,sqle.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
    }
       
    public boolean logIn(String username, String password)
    {
        boolean loggedIn = false;
        Connection connection = null;
        Statement statement = null;
        String query = "SELECT * FROM USERS WHERE UserName = '" + username + "'";

        try
		{
                        // load database driver class
			Class.forName(JDBC_DRIVER);
			// connect to database
			connection = DriverManager.getConnection(DATABASE_URL);

			// create statement to query database
			statement = connection.createStatement();
                        //String query = "SELECT * FROM USERS WHERE UserName = '" + username + "'";
			ResultSet resultSet = statement.executeQuery(query);

			// process the query results
                        if (!resultSet.isBeforeFirst())
                        {
                            JOptionPane.showMessageDialog(null, "No such user found in system.", "Log In Error", JOptionPane.ERROR_MESSAGE);
                            loggedIn = false;
                        }
                        else
                        {
                            resultSet.next();
                            if (password.equals(resultSet.getString(3)))
                            {
                                loggedIn = true;
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Password did not match.", "Log In Error", JOptionPane.ERROR_MESSAGE);
                                loggedIn = false;
                            }
                        }

		}

		catch (SQLException sqle)
		{
			JOptionPane.showMessageDialog(null, sqle.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
			sqle.printStackTrace();
			System.exit(1);
		}
                catch (ClassNotFoundException cnfe)
		{
			JOptionPane.showMessageDialog(null,cnfe.getMessage(),"Driver not Found", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		finally
		{
			try
			{
				statement.close();
				connection.close();
			}

			catch (SQLException sqle)
			{
				JOptionPane.showMessageDialog(null,sqle.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
        return loggedIn;
    }
    
    
    public void logOut()
    {
        
    }
    
    
 
}

