package javadeveloper.exam.minibank.model;

import java.math.BigDecimal;

public class User {
    private Integer accountNo;
    private String firstname;
    private String lastname;
    private String password;
    private BigDecimal balance;
    private String  email;

    public User(){

    }
    
    public User(String firstname, String lastname, String password, BigDecimal balance) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.balance = balance;
    }

    public User(String firstname, String lastname, String password, BigDecimal balance,Integer accountNo) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.balance = balance;
        this.accountNo = accountNo;
    }


    public Integer getAccountno() {
        return accountNo;
    }

    public void setAccountno(Integer accountno) {
        this.accountNo = accountno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
