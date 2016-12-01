<%@page contentType='text/html' pageEncoding='UTF-8' session='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp' >
		<c:param name='title' value='Sauzen Raden' />	
	</c:import>
</head>
<body>
	<form id="sauzenRadenForm" action="post">
		<p>saus: ${saus}</p>
		<p>Te raden saus: ${dotted}</p>
		<label>
		letter: 
		<input type="text" name="letter"/>
		</label>
		<br />
		<br />
		<label>
			<input type="button" name="radenBtn" value="Raden">
		</label>
		<br />
		<br />
		<label>
			<input type="button" name="nieuwBtn" value="Nieuw spel">
		</label>
	<br />
	</form>
</body>
</html>