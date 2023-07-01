package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.CuaHang;
import com.poly.canhdvph23043.repository.CuaHangRepository;
import com.poly.canhdvph23043.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuaHangServiceImpl implements CuaHangService {

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getAllCuaHang() {
        return this.cuaHangRepository.findAll();
    }

    @Override
    public Page<CuaHang> pageCuaHang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<CuaHang> page = this.cuaHangRepository.findAll(pageable);
        return page;
    }

    @Override
    public void addCuaHang(CuaHang cuaHang) {
        this.cuaHangRepository.save(cuaHang);
    }

    @Override
    public void updateCuaHang(CuaHang cuaHang) {
        this.cuaHangRepository.save(cuaHang);
    }

    @Override
    public void removeCuaHang(String id) {
        this.cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHang detailCuaHang(String id) {
        Optional<CuaHang> cuaHang = this.cuaHangRepository.findById(id);
        if (cuaHang.isPresent()) {
            return cuaHang.get();
        } else {
            return null;
        }
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.cuaHangRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

}
