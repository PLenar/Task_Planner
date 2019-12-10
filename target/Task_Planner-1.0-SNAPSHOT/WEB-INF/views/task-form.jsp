<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/jspf/head-config.jspf"%>
    <title>Dodaj zadanie</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<%@ include file="/WEB-INF/views/jspf/main-menu.jspf"%>
<div>
    <h2>Dodaj zadanie</h2><br>
    <div>
        <div>
            <form:form modelAttribute="task" method="post">

                <div>
                    <p><label>Zadanie: <form:input path="name"/></label></p>
                    <p><form:errors path="name"/></p>
                </div>
                <div>
                    <p><label>Opis: <form:input path="description"/></label></p>
                    <p><form:errors path="description"/></p>
                </div>
                <div>
                    <p><label>Projekt: <form:select path="project" items="${projects}" itemValue="id" itemLabel="name"/></label>
                    </p>
                    <p><form:errors path="project"/></p>
                </div>
                <div>
                    <p><label>Termin końcowy: <form:input path="deadline" type="date" value="${dateNow}"/></label></p>
                    <p><form:errors path="deadline"/></p>
                </div>
                <div>
                    <p><label>Priorytet (1-10): <form:input type="number" min="1" max="10"  path="priority"/></label></p>
                    <p><form:errors path="priority"/></p>
                </div>

                <div>
                    <input type="submit" value="Wyślij">
                </div>
            </form:form>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>