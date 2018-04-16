package org.aulaweb.servlet.admin.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.ServiceDAO;

/**
 *
 * @author john
 */
public class ListServicesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ServiceDAO services;

    public ListServicesServlet() throws ClassNotFoundException {
        super();
        services = new ServiceDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("services", services.getServices());
        request.getRequestDispatcher("/admin/services/list.jsp").forward(request, response);
    }

}
