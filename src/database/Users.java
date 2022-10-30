package database;

import java.sql.*;

public class Users {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/javaee18";
        String username = "root";
        String password = "1234";


        try (Connection con = DriverManager.getConnection(dbURL,username,password)){


            //TODO
            // Create menu that asks what you want to do
            // 1. Insert new user -> Asks username,password,full name, email. (Do trim on all inputs to get rid of spaces)
            // and give feedback also if it was not successfully inserted
            // 2. Read data
            // 3. Delete data -> read username and give feedback also if it was not successfully delete
            // After one of these options ask if you want to do something again (y/n)

            //readData(con);
            //insertData(con,"Karlisz","Java","Kārlis Zars", "zarskarlis@gmail.com");
            //deleteData(con,"KarlisZ");

        }catch (SQLException e){
            System.out.println(e);
        }


    }

    // Reading data
    public static void readData (Connection con) throws SQLException{

        String sql = "SELECT * FROM users";

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        int row = 1;

        while (resultSet.next()){

            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String fullName = resultSet.getString("fullname");
            String email = resultSet.getString("email");

            String output = "User #%d: %s - %s - %s - %s";
            System.out.println(String.format(output,row++,username,password,fullName,email));

        }

    }

    //Insert data
    public static void insertData(Connection con, String username, String password, String fullName, String email) throws SQLException{

        String sql = "INSERT INTO users (username, password, fullname,email) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, fullName);
        preparedStatement.setString(4, email);

        if(preparedStatement.executeUpdate() > 0){
            System.out.println("A new user was inserted successfully");
        }

    }

    //Delete data
    public static void deleteData(Connection con, String username) throws SQLException{

        String sql = "DELETE FROM users WHERE username = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);

        if(preparedStatement.executeUpdate() > 0){
            System.out.println("A user was deleted successfully");
        }
    }

}
