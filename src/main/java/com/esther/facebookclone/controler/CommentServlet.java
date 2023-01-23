package com.esther.facebookclone.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "CommentServlet", value = "/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/facebookdb?serverTimezone=UTC";
            String username = "root";
            String password3 = "146";

            Connection connection = DriverManager.getConnection(url, username, password3);

            String comment_content = request.getParameter("comment_content");
            Integer userId = Integer.valueOf(request.getSession().getAttribute("user_id").toString());
            String postId = request.getParameter("postId");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO comments (" +
                    "user_id, post_id, comment_content) VALUES (?, ?, ?)");


            statement.setInt(1, userId);
            statement.setInt(2, Integer.parseInt(postId));
            statement.setString(3, comment_content);

            statement.executeUpdate();

            String foundUser = comment_content;


            HttpSession requestSession = request.getSession();
            requestSession.setAttribute("loggedUser", foundUser);
            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
