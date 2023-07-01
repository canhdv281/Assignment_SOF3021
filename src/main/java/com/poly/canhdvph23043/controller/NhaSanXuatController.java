package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.NhaSanXuat;
import com.poly.canhdvph23043.service.NhaSanXuatService;
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
@RequestMapping("/nha-san-xuat/")
public class NhaSanXuatController {

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @GetMapping("hien-thi")
    public String hienThiNhaSanXuat(@RequestParam(name = "page", defaultValue = "0") Integer pageNo, Model model) {
        Page<NhaSanXuat> page = this.nhaSanXuatService.pageNhaSanXuat(pageNo, 5);
        model.addAttribute("nhaSanXuat", new NhaSanXuat());
        model.addAttribute("listNhaSanXuat", page);
        return "nha-san-xuat/index";
    }

    @PostMapping("add")
    public String addNhaSanXuat(@Valid @ModelAttribute(name = "nhaSanXuat") NhaSanXuat nhaSanXuat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<NhaSanXuat> page = this.nhaSanXuatService.pageNhaSanXuat(0, 5);
            model.addAttribute("listNhaSanXuat", page);
            return "nha-san-xuat/index";
        } else if (this.nhaSanXuatService.checkMa(nhaSanXuat.getMa()) == 1) {
            Page<NhaSanXuat> page = this.nhaSanXuatService.pageNhaSanXuat(0, 5);
            model.addAttribute("listNhaSanXuat", page);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "nha-san-xuat/index";
        } else {
            this.nhaSanXuatService.addNhaSanXuat(nhaSanXuat);
            return "redirect:/nha-san-xuat/hien-thi";
        }
    }

    @GetMapping("detail/{id}")
    public String detailNhaSanXuat(@PathVariable(name = "id")String id, Model model) {
        NhaSanXuat nhaSanXuat = this.nhaSanXuatService.detailNhaSanXuat(id);
        Page<NhaSanXuat> page = this.nhaSanXuatService.pageNhaSanXuat(0, 5);
        model.addAttribute("listNhaSanXuat", page);
        model.addAttribute("nhaSanXuat", nhaSanXuat);
        return "nha-san-xuat/index";
    }

    @GetMapping("remove/{id}")
    public String removeNhaSanXuat(@PathVariable(name = "id") String id) {
        this.nhaSanXuatService.removeNhaSanXuat(id);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdateNhaSanXuat(@PathVariable(name = "id") String id, Model model) {
        NhaSanXuat nhaSanXuat = this.nhaSanXuatService.detailNhaSanXuat(id);
        model.addAttribute("nhaSanXuat", nhaSanXuat);
        return "nha-san-xuat/edit";
    }

    @PostMapping("update/{id}")
    public String updateNhaSanXuat(@ModelAttribute(name = "nhaSanXuat") NhaSanXuat nhaSanXuat) {
        this.nhaSanXuatService.updateNhaSanXuat(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }

}
