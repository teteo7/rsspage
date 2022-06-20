package rssproject.rss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.openqa.selenium.*;

@Controller
public class indexController {

    @GetMapping("apple")
    public String apple(Model model){
        model.addAttribute("data", "apple");
        return "apple";
    }

    //    URL에 param값 넣었는데 안되
    @GetMapping("list")
    @ResponseBody
    public String list(@RequestParam("param") String param) {

        return "list" + param;
    }
}
