package matt.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class ownerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(){

//        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
