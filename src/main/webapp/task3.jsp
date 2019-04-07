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
            <li><a href="task2">Task2</a></li>
            <li><a href="task3"  class="marked">Task3</a></li>
            <li><a href="task4">Task4</a></li>
            <li><a href="task5">Task5</a></li>
        </ul>
    </nav>
    <form action="task3" method="post">
        <input type="text" placeholder="Search by company name..." name="company">
        <input type="submit" value="Search">
    </form>
    <p class="error"><c:out value="${error}"/></p>
    <table>
        <tr>
            <th class="one_column">Company</th>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td class="one_column">${item.getCompany()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>




