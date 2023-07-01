package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.NhaSanXuat;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAllNhaSanXuat();

    Page<NhaSanXuat> pageNhaSanXuat(Integer pageNo, Integer pageSize);

    void addNhaSanXuat(NhaSanXuat nhaSanXuat);

    void updateNhaSanXuat(NhaSanXuat nhaSanXuat);

    void removeNhaSanXuat(String id);

    NhaSanXuat detailNhaSanXuat(String id);

    Integer checkMa(String ma);

}
