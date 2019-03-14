package main.java.com.crudconsoleapp;


import main.java.com.crudconsoleapp.model.Account;
import main.java.com.crudconsoleapp.model.Developer;
import main.java.com.crudconsoleapp.model.Skill;
import main.java.com.crudconsoleapp.repository.DeveloperRepository;

import java.util.HashSet;
import java.util.Set;

public class CRUDRunner {
    public static void main(String[] args) {
        /*SkillView skillView = new SkillView();
        skillView.startCRUD();*/
       // AccountRepository accountRepository = new AccountRepository();
        //accountRepository.save(new Account(2L, Account.AccountStatus.ACTIVE, "Vasya"));
        //System.out.println(accountRepository.getById(1L));
        //accountRepository.update(new Account(1L,Account.AccountStatus.BANNED, "aaa"));
        //accountRepository.delete(new Account(2L,Account.AccountStatus.ACTIVE, "Vasya"));
        /*AccountView accountView = new AccountView();
        accountView.startCRUD();*/
       /* Set<Skill> set = new HashSet<>();
        set.add(new Skill(1L, "Peter"));
        set.add(new Skill(2L, "Peter"));
        set.add(new Skill(3L, "Peter"));
        set.add(new Skill(4L, "Peter"));
        developerRepository.save(new Developer(1L, "efef", "ewdfefef", "efer",
                set, new Account(2L, AccountStatus.ACTIVE, "efevrg")));
        developerRepository.save(new Developer(2L, "efef", "ewdfefef", "efer",
                set, new Account(2L, AccountStatus.ACTIVE, "efevrg")));*/
        /*developerRepository.save(new Developer(3L, "efef", "ewdfefef", "efer",
                set, new Account(2L, AccountStatus.ACTIVE, "efevrg")));*/
        DeveloperRepository developerRepository = new DeveloperRepository();
        //System.out.println(developerRepository.getAll());
        //System.out.println(developerRepository.getById(3L));
        Set<Skill> set = new HashSet<>();
        set.add(new Skill(1L, "Peter"));
        set.add(new Skill(2L, "Peter"));
       // set.add(new Skill(3L, "Peter"));
        //set.add(new Skill(4L, "Peter"));
        //developerRepository.delete(new Developer(1L, "efef", "ewdfefef", "efer",
        //        set, new Account(2L, AccountStatus.ACTIVE, "efevrg")));

        developerRepository.update(new Developer(2L, "aaa", "aa", "aa",
                set, new Account(2L, AccountStatus.BANNED, "aaaa")));
    }
}
