package tom.lumsden.lab3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab3Application {

    private static final Logger log = LoggerFactory.getLogger(Lab3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class);
    }

    @Bean
    public CommandLineRunner demo(AddressBookRepository addressBookRepository) {
        return (args) -> {
            BuddyInfo bud1 = new BuddyInfo("homer", "123 Rainbow road", "613-123-4567");
            BuddyInfo bud2 = new BuddyInfo("bob", "321 Oak st", "613-987-6543");
            BuddyInfo bud3 = new BuddyInfo("bart", "123 Rainbow road", "613-123-4567");
            BuddyInfo bud4 = new BuddyInfo("maggie", "321 Oak st", "613-987-6543");

            AddressBook ab = new AddressBook();


            ab.addBuddy(bud1);
            ab.addBuddy(bud2);
            ab.addBuddy(bud3);
            ab.addBuddy(bud4);



            addressBookRepository.save(ab);



            AddressBook addressBook = addressBookRepository.findById(1L);
            log.info("address book found with findById(1L):");
            log.info("--------------------------------------------");
            log.info(addressBook.toString());
            log.info("");



        };
    }

}
