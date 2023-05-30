<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="/lab34/bai-1/add" method="post">
    <label for="mamon">ma mon</label>
    <input id="mamon" name="mamon" />
    <label for="tenmon">ten mon</label>
    <input id="tenmon" name="tenmon"/>
    <label for="stc">stc</label>
    <input id="stc" name="sotinchi"/>
    <label for="chuyennganh">chuyen nganh</label>
    <select id="chuyennganh" name="chuyennganh">
        <option value="0">udpm</option>
        <option value="1">web</option>
        <option value="2">mobile</option>
        <option value="3">game</option>
    </select>
    <label for="cn1">minhdq28</label>
    <input id="cn1" type="checkbox" name="giangvien" value="0">
    <label for="cn2">dungna29</label>
    <input id="cn2" type="checkbox" name="giangvien" value="1">
    <label for="cn3">tiennh21</label>
    <input id="cn3" type="checkbox" name="giangvien" value="2">
    <label for="cn4">nguyenvv04</label>
    <input id="cn4" type="checkbox" name="giangvien" value="3">

    <p>bat buoc</p>
    <label for="bb0">co</label>
    <input id="bb0" type="radio" name="batbuoc" value="0">
    <label for="bb1">khong</label>
    <input id="bb1" type="radio" name="batbuoc" value="1">
    <input type="submit" />
</form>

<div style="display:flex; gap: 7px; margin-bottom: 10px; width: 20vw; border: 1px solid black"></div>
<c:forEach items="${list}" var="item">
    <p>${item.mamon}</p>
</c:forEach>
