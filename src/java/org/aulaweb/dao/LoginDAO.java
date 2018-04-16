package org.aulaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.aulaweb.util.MySqlConnect;
/**
 *
 * @author john
 */
public class LoginDAO {
    
    private final Connection conn;
    
    public LoginDAO() throws ClassNotFoundException {
        conn = MySqlConnect.ConnectTo();
    }
    
    public boolean validate(String email, String passwd) {
        boolean status = false;
        
        try {
            
            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND passwd = ?");
            st.setString(1, email);
            st.setString(2, passwd);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                status = true;
            } else {
                status = false;
            }
            
            st.close();
            rs.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
