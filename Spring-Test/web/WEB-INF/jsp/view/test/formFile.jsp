<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 14/07/2016
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:choose>
    <c:when test="${flagFormFile == true}">

    </c:when>
    <c:otherwise>
        <form:form method="post" action="/file/multipart" commandName="filesForm">
        </form:form>
    </c:otherwise>
</c:choose>

</body>
</html>
