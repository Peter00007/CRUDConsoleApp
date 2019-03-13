package main.java.com.crudconsoleapp;


import main.java.com.crudconsoleapp.view.AccountView;

public class CRUDRunner {
    public static void main(String[] args) {
        /*SkillView skillView = new SkillView();
        skillView.startCRUD();*/
       // AccountRepository accountRepository = new AccountRepository();
        //accountRepository.save(new Account(2L, Account.AccountStatus.ACTIVE, "Vasya"));
        //System.out.println(accountRepository.getById(1L));
        //accountRepository.update(new Account(1L,Account.AccountStatus.BANNED, "aaa"));
        //accountRepository.delete(new Account(2L,Account.AccountStatus.ACTIVE, "Vasya"));
        AccountView accountView = new AccountView();
        accountView.startCRUD();
    }
}
