package org.aulaweb.servlet.admin.users;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.UserDAO;
import org.aulaweb.models.User;

/**
 *
 * @author john
 */
public class AddUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAO users;
    
    public AddUsersServlet() throws ClassNotFoundException {
        super();
        users = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("/admin/users/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPasswd(request.getParameter("passwd"));
        
        users.createUser(user);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/users/list.jsp");
        request.setAttribute("users", users.getUsers());
        res.forward(request, response);
    }

}
