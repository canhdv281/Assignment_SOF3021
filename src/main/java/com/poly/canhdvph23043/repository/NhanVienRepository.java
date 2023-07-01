package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {

    Boolean existsByMa(String ma);

}
