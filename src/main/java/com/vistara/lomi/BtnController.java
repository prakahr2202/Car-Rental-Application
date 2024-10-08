package com.vistara.lomi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BtnController {
    @GetMapping("/sportss")
    public String detais() {
        return "sports";
    }

    @GetMapping("/normals")
    public String deilss() {
        return "normal";
    }

    @GetMapping("/sedan")
    public String dtailss() {
        return "sports";
    }

    @GetMapping("/suv")
    public String tailss() {
        return "sports";
    }

    @GetMapping("/convertible")
    public String deailss() {
        return "sports";
    }
}
