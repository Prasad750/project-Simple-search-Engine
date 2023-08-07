<%@page import = "java.util.ArrayList"%>
<%@page import = "com.SE.HistoryResult"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
    <body class="history">
    <h1>Search History</h1>
        <table border=2  class="resultTable">
            <tr>
                <th>Keyword</th>
                <th>Link</th>
            </tr>

            <%
                ArrayList<HistoryResult> result=(ArrayList<HistoryResult>) request.getAttribute("results");
                for(HistoryResult res:result){
            %>

            <tr>
                <td><%out.println(res.getKeyword());%></td>
                <td><a href="<%out.println(res.getLink());%>" ><%out.println(res.getLink());%></a></td>
            </tr>

            <%
                }
            %>
        </table>
    </body>
</html>