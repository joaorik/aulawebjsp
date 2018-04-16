package org.aulaweb.servlet.admin.users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.UserDAO;

/**
 *
 * @author john
 */
public class DeleteUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAO users;
    
    public DeleteUsersServlet() throws ClassNotFoundException {
        super();
        users = new UserDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userID = Integer.parseInt(request.getParameter("userId"));
        users.deleteUser(userID);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/users/list.jsp");
        request.setAttribute("users", users.getUsers());
        res.forward(request, response);
    }

}
