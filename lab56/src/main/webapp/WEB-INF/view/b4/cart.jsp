<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div style="display: block;gap: 5px">
    <c:forEach items="${list}" var="pro">
        <div style="display: flex;gap: 5px">
            <p>pro id: ${pro.key.proid}</p>
            <p>pro name: ${pro.key.name}</p>
            <p></p>
            <p>quantity: ${pro.value}</p>
            <a href="/b4/cart/remove/${pro.key.proid}"><p>remove</p></a>
        </div>
    </c:forEach>
</div>