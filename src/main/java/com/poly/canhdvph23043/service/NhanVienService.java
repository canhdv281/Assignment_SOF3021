package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.NhanVien;
import org.springframework.data.domain.Page;

public interface NhanVienService {

    Page<NhanVien> pageNhanVien(Integer pageNo, Integer pageSize);

    void addNhanVien(NhanVien nhanVien);

    void updateNhanVien(NhanVien nhanVien);

    void removeNhanVien(String id);

    NhanVien detailNhanVien(String id);

    Integer checkMa(String ma);

}
