package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.DongSanPham;
import com.poly.canhdvph23043.repository.DongSanPhamRepository;
import com.poly.canhdvph23043.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSanPham> getAllDongSanPham() {
        return this.dongSanPhamRepository.findAll();
    }

    @Override
    public void addDongSanPham(DongSanPham dongSanPham) {
        this.dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void updateDongSanPham(DongSanPham dongSanPham) {
        this.dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void removeDongSanPham(String id) {
        this.dongSanPhamRepository.deleteById(id);
    }

    @Override
    public DongSanPham detailDongSanPham(String id) {
        Optional<DongSanPham> dongSanPham = this.dongSanPhamRepository.findById(id);
        if (dongSanPham.isPresent()) {
            return dongSanPham.get();
        } else {
            return null;
        }
    }

    @Override
    public Page<DongSanPham> pageDongSanPham(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DongSanPham> page = this.dongSanPhamRepository.findAll(pageable);
        return page;
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.dongSanPhamRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

}
