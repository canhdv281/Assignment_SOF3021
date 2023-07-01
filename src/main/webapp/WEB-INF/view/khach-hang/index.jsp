<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Trang chủ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<%@include file="../layout/header.jsp" %>
<body>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold">QUẢN LÝ KHÁCH HÀNG</p>
        <br>
        <form:form method="post" modelAttribute="kh" action="/khach-hang/add">
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
            <div class="mb-3">
                <label class="form-label">Ngày sinh</label>
                <form:input type="date" class="form-control" path="ngaySinh"/>
                <span style="color:red;"><form:errors path="ngaySinh"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <form:input type="number" class="form-control" path="sdt"/>
                <span style="color:red;"><form:errors path="sdt"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <form:input type="text" class="form-control" path="diaChi"/>
                <span style="color:red;"><form:errors path="diaChi"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Thành phố</label>
                <form:input type="text" class="form-control" path="thanhPho"/>
                <span style="color:red;"><form:errors path="thanhPho"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Quốc gia</label>
                <form:input type="text" class="form-control" path="quocGia"/>
                <span style="color:red;"><form:errors path="quocGia"/></span>
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <form:input type="text" class="form-control" path="matKhau"/>
                <span style="color:red;"><form:errors path="matKhau"/></span>
            </div>
            <form:button type="submit" class="btn btn-primary"
                         onclick="return confirm('Bạn có muốn thêm không ?')">ADD</form:button>
        </form:form>
        <br>
    </div>
    <div class="col-3"></div>
</div>
<div class="row">
    <div class="col-12">
        <table class="table">
            <thead>
            <th>#</th>
            <th>Mã</th>
            <th>Họ và tên</th>
            <th>Ngày sinh</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach items="${ listKhachHang.content }" var="kh" varStatus="stt">
                <tr>
                    <td>${ stt.index + 1 }</td>
                    <td>${ kh.ma }</td>
                    <td>${ kh.ho } ${ kh.tenDem } ${ kh.ten }</td>
                    <td>${ kh.ngaySinh }</td>
                    <td>${ kh.sdt }</td>
                    <td>${ kh.diaChi }</td>
                    <td>${ kh.thanhPho }</td>
                    <td>${ kh.quocGia }</td>
                    <td>
                        <a href="/khach-hang/detail/${ kh.id }" class="btn btn-warning">Detail</a>
                        <a href="/khach-hang/view-update/${ kh.id }" class="btn btn-success">Update</a>
                        <a href="/khach-hang/remove/${ kh.id }" class="btn btn-danger"
                           onclick="return confirm('Bạn có muốn xóa không ?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="1" end="${ listKhachHang.totalPages }" var="page">
                    <li class="page-item"><a class="page-link"
                                             href="/khach-hang/hien-thi?page=${ page }">${ page }</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>