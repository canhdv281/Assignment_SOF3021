package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.KhachHang;
import org.springframework.data.domain.Page;

public interface KhachHangService {

    Page<KhachHang> pageKhachHang(Integer page);

    void addKhachHang(KhachHang khachHang);

    void updateKhachHang(KhachHang khachHang);

    void removeKhachHang(String id);

    KhachHang detailKhachHang(String id);

    Integer checkMa(String ma);

}
