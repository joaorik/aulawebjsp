package org.aulaweb.servlet.admin.clients;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.ClientDAO;
import org.aulaweb.models.Client;

/**
 *
 * @author john
 */
public class AddClientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ClientDAO client;
    
    public AddClientsServlet() throws ClassNotFoundException {
        super();
        client = new ClientDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/admin/clients/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Client clients = new Client();
        clients.setName(request.getParameter("name"));
        clients.setAddress(request.getParameter("address"));
        clients.setCity(request.getParameter("city"));
        clients.setEstate(request.getParameter("estate"));
        clients.setZip(request.getParameter("zip"));
        clients.setAddr_number(request.getParameter("addr_number"));
        clients.setNeighborhood(request.getParameter("neighborhood"));
        clients.setPhone(request.getParameter("phone"));
        clients.setCellphone(request.getParameter("cellphone"));
        clients.setEmail(request.getParameter("email"));
        
        client.createClient(clients);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/clients/list.jsp");
        request.setAttribute("clients", client.getClients());
        res.forward(request, response);
    }

}
