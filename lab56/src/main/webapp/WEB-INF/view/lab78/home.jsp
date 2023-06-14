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

<c:set var="page" value="${not empty param.stt ? param.stt : 0}"/>
<jsp:include page="navbar.jsp"></jsp:include>
<div style="width: 100vw; height: 100vh" class="row">
    <div class="col-6 offset-3">
        <h2>hs</h2>
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
        <div>
            <form method="get" id="myForm" action="/lab78">
                <div>
                    <label for="searchInput">search by name</label>
                    <input type="hidden" id="page" name="stt" value="${pagex.getNumber()}"/>
                    <c:if test="${not param.keyword}">
                        <input type="text" id="searchInput" name="keyword" onkeyup="updateAction()"/>
                    </c:if>
                    <c:if test="${param.keyword}">
                        <input type="text" id="searchInput" value="${param.keyword}" name="keyword"
                               onkeyup="updateAction()"/>
                    </c:if>
                </div>
                <input type="submit" value="search">
            </form>

        </div>
        <p>found ${pagex.getTotalElements()}</p>
        <c:if test="${not (pagex.getTotalElements() == 0)}">
            <table class="table">
                <tr>
                    <th scope="col">ma</th>
                    <th scope="col">ten</th>
                    <th scope="col">lop</th>
                    <th scope="col">tbm</th>
                    <th scope="col">hanh kiem</th>
                </tr>
                <c:forEach items="${pagex.getContent()}" var="hs">

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
                            <c:when test="${hs.hanhkiem == 3}">
                                <td>gioi</td>
                            </c:when>
                        </c:choose>
                        <td><a href="/lab78/delete/${hs.ma}">delete</a></td>
                    </tr>

                </c:forEach>

            </table>
            <div style="display: flex; gap: 12px">
                <c:if test="${pagex.getNumber() + 1 > 1}">
                    <a href="/lab78?&stt=${page - 1}${not empty param.keyword ? '&keyword='+param.keyword : ""}">
                        <button class="btn-primary">previous</button>
                    </a>
                </c:if>
                <c:if test="${pagex.getNumber() + 1 <= 1}">
                    <a>
                        <button class="btn-primary">previous</button>
                    </a>
                </c:if>
                <span> ${pagex.getNumber() + 1} , ${pagex.getTotalPages()} </span>
                <c:if test="${pagex.getNumber() + 1 lt pagex.getTotalPages()}">
                    <a href="/lab78?&stt=${page + 1}${not empty param.keyword ? '&keyword='+param.keyword : ""}">
                        <button class="btn-primary">next</button>
                    </a>
                </c:if>
            </div>
        </c:if>

    </div>
</div>
