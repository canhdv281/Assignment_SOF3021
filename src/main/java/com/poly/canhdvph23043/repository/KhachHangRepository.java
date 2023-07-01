package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

    Boolean existsByMa(String ma);

}
