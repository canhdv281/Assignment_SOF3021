package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, String> {

    Boolean existsByMa(String ma);

}
