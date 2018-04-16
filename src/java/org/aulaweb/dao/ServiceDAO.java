package org.aulaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.aulaweb.util.MySqlConnect;


import org.aulaweb.models.Service;

/**
 *
 * @author john
 */
public class ServiceDAO {
    
    private final Connection conn;
    
    public ServiceDAO() throws ClassNotFoundException {
        conn = MySqlConnect.ConnectTo();
    }
    
    public void createService(Service service) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO services(title, image, content) VALUES(?, ?, ?)");
            
            st.setString(1, service.getTitle());
            st.setString(2, service.getImage());
            st.setString(3, service.getContent());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateService(Service service) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE services SET title = ?, image = ?, content = ? WHERE id = ?");
            
            st.setString(1, service.getTitle());
            st.setString(2, service.getImage());
            st.setString(3, service.getContent());
            st.setInt(4, service.getServiceid());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteService(int ServiceID) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM services WHERE id = ?");
            
            st.setInt(1, ServiceID);
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Service> getServices() {
        List<Service> services = new ArrayList<Service>();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM services");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                Service service = new Service();
                service.setServiceid(rs.getInt("id"));
                service.setTitle(rs.getString("title"));
                service.setImage(rs.getString("image"));
                service.setContent(rs.getString("content"));
                services.add(service);
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return services;
    }
    
    public Service getByID(int serviceID) {
        Service service = new Service();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM services WHERE id = ?");
            
            st.setInt(1, serviceID);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                service.setServiceid(rs.getInt("id"));
                service.setTitle(rs.getString("title"));
                service.setImage(rs.getString("image"));
                service.setContent(rs.getString("content"));
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return service;
    }
}
