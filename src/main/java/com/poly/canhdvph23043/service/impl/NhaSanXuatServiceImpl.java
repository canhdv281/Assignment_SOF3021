package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.NhaSanXuat;
import com.poly.canhdvph23043.repository.NhaSanXuatRepository;
import com.poly.canhdvph23043.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public List<NhaSanXuat> getAllNhaSanXuat() {
        return this.nhaSanXuatRepository.findAll();
    }

    @Override
    public Page<NhaSanXuat> pageNhaSanXuat(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<NhaSanXuat> page = this.nhaSanXuatRepository.findAll(pageable);
        return page;
    }

    @Override
    public void addNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void updateNhaSanXuat(NhaSanXuat nhaSanXuat) {
        this.nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void removeNhaSanXuat(String id) {
        this.nhaSanXuatRepository.deleteById(id);
    }

    @Override
    public NhaSanXuat detailNhaSanXuat(String id) {
        Optional<NhaSanXuat> NhaSanXuat = this.nhaSanXuatRepository.findById(id);
        if (NhaSanXuat.isPresent()) {
            return NhaSanXuat.get();
        } else {
            return null;
        }
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.nhaSanXuatRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

}
