package tom.lumsden.lab3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressBookController {
    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/addressbook")
    public AddressBook addressBook(@RequestParam(value = "id", defaultValue = "1") long id){
        AddressBook ab = addressBookRepository.findById(id);
        return ab;
    }

    @PostMapping("/addressbook")
    public AddressBook newAddressbook(@RequestBody AddressBook ab){
        return addressBookRepository.save(ab);
    }

    @DeleteMapping("/addressbook/{id}")
    void deleteAddressBook(@PathVariable long id){
        addressBookRepository.deleteById(id);
    }
}
