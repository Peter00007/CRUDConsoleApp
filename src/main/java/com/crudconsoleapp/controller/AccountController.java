package main.java.com.crudconsoleapp.controller;

import main.java.com.crudconsoleapp.model.Account;
import main.java.com.crudconsoleapp.repository.AccountRepository;
import main.java.com.crudconsoleapp.repository.io.JavaIOAccountRepositoryImpl;

import java.util.List;

public class AccountController {
    AccountRepository  javaIOAccountRepository = new JavaIOAccountRepositoryImpl();

    public Account getById(Long id) {
        return javaIOAccountRepository.getById(id);
    }

    public List<Account> getAccount () {
        return javaIOAccountRepository.getAll();
    }

    public Account createAccount(Account account) {
        return javaIOAccountRepository.save(account);
    }

    public Account updateAccount (Account account) {
        return javaIOAccountRepository.update(account);
    }

    public void deleteByIdAccount(Long id) {
        javaIOAccountRepository.delete(id);
    }

    public void deleteAccount(Account account) {
        javaIOAccountRepository.deleteByObject(account);
    }
}
