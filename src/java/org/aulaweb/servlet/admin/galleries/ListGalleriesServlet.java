package org.aulaweb.servlet.admin.galleries;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.GalleryDAO;

/**
 *
 * @author john
 */
public class ListGalleriesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final GalleryDAO gallery;

    public ListGalleriesServlet() throws ClassNotFoundException {
        super();
        gallery = new GalleryDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("galleries", gallery.getGalleries());
        request.getRequestDispatcher("/admin/galleries/list.jsp").forward(request, response);
    }

}
