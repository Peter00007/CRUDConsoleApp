package main.java.com.crudconsoleapp.controller;

import main.java.com.crudconsoleapp.model.Account;
import main.java.com.crudconsoleapp.repository.AccountRepository;

import java.util.List;

public class AccountController {
    AccountRepository accountRepository = new AccountRepository();

    public Account getById(Long id) {
        return accountRepository.getById(id);
    }

    public List<Account> getAccount () {
        return accountRepository.getAll();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount (Account account) {
        return accountRepository.update(account);
    }

    public void deleteByIdAccount(Long id) {
        accountRepository.delete(id);
    }

    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }
}
