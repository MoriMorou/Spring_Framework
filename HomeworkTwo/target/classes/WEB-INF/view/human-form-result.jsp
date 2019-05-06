<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>
<h1>Human Form Result</h1>
<br>
First name: ${human.firstName}
<br>
Last name: ${human.lastName}
<br>
Sex: ${human.sex}
<br>
Education:
<br>
<ul>
    <c:forEach var="item" items="${human.education}">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>