<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chi Tiết Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%@include file="../layout/header.jsp" %>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6">
        <p class="fs-2" style="color: red; text-align: center; font-weight: bold" >QUẢN LÝ CHI TIẾT SẢN PHẨM</p>
        <form:form action="/chi-tiet-san-pham/add" method="post" modelAttribute="chiTietSanPham">
            <label>Sản phẩm</label>
            <form:select class="form-select" path="sanPham">
                <form:option selected="true" value="" disabled="true">- Chọn sản phẩm -</form:option>
                <c:forEach items="${ listSanPham }" var="sanPham">
                    <form:option value="${ sanPham.id }">${ sanPham.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="sanPham" cssStyle="color: red"/>
            <br>
            <label>Nhà sản xuất</label>
            <form:select class="form-select" path="nhaSanXuat">
                <form:option selected="true" value="" disabled="true">- Chọn nhà sản xuất -</form:option>
                <c:forEach items="${ listNhaSanXuat }" var="nhaSanXuat">
                    <form:option value="${ nhaSanXuat.id }">${ nhaSanXuat.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="nhaSanXuat" cssStyle="color: red"/>
            <br>
            <label>Màu sắc</label>
            <form:select class="form-select" path="mauSac">
                <form:option selected="true" value="" disabled="true">- Chọn màu sắc -</form:option>
                <c:forEach items="${ listMauSac }" var="ms">
                    <form:option value="${ ms.id }">${ ms.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="mauSac" cssStyle="color: red"/>
            <br>
            <label>Dòng sản phẩm</label>
            <form:select class="form-select" path="dongSanPham">
                <form:option selected="true" value="" disabled="true">- Chọn dòng sản phẩm -</form:option>
                <c:forEach items="${ listDongSanPham }" var="dongSanPham">
                    <form:option value="${ dongSanPham.id }">${ dongSanPham.ten }</form:option>
                </c:forEach>
            </form:select>
            <form:errors path="dongSanPham" cssStyle="color: red"/>
            <br>
            <div class="mb-3">
                <label class="form-label">Năm bảo hành</label>
                <form:input type="number" class="form-control" path="namBH"/>
                <form:errors path="namBH" cssStyle="color: red"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Mô tả</label>
                <form:input type="text" class="form-control" path="moTa"/>
                <form:errors path="moTa" cssStyle="color: red"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Số lượng tồn</label>
                <form:input type="number" class="form-control" path="soLuongTon"/>
                <form:errors path="soLuongTon" cssStyle="color: red"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Giá nhập</label>
                <form:input type="text" class="form-control" path="giaNhap"/>
                <form:errors path="giaNhap" cssStyle="color: red"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Giá bán</label>
                <form:input type="text" class="form-control" path="giaBan"/>
                <form:errors path="giaBan" cssStyle="color: red"/>
            </div>
            <form:button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn thêm không ?')">ADD</form:button>
        </form:form>
    </div>
    <div class="col-3"></div>
</div>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <table class="table">
            <thead>
            <th>#</th>
            <th>Sản phẩm</th>
            <th>Nhà sản xuất</th>
            <th>Màu sắc</th>
            <th>Dòng SP</th>
            <th>Năm BH</th>
            <th>Mô tả</th>
            <th>Số lượng tồn</th>
            <th>Giá nhập</th>
            <th>Giá bán</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach items="${ listChiTietSanPham.content }" var="chiTietSanPham" varStatus="status">
                <tr>
                    <td>${ status.index + 1 }</td>
                    <td>${ chiTietSanPham.sanPham.ten }</td>
                    <td>${ chiTietSanPham.nhaSanXuat.ten }</td>
                    <td>${ chiTietSanPham.mauSac.ten }</td>
                    <td>${ chiTietSanPham.dongSanPham.ten }</td>
                    <td>${ chiTietSanPham.namBH }</td>
                    <td>${ chiTietSanPham.moTa }</td>
                    <td>${ chiTietSanPham.soLuongTon }</td>
                    <td>${ chiTietSanPham.giaNhap }</td>
                    <td>${ chiTietSanPham.giaBan }</td>
                    <td>
                        <a href="/chi-tiet-san-pham/detail/${ chiTietSanPham.id }" class="btn btn-warning">Detail</a>
                        <a href="/chi-tiet-san-pham/view-update/${ chiTietSanPham.id }" class="btn btn-success">Update</a>
                        <a href="/chi-tiet-san-pham/remove/${ chiTietSanPham.id }" class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')">Remove</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="1" end="${ listChiTietSanPham.totalPages }" var="page">
                    <li class="page-item"><a class="page-link"
                                             href="/chi-tiet-san-pham/hien-thi?page=${ page }">${ page }</a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>
    <div class="col-1"></div>
</div>
</body>
</html>
