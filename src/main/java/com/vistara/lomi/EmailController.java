package com.vistara.lomi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @GetMapping("/email")
    public String emailpage() {
        return "email";
    }

    @GetMapping("/call")
    public String callbacki() {
        return "callback";
    }
}
