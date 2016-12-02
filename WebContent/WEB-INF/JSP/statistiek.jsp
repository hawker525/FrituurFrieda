<%--
  Created by IntelliJ IDEA.
  User: maarten
  Date: 12/2/16
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<html>
<head>
    <title>Statistieken</title>
</head>
<body>
 <c:forEach items="${statistiek}" var="site" >
     <p>pagina ${site.key} werd al ${site.value} keer bezocht.</p>
 </c:forEach>
</body>
</html>
