/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aulaweb.servlet.admin.services;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.ServiceDAO;

/**
 *
 * @author john
 */
public class DeleteServicesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ServiceDAO services;

    public DeleteServicesServlet() throws ClassNotFoundException {
        super();
        services = new ServiceDAO();
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int serviceID = Integer.parseInt(request.getParameter("serviceId"));
        services.deleteService(serviceID);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/services/list.jsp");
        request.setAttribute("services", services.getServices());
        res.forward(request, response);
    }

}
