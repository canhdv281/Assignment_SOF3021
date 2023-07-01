package com.poly.canhdvph23043.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "DongSP")
@Entity
public class DongSanPham {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id", columnDefinition = "uniqueidentifier")
    private String id;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Không được bỏ trống")
    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "dongSanPham", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listChiTietSanPham;

}
