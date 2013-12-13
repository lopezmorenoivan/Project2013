package com.example.Tools;
import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.Logic.New;
import com.example.Logic.Room;
import com.example.Logic.Task;
import com.example.Logic.User;

public class Database {

    public static void execute(String query){

        String connectionUrl = "jdbc:sqlserver://y5huf0ke8e.database.windows.net:1433;database=DB2;user=database@y5huf0ke8e;password=Finlandsgade22;loginTimeout=30;";
        Connection connexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connexion = DriverManager.getConnection(connectionUrl);
            statement = connexion.createStatement();
            rs = statement.executeQuery(query);
        }

        catch (Exception e) {}
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (statement != null) try { statement.close(); } catch(Exception e) {}
            if (connexion != null) try { connexion.close(); } catch(Exception e) {}
        }
    }

    public static ArrayList<Room> readFromRoom(User u){
        ArrayList<Room> result = new ArrayList<Room>();

        String query = "SELECT * FROM dbo.Room WHERE idCompany="+
                            "(SELECT idCompany FROM dbo.Employee WHERE idEmployee="+u.getId()+");";

        String connectionUrl = "jdbc:sqlserver://y5huf0ke8e.database.windows.net:1433;database=DB2;user=database@y5huf0ke8e;password=Finlandsgade22;loginTimeout=30;";
        Connection connexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connexion = DriverManager.getConnection(connectionUrl);
            statement = connexion.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                result.add(new Room(rs.getString("name"), rs.getBytes("map"), rs.getInt("location")));
            }
        }

        catch (Exception e) {}
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (statement != null) try { statement.close(); } catch(Exception e) {}
            if (connexion != null) try { connexion.close(); } catch(Exception e) {}
        }

        return result;
    }

    public static ArrayList<Task> readFromAgenda(User u){
        ArrayList<Task> result = new ArrayList<Task>();

        String query = "SELECT * FROM dbo.Task WHERE idEmployee="+u.getId()+";";

        String connectionUrl = "jdbc:sqlserver://y5huf0ke8e.database.windows.net:1433;database=DB2;user=database@y5huf0ke8e;password=Finlandsgade22;loginTimeout=30;";
        Connection connexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connexion = DriverManager.getConnection(connectionUrl);
            statement = connexion.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                Calendar cal = GregorianCalendar.getInstance();
                cal.setTime(rs.getDate("date"));
                result.add(new Task(rs.getString("name"), rs.getString("description"), (GregorianCalendar) cal));
            }
        }

        catch (Exception e) {}
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (statement != null) try { statement.close(); } catch(Exception e) {}
            if (connexion != null) try { connexion.close(); } catch(Exception e) {}
        }

        return result;
    }

    public static ArrayList<New> readFromNews(User u){
        ArrayList<New> result = new ArrayList<New>();

        String query = "SELECT * FROM dbo.News WHERE idCompany=(SELECT idCompany FROM dbo.Employee WHERE idEmployee="+u.getId()+");";

        String connectionUrl = "jdbc:sqlserver://y5huf0ke8e.database.windows.net:1433;database=DB2;user=database@y5huf0ke8e;password=Finlandsgade22;loginTimeout=30;";
        Connection connexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connexion = DriverManager.getConnection(connectionUrl);
            statement = connexion.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()){
                result.add(new New(rs.getString("tilte"), rs.getString("content"), rs.getString("description"),rs.getBytes("picture")));
            }
        }

        catch (Exception e) {}
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (statement != null) try { statement.close(); } catch(Exception e) {}
            if (connexion != null) try { connexion.close(); } catch(Exception e) {}
        }
        return result;
    }

    public static ArrayList<User> readFromUsers(User u){
        ArrayList<User> result = new ArrayList<User>();

        String query = "SELECT * FROM dbo.User WHERE idCompany="+
                "(SELECT idCompany FROM dbo.Employee WHERE idEmployee="+u.getId()+");";

        String connectionUrl = "jdbc:sqlserver://y5huf0ke8e.database.windows.net:1433;database=DB2;user=database@y5huf0ke8e;password=Finlandsgade22;loginTimeout=30;";
        Connection connexion = null;
        Statement statement = null;
        ResultSet rs = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connexion = DriverManager.getConnection(connectionUrl);
            statement = connexion.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
                result.add(new User(rs.getString("name"),rs.getString("surname"),rs.getBytes("picture"), rs.getInt("privileges"), rs.getString(" phone"), rs.getString(" office"), rs.getInt(" location"), rs.getString(" position"), rs.getString(" mail"), rs.getString("password")));
            }
        }

        catch (Exception e) {}
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (statement != null) try { statement.close(); } catch(Exception e) {}
            if (connexion != null) try { connexion.close(); } catch(Exception e) {}
        }


        return result;
    }

    public static void lastCheckIn(User u){
        // todo
    }
}
