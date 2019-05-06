<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<%--@elvariable id="SumOfNumbers" type="SumOfNumbers"--%>
<form:form action="processForm" modelAttribute="SumOfNumbers">
    First Name: <form:input path="A: " />
    <br>
    Last Name: <form:input path="B: " />
    <br>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>