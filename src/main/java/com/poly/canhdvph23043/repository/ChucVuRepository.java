package com.poly.canhdvph23043.repository;

import com.poly.canhdvph23043.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, String> {

    Boolean existsByMa(String ma);

}
