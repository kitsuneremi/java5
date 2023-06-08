<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="width: 100vw; height: 100vh; padding-left: 45vw;">
    <div style="display: block; gap: 7px">
        <p>ma: ${rau.ma}</p>
        <p>ten: ${rau.ten}</p>
        <p>so luong: ${rau.soluong}</p>
        <p>dongia: ${rau.dongia}</p>
        <c:if test="${rau.ansong == true}">
            <p>an song dc</p>
        </c:if>
        <c:if test="${rau.ansong == false}">
            <p>ko an song dc</p>
        </c:if>
        <c:if test="${rau.phanloai == 0}">
            <p>phan loai: rau</p>
        </c:if>
        <c:if test="${rau.phanloai == 1}">
            <p>phan loai: cu</p>
        </c:if>
        <c:if test="${rau.phanloai == 2}">
            <p>phan loai: qua</p>
        </c:if>
    </div>
</div>