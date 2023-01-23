package com.esther.facebookclone.serviceDaoImpli;

import com.esther.facebookclone.model.ThePost;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetPostsFromDB {


    public static List<ThePost> getPostsFromDB() {
        List<ThePost> postList = new ArrayList<>();

        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/facebookdb?serverTimezone=UTC";
            String username = "root";
            String password3 = "146";

            Connection connection = DriverManager.getConnection(url, username, password3);

            try (PreparedStatement statement = connection.prepareStatement("SELECT facebookdb.users.firstname,\n" +
                    "       facebookdb.users.lastname,\n" +
                    "       post_id,\n" +
                    "       post_content,\n" +
                    "       post_time\n" +
                    "FROM users\n" +
                    "INNER JOIN post ON users.user_id = post.user_id ORDER BY post_time DESC;")) {

                resultSet = statement.executeQuery();
            }

            while (resultSet.next()) {
                ThePost post = new ThePost();
                post.setPost_id(resultSet.getInt("post_id"));
                post.setPost_content(resultSet.getString("post_content"));
                post.setFirstname(resultSet.getString("firstname"));
                post.setLastname(resultSet.getString("lastname"));
                post.setTime(LocalDate.parse(resultSet.getString("post_time").substring(0,10)));
//                '2022-11-05 15:57:28

                postList.add(post);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return postList;
    }
}
