package database;

//TODO
// Using the JDBC API and MySQl make the following queries as individual functions:
// 1. Drop table MOVIES if there is one.
// 2. Create a table MOVIES with columns: id(primary key) of type INTEGER AUTO INCREMENT,title of type VARCHAR (255), genre of type VARCHAR (255),yearOfRelease of type INTEGER.
// 3. Add any three records to the MOVIES table
// 4. Update one selected record's title field (use the PreparedStatement)
// 5. Delete selected record with specified id
// 6. Display all other records in the database

import java.sql.*;


public class Task1 {
    public static void main(String[] args) {

        String dbURL = "jdbc:mysql://localhost:3306/javaee18";
        String username = "root";
        String password = "1234";

        try(Connection con = DriverManager.getConnection(dbURL, username, password)){

            drop(con);
            create(con);
            insert(con);
            read(con);
            update(con);
            read(con);
            delete(con);
            read(con);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void drop(Connection con) throws SQLException{
        Statement dropStatement =  con.createStatement();
        dropStatement.execute("DROP TABLE IF EXISTS MOVIES");
    }

    public static void create(Connection con) throws SQLException{

        Statement createTableStatement = con.createStatement();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS MOVIES ("+
              "id INTEGER AUTO_INCREMENT, "+
              "title VARCHAR(255), "+
              "genre VARCHAR(255), "+
              "yearOfRelease INTEGER, "+
              "PRIMARY KEY (id))";
        createTableStatement.execute(createTableQuery);

    }

    public static void insert(Connection con) throws SQLException{
        Statement insertItemStatement = con.createStatement();
        String insertStarWarsQuery = "INSERT INTO MOVIES (title, genre, yearOfRelease) VALUES ('Star Wars', 'Action', 2015)";
        String insertHarryPotterQuery = "INSERT INTO MOVIES (title, genre, yearOfRelease) VALUES ('Harry Potter', 'Fantasy', 2001)";
        String insertRockyQuery = "INSERT INTO MOVIES (title, genre, yearOfRelease) VALUES ('Rocky', 'Sports', 1979)";
        insertItemStatement.executeUpdate(insertStarWarsQuery);
        insertItemStatement.executeUpdate(insertHarryPotterQuery);
        insertItemStatement.executeUpdate(insertRockyQuery);
    }

    public static void update(Connection con) throws SQLException{
        PreparedStatement updateStatement = con.prepareStatement("UPDATE MOVIES SET title = ? WHERE id = ?");
        updateStatement.setString(1, "Star Wars Force Awakens");
        updateStatement.setInt(2, 1);
        updateStatement.executeUpdate();
    }

    public static void delete(Connection con) throws SQLException{
        Statement deleteItemStatement = con.createStatement();
        deleteItemStatement.executeUpdate("DELETE FROM MOVIES WHERE id = 2");
    }


    public static void read(Connection con) throws SQLException{

        Statement readItemStatement = con.createStatement();
        String readItemsQuery = "SELECT * FROM MOVIES";
        ResultSet rs = readItemStatement.executeQuery(readItemsQuery);

        while (rs.next()){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String genre = rs.getString("genre");
            int yearOfRelease = rs.getInt("yearOfRelease");

            System.out.println("###########");
            System.out.println("Id: " + id);
            System.out.println("Title: " + title);
            System.out.println("Genre: " + genre);
            System.out.println("Year of release: " + yearOfRelease);

        }
    }


}
