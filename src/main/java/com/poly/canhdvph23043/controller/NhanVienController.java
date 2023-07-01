package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.ChucVu;
import com.poly.canhdvph23043.entity.CuaHang;
import com.poly.canhdvph23043.entity.NhanVien;
import com.poly.canhdvph23043.service.ChucVuService;
import com.poly.canhdvph23043.service.CuaHangService;
import com.poly.canhdvph23043.service.NhanVienService;
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
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("hien-thi")
    public String hienThiNhanVien(@RequestParam(name = "page", defaultValue = "1") Integer pageNo, Model model) {
        Page<NhanVien> page = this.nhanVienService.pageNhanVien(pageNo - 1, 5);
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("listNhanVien", page);
        List<ChucVu> listCV = this.chucVuService.getAllChucVu();
        model.addAttribute("listChucVu", listCV);
        List<CuaHang> listCH = this.cuaHangService.getAllCuaHang();
        model.addAttribute("listCuaHang", listCH);
        return "nhan-vien/index";
    }

    @GetMapping("detail/{id}")
    public String detailNhanVien(@PathVariable(name = "id")String id, Model model) {
        NhanVien nhanVien = this.nhanVienService.detailNhanVien(id);
        model.addAttribute("nhanVien", nhanVien);
        Page<NhanVien> page = this.nhanVienService.pageNhanVien(0, 5);
        model.addAttribute("listNhanVien", page);
        List<ChucVu> listCV = this.chucVuService.getAllChucVu();
        model.addAttribute("listChucVu", listCV);
        List<CuaHang> listCH = this.cuaHangService.getAllCuaHang();
        model.addAttribute("listCuaHang", listCH);
        return "nhan-vien/index";
    }

    @PostMapping("add")
    public String addNhanVien(@Valid @ModelAttribute(name = "nhanVien")NhanVien nhanVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<NhanVien> page = this.nhanVienService.pageNhanVien(0, 5);
            model.addAttribute("listNhanVien", page);
            List<ChucVu> listCV = this.chucVuService.getAllChucVu();
            model.addAttribute("listChucVu", listCV);
            List<CuaHang> listCH = this.cuaHangService.getAllCuaHang();
            model.addAttribute("listCuaHang", listCH);
            return "nhan-vien/index";
        } else if (this.nhanVienService.checkMa(nhanVien.getMa()) == 1) {
            Page<NhanVien> page = this.nhanVienService.pageNhanVien(0, 5);
            model.addAttribute("listNhanVien", page);
            List<ChucVu> listCV = this.chucVuService.getAllChucVu();
            model.addAttribute("listChucVu", listCV);
            List<CuaHang> listCH = this.cuaHangService.getAllCuaHang();
            model.addAttribute("listCuaHang", listCH);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "nhan-vien/index";
        } else {
            this.nhanVienService.addNhanVien(nhanVien);
            return "redirect:/nhan-vien/hien-thi";
        }
    }

    @GetMapping("view-update/{id}")
    public String hienThiViewUpdate(@PathVariable(name = "id")String id,Model model) {
        NhanVien nhanVien = this.nhanVienService.detailNhanVien(id);
        model.addAttribute("nhanVien", nhanVien);
        List<ChucVu> listCV = this.chucVuService.getAllChucVu();
        model.addAttribute("listChucVu", listCV);
        List<CuaHang> listCH = this.cuaHangService.getAllCuaHang();
        model.addAttribute("listCuaHang", listCH);
        return "nhan-vien/edit";
    }

    @PostMapping("update/{id}")
    public String updateNhanVien(@ModelAttribute(name = "nhanVien") NhanVien nhanVien) {
        this.nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeNhanVien(@PathVariable(name = "id")String id) {
        this.nhanVienService.removeNhanVien(id);
        return "redirect:/nhan-vien/hien-thi";
    }

}
