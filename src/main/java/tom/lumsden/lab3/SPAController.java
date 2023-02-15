package tom.lumsden.lab3;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SPAController {


    @GetMapping("/SPA")
    public String page(){
        return "spa.html";
    }
}
