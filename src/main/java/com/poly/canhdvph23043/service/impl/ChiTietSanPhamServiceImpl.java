package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.ChiTietSanPham;
import com.poly.canhdvph23043.repository.ChiTietSanPhamRepository;
import com.poly.canhdvph23043.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public Page<ChiTietSanPham> pageChiTietSanPham(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ChiTietSanPham> pageChiTietSanPham = this.chiTietSanPhamRepository.findAll(pageable);
        return pageChiTietSanPham;
    }

    @Override
    public void addChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void updateChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void removeChiTietSanPham(String id) {
        this.chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public ChiTietSanPham detailChiTietSanPham(String id) {
        Optional<ChiTietSanPham> chiTietSanPham = this.chiTietSanPhamRepository.findById(id);
        if (chiTietSanPham.isPresent()) {
            return chiTietSanPham.get();
        } else {
            return null;
        }
    }

}
