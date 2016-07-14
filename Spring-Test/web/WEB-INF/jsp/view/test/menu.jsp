<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 12/07/2016
  Time: 10:29 PM
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
    <title>Spring-test</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
    <div class="card" style="margin: 5%;">
        <h4>Uso de @RequestMapping</h4>
        <ul>
            <li>
                <a href="<c:url value="/view"/>">Vista-Implicita</a>
            </li>
            <li>
                <a href="<c:url value="/add"/>">Vista-explicita</a>
            </li>

            <li>
                <a href="<c:url value="/url1/url2"/>">Rutas Anidadas</a>
            </li>
            <li>
                <a href="<c:url value="/ruta1/ruta2"/>">Restricciones HTTP</a>
            </li>
        </ul>
    </div>
    <div class="card" style="margin: 5%;">
        <h4>Uso de @RequestParam</h4>
        <ul>
            <li>
                <a href="<c:url value="/var-test4">
                            <c:param name="var" value="Parametro var: Hola mundo"/>
                         </c:url>">Parametro sin restriccion</a>
            </li>
            <li>
                <a href="<c:url value="/option-test4">
                         </c:url>">Parametro con la restriccion del valor opcional(null)</a>

            </li>
            <li>
                <a href="<c:url value="/option-test4">
                            <c:param name="var" value="Hola mundo"/>
                         </c:url>">Parametro con la restriccion del valor opcional("hola mundo")</a>
            </li>
            <li>
                <a href="<c:url value="/force-test4">
                         </c:url>">Parametro con la restriccion required=true valor del parametro(null)</a>
            </li>
            <li>
                <a href="<c:url value="/force-test4">
                            <c:param name="var" value="Hola mundo"/>
                         </c:url>">Parametro con la restriccion required=true valor del parametro("hola mundo")</a>
            </li>
            <li>
                <a href="<c:url value="/default-test4">
                         </c:url>">Parametro con la restriccion defaultvalue valor del parametro(null)</a>
            </li>
            <li>
                <a href="<c:url value="/default-test4">
                            <c:param name="var" value="Hola mundo desde el parametro"/>
                         </c:url>">Parametro con la restriccion defaultvalue valor parametro("hola mundo desde el parametro")</a>
            </li>
        </ul>
    </div>
    <div class="card" style="margin: 5%;">
        <h4>Uso de @PathVariable</h4>
        <ul>
            <li>
                <a href="<c:url value="/head-test4">
                         </c:url>">Headers</a>
            </li>
        </ul>
    </div>
    <div class="card" style="margin: 5%;">
        <h4>Uso de @RequestHeader</h4>
        <ul>
            <li>
                <a href="<c:url value="/head-test4">
                         </c:url>">Headers</a>
            </li>
        </ul>
    </div>

    <div class="card" style="margin: 5%;">
        <h4>Uso de @PathVariable</h4>
        <ul>
            <li>
                <a href="<c:url value="/user/name/tomas/age/23"/>">Ruta url: user/name/{Tomas}/age/{23}</a>
            </li>
        </ul>
        <h4>Uso de @PathVariable y @MatrixVariable</h4>
        <ul>
            <li>
                <a href="<c:url value="/user/1;floor=1;room=23/end"/>">Ruta Matrix url: /user/1;floor=1;room=23/end</a>
            </li>
        </ul>
    </div>
    <div class="card" style="margin: 5%;">
        <h4>Uso de Formulario</h4>
        <a href="<c:url value="/test/form"/>">Forumularios</a>

    </div>
    <!-- Compiled and minified JavaScript -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
</body>
</html>
