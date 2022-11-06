package database;

import java.sql.*;
import java.util.Scanner;

public class Users {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/javaee18";
        String username = "root";
        String password = "1234";
        char again = 'y';
        Scanner scanner = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(dbURL,username,password)) {

            //TODO
            // Create menu that asks what you want to do
            // 1. Insert new user -> Asks username,password,full name, email. (Do trim on all inputs to get rid of spaces)
            // and give feedback also if it was not successfully inserted
            // 2. Read data
            // 3. Delete data -> read username and give feedback also if it was not successfully delete
            // After one of these options ask if you want to do something again (y/n)

            while (again == 'y'){

                System.out.println("What you want to do?");
                System.out.println("1 - insert data");
                System.out.println("2 - view data");
                System.out.println("3 - delete data");
                System.out.println("4 - drop table");

                char action = scanner.nextLine().charAt(0);

                if(action == '1'){

                    //Input data
                    System.out.println("Enter username");
                    String usr = scanner.nextLine().trim();

                    System.out.println("Enter password");
                    String pswd = scanner.nextLine().trim();

                    System.out.println("Enter full name");
                    String fullName = scanner.nextLine().trim();

                    System.out.println("Enter email");
                    String email = scanner.nextLine().trim();

                    insertData(con,usr,pswd,fullName,email);

                } else if (action == '2') {
                    //Read data
                    readData(con);

                } else if (action == '3') {

                    //Delete data
                    System.out.println("Enter username that you want to delete");
                    String userDelete = scanner.nextLine().trim();
                    deleteData(con,userDelete);

                } else if (action == '4') {
                    dropTable(con);
                } else {
                    System.out.println("Invalid input");
                }


                System.out.println("Do you want to do anything else? y/n");
                again = scanner.nextLine().charAt(0);
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
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
        } else {
            System.out.println("Something went wrong");
        }

    }

    //Delete data
    public static void deleteData(Connection con, String username) throws SQLException{

        String sql = "DELETE FROM users WHERE username = ?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, username);

        if(preparedStatement.executeUpdate() > 0){
            System.out.println("A user was deleted successfully");
        } else {
            System.out.println("User not found");
        }
    }

    //Drop table
    public  static void dropTable(Connection con) throws SQLException{

        Statement dropStatement = con.createStatement();
        dropStatement.execute("DROP TABLE IF EXISTS users");
        

    }

}
