# project-Simple-search-Engine
The project is about implementing a simple search engine and understanding how it works behind the scenes which shows a web application with a search bar,search button and a history button.The project allows users to search for top 30 results according to their query and displays their search history.The project only includes two functions for simplicity. The functions of the project are to perform a search and to get user search history.The function to perform a search is complex and involves many algorithms.

# Description
The web application consists of three major components: front end, back end, and database.
1. Front end: Responsible for the client-side of the application, where the user interacts with the application.
2. Back end: Handles the server-side of the application, processing requests from the client and generating responses.
3. Database: Stores and manages the data used by the web application.

The client makes requests to the server for data, calculations, or other operations it cannot perform.Server handles the request and generates a response to the client.Front end is the client-side application, and back end is the server-side application.The front end sends requests to the back end, and the back end fulfills the requests and generates responses.


# Demonstration of Search Engine 
The web application consists of a front end and a back end user interacts with the front end by providing a search query.The query is passed to the back-end query parser back end performs a search operation based on the query.The search is conducted in a database containing web pages.The back end uses a ranking algorithm to find the top 30 most relevant results and ranked results are sent to the front end and displayed to the user.
The back story of the search engine involves obtaining web pages for the database.A crawler, also known as a web crawler or spider bot, is used to retrieve data from web pages.Crawler parses HTML pages and converts objects to Java objects.The crawler requests and retrieves pages from the internet, crawling through them and retrieved data is provided to the indexer.Indexer saves the data to the database.

# Demonstration  of Search Engine Web Crawler
A web crawler is a bot that crawls over the Internet to gather page data.Manual page-by-page addition to a database is impractical, so an automatic bot is needed.
The bot uses an algorithm called DFS (Depth-First Search) to navigate through web pages. Process starts with a designated starting webpage (W1).Crawler bot visits W1 and parses all its HTML objects, converting them to Java objects.The bot determines the next webpage to visit based on the DFS algorithm.Webpage w1 contains hyperlinks that connect it to other web pages.While parsing the HTML objects, the bot identifies the links present on W1.These links serve as children's web pages connected to W1.The bot proceeds to visit the first child webpage (W2) and repeats the parsing process.W2 also contains hyperlinks that connect it to other web pages, such as W5, W6, and W7.The crawler bot follows the DFS approach, processing children before moving to the next level.After processing W5, the bot proceeds to W6 and then W7.If a web page has no further connections, the bot backtracks to the previous level.Backtracking ensures all children of a parent node are processed before moving to the next parent.The order of processing is: W1, W2, W5, W6, W7.If all web pages are not connected to anything, the bot continues to backtrack.Backtracking from W7 leads to W2, and then back to W1 to process the next child.the process continues with W3 and W4 webpages.The final order of processing is: W1, W2, W5, W6, W7, W3, W4.

# Demonstration of Search Engine Indexing
Indexing is a process of selecting important parts of a web page for finding its relevance with the user's query.Indexer gets the HTML pages from the crawler and selects three important things of a web page: page title, page link, and page text.Page title and page link are used to show in the result section, and page text is used to find the relevance of the page.Indexer saves all the important things to the database, including page title, page link, and page text.The connection instance needs to be static to save it in the database.Indexer constructor is a parameterized constructor that receives a Document object.In the constructor, important elements of the document are selected: title, link, and text.These elements are then saved to the database.

# Demonstration of  Search Engine Ranking 
Different search engines use various ranking algorithms.Some search engines, like Google, use sentiment and semantic analysis to understand the context and meaning of web pages.In the project, a basic ranking algorithm is used.The algorithm counts the number of occurrences of the keyword in the page text to determine relevance.The example of a page about "Bahubali" movie and a page about "top 10 movies" is given to explain relevance based on keyword occurrences.Counting Keyword Occurrences.The algorithm counts the occurrences of the keyword in the page text.The page text is considered more important for relevance than page links or titles.
The page with more occurrences of the keyword is deemed more relevant to the user's search.An SQL query is created to count the keyword occurrences in the page text.

# Demonstration of Displying Search Results
The result analyst has been prepared in the back end using an SQL query.The top 30 results have been obtained from the back end.To show the results in Tableau format, the result analyst needs to be sent to the front end.Setting the parameter of the request is necessary to send the result analyst to the front end.The request is then forwarded to the front end.A front end file, "search.jsp," is created for displaying the search result.The request and response are forwarded to the "search.jsp" file.Exception handling is implemented using the catch blocks.All the search results are accessible in the "search.jsp" file, which is an HTML file with embedded Java code and an HTML structure.

# Demonstration of Displying Search History
The History feature stores all the previously searched queries by the user.When a user searches for a query, it goes from the front end to the back end, where the SQL query is applied to the database to retrieve the results.The results are then forwarded to the front end and shown to the user.To implement the History feature, a separate sublet called the history sublet needs to be created.The history sublet stores and displays all the queries previously searched by the user. When the search sublet is triggered, it stores the query in a separate table called the history table.The history sublet retrieves and displays all the queries stored in the history table. Storing queries is the responsibility of the search sublet, not the history sublet. When the user clicks on the history button, the request is passed to the back end, triggering the history sublet.The history sublet retrieves all the values from the history table using a SQL query. The retrieved history results are then forwarded to the front end for display. The functioning of the history feature is similar to the search function, but the queries are stored by the search sublet. The history sublet is only responsible for displaying the previously searched queries. When the search sublet is triggered, it stores the query in addition to retrieving the search results. 

# Technologies
1. Java: Java is used to writing project logic utilizing Object Oriented Programming (OOP) concepts.
2. Intellij IDE :IntelliJ IDEA is a popular integrated development environment (IDE) designed to streamline software development. It offers a user-friendly interface and a wide array of features to assist developers in writing, debugging, and maintaining code efficiently.
3. HTML:HTML will be used for the front end, which is responsible for creating the structure of the web page.
4. CSS : CSS  will be used for styling the web page, including elements such as background color, font color, and alignment.
5. JSP : JSP (Java Server Pages) will be used to connect the front end to the back end by allowing Java code to be written inside HTML files.Java Servlets will be used for the back end, specifically for creating multiple mini servers to handle different types of calculations or operations.
6. MySQL:MySQL is a popular database management system, will be used for storing and interacting with data.
7. Java Servlets : Java Servlets are introduced as a technology to divide the back end server into different servlet classes. The front end receives a keyword or query from the user through a search bar and sends a request to the back end. The back end, which contains multiple servlets, including the search servlet, receives the request and generates a response. The response is then displayed in a tabular view or the desired view by the front end. The front end-back end interaction involves the front end sending a request to the back end, and the back end generating a response based on the user's request. The search servlet is triggered when the user submits the search form, and it handles the search request. To make the search Java class a servlet, it needs to be annotated with "@WebServlet" before the class declaration.

# ScreenShots of the live demo project
1. Home page
![Screenshot 2023-08-07 164640](https://github.com/Prasad750/project-Simple-search-Engine/assets/138876806/f9aa6ff2-7f1a-4810-b68c-063d0fb95119)

2. Search Result Page
![Screenshot 2023-08-07 164657](https://github.com/Prasad750/project-Simple-search-Engine/assets/138876806/26443e5c-9334-420b-b9d8-ce3bc2da7424)

3. Search History Page
![Screenshot 2023-08-07 164713](https://github.com/Prasad750/project-Simple-search-Engine/assets/138876806/52d9791e-2cab-460c-ab20-c310f821cf10)
