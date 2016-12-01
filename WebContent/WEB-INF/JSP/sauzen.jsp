<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import='java.io.PrintWriter'%> 
<%@page import='java.util.Calendar'%>
<!doctype html>
<html>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp' >
		<c:param name='title' value='Sauzen' />	
	</c:import>
</head>

<body>
	<h1>Sauzen</h1>
	<form method='post' id='sauzenForm'>
		<c:forEach items="${sauzen}" var="saus">
			<label>
			<input type="checkbox" name="id" value="${saus.nummer}">
			${saus.naam}, ingredienten: 
			${fn:join(saus.ingredienten.toArray() , ",")}
			<img src="images/${saus.naam}.png" />
			<br />
			</label>
		</c:forEach>
		<input type="submit" name="submit" value="Aangevinkte sauzen verwijderen" id="submitBtn"/> 
	</form>
	<!-- <ul>
		<c:forEach var="saus" items="${sauzen}">
			<li>
${saus.naam}, ingredienten: 
			${fn:join(saus.ingredienten.toArray() , ",")}
			<img src="images/${saus.naam}.png" />
			</li>
		</c:forEach>
	</ul> -->
<script>
	document.getElementById('sauzenForm').onsubmit = function() {
		document.getElementById('submitBtn').disabled = true;
	};
</script>
</body>
</html>