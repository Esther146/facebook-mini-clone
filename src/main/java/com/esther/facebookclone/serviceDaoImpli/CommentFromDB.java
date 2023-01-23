package com.esther.facebookclone.serviceDaoImpli;


import com.esther.facebookclone.model.TheComment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentFromDB {

    public static List<TheComment> getCommentsFromDB(int post_id) {
        List<TheComment> commentList = new ArrayList<>();

        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/facebookdb?serverTimezone=UTC";
            String username = "root";
            String password3 = "146";

            Connection connection = DriverManager.getConnection(url, username, password3);

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT comment_content, id FROM comments WHERE post_id = ?;");

            statement.setInt(1, post_id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TheComment comment = new TheComment();
                comment.setComment_content(resultSet.getString("comment_content"));
                comment.setComment_id(resultSet.getInt("id"));
                comment.setPost_id(post_id);
//                '2022-11-05 15:57:28

                commentList.add(comment);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return commentList;
    }

}
