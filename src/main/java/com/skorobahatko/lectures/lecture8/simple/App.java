package com.skorobahatko.lectures.lecture8.simple;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String URL = "jdbc:mysql://localhost:3306/forum?verifyServerCertificate=false&useSSL=false&serverTimezone=GMT";
    private static final String USER = "forum_admin";
    private static final String PASSWORD = "1234321";
    private static final String SQL_CREATE_TABLE = "CREATE TABLE human(id int AUTO_INCREMENT primary key, name VARCHAR(30), age int);";
    private static final String SQL_INSERT_HUMAN = "INSERT INTO human(name, age) VALUES(?, ?)";
    private static final String SQL_READ_HUMAN = "SELECT * FROM human";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            statement.execute(SQL_CREATE_TABLE);
            List<Human> humanList = getListOfHumans();
//            addHumansToDB(connection, humanList);
            System.out.println(getHumansFromDB(connection));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addHumansToDB(Connection conn, List<Human> humanList) {
        try (PreparedStatement statement = conn.prepareStatement(SQL_INSERT_HUMAN, Statement.RETURN_GENERATED_KEYS)) {
            for (Human h : humanList) {
                statement.setString(1, h.getName());
                statement.setInt(2, h.getAge());
                statement.executeUpdate();
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    h.setId(generatedKeys.getInt(1));
                }
                generatedKeys.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Human> getHumansFromDB(Connection conn) {
        List<Human> humanList = new ArrayList<>();
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL_READ_HUMAN)) {
            while (resultSet.next()) {
                Human human = new Human();
                human.setId(resultSet.getInt("id"));
                human.setName(resultSet.getString("name"));
                human.setAge(resultSet.getInt("age"));
                humanList.add(human);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return humanList;
    }

    private static List<Human> getListOfHumans() {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("John", 25));
        humans.add(new Human("Bob", 28));
        humans.add(new Human("Jack", 30));
        return humans;
    }


}
