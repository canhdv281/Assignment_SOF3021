package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, String> {

    Boolean existsByMa(String ma);

}
