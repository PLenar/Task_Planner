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
        <tbody>
        <tr>
            <td>Nazwa</td>
            <td>Opis</td>
            <td>Status</td>
            <td>Data utworzenia</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <c:forEach items="${projects}" var="project">
            <tr>
                <td>${project.name}</td>
                <td>${project.description}</td>
                <td>${project.progressComment}</td>
                <td>${project.created}</td>
                <td>
                    <a href="user/project/edit">
                        <button>Edytuj</button>
                    </a>
                </td>
                <td>
                    <a href="user/project/delete">
                        <button>Usuń</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
