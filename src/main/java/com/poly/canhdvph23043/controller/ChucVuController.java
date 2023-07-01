package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.ChucVu;
import com.poly.canhdvph23043.service.ChucVuService;
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
@RequestMapping("/chuc-vu/")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("hien-thi")
    public String hienThiChucVu(@RequestParam(name = "page", defaultValue = "1") Integer pageNo, Model model) {
        Page<ChucVu> page = this.chucVuService.pageChucVu(pageNo - 1, 5);
        model.addAttribute("listChucVu", page);
        model.addAttribute("cv", new ChucVu());
        return "chuc-vu/index";
    }

    @PostMapping("add")
    public String addChucVu(@Valid @ModelAttribute(name = "cv") ChucVu chucVu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<ChucVu> page = this.chucVuService.pageChucVu(0, 5);
            model.addAttribute("listChucVu", page);
            return "chuc-vu/index";
        } else if (this.chucVuService.checkMa(chucVu.getMa()) == 1 ) {
            Page<ChucVu> page = this.chucVuService.pageChucVu(0, 5);
            model.addAttribute("listChucVu", page);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "chuc-vu/index";
        } else {
            this.chucVuService.addChucVu(chucVu);
            return "redirect:/chuc-vu/hien-thi";
        }
    }

    @GetMapping("detail/{id}")
    public String detailChucVu(@PathVariable(name = "id")String id, Model model) {
        ChucVu chucVu = this.chucVuService.detailChucVu(id);
        model.addAttribute("cv", chucVu);
        Page<ChucVu> page = this.chucVuService.pageChucVu(0, 5);
        model.addAttribute("listChucVu", page);
        return "chuc-vu/index";
    }

    @GetMapping("view-update/{id}")
    public String hienThiViewUpdate(@PathVariable(name = "id") String id, Model model) {
        ChucVu chucVu = this.chucVuService.detailChucVu(id);
        model.addAttribute("cv", chucVu);
        return "chuc-vu/edit";
    }

    @PostMapping("update/{id}")
    public String updateChcuVu(@ModelAttribute(name = "cv") ChucVu chucVu) {
        this.chucVuService.updateChucVu(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeChucVu(@PathVariable(name = "id")String id) {
        this.chucVuService.removeChucVu(id);
        return "redirect:/chuc-vu/hien-thi";
    }

}
