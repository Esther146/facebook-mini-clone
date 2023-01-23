package com.esther.facebookclone.serviceDaoImpli;

import com.esther.facebookclone.InterfaceDaoService.UserDaoService;
import com.esther.facebookclone.dataTransferObj.UserDto;
import com.esther.facebookclone.model.User;
import lombok.NonNull;

import java.sql.*;

public class UserImplement implements UserDaoService {
    final static String USER_INSERT_SQL = "INSERT INTO users (firstname, lastname, email, password, dateOfBirth, gender) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    final static String SELECT_USE_BY_USERNAME_AND_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?";

    @Override
    public User saveUser(UserDto userDto){

        User savedUser = new User();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = ("jdbc:mysql://localhost:3306/facebookdb?serverTimezone=UTC");
            String usr = "root";
            String pwd = "146";

            Connection connection = DriverManager.getConnection(url,usr,pwd);

            PreparedStatement statement = connection.prepareStatement(USER_INSERT_SQL);

            statement.setString(1, userDto.getFirstname());
            statement.setString(2, userDto.getLastname());
            statement.setString(3, userDto.getEmail());
            statement.setString(4, userDto.getPassword());
            statement.setString(5, userDto.getDateOfBirth());
            statement.setString(6, userDto.getGender());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return savedUser;
    }



    @Override
    public User findUserByEmailAndPassword(@NonNull String email, @NonNull String password){
        User foundUser = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = ("jdbc:mysql://localhost:3306/facebookdb?serverTimezone=UTC");
            String usr = "root";
            String pwd = "146";

            Connection connection = DriverManager.getConnection(url,usr,pwd);

            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USE_BY_USERNAME_AND_PASSWORD);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String foundEmail = resultSet.getString("email");
                String foundPassword = resultSet.getString("password");
                String dateOfBirth = resultSet.getString("dateOfBirth");
                String gender = resultSet.getString("gender");
                Integer user_id = resultSet.getInt("user_id");


                foundUser = User.builder()
                        .firstname(firstname)
                        .lastname(lastname)
                        .email(foundEmail)
                        .password(foundPassword)
                        .dateOfBirth(dateOfBirth)
                        .gender(gender)
                        .id(user_id)
                        .build();
            }
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {

            System.err.println(e.getMessage());;
        }
        return foundUser;
    }
}
