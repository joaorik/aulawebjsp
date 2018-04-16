package org.aulaweb.servlet.admin.clients;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.ClientDAO;

/**
 *
 * @author john
 */
public class ListClientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ClientDAO clients;

    public ListClientsServlet() throws ClassNotFoundException {
        super();
        clients = new ClientDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        request.setAttribute("clients", clients.getClients());
        request.getRequestDispatcher("/admin/clients/list.jsp").forward(request, response);
    }

}
