package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.KhachHang;
import com.poly.canhdvph23043.repository.KhachHangRepository;
import com.poly.canhdvph23043.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> pageKhachHang(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<KhachHang> pageKhachHang = this.khachHangRepository.findAll(pageable);
        return pageKhachHang;
    }

    @Override
    public void addKhachHang(KhachHang khachHang) {
        this.khachHangRepository.save(khachHang);
    }

    @Override
    public void updateKhachHang(KhachHang khachHang) {
        this.khachHangRepository.save(khachHang);
    }

    @Override
    public void removeKhachHang(String id) {
        this.khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang detailKhachHang(String id) {
        Optional<KhachHang> khachHang = this.khachHangRepository.findById(id);
        if (khachHang.isPresent()) {
            return khachHang.get();
        } else {
            return null;
        }
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.khachHangRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

}
