package by.tms.servlet;


import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        if (name != null | userName != null | password != null && UserValidator.isValidUsername(Objects.requireNonNull(userName)) && UserValidator.isValidPassword(Objects.requireNonNull(password))) {
            User user = new User();
            user.setName(name);
            user.setUserName(userName);
            user.setPassword(password);
            userService.create(user);
            resp.getWriter().println("Registration is completed!");
        } else {
            resp.getWriter().println("Registration failed. Check the correctness of the entered data!");
        }
    }
}
