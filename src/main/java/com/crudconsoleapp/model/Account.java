package main.java.com.crudconsoleapp.model;

import main.java.com.crudconsoleapp.AccountStatus;

public class Account {
    private Long id;
    private AccountStatus accountStatus;
    private String accountData;

    public Account(Long id, AccountStatus accountStatus, String accountData) {
        this.id = id;
        this.accountStatus = accountStatus;
        this.accountData = accountData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountData() {
        return accountData;
    }

    public void setAccountData(String accountData) {
        this.accountData = accountData;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountStatus=" + accountStatus +
                ", accountData='" + accountData + '\'' +
                '}';
    }
}


