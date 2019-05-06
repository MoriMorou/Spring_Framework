<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<body>
<form:form action="processForm" modelAttribute="humans">
    First Name: <form:input path="firstName" />
    <br>
    Last Name: <form:input path="lastName" />
    <br>
    Sex:
    <form:select path="sex">
        <form:option value="Male" label="Male" />
        <form:option value="Female" label="Female" />
    </form:select>
    <br>
    Education:
    <br>
    MBA or other <form:checkbox path="education" value="MBA and other" />
    University  <form:checkbox path="education" value="University" />
    Сollege <form:checkbox path="education" value="Сollege" />
    School <form:checkbox path="education" value="School" />
    <br>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>