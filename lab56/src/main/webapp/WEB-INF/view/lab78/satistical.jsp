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
    <p>found ${list.size()}</p>
    <table class="table">
        <tr>
            <th scope="col">ma</th>
            <th scope="col">ten</th>
            <th scope="col">lop</th>
            <th scope="col">tbm</th>
            <th scope="col">hanh kiem</th>
        </tr>
        <c:forEach items="${list}" var="hs">

            <tr>
                <td>${hs.ma}</td>
                <td>${hs.ten}</td>
                <td>${hs.lop}</td>
                <td>${hs.tbm}</td>
                <c:choose>
                    <c:when test="${hs.hanhkiem == 0}">
                        <td>yeu</td>
                    </c:when>
                    <c:when test="${hs.hanhkiem == 1}">
                        <td>tb</td>
                    </c:when>
                    <c:when test="${hs.hanhkiem == 2}">
                        <td>kha</td>
                    </c:when>
                    <c:when test="${hs.hanhkiem == 2}">
                        <td>gioi</td>
                    </c:when>
                </c:choose>
                <td><a href="/lab78/delete/${hs.ma}">delete</a></td>
            </tr>

        </c:forEach>

    </table>

</body>