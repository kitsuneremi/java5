<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="display: block;gap: 5px">
    <c:forEach items="${list}" var="pro">
        <div style="display: flex;gap: 5px">
            <p>${pro.productId}</p>
            <p>${pro.productName}</p>
            <p>${pro.quantity}</p>
            <p>${pro.price}</p>
        </div>
    </c:forEach>

</div>
