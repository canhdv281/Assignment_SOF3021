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
<body>
<%@include file="../layout/header.jsp" %>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold">QUẢN LÝ NHÂN VIÊN</p>
        <br>
        <form:form method="post" modelAttribute="nv" action="/nhan-vien/add">
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
                <form:option disabled="true" selected="true" value="">- Chọn chức vụ -</form:option>
                <c:forEach items="${ listChucVu }" var="cv">
                    <form:option value="${ cv.id }">${ cv.ten }</form:option>
                </c:forEach>
            </form:select>
            <span style="color:red;"><form:errors path="chucVu"/></span>
            <br>
            <label>Cửa hàng</label>
            <form:select class="form-select" path="cuaHang">
                <form:option disabled="true" selected="true" value="">- Chọn cửa hàng -</form:option>
                <c:forEach items="${ listCuaHang }" var="ch">
                    <form:option value="${ ch.id }">${ ch.ten }</form:option>
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
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không ?')">ADD</form:button>
        </form:form>
        <br>
    </div>
    <div class="col-3"></div>
</div>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <table class="table">
            <thead>
            <th>#</th>
            <th>Mã</th>
            <th>Họ và tên</th>
            <th>Giới tính</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Chức vụ</th>
            <th>Cửa hàng</th>
            <th>Trạng thái</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach items="${ listNhanVien.content }" var="nv" varStatus="stt">
                <c:set var="birthDate" value="${nv.ngaySinh}"/>
                <c:set var="year" value="${fn:substring(birthDate, 0, 4)}"/>
                <tr>
                    <td>${ stt.index + 1 }</td>
                    <td>${ nv.ma }</td>
                    <td>${ nv.ho } ${ nv.tenDem } ${ nv.ten }</td>
                    <td>${ nv.gioiTinh == "Nam" ? "Nam" : "Nữ" }</td>
                    <td>${ nv.ngaySinh }</td>
                    <td>${ nv.diaChi }</td>
                    <td>${ nv.sdt }</td>
                    <td>${ nv.chucVu.ten }</td>
                    <td>${ nv.cuaHang.ten }</td>
                    <td>${ nv.trangThai == 1 ? "Hoạt động" : "Không hoạt động" }</td>
                    <td>
                        <a href="/nhan-vien/detail/${ nv.id }" class="btn btn-warning">Detail</a>
                        <a href="/nhan-vien/view-update/${ nv.id }" class="btn btn-success">Update</a>
                        <a href="/nhan-vien/remove/${ nv.id }" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="1" end="${ listNhanVien.totalPages }" var="page">
                    <li class="page-item"><a class="page-link"
                                             href="/nhan-vien/hien-thi?page=${ page }">${ page }</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <div class="col-1"></div>
</div>
</body>
</html>