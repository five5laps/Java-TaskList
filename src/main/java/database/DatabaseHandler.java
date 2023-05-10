package database;
import com.example.todoapplication.LoginController;
import model.Task;
import model.User;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws  ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/"
                + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }
    //Write
    public void signUpUser(User user){

        String insert = "INSERT INTO " + Const.USERS_TABLE + "(" + Const.USERS_FIRSTNAME
                + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + ","
                + Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getLocation());
            preparedStatement.setString(6, user.getGender());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getUser(User user){
        ResultSet resultSet = null;

        if(!user.getUserName().equals("") || !user.getPassword().equals("")){
            //select all from users where username = "username" and password = "password"
            String query = "SELECT * FROM " + Const.USERS_TABLE + " WHERE "
                    + Const.USERS_USERNAME + "=?" + " AND " + Const.USERS_PASSWORD
                    + "=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());

                resultSet = preparedStatement.executeQuery();

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else{
            System.out.println("Please enter your credentials!");
        }

        return resultSet;
    }

    public void getUserId(String username){
        ResultSet resultSet = null;
        String query = "SELECT " + Const.USERS_ID +  " FROM " + Const.USERS_TABLE + " WHERE "
                + Const.USERS_USERNAME + "=?";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);

            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userid = resultSet.getInt("userid");
                Const.LOGGED_USER_ID = userid;
                System.out.println("User ID: " + Const.LOGGED_USER_ID);
            } else {
                System.out.println("404");
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        
    }

    public void saveTask(Task task){

        String insert = "INSERT INTO `" + Const.TASKS_TABLE + "` " +
                "(`" + Const.TASKS_USER_ID + "`, `" + Const.TASKS_TASK + "`, `" + Const.TASKS_DATE + "`, `" + Const.TASKS_DESCRIPTION + "`) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

            preparedStatement.setInt(1, task.getUserId());
            preparedStatement.setString(2, task.getTask());
            preparedStatement.setTimestamp(3, task.getDatecreated());
            preparedStatement.setString(4, task.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    //Read

    //Update

    //Delete
}
