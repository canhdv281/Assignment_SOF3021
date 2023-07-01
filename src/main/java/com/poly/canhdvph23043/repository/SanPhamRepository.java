package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, String> {

    Boolean existsByMa(String ma);

}
