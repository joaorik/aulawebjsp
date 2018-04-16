package org.aulaweb.servlet.index;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.GalleryDAO;
import org.aulaweb.dao.ServiceDAO;
import org.aulaweb.dao.SliderDAO;

/**
 *
 * @author john
 */
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ServiceDAO services;
    private final GalleryDAO galleries;
    private final SliderDAO sliders;

    public IndexServlet() throws ClassNotFoundException {
        super();
        services = new ServiceDAO();
        galleries = new GalleryDAO();
        sliders = new SliderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("sliders", sliders.getSliders());
        request.setAttribute("services", services.getServices());
        request.setAttribute("galleries", galleries.getGalleries());

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String mensagem = request.getParameter("mensagem");
    }
}
