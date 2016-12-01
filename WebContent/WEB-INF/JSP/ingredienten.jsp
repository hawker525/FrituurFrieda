<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp'>
		<c:param name='title' value="Sauzen zoeken per ingredient"/>
	</c:import>
</head>
<body>
	<h1>Sauzen zoeken per ingredient</h1>
	<form>
		<label><input type="text" name="ingredient" value="${param.ingredient}" ><span>${fout}</span></label>
		<input type="submit" value="Toon de sauzen">	
	</form>
	<c:if test='${not empty ingSauzen}'>
		<h1>Sauzen die ${param.ingredient} bevatten:</h1>	
		<ul>
		<c:forEach var='saus' items='${ingSauzen}' >
			<li><c:out value='${saus.naam}' /></li>
		</c:forEach>
		</ul>
	</c:if>
</body>
</html>