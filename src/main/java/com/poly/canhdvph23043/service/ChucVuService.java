package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.ChucVu;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChucVuService {

    List<ChucVu> getAllChucVu();

    Page<ChucVu> pageChucVu(Integer pageNo, Integer pageSize);

    void addChucVu(ChucVu chucVu);

    void updateChucVu(ChucVu chucVu);

    void removeChucVu(String id);

    ChucVu detailChucVu(String id);

    Integer checkMa(String ma);

}
