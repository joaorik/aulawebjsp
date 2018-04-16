package org.aulaweb.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.aulaweb.models.Gallery;
import org.aulaweb.util.MySqlConnect;
/**
 *
 * @author john
 */
public class GalleryDAO {
    
    private final Connection conn;
    
    public GalleryDAO() throws ClassNotFoundException {
        conn = MySqlConnect.ConnectTo();
    }
    
    public void createGallery(Gallery gall) {
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO galleries(image, caption) VALUES(?, ?)");
            
            st.setString(1, gall.getImage());
            st.setString(2, gall.getCaption());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void updateGallery(Gallery gallery) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE galleries SET image = ?, caption = ? WHERE id = ?");
            
            st.setString(1, gallery.getImage());
            st.setString(2, gallery.getCaption());
            st.setInt(3, gallery.getGalleryid());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteGallery(int GalleryID) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM galleries WHERE id = ?");
            
            st.setInt(1, GalleryID);
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<Gallery> getGalleries() {
        List<Gallery> galleries = new ArrayList<Gallery>();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM galleries");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                Gallery gallery = new Gallery();
                gallery.setGalleryid(rs.getInt("id"));
                gallery.setImage(rs.getString("image"));
                gallery.setCaption(rs.getString("caption"));
                galleries.add(gallery);
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return galleries;
    }
    
    public Gallery getByID(int galleryID) {
        Gallery gallery = new Gallery();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM galleries WHERE id = ?");
            
            st.setInt(1, galleryID);
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                gallery.setGalleryid(rs.getInt("id"));
                gallery.setImage(rs.getString("image"));
                gallery.setCaption(rs.getString("caption"));
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return gallery;
    }
    
}
