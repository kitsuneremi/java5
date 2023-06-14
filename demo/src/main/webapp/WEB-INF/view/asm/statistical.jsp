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
    <form action="/asm/statistical" method="get">
        <label>
            select date
            <input type="date" name="typeDate" />
        </label>
        <input type="submit" value="search"/>
    </form>
    <p>danh sach 10 rau ban chay nhat</p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ten</th>
            <th scope="col">an song</th>
            <th scope="col">phan loai</th>
            <th scope="col">don gia</th>
            <th scope="col">so luong da ban</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listRauBanChay}" var="rau">
            <tr>
                <th scope="row">${rau.ten}</th>
                <td>${rau.ansong}</td>
                <td>${rau.phanloai}</td>
                <td>${rau.dongia}</td>
                <td>${rau.tongluongban}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p class="mt-3">danh sach 10 rau khong ban duoc</p>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ten</th>
            <th scope="col">an song</th>
            <th scope="col">phan loai</th>
            <th scope="col">don gia</th>
            <th scope="col">so luong ton</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listRauKhongBanDuoc}" var="rau">
            <tr>
                <th scope="row">${rau.ten}</th>
                <c:choose>
                    <c:when test="${rau.ansong == true}">
                        <td>dc</td>
                    </c:when>
                    <c:when test="${rau.ansong == false}">
                        <td>khong dc</td>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${rau.phanloai == 0}">
                        <td>rau</td>
                    </c:when>
                    <c:when test="${rau.phanloai == 1}">
                        <td>cu</td>
                    </c:when>
                    <c:when test="${rau.phanloai == 2}">
                        <td>qua</td>
                    </c:when>
                </c:choose>
                <td>${rau.dongia}</td>
                <td>${rau.soluong}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>