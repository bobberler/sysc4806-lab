package tom.lumsden.lab3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    public BuddyInfo(){

    }

    public BuddyInfo(String _name, String _address, String _phoneNumber){
        this.name = _name;
        this.address = _address;
        this.phoneNumber = _phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {return name;}

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return (this.name + " " + this.address + " " + this.phoneNumber);
    }
}