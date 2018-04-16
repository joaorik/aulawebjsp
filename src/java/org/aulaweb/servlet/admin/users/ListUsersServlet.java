package org.aulaweb.servlet.admin.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.UserDAO;

/**
 *
 * @author john
 */
public class ListUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAO users;
    
    public ListUsersServlet() throws ClassNotFoundException {
        super();
        users = new UserDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("users", users.getUsers());
        request.getRequestDispatcher("/admin/users/list.jsp").forward(request, response);
    }

}
