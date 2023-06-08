<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<form action="" method="post">

</form>

<div style="display: block;gap: 5px">
    <c:forEach items="${list}" var="gv">
        <div style="display: flex;gap: 9px">
            <p>id: ${gv.id}</p>
            <p>ten: ${gv.name}</p>
            <p>tuoi: ${2023 - gv.namSinh}</p>
        </div>
    </c:forEach>
</div>