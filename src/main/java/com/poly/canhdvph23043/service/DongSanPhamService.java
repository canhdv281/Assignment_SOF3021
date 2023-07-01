package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.DongSanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DongSanPhamService {

    List<DongSanPham> getAllDongSanPham();

    void addDongSanPham(DongSanPham DongSanPham);

    void updateDongSanPham(DongSanPham DongSanPham);

    void removeDongSanPham(String id);

    DongSanPham detailDongSanPham(String id);

    Page<DongSanPham> pageDongSanPham(Integer pageNo, Integer pageSize);

    Integer checkMa(String ma);

}
