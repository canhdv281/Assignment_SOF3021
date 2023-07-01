<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%@include file="../layout/header.jsp" %>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold">UPDATE CHỨC VỤ</p>
        <form:form action="/chuc-vu/update/${ cv.id }" method="post" modelAttribute="cv">
            <div class="mb-3">
                <label class="form-label">Mã chức vụ</label>
                <form:input type="text" class="form-control" path="ma"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên chức vụ</label>
                <form:input type="text" class="form-control" path="ten"/>
            </div>
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn cập nhật không ?')">UPDATE</form:button>
        </form:form>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>