<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/views/jspf/head-config.jspf"%>
    <title>Rejestracja</title>
</head>
<body>
<%@ include file="/WEB-INF/views/jspf/header.jspf"%>
<%@ include file="/WEB-INF/views/jspf/main-menu.jspf"%>
<form:form method="post" modelAttribute="user">
    <div>
        <p><label>Nazwa użytkownika: <form:input path="username"/></label></p>
        <p> <form:errors path="username" /></p>
    </div>
    <div>
        <p><label>Email: <form:input path="email"/></label></p>
        <p> <form:errors path="email" /></p>
    </div>
    <div>
        <p><label>Hasło: <form:input path="password"/></label></p>
        <p> <form:errors path="password" /></p>
    </div>
    <div>
        <p><label>Powtórz hasło: <form:input path="repeatPassword"/></label></p>
        <p> <form:errors path="repeatPassword" /></p>
    </div>
    <div>
        <input type="submit" value="Wyślij">
    </div>
</form:form>
<%@ include file="/WEB-INF/views/jspf/footer.jspf"%>
</body>
</html>
