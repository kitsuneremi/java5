<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form action="/lab34/bai-1/add" method="post" style="gap: 4px">
    <div>
        <label for="mamon">ma mon</label>
        <input id="mamon" name="mamon" />
    </div>
    <div>
        <label for="tenmon">ten mon</label>
        <input id="tenmon" name="tenmon"/>
    </div>
    <div>
        <label for="stc">stc</label>
        <input id="stc" name="stc"/>
    </div>
    <div>
        <label for="chuyennganh">chuyen nganh</label>
        <select id="chuyennganh" name="chuyennganh">
            <option value="0">udpm</option>
            <option value="1">web</option>
            <option value="2">mobile</option>
            <option value="3">game</option>
        </select>
    </div>
    <div>
        <label for="cn1">minhdq28</label>
        <input id="cn1" type="checkbox" name="giangvien" value="0">
        <label for="cn2">dungna29</label>
        <input id="cn2" type="checkbox" name="giangvien" value="1">
        <label for="cn3">tiennh21</label>
        <input id="cn3" type="checkbox" name="giangvien" value="2">
        <label for="cn4">nguyenvv04</label>
        <input id="cn4" type="checkbox" name="giangvien" value="3">
    </div>
    <div>
        <p>bat buoc</p>
        <label for="bb0">co</label>
        <input id="bb0" type="radio" name="batbuoc" value="0">
        <label for="bb1">khong</label>
        <input id="bb1" type="radio" name="batbuoc" value="1">
    </div>
    <input type="submit" />
</form>

<div style="gap: 7px; margin-bottom: 10px; min-width: 20vw; border: 1px solid black;">
    <c:forEach items="${list}" var="item">
        <div style="display: flex;justify-content: space-between">
            <p>${item.mamon}</p>
            <p>${item.tenmon}</p>
            <p>${item.stc}</p>
            <c:choose>
                <c:when test="${item.chuyennganh == 0}">
                    <p>udpm</p>
                </c:when>
                <c:when test="${item.chuyennganh == 1}">
                    <p>ưeb</p>
                </c:when>
                <c:when test="${item.chuyennganh == 2}">
                    <p>mobile</p>
                </c:when>
                <c:when test="${item.chuyennganh == 3}">
                    <p>game</p>
                </c:when>
            </c:choose>
            <p>
            <c:forEach items="${item.giangvien}" var="value">
                <c:set var="result" value="" />
                <c:if test="${value eq 0}">
                    <c:set var="result" value="${result}minhdq28+" />
                </c:if>
                <c:if test="${value eq 1}">
                    <c:set var="result" value="${result}dungna29+" />
                </c:if>
                <c:if test="${value eq 2}">
                    <c:set var="result" value="${result}tiennh21+" />
                </c:if>
                <c:if test="${value eq 3}">
                    <c:set var="result" value="${result}nguyenvv04+" />
                </c:if>
                ${result}
            </c:forEach>
            </p>
            <c:choose>
                <c:when test="${item.batbuoc == true}">
                    <p>bat buoc</p>
                </c:when>
                <c:otherwise>
                    <p>ko bat buoc</p>
                </c:otherwise>
            </c:choose>
            <a href="/lab34/bai-1/delete/${item.mamon}"><button>delete</button></a>
        </div>

    </c:forEach>
</div>