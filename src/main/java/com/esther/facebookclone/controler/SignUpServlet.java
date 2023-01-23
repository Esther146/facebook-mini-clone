package com.esther.facebookclone.controler;

import com.esther.facebookclone.serviceDaoImpli.UserImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", value = "/sign-up")
public class SignUpServlet extends HttpServlet {

    private static UserImplement userDao = new UserImplement();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/facebookdb";
            String username = "root";
            String password2 = "146";

            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String gender = request.getParameter("gender");


            Connection con = DriverManager.getConnection(url, username, password2);

            PreparedStatement statement = con.prepareStatement("INSERT INTO users(" +
                    "firstname, lastname, email, password, dateOfBirth, gender) VALUES (?, ?, ?, ?, ?, ?)");


            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setString(5, dateOfBirth);
            statement.setString(6, gender);

            statement.executeUpdate();

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
