<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold">UPDATE KHÁCH HÀNG</p>
        <form:form method="post" modelAttribute="kh" action="/khach-hang/update/${ kh.id }">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <form:input type="text" class="form-control" path="ma"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Họ</label>
                <form:input type="text" class="form-control" path="ho"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên đệm</label>
                <form:input type="text" class="form-control" path="tenDem"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <form:input type="text" class="form-control" path="ten"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Ngày sinh</label>
                <form:input type="date" class="form-control" path="ngaySinh"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <form:input type="number" class="form-control" path="sdt"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <form:input type="text" class="form-control" path="diaChi"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Thành phố</label>
                <form:input type="text" class="form-control" path="thanhPho"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Quốc gia</label>
                <form:input type="text" class="form-control" path="quocGia"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <form:input type="text" class="form-control" path="matKhau"/>
            </div>
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn cập nhật không ?')">UPDATE</form:button>
        </form:form>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>