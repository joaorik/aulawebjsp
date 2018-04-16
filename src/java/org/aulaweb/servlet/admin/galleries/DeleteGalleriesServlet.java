/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aulaweb.servlet.admin.galleries;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.GalleryDAO;

/**
 *
 * @author john
 */
public class DeleteGalleriesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final GalleryDAO gallery;

    public DeleteGalleriesServlet() throws ClassNotFoundException {
        super();
        gallery = new GalleryDAO();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int galleryID = Integer.parseInt(request.getParameter("galleryId"));
        gallery.deleteGallery(galleryID);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/galleries/list.jsp");
        request.setAttribute("galleries", gallery.getGalleries());
        res.forward(request, response);
    }

}
