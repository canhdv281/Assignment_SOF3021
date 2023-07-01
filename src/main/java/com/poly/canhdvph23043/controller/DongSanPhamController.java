package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.DongSanPham;
import com.poly.canhdvph23043.service.DongSanPhamService;
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
@RequestMapping("/dong-san-pham/")
public class DongSanPhamController {

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("/hien-thi")
    public String hienThiDongSanPham(Model model, @RequestParam(name = "page", defaultValue = "0")Integer pageNo) {
        Page<DongSanPham> page = this.dongSanPhamService.pageDongSanPham(pageNo, 5);
        model.addAttribute("dongSanPham", new DongSanPham());
        model.addAttribute("listDongSanPham", page);
        return "dong-san-pham/index";
    }

    @GetMapping("detail/{id}")
    public String detailDongSanPham(@PathVariable(name = "id") String id, Model model) {
        DongSanPham dongSanPham = this.dongSanPhamService.detailDongSanPham(id);
        model.addAttribute("dongSanPham", dongSanPham);
        Page<DongSanPham> page = this.dongSanPhamService.pageDongSanPham(0, 5);
        model.addAttribute("listDongSanPham", page);
        return "dong-san-pham/index";
    }

    @PostMapping("add")
    public String addDongSanPham(@Valid @ModelAttribute(name = "dongSanPham") DongSanPham dongSanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<DongSanPham> page = this.dongSanPhamService.pageDongSanPham(0, 5);
            model.addAttribute("listDongSanPham", page);
            return "dong-san-pham/index";
        } else if (this.dongSanPhamService.checkMa(dongSanPham.getMa()) == 1) {
            Page<DongSanPham> page = this.dongSanPhamService.pageDongSanPham(0, 5);
            model.addAttribute("listDongSanPham", page);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "dong-san-pham/index";
        }
        this.dongSanPhamService.addDongSanPham(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable(name = "id") String id, Model model) {
        DongSanPham dongSanPham = this.dongSanPhamService.detailDongSanPham(id);
        model.addAttribute("dongSanPham", dongSanPham);
        return "dong-san-pham/edit";
    }

    @PostMapping("update/{id}")
    public String updateDongSanPham(@ModelAttribute(name = "dongSanPham") DongSanPham dongSanPham) {
        this.dongSanPhamService.updateDongSanPham(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeDongSanPham(@PathVariable(name = "id") String id) {
        this.dongSanPhamService.removeDongSanPham(id);
        return "redirect:/dong-san-pham/hien-thi";
    }

}
