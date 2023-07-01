package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAllSanPham();

    Page<SanPham> pageSanPham(Integer pageNo, Integer pageSize);

    void addSanPham(SanPham sanPham);

    void updateSanPham(SanPham sanPham);

    void removeSanPham(String id);

    SanPham detailSanPham(String id);

    Integer checkMa(String ma);

}
