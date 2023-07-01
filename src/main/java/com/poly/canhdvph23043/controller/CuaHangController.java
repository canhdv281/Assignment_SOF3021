package com.poly.canhdvph23043.controller;

import com.poly.canhdvph23043.entity.CuaHang;
import com.poly.canhdvph23043.service.CuaHangService;
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
@RequestMapping("/cua-hang/")
public class CuaHangController {

    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("hien-thi")
    public String hienThiCuaHang(@RequestParam(name = "page",defaultValue = "1") Integer pageNo, Model model) {
        Page<CuaHang> page = this.cuaHangService.pageCuaHang(pageNo - 1, 5);
        model.addAttribute("ch", new CuaHang());
        model.addAttribute("listCuaHang", page);
        return "cua-hang/index";
    }

    @PostMapping("add")
    public String addCuaHang(@Valid @ModelAttribute(name = "ch") CuaHang cuaHang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Page<CuaHang> page = this.cuaHangService.pageCuaHang(0, 5);
            model.addAttribute("listCuaHang", page);
            return "cua-hang/index";
        } else if (this.cuaHangService.checkMa(cuaHang.getMa()) == 1) {
            Page<CuaHang> page = this.cuaHangService.pageCuaHang(0, 5);
            model.addAttribute("listCuaHang", page);
            model.addAttribute("errorMa", "Mã đã tồn tại");
            return "cua-hang/index";
        } else {
            this.cuaHangService.addCuaHang(cuaHang);
            return "redirect:/cua-hang/hien-thi";
        }
    }

    @GetMapping("detail/{id}")
    public String detailCuaHang(@PathVariable(name = "id")String id, Model model) {
        CuaHang cuaHang = this.cuaHangService.detailCuaHang(id);
        model.addAttribute("ch", cuaHang);
        Page<CuaHang> page = this.cuaHangService.pageCuaHang(0, 5);
        model.addAttribute("listCuaHang", page);
        return "cua-hang/index";
    }

    @GetMapping("view-update/{id}")
    public String hienThiViewUpdate(@PathVariable(name = "id")String id, Model model) {
        CuaHang cuaHang = this.cuaHangService.detailCuaHang(id);
        model.addAttribute("ch", cuaHang);
        return "cua-hang/edit";
    }

    @PostMapping("update/{id}")
    public String updateCuaHang(@ModelAttribute(name = "ch") CuaHang cuaHang) {
        this.cuaHangService.updateCuaHang(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String removeCuaHang(@PathVariable(name = "id") String id) {
        this.cuaHangService.removeCuaHang(id);
        return "redirect:/cua-hang/hien-thi";
    }

}
