package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.CuaHang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CuaHangService {

    List<CuaHang> getAllCuaHang();

    Page<CuaHang> pageCuaHang(Integer pageNo, Integer pageSize);

    void addCuaHang(CuaHang cuaHang);

    void updateCuaHang(CuaHang cuaHang);

    void removeCuaHang(String id);

    CuaHang detailCuaHang(String id);

    Integer checkMa(String ma);

}
