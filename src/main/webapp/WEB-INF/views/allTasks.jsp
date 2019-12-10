<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/jspf/head-config.jspf"%>
    <title>Zadanie</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<%@ include file="/WEB-INF/views/jspf/main-menu.jspf"%>

<div>
    <h2>Zadania</h2>
</div>

<div>
    <table>
        <thead>
        <tr>
            <th>Zadanie</th>
            <th>Opis</th>
            <th>Termin końcowy</th>
            <th>Priorytet</th>
            <th>Data utworzenia</th>
            <th>Data ostatniej edycji</th>
            <th>Edytuj</th>
            <th>Usuń</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${allTasks}">
            <tr>
                <td>${task.name}</td>
                <br>
                <td>${task.description}</td>
                <br>
                <td>${task.deadline}</td>
                <br>
                <td>${task.priority}</td>
                <br>
                <td>${task.created}</td>
                <br>
                <td>${task.updated}</td>
                <br>
                <td>
                    <form action="edit/${task.id}" method="get">
                        <button type="submit">Edytuj</button>
                    </form>
                </td>
                <br>
                <td>
                    <form action="delete/${task.id}" method="post">
                        <button type="submit">Usuń</button>
                    </form>
                </td>
                <br>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
