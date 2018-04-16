package org.aulaweb.servlet.admin.sliders;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.SliderDAO;

/**
 *
 * @author john
 */
public class DeleteSlidersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final SliderDAO sliders;
    
    public DeleteSlidersServlet() throws ClassNotFoundException {
        super();
        sliders = new SliderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int sliderID = Integer.parseInt(request.getParameter("sliderId"));
        sliders.deleteSlider(sliderID);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/sliders/list.jsp");
        request.setAttribute("sliders", sliders.getSliders());
        res.forward(request, response);
    }

}
