<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/jspf/head-config.jspf"%>
    <title>Strona główna</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<%@ include file="/WEB-INF/views/jspf/main-menu.jspf"%>
<div>
    <h2>Dodaj projekt</h2>
    <form:form method="post" modelAttribute="project">
    <div>
        <p><label>Nazwa projektu: <form:input path="name"</label></p>
    </div>
</div>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>