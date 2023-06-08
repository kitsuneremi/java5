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
    <p>tong tien: ${tongtien}</p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ten sp</th>
            <th scope="col">an song</th>
            <th scope="col">phan loai</th>
            <th scope="col">don gia</th>
            <th scope="col">so luong</th>
            <th scope="col">thanh tien</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sp" items="${list}">
            <tr>
                <td>${sp.getRau().getTen()}</td>
                <c:choose>
                    <c:when test="${sp.getRau().ansong == true}">
                        <td>dc</td>
                    </c:when>
                    <c:when test="${sp.getRau().ansong == false}">
                        <td>ko dc</td>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${sp.getRau().phanloai == 0}">
                        <td>rau</td>
                    </c:when>
                    <c:when test="${sp.getRau().phanloai == 1}">
                        <td>cu</td>
                    </c:when>
                    <c:when test="${sp.getRau().phanloai == 2}">
                        <td>qua</td>
                    </c:when>
                </c:choose>
                <td><p id="dongia${sp.marau}">${sp.getRau().dongia}</p></td>
                <form method="post" action="/asm/cart/update">
                    <input type="hidden" value="${sp.marau}" name="marau"/>
                    <input type="hidden" value="${sp.mataikhoan}" name="mataikhoan"/>
                    <td><input id="soluong${sp.marau}" type="number" name="sl" min="1" value="${sp.soluong}"
                               onchange="handleChangePrice(${sp.marau})"/></td>
                    <td><p id="thanhtien${sp.marau}">${sp.getRau().dongia * sp.soluong}</p></td>
                    <td>
                        <button class="btn-primary" type="submit">update</button>
                    </td>
                </form>
                <td>
                    <form action="/asm/cart/delete" method="post">
                        <input type="hidden" value="${sp.marau}" name="marau"/>
                        <input type="hidden" value="${sp.mataikhoan}" name="mataikhoan"/>
                        <button class="btn-danger" type="submit">delete</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
<script>
    function handleChangePrice(marau) {
        let sl = Number.parseInt(document.getElementById('soluong' + marau).value)
        let price = Number.parseFloat(document.getElementById('dongia' + marau).innerText)
        document.getElementById('thanhtien' + marau).innerText = sl * price
    }
</script>