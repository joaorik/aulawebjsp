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
public class EditClientsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ClientDAO clients;
    
    public EditClientsServlet() throws ClassNotFoundException {
        super();
        clients = new ClientDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int clientID = Integer.parseInt(request.getParameter("clientId"));
        Client client = clients.getByID(clientID);
        request.setAttribute("client", client);
        request.getRequestDispatcher("/admin/clients/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Client client = new Client();
        client.setName(request.getParameter("name"));
        client.setAddress(request.getParameter("address"));
        client.setCity(request.getParameter("city"));
        client.setEstate(request.getParameter("estate"));
        client.setZip(request.getParameter("zip"));
        client.setAddr_number(request.getParameter("addr_number"));
        client.setNeighborhood(request.getParameter("neighborhood"));
        client.setPhone(request.getParameter("phone"));
        client.setCellphone(request.getParameter("cellphone"));
        client.setEmail(request.getParameter("email"));
        
        String clientid = request.getParameter("clientid");
        
        client.setClientid(Integer.parseInt(clientid));
        
        clients.updateClient(client);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/clients/list.jsp");
        request.setAttribute("clients", clients.getClients());
        res.forward(request, response);
    }

}
