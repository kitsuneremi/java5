<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div style="display: block;gap: 5px">
    <c:forEach items="${list}" var="pro">
        <div style="display: flex;gap: 5px">
            <p>${pro.proid}</p>
            <p>${pro.name}</p>
            <p>${pro.quantity}</p>
            <p>${pro.price}</p>
            <a href="/b4/cart/add/${pro.proid}"><button>add to cart</button></a>
        </div>
    </c:forEach>
</div>