<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<body>
<div class="float-middle" style="padding: 70px 20vw">
    <form action="/asm/register" method="post">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">username</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="username">
        </div>
        <label for="email">email</label>
        <input type="email" class="form-control" id="email" name="email"/>
        <label for="inputPassword" class="form-label">Password</label>
        <input type="password" id="inputPassword" class="form-control" aria-labelledby="passwordHelpBlock" name="password">
        <button class="btn-primary mt-3">register</button>
    </form>
    <a href="/asm/login">have an account? login</a>
    <c:if test="${not message.equals('')}">
        <p class="text-danger">${message}</p>
    </c:if>
</div>
</body>