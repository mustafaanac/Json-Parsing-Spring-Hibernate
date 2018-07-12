<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

<title>Doviz Kurlari</title>
</head>
<body>

		<div>
			<center><h2>Doviz Kurlari</h2></center>
		</div>
		
		<script language="javascript">
		setTimeout(function() {
			window.location.reload(1);
		}, 10000);
	</script>
	
		<div>
			<table class="table table-striped">
				<tr>
					<th>dovizTuru</th>
					<th>dovizAlis</th>
					<th>dovizSatis</th>
				</tr>
					
					<c:forEach var = "tempKurlar" items="${kurlar}">
					
				<tr>
				
					<td>${tempKurlar.name }</td>	
					<td>${tempKurlar.buying }</td>
					<td>${tempKurlar.selling }</td>
				
				</tr>
				</c:forEach>
			</table>
		
		</div>

</body>
</html>