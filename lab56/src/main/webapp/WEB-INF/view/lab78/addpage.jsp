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
    <form action="/lab78/add" method="post" style="display: block; gap: 20px">
        <div style="margin-bottom: 20px">
            <label for="ma" style="width: 60px">ma</label>
            <input id="ma" name="ma"/>
        </div>
        <div style="margin-bottom: 20px">
            <label for="ten" style="width: 60px">ten</label>
            <input id="ten" name="ten"/>
        </div>
        <div style="margin-bottom: 20px">
            <label for="soluong" style="width: 60px">lop</label>
            <input id="soluong" name="lop"/>
        </div>
        <div style="margin-bottom: 20px">
            <label for="dongia" style="width: 60px">trung binh mon</label>
            <input id="dongia" name="tbm"/>
        </div>
        <div style="margin-bottom: 20px">
            <label for="hanhkiem">hanhkiem</label>
            <select id="hanhkiem" name="hanhkiem">
                <option value="0">yeu</option>
                <option value="1">trung binh</option>
                <option value="2">kha</option>
                <option value="3">gioi</option>
            </select>
        </div>
        <input type="submit"/>
    </form>
</div>
</body>