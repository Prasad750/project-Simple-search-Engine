package com.SE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/Search")
public class Search extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String keyword=request.getParameter("keyword");
        //System.out.println(keyword); this line print in console

        // setting connection with database
        Connection connection=DatabaseConnection.getConnection();
        try {

            //store querry in history table
            PreparedStatement pst=connection.prepareStatement("Insert into history values(?, ?);");
            pst.setString(1,keyword);
            pst.setString(2,"http://localhost:8080/SearchEngine/Search?keyword="+keyword);
            pst.executeUpdate();

            // creating sql query for getting to 30 results
            Statement st = connection.createStatement();

            //getting query result in ResultSet
            ResultSet rs = st.executeQuery("Select pageTitle,pageLink,(length(lower(pageText))-length(replace(lower(pageText),'"+keyword.toLowerCase()+"',' ')))/length('"+keyword.toLowerCase()+"') as countoccured from webpages order by countoccured desc limit 30;");

            //creating a list to store search result object
            ArrayList<SearchResult> results=new ArrayList<>();

            while(rs.next())
            {
                SearchResult searchResult=new SearchResult();
                searchResult.setTitle(rs.getString("pageTitle"));
                searchResult.setLink(rs.getString("pageLink"));
                results.add(searchResult);
            }

            //printing result in console

            for(SearchResult res: results)
            {
                System.out.println(res.getTitle()+"\n"+res.getLink()+"\n");
            }


            //requesting to new search.jsp file to display table

            request.setAttribute("results",results);
            request.getRequestDispatcher("search.jsp").forward(request, response);

            // to write in html page
            response.setContentType("Text/html");
            PrintWriter out=response.getWriter();

            // out.println("this is the keyword you have entered "+keyword);



        }
        catch(SQLException | ServletException e)
        {
            e.printStackTrace();
        }


    }

}
