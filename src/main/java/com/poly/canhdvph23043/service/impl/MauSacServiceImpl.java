package com.poly.canhdvph23043.service.impl;

import com.poly.canhdvph23043.entity.MauSac;
import com.poly.canhdvph23043.repository.MauSacRepository;
import com.poly.canhdvph23043.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAllMauSac() {
        return mauSacRepository.findAll();
    }

    @Override
    public void addMauSac(MauSac mauSac) {
        this.mauSacRepository.save(mauSac);
    }

    @Override
    public void updateMauSac(MauSac mauSac) {
        this.mauSacRepository.save(mauSac);
    }

    @Override
    public void removeMauSac(String id) {
        this.mauSacRepository.deleteById(id);
    }

    @Override
    public MauSac detailMauSac(String id) {
        Optional<MauSac> ms =  this.mauSacRepository.findById(id);
        if(ms.isPresent()) {
            return ms.get();
        } else {
            return null;
        }
    }

    @Override
    public Integer checkMa(String ma) {
        if (this.mauSacRepository.existsByMa(ma) == false) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Page<MauSac> pageMauSac(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<MauSac> page = this.mauSacRepository.findAll(pageable);
        return page;
    }
}
