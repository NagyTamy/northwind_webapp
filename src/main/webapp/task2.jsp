<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<jsp:include page="snippets/head.jsp"/>
<body>
    <h1>Northwind Webapp</h1>
    <nav>
        <ul>
            <li><a href="task1">Task1</a></li>
            <li><a href="task2"  class="marked">Task2</a></li>
            <li><a href="task3">Task3</a></li>
            <li><a href="task4">Task4</a></li>
            <li><a href="task5">Task5</a></li>
        </ul>
    </nav>
    <form action="task2" method="post">
        <input type="text" placeholder="Search by company name..." name="company">
        <input type="submit" value="Search">
    </form>
    <p class="error"><c:out value="${error}"/></p>
    <table>
        <tr>
            <th>Company</th>
            <th>Numbers of product</th>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.getCompany()}</td>
                <td>${item.getNumbersOfProduct()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>




