package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.NhanVien;
import com.poly.canhdvph23043.repository.NhanVienRepository;
import com.poly.canhdvph23043.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> pageNhanVien(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<NhanVien> page = this.nhanVienRepository.findAll(pageable);
        return page;
    }

    @Override
    public void addNhanVien(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
    }

    @Override
    public void updateNhanVien(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
    }

    @Override
    public void removeNhanVien(String id) {
        this.nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien detailNhanVien(String id) {
        Optional<NhanVien> optionalNhanVien = this.nhanVienRepository.findById(id);
        if (optionalNhanVien.isPresent()) {
            return optionalNhanVien.get();
        } else {
            return null;
        }
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.nhanVienRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

}
