<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/jspf/head-config.jspf"%>
    <title>Projekty</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<%@ include file="/WEB-INF/views/jspf/main-menu.jspf"%>

<div>
    <h2>Projekty</h2>
</div>

<div>
    <table>
        <thead>
        <tr>
            <th>Szczegóły</th>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Status</th>
            <th>Data utworzenia</th>
            <th>Data ostatniej edycji</th>
            <th>Edytuj</th>
            <th>Usuń</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="project" items="${allProjects}">
            <tr>
                <td>
                    <form action="details/${project.id}" method="get">
                        <button type="submit">Pokaż zadania</button>
                    </form>
                </td>
                <td>${project.name}</td>
                <br>
                <td>${project.description}</td>
                <br>
                <td>${project.progressStatus}</td>
                <br>
                <td>${project.created}</td>
                <br>
                <td>${project.updated}</td>
                <br>
                <td>
                    <form action="edit/${project.id}" method="get">
                        <button type="submit">Edytuj</button>
                    </form>
                </td>
                <br>
                <td>
                    <form action="delete/${project.id}" method="post">
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
