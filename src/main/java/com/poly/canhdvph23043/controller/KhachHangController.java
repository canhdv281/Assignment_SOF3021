package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.KhachHang;
import com.poly.canhdvph23043.service.KhachHangService;
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

@Controller
@RequestMapping("/khach-hang/")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("hien-thi")
    public String hienThiKhachHang(@RequestParam(name = "page", defaultValue = "1") Integer page, Model model) {
        Page<KhachHang> pageKhachHang = this.khachHangService.pageKhachHang(page - 1);
        model.addAttribute("listKhachHang", pageKhachHang);
        model.addAttribute("kh", new KhachHang());
        return "khach-hang/index";
    }

    @PostMapping("add")
    public String addKhachHang(@Valid @ModelAttribute(name = "kh") KhachHang khachHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<KhachHang> pageKhachHang = this.khachHangService.pageKhachHang(0);
            model.addAttribute("listKhachHang", pageKhachHang);
            return "khach-hang/index";
        } else if (this.khachHangService.checkMa(khachHang.getMa()) == 1) {
            Page<KhachHang> pageKhachHang = this.khachHangService.pageKhachHang(0);
            model.addAttribute("listKhachHang", pageKhachHang);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "khach-hang/index";
        } else {
            this.khachHangService.addKhachHang(khachHang);
            return "redirect:/khach-hang/hien-thi";
        }
    }

    @GetMapping("detail/{id}")
    public String detailKhachHang(@PathVariable(name = "id") String id, Model model) {
        KhachHang khachHang = this.khachHangService.detailKhachHang(id);
        model.addAttribute("kh", khachHang);
        Page<KhachHang> pageKhachHang = this.khachHangService.pageKhachHang(0);
        model.addAttribute("listKhachHang", pageKhachHang);
        return "khach-hang/index";
    }

    @GetMapping("remove/{id}")
    public String removeKhachHang(@PathVariable(name = "id") String id) {
        this.khachHangService.removeKhachHang(id);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String hienThiViewUpdate(@PathVariable(name = "id") String id, Model model) {
        KhachHang khachHang = this.khachHangService.detailKhachHang(id);
        model.addAttribute("kh", khachHang);
        return "khach-hang/edit";
    }

    @PostMapping("update/{id}")
    public String updateKhachHang(@ModelAttribute(name = "kh") KhachHang khachHang) {
        this.khachHangService.updateKhachHang(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

}
