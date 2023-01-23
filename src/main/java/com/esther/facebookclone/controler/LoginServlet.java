package com.esther.facebookclone.controler;

import com.esther.facebookclone.InterfaceDaoService.UserDaoService;
import com.esther.facebookclone.model.User;
import com.esther.facebookclone.serviceDaoImpli.UserImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet  extends HttpServlet {

    private static final UserDaoService userDao = new UserImplement();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User foundUser = userDao.findUserByEmailAndPassword(email, password);

        if (foundUser != null ){
            HttpSession requestSession = request.getSession();
            requestSession.setAttribute("user_id", foundUser.getId());
            requestSession.setAttribute("loggedUser", foundUser);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
    }

}
