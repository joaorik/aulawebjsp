package org.aulaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.aulaweb.util.MySqlConnect;

import org.aulaweb.models.Client;
/**
 *
 * @author john
 */
public class ClientDAO {

    private final Connection conn;
    
    public ClientDAO() throws ClassNotFoundException {
        conn = MySqlConnect.ConnectTo();
    }
    
    public void createClient(Client client) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO clients(name, address, city, estate, zip, addr_number, neighborhood, phone, cellphone, email, created_at) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            Timestamp date = new Timestamp(new Date().getTime());
            
            st.setString(1, client.getName());
            st.setString(2, client.getAddress());
            st.setString(3, client.getCity());
            st.setString(4, client.getEstate());
            st.setString(5, client.getZip());
            st.setString(6, client.getAddr_number());
            st.setString(7, client.getNeighborhood());
            st.setString(8, client.getPhone());
            st.setString(9, client.getCellphone());
            st.setString(10, client.getEmail());
            st.setTimestamp(11, date);
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException exc) {
            System.out.println(exc);
        }
    }
    
    public void updateClient(Client client) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE clients SET name = ?, address = ?, city = ?, estate = ?, zip = ?, addr_number = ?, neighborhood = ?, phone = ?, cellphone = ?, email = ? WHERE id = ?");
            
            st.setString(1, client.getName());
            st.setString(2, client.getAddress());
            st.setString(3, client.getCity());
            st.setString(4, client.getEstate());
            st.setString(5, client.getZip());
            st.setString(6, client.getAddr_number());
            st.setString(7, client.getNeighborhood());
            st.setString(8, client.getPhone());
            st.setString(9, client.getCellphone());
            st.setString(10, client.getEmail());
            st.setInt(11, client.getClientid());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException exc) {
            System.out.println(exc);
        }
    }
    
    public void deleteClient(int clientID) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM clients WHERE id = ?");
            
            st.setInt(1, clientID);
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<Client>();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM clients");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Client client = new Client();
                client.setClientid(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setAddress(rs.getString("address"));
                client.setCity(rs.getString("city"));
                client.setEstate(rs.getString("estate"));
                client.setZip(rs.getString("zip"));
                client.setAddr_number(rs.getString("addr_number"));
                client.setNeighborhood(rs.getString("neighborhood"));
                client.setPhone(rs.getString("phone"));
                client.setCellphone(rs.getString("cellphone"));
                client.setEmail(rs.getString("email"));
                client.setCreated_at(rs.getTimestamp("created_at"));
                clients.add(client);
            }
            
            st.close();
            rs.close();
            
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return clients;
    }
    
    public Client getByID(int clientID) {
        Client client = new Client();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM clients WHERE id = ?");
            
            st.setInt(1, clientID);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                client.setClientid(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setAddress(rs.getString("address"));
                client.setCity(rs.getString("city"));
                client.setEstate(rs.getString("estate"));
                client.setZip(rs.getString("zip"));
                client.setAddr_number(rs.getString("addr_number"));
                client.setNeighborhood(rs.getString("neighborhood"));
                client.setPhone(rs.getString("phone"));
                client.setCellphone(rs.getString("cellphone"));
                client.setEmail(rs.getString("email"));
                client.setCreated_at(rs.getTimestamp("created_at"));
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return client;
    }
}
