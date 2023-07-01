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
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold">UPDATE NHÂN VIÊN</p>
        <form:form method="post" modelAttribute="nhanVien" action="/nhan-vien/update/${ nhanVien.id }">
            <div class="mb-3">
                <label class="form-label">Mã</label>
                <form:input type="text" class="form-control" path="ma"/>
                <span style="color:red;"><form:errors path="ma"/></span>
                <span style="color:red;">${ errorMa }</span>
            </div>
            <div class="mb-3">
                <label class="form-label">Họ</label>
                <form:input type="text" class="form-control" path="ho"/>
                <span style="color:red;"><form:errors path="ho"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên đệm</label>
                <form:input type="text" class="form-control" path="tenDem"/>
                <span style="color:red;"><form:errors path="tenDem"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên</label>
                <form:input type="text" class="form-control" path="ten"/>
                <span style="color:red;"><form:errors path="ten"/></span>
            </div>
            <br>
            <label>Giới tính</label>
            <br>
            <br>
            <form:radiobutton path="gioiTinh" value="Nam" checked="true"/>Nam
            <form:radiobutton path="gioiTinh" value="Nữ"/>Nữ
            <br>
            <br>
            <div class="mb-3">
                <label class="form-label">Ngày sinh</label>
                <form:input type="date" class="form-control" path="ngaySinh"/>
                <span style="color:red;"><form:errors path="ngaySinh"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <form:input type="text" class="form-control" path="diaChi"/>
                <span style="color:red;"><form:errors path="diaChi"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <form:input type="number" class="form-control" path="sdt"/>
                <span style="color:red;"><form:errors path="sdt"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <form:input type="text" class="form-control" path="matKhau"/>
                <span style="color:red;"><form:errors path="matKhau"/></span>
            </div>
            <label>Chức vụ</label>
            <form:select class="form-select" path="chucVu">
                <c:forEach items="${ listChucVu }" var="chucVu">
                    <form:option value="${ chucVu.id }">${ chucVu.ten }</form:option>
                </c:forEach>
            </form:select>
            <span style="color:red;"><form:errors path="chucVu"/></span>
            <br>
            <label>Cửa hàng</label>
            <form:select class="form-select" path="cuaHang">
                <c:forEach items="${ listCuaHang }" var="cuaHang">
                    <form:option value="${ cuaHang.id }">${ cuaHang.ten }</form:option>
                </c:forEach>
            </form:select>
            <span style="color:red;"><form:errors path="cuaHang"/></span>
            <br>
            <label>Trạng thái</label>
            <br>
            <form:radiobutton path="trangThai" value="1" checked="true"/>Hoạt động
            <form:radiobutton path="trangThai" value="0"/>Không hoạt động
            <br>
            <br>
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn cập nhật không ?')">UPDATE</form:button>
        </form:form>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>