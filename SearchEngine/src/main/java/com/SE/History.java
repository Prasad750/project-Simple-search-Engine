package com.SE;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet("/History")
public class History extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
      Connection connection=DatabaseConnection.getConnection();
      try {
          Statement st=connection.createStatement();
          ResultSet rs=st.executeQuery("select * from history");

          ArrayList<HistoryResult> result=new ArrayList<HistoryResult>();

          while(rs.next())
          {
              HistoryResult historyResult=new HistoryResult();
              historyResult.setKeyword(rs.getString("keyword"));
              historyResult.setLink(rs.getString("link"));
              result.add(historyResult);
          }

          // requesting to history.jsp to display history table
          request.setAttribute("results",result);
          request.getRequestDispatcher("history.jsp").forward(request, response);

          // to write in html templet
          response.setContentType("Text/html");
          PrintWriter out=response.getWriter();
      }
      catch (SQLException | ServletException e)
      {
          e.printStackTrace();
      }
  }
}
