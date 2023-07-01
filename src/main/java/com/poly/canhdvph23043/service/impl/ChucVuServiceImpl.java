package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.ChucVu;
import com.poly.canhdvph23043.repository.ChucVuRepository;
import com.poly.canhdvph23043.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAllChucVu() {
        return this.chucVuRepository.findAll();
    }

    @Override
    public Page<ChucVu> pageChucVu(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ChucVu> page = this.chucVuRepository.findAll(pageable);
        return page;
    }

    @Override
    public void addChucVu(ChucVu chucVu) {
        this.chucVuRepository.save(chucVu);
    }

    @Override
    public void updateChucVu(ChucVu chucVu) {
        this.chucVuRepository.save(chucVu);
    }

    @Override
    public void removeChucVu(String id) {
        this.chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVu detailChucVu(String id) {
        Optional<ChucVu> chucVu = this.chucVuRepository.findById(id);
        if (chucVu.isPresent()) {
            return chucVu.get();
        } else {
            return null;
        }
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.chucVuRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

}
