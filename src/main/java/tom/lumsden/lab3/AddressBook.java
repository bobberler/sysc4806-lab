package tom.lumsden.lab3;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "addressBook")
public class AddressBook {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BuddyInfo> buds;


    public AddressBook(){
        buds = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy){
        buds.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy){
        buds.remove(buddy);
    }

    public List<BuddyInfo> getBuds() {
        return buds;
    }

    public void setBuds(ArrayList<BuddyInfo> buds) {
        this.buds = buds;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        String ab = "Address book: \n";
        for(BuddyInfo b : buds){
            ab += "Buddy:" + b.toString() + "\n";
        }
        return ab;
    }



}
