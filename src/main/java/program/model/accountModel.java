package program.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class accountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String accountNumber;
    private long balance;
    private String iban;

    //GENERATE IBAN
    public String generateIban(){
        String[] ibanMark = {"NL INGB", "NL AMRO", "NL RABO"};
        int markIndex = new Random().nextInt(ibanMark.length);
        return ibanMark[markIndex];
    }

    //GETTERS AND SETTERS
    public long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public String getIban() {
        return iban;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}