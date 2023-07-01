package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.MauSac;
import com.poly.canhdvph23043.service.MauSacService;
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
@RequestMapping("/mau-sac/")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page",defaultValue = "0")Integer pageNo) {
        Page<MauSac> page = this.mauSacService.pageMauSac(pageNo, 5);
        model.addAttribute("ms", new MauSac());
        List<MauSac> listMauSac = this.mauSacService.getAllMauSac();
        model.addAttribute("listMauSac", page);
        return "mau-sac/index";
    }

    @PostMapping("add")
    public String addMauSac(@Valid @ModelAttribute(name = "ms")MauSac mauSac, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<MauSac> page = this.mauSacService.pageMauSac(0, 5);
            model.addAttribute("listMauSac", page);
            return "mau-sac/index";
        } else if (this.mauSacService.checkMa(mauSac.getMa()) == 1) {
            Page<MauSac> page = this.mauSacService.pageMauSac(0, 5);
            model.addAttribute("listMauSac", page);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "mau-sac/index";
        }
        this.mauSacService.addMauSac(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("detail/{id}")
    public String detailMauSac(@PathVariable(name = "id") String id, Model model) {
        MauSac mauSac = this.mauSacService.detailMauSac(id);
        model.addAttribute("ms", mauSac);
        Page<MauSac> page = this.mauSacService.pageMauSac(0, 5);
        model.addAttribute("listMauSac", page);
        return "mau-sac/index";
    }

    @GetMapping("remove/{id}")
    public String removeMauSac(@PathVariable(name = "id")String id) {
        this.mauSacService.removeMauSac(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable(name = "id")String id, Model model) {
        MauSac mauSac = this.mauSacService.detailMauSac(id);
        model.addAttribute("ms", mauSac);
        return "mau-sac/edit";
    }

    @PostMapping("update/{id}")
    public String updateMauSac(@ModelAttribute(name = "ms") MauSac mauSac) {
        this.mauSacService.updateMauSac(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

}
