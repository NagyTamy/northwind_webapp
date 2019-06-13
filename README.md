Task description:


<h1>Northwind Webapp</h1>

Your task is to create a very simple webapp which displays the result of the queries you have written previously for the Northwind Queries assignment.
Requirements

    Create an index page where there's link to Task pages.
    Each Task's result should be accessible on a separate page
        .../task1
        .../task2
        ...
    When a user clicks on a Task 's link display the results in an HTML table (styling with CSS isn't necessary, but make it look okay ).
        On each page create a FORM with which user can enter a filter expression to filter the results.
        It's enough to allow users to filter on one dimension. E.g. if the result contains all products from all suppliers then the user should be able to filter the selection by the name of the supplier.
    On the back-end, for each Task create
        a Model object - a simple Java POJO which can contain all information available in the result.
        a Servlet - that accepts the GET/POST requests and delegates to a Service for further processing (to retrieve a list of Model objects) to pass that to a JSP to render as HTML.
            Create JDBC Connections here, once per request and pass them as constructor parameters to DAOs.
            DAOs and services are instantiated in the servlet.
        a Service - that can return the results (either unfiltered or filtered) using a DAO.
            Services depend on DAOs - only allow a service to be instantiated when supplied a DAO.
        a DAO - which actually queries the database for information.
            DAOs depend on established Connections - only allow DAOs to be instantiated after passing a Connection as constructor argument.
            Here you'll going to use classes like Statement/PreparedStament and ResultSet.
    Login, session handling, etc. is not required.
