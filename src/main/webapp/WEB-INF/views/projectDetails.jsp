<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/jspf/head-config.jspf"%>
    <title>Szczegóły projektu</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<%@ include file="/WEB-INF/views/jspf/main-menu.jspf"%>
<div>
    <h2>Szczegóły projektu</h2>
</div>


<div>
    <table>

        <thead>
        <tr>
            <th>Projekt</th>
            <th>Zadanie</th>
            <th>Opis</th>
            <th>Termin końcowy</th>
            <th>Priorytet</th>
            <th>&nbsp;</th>
        </tr>
        </thead>

        <c:forEach var="task" items="${tasks}">
            <tr>
                <td><c:out value="${task.project.name}"/></td>
                <td><c:out value="${task.name}"/></td>
                <td><c:out value="${task.description}"/></td>
                <td><c:out value="${task.deadline}"/></td>
                <td><c:out value="${task.priority}"/></td>
                <td>
                    <form action="/user/comment/showComments/${task.id}" method="get">
                        <button type="submit">Pokaż komentarze</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>