package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.NhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, String> {

    Boolean existsByMa(String ma);

}
