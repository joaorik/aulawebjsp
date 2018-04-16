package org.aulaweb.servlet.admin.sliders;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.SliderDAO;

/**
 *
 * @author john
 */
public class ListSlidersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final SliderDAO sliders;
    
    public ListSlidersServlet() throws ClassNotFoundException {
        super();
        sliders = new SliderDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("sliders", sliders.getSliders());
        request.getRequestDispatcher("/admin/sliders/list.jsp").forward(request, response);
    }

}
