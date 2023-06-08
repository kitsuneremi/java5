<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div style="display: block;gap: 5px">
    <c:forEach items="${list}" var="sv">
        <p>name: ${sv.name}</p>
        <p>tuoi: ${sv.tuoi}</p>
    </c:forEach>
</div>

