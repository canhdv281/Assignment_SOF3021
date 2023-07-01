<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Dòng SP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%@include file="../layout/header.jsp" %>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold">QUẢN LÝ DÒNG SẢN PHẨM</p>
        <form:form action="/dong-san-pham/add" method="post" modelAttribute="dongSanPham">
            <div class="mb-3">
                <label class="form-label">Mã dòng sản phẩm</label>
                <form:input type="text" class="form-control" path="ma"/>
                <form:errors path="ma" cssStyle="color: red" />
                <span style="color: red">${ errorMa }</span>
            </div>
            <div class="mb-3">
                <label class="form-label">Tên dòng sản phẩm</label>
                <form:input type="text" class="form-control" path="ten"/>
                <form:errors path="ten" cssStyle="color: red" />
            </div>
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không ?')">ADD</form:button>
        </form:form>
    </div>
    <div class="col-3"></div>
</div>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <table class="table">
            <thead>
            <th>#</th>
            <th>Mã</th>
            <th>Tên dòng sản phẩm</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach items="${ listDongSanPham.content }" varStatus="status" var="dongSanPham">
                <tr>
                    <td>${ status.index + 1 }</td>
                    <td>${ dongSanPham.ma }</td>
                    <td>${ dongSanPham.ten }</td>
                    <td>
                        <a href="/dong-san-pham/detail/${ dongSanPham.id }" class="btn btn-warning">Detail</a>
                        <a href="/dong-san-pham/view-update/${ dongSanPham.id }" class="btn btn-success">Update</a>
                        <a href="/dong-san-pham/remove/${ dongSanPham.id }" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="0" end="${ listDongSanPham.totalPages - 1}" var="page">
                    <li class="page-item"><a class="page-link" href="/dong-san-pham/hien-thi?page=${ page }">${ page + 1 }</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>