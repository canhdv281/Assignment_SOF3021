package com.poly.canhdvph23043.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ChiTietSP")
@Entity
public class ChiTietSanPham {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private String id;

    @NotNull(message = "Không được bỏ trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private SanPham sanPham;

    @NotNull(message = "Không được bỏ trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id")
    private NhaSanXuat nhaSanXuat;

    @NotNull(message = "Không được bỏ trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;

    @NotNull(message = "Không được bỏ trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private DongSanPham dongSanPham;

    @NotNull(message = "Không được bỏ trống")
    @Column(name = "NamBH")
    private Integer namBH;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "MoTa")
    private String moTa;

    @NotNull(message = "Không được bỏ trống")
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @NotNull(message = "Không được bỏ trống")
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @NotNull(message = "Không được bỏ trống")
    @Column(name = "GiaBan")
    private BigDecimal giaBan;

}
