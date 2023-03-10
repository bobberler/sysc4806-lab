package tom.lumsden.lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class BuddyInfoController {
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @Autowired
    AddressBookRepository addressBookRepository;


    @GetMapping("/buddyinfo")
    public BuddyInfo getBuddyById(@RequestParam(value = "id", defaultValue = "1") long id){
        BuddyInfo bud = buddyInfoRepository.findById(id);
        return bud;
    }

    @PostMapping("/buddyinfo/add")
    public RedirectView addBuddyFromGet(@RequestParam(value = "name") String name,
                                        @RequestParam(value="address") String address,
                                        @RequestParam(value="phoneNumber") String phoneNumber,
                                        @RequestParam(value="bookId", defaultValue = "1") long bookId){
        BuddyInfo bud = new BuddyInfo(name, address, phoneNumber);
        try{
            AddressBook ab = addressBookRepository.findById(bookId);
            ab.addBuddy(bud);
            addressBookRepository.save(ab);

        }
        catch (Exception e){
            AddressBook ab = new AddressBook();
            ab.addBuddy(bud);
            addressBookRepository.save(ab);
        }
        return new RedirectView("/page?id=" + bookId);
    }


    @PostMapping("/buddyinfo")
    public BuddyInfo newBuddy(@RequestBody BuddyInfo bud){
        AddressBook ab = addressBookRepository.findById(1);
        ab.addBuddy(bud);
        addressBookRepository.save(ab);
        return buddyInfoRepository.save(bud);
    }




}
