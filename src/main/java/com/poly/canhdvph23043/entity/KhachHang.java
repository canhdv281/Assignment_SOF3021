package com.poly.canhdvph23043.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "KhachHang")
@Entity
public class KhachHang {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private String id;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Ten")
    private String ten;

    @NotBlank(message = "Không được để trống")
    @Column(name = "TenDem")
    private String tenDem;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Ho")
    private String ho;

    @NotNull(message = "Không được để trống")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @NotBlank(message = "Không được để trống")
    @Column(name = "Sdt")
    private String sdt;

    @NotBlank(message = "Không được để trống")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank(message = "Không được để trống")
    @Column(name = "ThanhPho")
    private String thanhPho;

    @NotBlank(message = "Không được để trống")
    @Column(name = "QuocGia")
    private String quocGia;

    @NotBlank(message = "Không được để trống")
    @Column(name = "MatKhau")
    private String matKhau;

}
