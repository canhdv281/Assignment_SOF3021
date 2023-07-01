package com.poly.canhdvph23043.service;

import com.poly.canhdvph23043.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauSacService {

    List<MauSac> getAllMauSac();

    void addMauSac(MauSac mauSac);

    void updateMauSac(MauSac mauSac);

    void removeMauSac(String id);

    MauSac detailMauSac(String id);

    Integer checkMa(String ma);

    Page<MauSac> pageMauSac(Integer pageNo, Integer pageSize);

}
