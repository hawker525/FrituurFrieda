<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp' >
		<c:param name='title' value='Frituur Frieda' />	
	</c:import>
</head>
<body>
	<h1>Vandaag zijn we ${openGesloten}</h1>
	<img src="images/${openGesloten}.png" />
	<h2>Adres</h2>
	<p>${adres.straat} ${adres.huisNr}, ${adres.gemeente.postCode} ${adres.gemeente.naam}</p>
</body>
</html>