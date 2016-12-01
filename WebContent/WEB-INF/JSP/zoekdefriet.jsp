<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html>
<head>
<title>Zoek de friet</title>
</head>
<body>
<h1>Zoek de friet</h1>
<form method='get'>
	<c:forEach begin="0" end="6" var="teller">
	<button type='submit' name='volgnummer' value='${teller}'>
		<img src='<c:url value="/images/${keuzes[teller]}.png"/>' alt='deur toe'/>
	</button>
	</c:forEach>
	<br />
	<button type='submit' name='nieuwBtn' value="nieuw">Nieuw spel</button>
</form>
</body>
</html>