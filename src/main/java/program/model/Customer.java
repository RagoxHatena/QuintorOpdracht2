package program.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

enum Gender{
    MALE,
    FEMALE
}

@Entity
public class Customer{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    @Embedded
    private Account account;

    protected Customer(){}

    public Customer(long id, String firstName, String lastName, Gender gender, Account account){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.account = account;
    }

    public long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Gender getGender(){
        return gender;
    }

    public Account getAccount() {
        return account;
    }
}