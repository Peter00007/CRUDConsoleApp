package main.java.com.crudconsoleapp.view;


import main.java.com.crudconsoleapp.controller.AccountController;
import main.java.com.crudconsoleapp.model.Account;

import java.util.Scanner;

public class AccountView {
    Scanner in;
    AccountController accountController;

    public AccountView () {
        in = new Scanner(System.in);
        accountController = new AccountController();
    }

    private final String start = "Enter:\n" +
            "1 if you want Get Account by ID\n" +
            "2 if you want Get All Accounts\n" +
            "3 if you want Create Account\n" +
            "4 if you want Update Account\n" +
            "5 if you want Delete Account";

    private final String getAccountByIdMessage = "Input Id our Account:";
    private final String getAllAccountMessage = "Get our All Account:";
    private final String createAccountMessageId = "Input Id:";
    private final String createAccountDataMessage = "Input AccountData:";
    private final String createAccountStatusMessage = "Input Account Status:\n" +
            "Enter 'ACTIVE', if your account is Active\n" +
            "Enter 'BANNED', if your account is Banned\n" +
            "Enter 'DELETED', if your account is Deleted";
    private final String choiceDeleteMessage = "Enter:\n" +
            "1 if you want delete Account by Id\n" +
            "2 if you want delete Account by Account";
    private final String choice = "Input your choice:";

    public void startCRUD() {
        System.out.println(start);
        try {
            int pointer;
            do {
                System.out.println(choice);
                String getData = in.next();
                int number = Integer.parseInt(getData);
                pointer = number;
                switch (number) {
                    case 1:
                        System.out.println(getAccountByIdMessage);
                        String getId = in.next();
                        try {
                            Long idAccount = Long.parseLong(getId);
                            getByIdAccount(idAccount);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.println(getAllAccountMessage);
                        getAllAccount();
                        break;
                    case 3:
                        System.out.println("Create Account\n" + createAccountMessageId);
                        String getIdAccount = in.next();
                        System.out.println(createAccountStatusMessage);
                        String accountStatus = in.next();
                        System.out.println(createAccountDataMessage);
                        String getAccountData = in.next();
                        try {
                            Account.AccountStatus status = Account.AccountStatus.valueOf(accountStatus);
                            Long getAccountId = Long.parseLong(getIdAccount);
                            Account account = new Account(getAccountId, status, getAccountData);
                            createAccount(account);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        System.out.println("Update Account\n" + createAccountMessageId);
                        String getUpdateId = in.next();
                        System.out.println(createAccountStatusMessage);
                        String newAccountStatus = in.next();
                        System.out.println(createAccountDataMessage);
                        String getUpdateAccountData = in.next();
                        try {
                            Account.AccountStatus status = Account.AccountStatus.valueOf(newAccountStatus);
                            Long updateId = Long.parseLong(getUpdateId);
                            Account account = new Account(updateId, status, getUpdateAccountData);
                            updateAccount(account);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        System.out.println(choiceDeleteMessage);
                        try {
                            int index;
                            do {
                                System.out.println(choice);
                                String choiceCount = in.next();
                                int count = Integer.parseInt(choiceCount);
                                index = count;
                                if (count == 1) {
                                    System.out.println(createAccountMessageId);
                                    try {
                                        String deleteId = in.next();
                                        Long getDeleteId = Long.parseLong(deleteId);
                                        deleteByIdAccount(getDeleteId);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (count == 2) {
                                    System.out.println(createAccountMessageId);
                                    String deleteIdAccount = in.next();
                                    System.out.println(createAccountStatusMessage);
                                    String accStatus = in.next();
                                    System.out.println(createAccountDataMessage);
                                    String deleteAccountData = in.next();
                                    try {
                                        Account.AccountStatus status = Account.AccountStatus.valueOf(accStatus);
                                        Long getDeleteId = Long.parseLong(deleteIdAccount);
                                        Account account = new Account(getDeleteId, status, deleteAccountData);
                                        deleteAccount(account);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } while ((index != 1) && (index != 2));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } while (pointer < 1 || pointer > 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getByIdAccount(Long id) {
        System.out.println(accountController.getById(id));
    }

    void getAllAccount() {
        System.out.println(accountController.getAccount());
    }

    void createAccount(Account account) {
        System.out.println(accountController.createAccount(account));
    }

    void updateAccount(Account account) {
        System.out.println(accountController.updateAccount(account));
    }

    void deleteByIdAccount(Long id) {
        accountController.deleteByIdAccount(id);
    }

    void deleteAccount(Account account) {
        accountController.deleteAccount(account);
    }
}
