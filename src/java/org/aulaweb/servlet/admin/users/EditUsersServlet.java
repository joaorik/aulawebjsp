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
public class EditUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDAO users;
    
    public EditUsersServlet() throws ClassNotFoundException {
        super();
        users = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userID = Integer.parseInt(request.getParameter("userId"));
        User user = users.getByID(userID);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/admin/users/edit.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPasswd(request.getParameter("passwd"));
        
        String userid = request.getParameter("userid");
        
        user.setUserid(Integer.parseInt(userid));
        
        users.updateUser(user);
        
        RequestDispatcher res = request.getRequestDispatcher("/admin/users/list.jsp");
        request.setAttribute("users", users.getUsers());
        res.forward(request, response);
    }
    
}
