package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.ChiTietSanPham;
import com.poly.canhdvph23043.entity.DongSanPham;
import com.poly.canhdvph23043.entity.MauSac;
import com.poly.canhdvph23043.entity.NhaSanXuat;
import com.poly.canhdvph23043.entity.SanPham;
import com.poly.canhdvph23043.service.ChiTietSanPhamService;
import com.poly.canhdvph23043.service.DongSanPhamService;
import com.poly.canhdvph23043.service.MauSacService;
import com.poly.canhdvph23043.service.NhaSanXuatService;
import com.poly.canhdvph23043.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("chi-tiet-san-pham")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("hien-thi")
    public String hienThiChiTietSanPham(@RequestParam(name = "page", defaultValue = "1") Integer page, Model model){
        Page<ChiTietSanPham> pageChiTietSanPham = this.chiTietSanPhamService.pageChiTietSanPham(page - 1);
        model.addAttribute("listChiTietSanPham", pageChiTietSanPham);
        model.addAttribute("chiTietSanPham", new ChiTietSanPham());
        List<SanPham> listSP = this.sanPhamService.getAllSanPham();
        model.addAttribute("listSanPham", listSP);
        List<NhaSanXuat> listNhaSanXuats = this.nhaSanXuatService.getAllNhaSanXuat();
        model.addAttribute("listNhaSanXuat", listNhaSanXuats);
        List<MauSac> listMauSac = this.mauSacService.getAllMauSac();
        model.addAttribute("listMauSac", listMauSac);
        List<DongSanPham> listDongSanPham = this.dongSanPhamService.getAllDongSanPham();
        model.addAttribute("listDongSanPham", listDongSanPham);
        return "chi-tiet-san-pham/index";
    }

    @GetMapping("detail/{id}")
    public String detailChiTietSanPham(@PathVariable(name = "id") String id, Model model) {
        ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.detailChiTietSanPham(id);
        model.addAttribute("chiTietSanPham", chiTietSanPham);
        Page<ChiTietSanPham> pageChiTietSanPham = this.chiTietSanPhamService.pageChiTietSanPham(0);
        model.addAttribute("listChiTietSanPham", pageChiTietSanPham);
        List<SanPham> listSP = this.sanPhamService.getAllSanPham();
        model.addAttribute("listSanPham", listSP);
        List<NhaSanXuat> listNhaSanXuats = this.nhaSanXuatService.getAllNhaSanXuat();
        model.addAttribute("listNhaSanXuat", listNhaSanXuats);
        List<MauSac> listMauSac = this.mauSacService.getAllMauSac();
        model.addAttribute("listMauSac", listMauSac);
        List<DongSanPham> listDongSanPham = this.dongSanPhamService.getAllDongSanPham();
        model.addAttribute("listDongSanPham", listDongSanPham);
        return "chi-tiet-san-pham/index";
    }

    @PostMapping("add")
    public String addChiTietSanPham(@Valid @ModelAttribute(name = "chiTietSanPham") ChiTietSanPham chiTietSanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<ChiTietSanPham> pageChiTietSanPham = this.chiTietSanPhamService.pageChiTietSanPham(0);
            model.addAttribute("listChiTietSanPham", pageChiTietSanPham);
            List<SanPham> listSP = this.sanPhamService.getAllSanPham();
            model.addAttribute("listSanPham", listSP);
            List<NhaSanXuat> listNhaSanXuats = this.nhaSanXuatService.getAllNhaSanXuat();
            model.addAttribute("listNhaSanXuat", listNhaSanXuats);
            List<MauSac> listMauSac = this.mauSacService.getAllMauSac();
            model.addAttribute("listMauSac", listMauSac);
            List<DongSanPham> listDongSanPham = this.dongSanPhamService.getAllDongSanPham();
            model.addAttribute("listDongSanPham", listDongSanPham);
            return "chi-tiet-san-pham/index";
        }

        this.chiTietSanPhamService.addChiTietSanPham(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String hienThiViewUpdate(@PathVariable(name = "id") String id, Model model) {
        ChiTietSanPham chiTietSanPham = this.chiTietSanPhamService.detailChiTietSanPham(id);
        model.addAttribute("chiTietSanPham", chiTietSanPham);
        List<SanPham> listSP = this.sanPhamService.getAllSanPham();
        model.addAttribute("listSanPham", listSP);
        List<NhaSanXuat> listNhaSanXuats = this.nhaSanXuatService.getAllNhaSanXuat();
        model.addAttribute("listNhaSanXuat", listNhaSanXuats);
        List<MauSac> listMauSac = this.mauSacService.getAllMauSac();
        model.addAttribute("listMauSac", listMauSac);
        List<DongSanPham> listDongSanPham = this.dongSanPhamService.getAllDongSanPham();
        model.addAttribute("listDongSanPham", listDongSanPham);
        return "chi-tiet-san-pham/edit";
    }

    @PostMapping("update/{id}")
    public String updateChiTietSanPham(@ModelAttribute(name = "chiTietSanPham") ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPhamService.updateChiTietSanPham(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeChiTietSanPham(@PathVariable(name = "id") String id) {
        this.chiTietSanPhamService.removeChiTietSanPham(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}