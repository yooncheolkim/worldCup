package com.jaeyoon.Controller;

import com.jaeyoon.Model.ImageContents;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LastController {

    @GetMapping("/last")
    public String lastOnePick(Model model , @RequestParam("winner") int winner){

        model.addAttribute("winnerImage", "images/"+winner + ".jpg");
        model.addAttribute("desc", ImageContents.ImageDesc[winner]);

        return "last";
    }
}
