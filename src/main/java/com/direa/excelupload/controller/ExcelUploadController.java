package com.direa.excelupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ExcelUploadController {

    @GetMapping("/excelUpload.do")
    public String excelUpload() {
        return "excelUpload";
    }
}
