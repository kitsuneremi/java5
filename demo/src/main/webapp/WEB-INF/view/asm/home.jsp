<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="page" value="${not empty param.stt ? param.stt : 1}"/>
<div style="width: 100vw; height: 100vh; padding-left: 35vw; font-size: 1.4rem">
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
            <input id="andc" name="ansong" type="radio" checked aria-selected="true"/>
            <label for="koandc">ko dc</label>
            <input id="koandc" name="ansong" type="radio"/>
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
            <tr class="row">
                <th>ma</th>
                <th>ten</th>
                <th>so luong</th>
                <th>don gia</th>
                <th>an song</th>
                <th>phan loai</th>
            </tr>
            <c:forEach items="${pagex.getContent()}" var="sp">

                <tr class="row">
                    <td class="col"><a href="/asm/detail/${sp.ma}">${sp.ma}</a></td>
                    <td class="col">${sp.ten}</td>
                    <td class="col">${sp.soluong}</td>
                    <td class="col">${sp.dongia}</td>
                    <c:choose>
                        <c:when test="${sp.ansong == true}">
                            <td class="col">dc</td>
                        </c:when>
                        <c:when test="${sp.ansong == false}">
                            <td class="col">ko dc</td>
                        </c:when>
                    </c:choose>
                    <c:choose>
                        <c:when test="${sp.phanloai == 0}">
                            <td class="col">rau</td>
                        </c:when>
                        <c:when test="${sp.phanloai == 1}">
                            <td class="col">cu</td>
                        </c:when>
                        <c:when test="${sp.phanloai == 2}">
                            <td class="col">qua</td>
                        </c:when>
                    </c:choose>
                    <td><a href="/asm/delete/${sp.ma}">delete</a></td>
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

<style>
    .table {
        border: 1px solid black;
        gap: 0;
    }

    .row {
        width: max-content;

    }

    .col {
        width: max-content;
        border: 1px solid black;
        padding: 5px 10px;
    }
</style>