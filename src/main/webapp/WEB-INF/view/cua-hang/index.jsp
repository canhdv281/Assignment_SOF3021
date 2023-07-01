<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>NSX</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%@include file="../layout/header.jsp" %>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold">QUẢN LÝ CỬA HÀNG</p>
        <form:form action="/cua-hang/add" method="post" modelAttribute="ch">
            <div class="mb-3">
                <label class="form-label">Mã cửa hàng</label>
                <form:input type="text" class="form-control" path="ma"/>
                <form:errors path="ma" cssStyle="color: red" />
                <span style="color: red">${ errorMa }</span>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên cửa hàng</label>
                <form:input type="text" class="form-control" path="ten"/>
                <form:errors path="ten" cssStyle="color: red" />
            </div>
            <div class="mb-3">
                <label class="form-label">Địa chỉ</label>
                <form:input type="text" class="form-control" path="diaChi"/>
                <form:errors path="diaChi" cssStyle="color: red" />
            </div>
            <div class="mb-3">
                <label class="form-label">Thành phố</label>
                <form:input type="text" class="form-control" path="thanhPho"/>
                <form:errors path="thanhPho" cssStyle="color: red" />
            </div>
            <div class="mb-3">
                <label class="form-label">Quốc gia</label>
                <form:input type="text" class="form-control" path="quocGia"/>
                <form:errors path="quocGia" cssStyle="color: red" />
            </div>
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không ?')">ADD</form:button>
        </form:form>
    </div>
    <div class="col-3"></div>
</div>
<div class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <table class="table">
            <thead>
            <th>#</th>
            <th>Mã</th>
            <th>Tên cửa hàng</th>
            <th>Địa chỉ</th>
            <th>Thành phố</th>
            <th>Quốc gia</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach items="${ listCuaHang.content }" varStatus="status" var="ch">
                <tr>
                    <td>${ status.index + 1 }</td>
                    <td>${ ch.ma }</td>
                    <td>${ ch.ten }</td>
                    <td>${ ch.diaChi }</td>
                    <td>${ ch.thanhPho }</td>
                    <td>${ ch.quocGia }</td>
                    <td>
                        <a href="/cua-hang/detail/${ ch.id }" class="btn btn-warning">Detail</a>
                        <a href="/cua-hang/view-update/${ ch.id }" class="btn btn-success">Update</a>
                        <a href="/cua-hang/remove/${ ch.id }" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="1" end="${ listCuaHang.totalPages }" var="page">
                    <li class="page-item"><a class="page-link"
                                             href="/cua-hang/hien-thi?page=${ page }">${ page }</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <div class="col-2"></div>
</div>
</body>
</html>