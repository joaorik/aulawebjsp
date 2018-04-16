package org.aulaweb.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.aulaweb.models.User;
import org.aulaweb.util.MySqlConnect;
/**
 *
 * @author john
 */
public class UserDAO {

    private final Connection conn;
    
    public UserDAO() throws ClassNotFoundException {
        conn = MySqlConnect.ConnectTo();
    }
    
    public void createUser(User user) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO users(username, email, passwd) VALUES(?, ?, ?)");
            
            st.setString(1, user.getUsername());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPasswd());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException exc) {
            System.out.println(exc);
        }
    }
    
    public void updateUser(User user) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users SET username = ?, email = ?, passwd = ? WHERE id = ?");
            
            st.setString(1, user.getUsername());
            st.setString(2, user.getEmail());
            st.setString(3, user.getPasswd());
            st.setInt(4, user.getUserid());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException exc) {
            System.out.println(exc);
        }
    }
    
    public void deleteUser(int userID) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            
            st.setInt(1, userID);
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            
            st.close();
            rs.close();
            
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return users;
    }
    
    public User getByID(int userID) {
        User user = new User();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                user.setUserid(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPasswd(rs.getString("passwd"));
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }
}
