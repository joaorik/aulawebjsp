package org.aulaweb.servlet.admin.clients;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.ClientDAO;

/**
 *
 * @author john
 */
public class DeleteClientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ClientDAO client;
    
    public DeleteClientsServlet() throws ClassNotFoundException {
        super();
        client = new ClientDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int clientID = Integer.parseInt(request.getParameter("clientId"));
        client.deleteClient(clientID);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/clients/list.jsp");
        request.setAttribute("clients", client.getClients());
        res.forward(request, response);
    }

}
