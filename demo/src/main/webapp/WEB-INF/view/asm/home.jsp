<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
<head>
    <meta charset="UTF-8">
</head>
<c:set var="page" value="${not empty param.stt ? param.stt : 1}"/>
<jsp:include page="navbar.jsp"></jsp:include>
<div style="width: 100vw; height: 100vh" class="row">
    <div class="col-6 offset-3">
        <h2>rau</h2>
        <form action="/asm/add" method="post" style="display: block; gap: 20px">
            <div style="margin-bottom: 20px">
                <label for="ma" style="width: 60px">ma</label>
                <input id="ma" name="ma"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="ten" style="width: 60px">ten</label>
                <input id="ten" name="ten"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="soluong" style="width: 60px">so luong</label>
                <input id="soluong" name="soluong"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="dongia" style="width: 60px">dongia</label>
                <input id="dongia" name="dongia"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="andc">duoc</label>
                <input id="andc" name="ansong" type="radio" checked aria-selected="true" value="0"/>
                <label for="koandc">ko dc</label>
                <input id="koandc" name="ansong" type="radio" value="1"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="phanloai">phan loai</label>
                <select id="phanloai" name="phanloai">
                    <option value="0">rau</option>
                    <option value="1">cu</option>
                    <option value="2">qua</option>
                </select>
            </div>
            <input type="submit"/>
        </form>
        <div>
            <form method="get" id="myForm" action="/asm">
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
                <div>
                    <label for="min">min</label>
                    <input id="min" name="min"/>
                    <label for="max">max</label>
                    <input id="max" name="max"/>
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
                    <th scope="col">so luong</th>
                    <th scope="col">don gia</th>
                    <th scope="col">an song</th>
                    <th scope="col">phan loai</th>
                </tr>
                <c:forEach items="${pagex.getContent()}" var="sp">

                    <tr>
                        <td><a href="/asm/detail/${sp.ma}">${sp.ma}</a></td>
                        <td>${sp.ten}</td>
                        <td>${sp.soluong}</td>
                        <td>${sp.dongia}</td>
                        <c:choose>
                            <c:when test="${sp.ansong == true}">
                                <td>dc</td>
                            </c:when>
                            <c:when test="${sp.ansong == false}">
                                <td>ko dc</td>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test="${sp.phanloai == 0}">
                                <td>rau</td>
                            </c:when>
                            <c:when test="${sp.phanloai == 1}">
                                <td>cu</td>
                            </c:when>
                            <c:when test="${sp.phanloai == 2}">
                                <td>qua</td>
                            </c:when>
                        </c:choose>
                        <td><a href="/asm/delete/${sp.ma}">delete</a></td>
                        <td><a href="/asm/addcart?marau=${sp.ma}&sl=${1}">add to cart</a></td>
                    </tr>

                </c:forEach>

            </table>
            <div style="display: flex">
                <c:if test="${pagex.getNumber() + 1 > 1}">
                    <a href="${pageContext.request.contextPath}/asm?&stt=${page - 1}${not empty param.keyword ? '&keyword='+param.keyword : ""}">
                        <button>previous</button>
                    </a>
                </c:if>
                <span> ${pagex.getNumber() + 1} / ${pagex.getTotalPages()} </span>
                <c:if test="${pagex.getNumber() + 1 lt pagex.getTotalPages()}">
                    <a href="${pageContext.request.contextPath}/asm?&stt=${page + 1}${not empty param.keyword ? '&keyword='+param.keyword : ""}">
                        <button>next</button>
                    </a>
                </c:if>
            </div>
        </c:if>

    </div>
</div>
<%--<script>--%>
<%--    function updateAction() {--%>
<%--        var form = document.getElementById("myForm");--%>
<%--        var page = document.getElementById("page").value;--%>
<%--        var keyword = document.getElementById("searchInput").value;--%>
<%--        var min = document.getElementById("min").value;--%>
<%--        var max = document.getElementById("max").value;--%>
<%--        form.action = "${pageContext.request.contextPath}/asm?stt=" + page + "&keyword=" + encodeURIComponent(keyword) + min !== "0" ? ("&min=" + min) : "" + max !== "0" ? ("&max=" + max) : "";--%>
<%--    }--%>
<%--</script>--%>
