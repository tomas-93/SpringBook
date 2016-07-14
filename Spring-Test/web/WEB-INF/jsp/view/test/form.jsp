<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 14/07/2016
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Form</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<div class="card" style="margin: 5%; padding: 5%;">
    <h5>Formulario de Usuarios</h5>
    <c:choose>
        <c:when test="${flagForm == true}">
            <span>Nombre ${userForm.name}</span><br>
            <span>Apellido ${userForm.surName}</span><br>
            <span>Escuela ${userForm.school}</span><br>
            <span>Edad ${userForm.age}</span><br>
        </c:when>
        <c:otherwise>
            <form:form method="post" action="/test/form" commandName="UserForm">
                <form:label path="name">Nombre</form:label>
                <form:input path="name"></form:input>
                <form:errors path="name">Error de Nombre</form:errors>
                <br>
                <form:label path="surName">Apellidos</form:label>
                <form:input path="surName"></form:input>
                <form:errors path="surName">Error de apellidos</form:errors>
                <br>
                <form:label path="school">Escuela</form:label>
                <form:input path="school"></form:input>
                <form:errors path="school">Error de escuela</form:errors>
                <br>
                <form:label path="age">Edad</form:label>
                <form:input path="age"></form:input>
                <form:errors path="age">Error de edad</form:errors>
                <br>
                <input type="submit" value="Guardar"/>
            </form:form>
        </c:otherwise>
    </c:choose>



    <!-- Compiled and minified JavaScript -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
    <script src="/web/public/js/app.js"></script>
</div>
</body>
</html>
