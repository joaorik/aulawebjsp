/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aulaweb.servlet.admin.galleries;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.aulaweb.dao.GalleryDAO;
import org.aulaweb.models.Gallery;

/**
 *
 * @author john
 */
@MultipartConfig(fileSizeThreshold = 1024*1024*2, maxFileSize = 1024*1024*5)
public class AddGalleriesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "/uploads/galleries";
    private final GalleryDAO gallery;

    public AddGalleriesServlet() throws ClassNotFoundException {
        super();
        gallery = new GalleryDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/admin/galleries/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //get absolute paht of the web app
        String appPath = request.getServletContext().getRealPath("");
        //construct path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;

        //create the saves directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        Part file = request.getPart("image");
        String fileName = extractFilename(file);
        file.write(savePath + File.separator + fileName);
        String filePath = savePath + File.separator + fileName;
        
        Gallery gall = new Gallery();
        gall.setImage(fileName);
        gall.setCaption(request.getParameter("caption"));
        
        gallery.createGallery(gall);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/galleries/list.jsp");
        request.setAttribute("galleries", gallery.getGalleries());
        res.forward(request, response);
    }

    private String extractFilename(Part file) {
        String cd = file.getHeader("content-disposition");
        String[] items = cd.split(";");
        for (String string : items) {
            if (string.trim().startsWith("filename")) {
                return string.substring(string.indexOf("=") + 2, string.length() - 1);
            }
        }
        return "";
    }

}
