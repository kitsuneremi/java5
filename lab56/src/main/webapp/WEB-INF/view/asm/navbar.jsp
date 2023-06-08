<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/asm">Home</a>
                <a class="nav-link" href="#">Features</a>
                <a class="nav-link" href="#">Pricing</a>
                <a class="nav-link disabled">Disabled</a>
            </div>
        </div>
        <div class="float-end" style="display: flex;gap: 5px">
            <a class="nav-link" href="/asm/cart">cart</a>

            <c:set var="matk" value="${sessionScope.matk}" />

            <c:choose>
                <c:when test="${not empty matk}">
                    <p>hello ${sessionScope.ten}</p>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="/asm/login">login</a>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</nav>