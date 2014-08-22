<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find user</title>
</head>
<body>

<h2>Find user</h2>
<form:form method="post" action="search.html" modelAttribute="user">

<table>

    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input type="text" path="name" /><span style="color:red"> ${errorMsg1}</span></td>
    </tr>
    
    <tr>
        <td><form:label path="nick">Nick</form:label></td>
        <td><form:input type="text" path="nick" /><span style="color:red"> ${errorMsg2}</span></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="Search"/>
        </td>
    </tr>
</table>
</form:form>

</body>
</html>