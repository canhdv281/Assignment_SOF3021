package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;

public interface ChiTietSanPhamService {

    Page<ChiTietSanPham> pageChiTietSanPham(Integer page);

    void addChiTietSanPham(ChiTietSanPham chiTietSanPham);

    void updateChiTietSanPham(ChiTietSanPham chiTietSanPham);

    void removeChiTietSanPham(String id);

    ChiTietSanPham detailChiTietSanPham(String id);

}
