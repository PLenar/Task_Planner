<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/jspf/head-config.jspf"%>
    <title>Zarządzaj projektem</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<%@ include file="/WEB-INF/views/jspf/main-menu.jspf"%>
<div>
    <h2>Manage</h2>
</div>

<div>
    <table>
        <tbody>
        <tr>
            <td>Project</td>
            <br>
            <td>
                <a href="project/add">
                    <button>Add</button>
                </a>
            </td>
            <br>

            <td>
                <a href="project/all">
                    <button>All Projects</button>
                </a>
            </td>
            <br>
        </tr>
        <tr>
            <td>Task</td>
            <br>
            <td>
                <a href="task/add">
                    <button>Add</button>
                </a>
            </td>
            <br>
            <td>
                <a href="task/all">
                    <button>All Tasks</button>
                </a>
            </td>
            <br>
        </tr>
        <tr>
            <td>Comments</td>
            <br>
            <td>
                <a href="comment/add">
                    <button>Add</button>
                </a>
            </td>
            <br>
            <td>
                <a href="comment/all">
                    <button>All Comments</button>
                </a>
            </td>
            <br>
        </tr>
        </tbody>
    </table>
</div>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
