package org.aulaweb.servlet.admin.services;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.aulaweb.dao.ServiceDAO;
import org.aulaweb.models.Service;

/**
 *
 * @author john
 */
@MultipartConfig(fileSizeThreshold = 1024*1024*2, maxFileSize = 1024*1024*5)
public class EditServicesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "/uploads/services";
    private final ServiceDAO services;

    public EditServicesServlet() throws ClassNotFoundException {
        super();
        services = new ServiceDAO();
    }


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int galleryID = Integer.parseInt(request.getParameter("serviceId"));
        Service serv = services.getByID(galleryID);
        request.setAttribute("service", serv);
        request.getRequestDispatcher("/admin/services/edit.jsp").forward(request, response);
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
        
        Service serv = new Service();
        serv.setTitle(request.getParameter("title"));
        serv.setImage(fileName);
        serv.setContent(request.getParameter("content"));
        
        String serviceid = request.getParameter("serviceid");
        
        serv.setServiceid(Integer.parseInt(serviceid));
        
        services.updateService(serv);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/services/list.jsp");
        request.setAttribute("services", services.getServices());
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
