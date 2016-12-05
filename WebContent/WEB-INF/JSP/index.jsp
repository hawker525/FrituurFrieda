<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<fmt:setBundle basename="resourceBundles.teksten"/>
<!doctype html>
<html>
<head>
	<c:import url='/WEB-INF/JSP/head.jsp' >
		<c:param name='title' value='Frituur Frieda' />	
	</c:import>
</head>
<body>
	<h1><fmt:message key="message" /><fmt:message key="${openGesloten}" /> </h1>
	<img src="/images/${openGesloten}<fmt:message key="img_suffix"/>.png" />
	<dl>
		<dt><fmt:message key="day"/> </dt>
		<dd>
			<fmt:formatDate type="date" dateStyle="long" value="${nu}" />
		</dd>
	</dl>
	<dt><fmt:message key="countMsg"/> </dt>
	<dd><fmt:formatNumber value='${aantalFrietenVerkocht}'/></dd>
</body>
</html>