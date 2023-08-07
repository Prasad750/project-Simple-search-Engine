<%@page import = "java.util.ArrayList"%>
<%@page import = "com.SE.SearchResult"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
   <body class="search">
   <h1>Simple Search Engine </h1>
   <form action="Search">
       <input type="text"  name="keyword"></input>
       <button type="submit">Search</button>
   </form>
   <form action="History">
       <button type="submit">History</button>
   </form>

   <h3>Search results</h3>

        <table border=2  class="resultTable">
            <tr>
                <th>Title</th>
                <th>Link</th>
            </tr>
                <%
                   ArrayList<SearchResult>result=(ArrayList<SearchResult>)request.getAttribute("results");
                   for(SearchResult res:result){
                 %>
             <tr>
                <td><%out.println(res.getTitle());%></td>
                <td><a href= "<%out.println(res.getLink());%>"><%out.println(res.getLink());%></a></td>
              </tr>
               <%
                  }
               %>

        </table>
    </body>
</html>