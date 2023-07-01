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
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold" >UPDATE CHI TIẾT SẢN PHẨM</p>
        <form:form action="/chi-tiet-san-pham/update/${ chiTietSanPham.id }" method="post" modelAttribute="chiTietSanPham">
            <label>Sản phẩm</label>
            <form:select class="form-select" path="sanPham">
                <c:forEach items="${ listSanPham }" var="sanPham">
                    <form:option value="${ sanPham.id }">${ sanPham.ten }</form:option>
                </c:forEach>
            </form:select>
            <br>
            <label>Nhà sản xuất</label>
            <form:select class="form-select" path="nhaSanXuat">
                <c:forEach items="${ listNhaSanXuat }" var="nhaSanXuat">
                    <form:option value="${ nhaSanXuat.id }">${ nhaSanXuat.ten }</form:option>
                </c:forEach>
            </form:select>
            <br>
            <label>Màu sắc</label>
            <form:select class="form-select" path="mauSac">
                <c:forEach items="${ listMauSac }" var="mauSac">
                    <form:option value="${ mauSac.id }">${ mauSac.ten }</form:option>
                </c:forEach>
            </form:select>
            <br>
            <label>Dòng sản phẩm</label>
            <form:select class="form-select" path="dongSanPham">
                <c:forEach items="${ listDongSanPham }" var="dongSanPham">
                    <form:option value="${ dongSanPham.id }">${ dongSanPham.ten }</form:option>
                </c:forEach>
            </form:select>
            <br>
            <div class="mb-3">
                <label class="form-label">Năm bảo hành</label>
                <form:input type="number" class="form-control" path="namBH"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Mô tả</label>
                <form:input type="text" class="form-control" path="moTa"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Số lượng tồn</label>
                <form:input type="number" class="form-control" path="soLuongTon"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Giá nhập</label>
                <form:input type="text" class="form-control" path="giaNhap"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Giá bán</label>
                <form:input type="text" class="form-control" path="giaBan"/>
            </div>
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn cập nhật không ?')">UPDATE</form:button>
        </form:form>
    </div>
    <div class="col-3"></div>
</div>
</body>
</html>
