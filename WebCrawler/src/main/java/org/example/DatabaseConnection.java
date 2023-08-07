package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{

    static Connection connection=null;

    public static Connection getConnection()
    {
        if(connection!=null)
        {
            return connection;
        }

        String user="root";
        String psw="Pr@s@d750#";
        String db="searchEngineApp";

        return getConnection(user,psw,db);

    }
    private static Connection getConnection(String user,String psw,String db)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,user,psw);
        }
        catch(ClassNotFoundException | SQLException classNotFoundException)
        {
            classNotFoundException.printStackTrace();
        }

        return connection;
    }
}
