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

<div style="width: 100vw; height: 100vh" class="row">
    <div class="col-6 offset-3">
        <h2>Tivi</h2>
        <form action="/lab56/add" method="post" style="display: block; gap: 20px">
            <div style="margin-bottom: 20px">
                <label for="ma" style="width: 60px">ma</label>
                <input id="ma" name="ma"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="ten" style="width: 60px">ten</label>
                <input id="ten" name="ten"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="nsx" style="width: 60px">nsx</label>
                <input id="nsx" name="nsx"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="kichco" style="width: 60px">kichco</label>
                <input id="kichco" name="kichco"/>
            </div>
            <div style="margin-bottom: 20px">
                <label for="dpg" style="width: 60px">do phan giai</label>
                <input id="dpg" name="dpg"/>
            </div>
            <input type="submit"/>
        </form>
        <div>
            <form method="get" action="/lab56">
                <div>
                    <label for="searchInput">search by name</label>
<%--                    <input type="hidden" id="page" name="stt" value="${pagex.getNumber()}"/>--%>
<%--                    <c:if test="${not param.keyword}">--%>
<%--                        <input type="text" id="searchInput" name="keyword"/>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${param.keyword}">--%>
<%--                        <input type="text" id="searchInput" value="${param.keyword}" name="keyword"/>--%>
<%--                    </c:if>--%>
                    <input type="text" id="searchInput" name="keyword"/>
                </div>
                <input type="submit" value="search">
            </form>
        </div>
        <p>found ${pagex.getTotalElements()}</p>
        <c:if test="${not (pagex.getTotalElements() == 0)}">
            <table class="table">
                <tr class="row">
                    <th scope="col" class="col">ma</th>
                    <th scope="col"  class="col">ten</th>
                    <th scope="col" class="col">nsx</th>
                    <th scope="col" class="col">kich co</th>
                    <th scope="col" class="col">dpg</th>
                    <th scope="col" class="col"></th>
                    <th scope="col" class="col"></th>
                </tr>
                <c:forEach items="${pagex.getContent()}" var="sp">

                    <tr class="row">
                        <td class="col">${sp.id}</td>
                        <td class="col">${sp.ten}</td>
                        <td class="col">${sp.nsx}</td>
                        <td class="col">${sp.kichco}</td>
                        <td class="col">${sp.dophangiai}</td>
                        <td><a href="/lab56/delete/${sp.id}">delete</a></td>
                    </tr>

                </c:forEach>

            </table>
            <div style="display: flex">
                <c:if test="${pagex.getNumber() + 1 > 1}">
                    <a href="${pageContext.request.contextPath}/lab56?stt=${page - 1}${not empty param.keyword ? '&keyword='+param.keyword : ""}">
                        <button>previous</button>
                    </a>
                </c:if>
                <span> ${pagex.getNumber() + 1} / ${pagex.getTotalPages()} </span>
                <c:if test="${pagex.getNumber() + 1 lt pagex.getTotalPages()}">
                    <a href="${pageContext.request.contextPath}/lab56?stt=${page}${not empty param.keyword ? '&keyword='+param.keyword : ""}">
                        <button>next</button>
                    </a>
                </c:if>
            </div>
        </c:if>

    </div>
</div>
