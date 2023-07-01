package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.SanPham;
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

@Controller
@RequestMapping("/san-pham/")
public class SanPhamController {

    @Autowired
    public SanPhamService sanPhamService;

    @GetMapping("hien-thi")
    public String hienThiSanPham(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {
        Page<SanPham> page = this.sanPhamService.pageSanPham(pageNo, 5);
        model.addAttribute("sp", new SanPham());
        model.addAttribute("listSanPham", page);
        return "san-pham/index";
    }

    @GetMapping("detail/{id}")
    public String detailSanPham(@PathVariable(name = "id") String id, Model model) {
        SanPham sanPham = this.sanPhamService.detailSanPham(id);
        model.addAttribute("sp", sanPham);
        Page<SanPham> page = this.sanPhamService.pageSanPham(0, 5);
        model.addAttribute("listSanPham", page);
        return "san-pham/index";
    }

    @PostMapping("add")
    public String addSanPham(@Valid @ModelAttribute(name = "sp") SanPham sanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<SanPham> page = this.sanPhamService.pageSanPham(0, 5);
            model.addAttribute("listSanPham", page);
            return "san-pham/index";
        } else if (this.sanPhamService.checkMa(sanPham.getMa()) == 1) {
            Page<SanPham> page = this.sanPhamService.pageSanPham(0, 5);
            model.addAttribute("listSanPham", page);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "san-pham/index";
        } else {
            this.sanPhamService.addSanPham(sanPham);
            return "redirect:/san-pham/hien-thi";
        }
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable(name = "id") String id, Model model) {
        SanPham sanPham = this.sanPhamService.detailSanPham(id);
        model.addAttribute("sp", sanPham);
        return "san-pham/edit";
    }

    @PostMapping("update/{id}")
    public String updateSanPham(@ModelAttribute(name = "sp") SanPham sanPham) {
        this.sanPhamService.updateSanPham(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeSanPham(@PathVariable(name = "id") String id) {
        this.sanPhamService.removeSanPham(id);
        return "redirect:/san-pham/hien-thi";
    }

}
