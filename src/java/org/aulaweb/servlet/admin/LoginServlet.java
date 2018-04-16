package org.aulaweb.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aulaweb.dao.LoginDAO;

/**
 *
 * @author john
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final LoginDAO logings;

    public LoginServlet() throws ClassNotFoundException {
        super();
        logings = new LoginDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String passwd = request.getParameter("passwd");

        boolean isValid = logings.validate(email, passwd);

        if (isValid) {
            request.getSession().setAttribute("mail", email);
            request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
            
        } else {
//            request.getSession().setAttribute("mail", email);
//            request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
            
            request.setAttribute("errorMessage", "Credenciais inválidas!");
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
    }

}
