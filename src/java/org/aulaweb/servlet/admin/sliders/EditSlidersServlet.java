package org.aulaweb.servlet.admin.sliders;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.aulaweb.dao.SliderDAO;
import org.aulaweb.models.Slider;

/**
 *
 * @author john
 */
@MultipartConfig(fileSizeThreshold = 1024*1024*2, maxFileSize = 1024*1024*5)
public class EditSlidersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "/uploads/sliders";
    private final SliderDAO sliders;
    
    public EditSlidersServlet() throws ClassNotFoundException {
        super();
        sliders = new SliderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int sliderID = Integer.parseInt(request.getParameter("sliderId"));
        Slider slid = sliders.getByID(sliderID);
        request.setAttribute("slider", slid);
        request.getRequestDispatcher("/admin/sliders/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get absolute paht of the web app
        String appPath = request.getServletContext().getRealPath("");
        //construct path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        String type = "";
        String fileName = "";
        
        //create the saves directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        Part file = request.getPart("image");
        
        type = file.getHeader("content-type");
        
        if (type.equals("image/jpeg") || type.equals("image/png") || type.equals("image/jpg") || type.equals("image/gif") || type.equals("image/bmp")) {

            fileName = extractFilename(file);
            file.write(savePath + File.separator + fileName);
            String filePath = savePath + File.separator + fileName;
            
        } else {
            
            fileName = request.getParameter("imagem");
        }
        
        Slider slid = new Slider();
        slid.setImage(fileName);
        
        String sliderid = request.getParameter("sliderid");
        
        sliders.updateSlider(slid);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/sliders/list.jsp");
        request.setAttribute("sliders", sliders.getSliders());
        res.forward(request, response);
    }
    
    private String extractFilename(Part file) {
        String cd = file.getHeader("content-disposition");
        String[] items = cd.split(";");
        for (String string : items) {
            if (string.trim().startsWith("filename")) {
                return string.substring(string.indexOf("=") + 2, string.length()-1);
            }
        }
        return "";
    }

}
