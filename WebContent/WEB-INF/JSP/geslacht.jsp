<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<!doctype html>
<html>
<head>
<title>Geslacht</title>
<style>
	body { 
		background-color: ${achtergrond};
		color: ${tekst};	
	}
</style>
</head>
<body>
<h1>Meisjes jongens</h1>
<form method='post'>
	<input type="submit" name="geslacht" value="meisjes" />
	<input type="submit" name="geslacht" value="jongens" />
</form>
</body>
</html>