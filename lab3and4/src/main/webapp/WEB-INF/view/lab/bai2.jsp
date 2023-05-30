<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form action="/lab34/bai-2/add" method="post">
    <div>
        <label for="maloa">ma loa</label>
        <input id="maloa" name="maloa" />
    </div>
    <div>
        <label for="tenloa">ten loa</label>
        <input id="tenloa" name="tenloa"/>
    </div>
    <div>
        <label for="congsuat">cong suat</label>
        <input id="congsuat" name="congsuat"/>
    </div>
    <div>
        <label for="mausac">mau sac</label>
        <select id="mausac" name="mausac">
            <option value="0">xanh</option>
            <option value="1">do</option>
            <option value="2">tim</option>
            <option value="3">vang</option>
            <option value="4">cam</option>
        </select>
    </div>
    <div>
        <label for="kenhamthanh">kenh am thanh</label>
        <input name="kenhamthanh" id="kenhamthanh" />
    </div>
    <input type="submit" />
    <button type="submit" formaction="/lab34/bai-2/update">update</button>
</form>



<div style="gap: 7px; margin-bottom: 10px; min-width: 20vw; border: 1px solid black;">

    <c:forEach items="${list}" var="item">
        <div style="display: flex;justify-content: space-between" onclick="mouseClick(event)" value="${item}">
            <p>${item.maloa}</p>
            <p>${item.tenloa}</p>
            <p>${item.congsuat}W</p>
            <c:choose>
                <c:when test="${item.mausac == 0}">
                    <p>xanh</p>
                </c:when>
                <c:when test="${item.mausac == 1}">
                    <p>do</p>
                </c:when>
                <c:when test="${item.mausac == 2}">
                    <p>tim</p>
                </c:when>
                <c:when test="${item.mausac == 3}">
                    <p>vang</p>
                </c:when>
                <c:when test="${item.mausac == 4}">
                    <p>cam</p>
                </c:when>
            </c:choose>
            <p>${item.kenhamthanh}</p>
            <a href="/lab34/bai-2/delete/${item.maloa}"><button>delete</button></a>
        </div>
    </c:forEach>
</div>


<script>
    const mouseClick = (event) => {
        console.log(event.target.value)
        document.getElementById("tenloa").innerText = "a"
    }
</script>