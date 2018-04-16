package org.aulaweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.aulaweb.models.Slider;
import org.aulaweb.util.MySqlConnect;

/**
 *
 * @author john
 */
public class SliderDAO {
    
    private final Connection conn;
    
    public SliderDAO() throws ClassNotFoundException {
        conn = MySqlConnect.ConnectTo();
    }
    
    public void createSlider(Slider slider)
    {
        try {
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO sliders(images) VALUES(?)");
            
            st.setString(1, slider.getImage());
            
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateSlider(Slider slider)
    {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE sliders SET image = ? WHERE id = ?");
            
            st.setString(1, slider.getImage());
            st.setInt(2, slider.getSliderid());
            
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteSlider(int sliderID)
    {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM sliders WHERE id = ?");
            
            st.setInt(1, sliderID);
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<Slider> getSliders()
    {
        List<Slider> sliders = new ArrayList<Slider>();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM sliders");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Slider slider = new Slider();
                slider.setSliderid(rs.getInt("id"));
                slider.setImage(rs.getString("image"));
                sliders.add(slider);
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return sliders;
    }
    
    public Slider getByID(int sliderID)
    {
        Slider slider = new Slider();
        
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM sliders WHERE id = ?");
            
            st.setInt(1, sliderID);
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                slider.setSliderid(rs.getInt("id"));
                slider.setImage(rs.getString("image"));
            }
            
            st.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return slider;
    }
}
