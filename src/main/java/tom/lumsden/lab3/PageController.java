package tom.lumsden.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @Autowired
    AddressBookController addressBookController;

    @GetMapping("/page")
    public String page(@RequestParam(value = "id", defaultValue = "1") long id, Model model){
        model.addAttribute("id", id);
        AddressBook ab = addressBookController.addressBook(id);
        model.addAttribute("buds", ab.getBuds().toArray());

        return "addressbook";
    }
}
