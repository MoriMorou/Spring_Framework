<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<form:form action="processForm" modelAttribute="SumOfNumbers">
    First Name: <form:input path="A: " />
    <br>
    Last Name: <form:input path="B: " />
    <br>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>