package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DongSanPhamRepository extends JpaRepository<DongSanPham, String> {

    Boolean existsByMa(String ma);

}
