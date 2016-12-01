<%@page contentType='text/html' pageEncoding='UTF-8' session='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
<title>Sauzen raden</title>
</head>
<body>
<form method="post" name="sausRadenForm">
	<label>Te raden saus: ${dotted}</label>
	<br />
	<label>
		letter: 
		<input type="text" name="letterField" />
	</label>
	<br /><br />
	<c:choose>
		<c:when test="${pogingen == 10}">
			<p>U bent verloren, de saus was ${saus}</p>
		</c:when>	
		<c:when test="${found}">
			<p>U bent gewonnen, de saus was ${saus}</p>
		</c:when>
		<c:otherwise>
			<button name="radenBtn" value="raden">Raden</button>	
		</c:otherwise>
	</c:choose>
	<br /><br />
	<button name="nieuwBtn" value="nieuw">Nieuw spel</button>	
</form>
<br />
<img src='<c:url value="/images/${pogingen}.png"/>' >
</body>
</html>