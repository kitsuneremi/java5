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
<jsp:include page="navbar.jsp"></jsp:include>
<div class="col-6 offset-3">
    <p>detail bill</p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">name</th>
            <th scope="col">quantity</th>
            <th scope="col">price</th>
            <th scope="col">total</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="hdct">
            <tr>
                <th scope="row">${hdct.getRau().ten}</th>
                <td>${hdct.soluong}</td>
                <td>${hdct.getRau().dongia}</td>
                <td>${hdct.getRau().dongia * hdct.soluong}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>