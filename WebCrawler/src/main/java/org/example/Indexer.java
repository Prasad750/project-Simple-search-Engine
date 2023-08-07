package org.example;

import org.jsoup.nodes.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Indexer {

    static Connection connection=null;

    Indexer(Document document,String url)
    {
        String title= document.title();
        String link=url;
        String text= document.text();

        // save this in database
        try {
            connection = DatabaseConnection.getConnection();
            PreparedStatement pst = connection.prepareStatement("Insert into webPages values(?,?,?)");
            pst.setString(1,title);
            pst.setString(2,link);
            pst.setString(3,text);
            pst.executeUpdate();

        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}
