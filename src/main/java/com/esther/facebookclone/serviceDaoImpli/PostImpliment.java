package com.esther.facebookclone.serviceDaoImpli;

import com.esther.facebookclone.InterfaceDaoService.PostDaoService;
import com.esther.facebookclone.model.ThePost;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostImpliment implements PostDaoService {
    final static String POST_CONTENT = "INSERT INTO posts (post_content) VALUES (?)";

    @Override
    public ThePost postContent(@NonNull String post_content){

        ThePost postContent = new ThePost();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = ("jdbc:mysql://localhost:3306/facebookdb?serverTimezone=UTC");
            String usr = "root";
            String pwd = "146";

            Connection connection = DriverManager.getConnection(url,usr,pwd);

            PreparedStatement statement = connection.prepareStatement(POST_CONTENT);

            statement.setString(1, post_content);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return postContent;
    }
}
