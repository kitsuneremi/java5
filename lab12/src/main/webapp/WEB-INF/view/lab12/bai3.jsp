<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<form action="" method="post">
    <input type="text" name="namex" placeholder="name"/>
    <input type="radio" name="gender" value="0" id="male"/>
    <label for="male">male</label>
    <input type="radio" name="gender" value="1" id="female"/>
    <label for="female">female</label>
    <select name="d">
        <option value="1">C</option>
        <option value="2">java</option>
        <option value="3">web</option>
    </select>
    <input type="submit"/>
</form>