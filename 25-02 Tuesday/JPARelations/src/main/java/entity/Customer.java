package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;
    
    private String firstName;
    private String lastName;
    
    
    @ElementCollection
    @CollectionTable(
            name ="Hobbies",
            joinColumns=@JoinColumn(name="customer_id")
    )
    @Column(name="hobby_name")
    private List<String> hobbies = new ArrayList();
    
    @OneToMany(mappedBy = "customer")
    private List<Address> addresses = new ArrayList();
    
    
    public void addHobby(String s) {
        hobbies.add(s);
    }
    
    public String getHobbies() {
        return String.join(",", hobbies);
    }

    public void addAddresses(Address address) {
        addresses.add(address);
    }
    
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {}
    
    public Integer getId() {
        return customer_id;
    }

    public void setId(int id) {
        this.customer_id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}