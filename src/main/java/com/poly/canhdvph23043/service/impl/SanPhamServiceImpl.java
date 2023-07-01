package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.SanPham;
import com.poly.canhdvph23043.repository.SanPhamRepository;
import com.poly.canhdvph23043.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAllSanPham() {
        return this.sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> pageSanPham(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<SanPham> page = this.sanPhamRepository.findAll(pageable);
        return page;
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        this.sanPhamRepository.save(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        this.sanPhamRepository.save(sanPham);
    }

    @Override
    public void removeSanPham(String id) {
        this.sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham detailSanPham(String id) {
        Optional<SanPham> sanPham = this.sanPhamRepository.findById(id);
        if (sanPham.isPresent()) {
            return sanPham.get();
        } else {
            return null;
        }
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.sanPhamRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

}
