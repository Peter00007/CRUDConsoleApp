package main.java.com.crudconsoleapp.repository.io;

import main.java.com.crudconsoleapp.model.Account;
import main.java.com.crudconsoleapp.model.AccountStatus;
import main.java.com.crudconsoleapp.repository.AccountRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {
    private static final String FILE_PATH = "D:\\JavaCourse\\CRUDConsoleApp\\src\\main\\resourses\\files\\accounts.txt";

    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String accountFileContent;
            while ((accountFileContent = bufferedReader.readLine()) != null) {
                String[] accountsRecords = accountFileContent.split(",");
                AccountStatus status = AccountStatus.valueOf(accountsRecords[1]);
                list.add(new Account(Long.parseLong(accountsRecords[0]), status, accountsRecords[2].substring(0, accountsRecords[2].length() - 1)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Account getById(Long id) {
        Account account;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String accountFileContent;
            while ((accountFileContent = bufferedReader.readLine()) != null) {
                String[] accountsRecords = accountFileContent.split(",");
                Long equalsId = Long.parseLong(accountsRecords[0]);
                if (equalsId == id) {
                    AccountStatus status = AccountStatus.valueOf(accountsRecords[1]);
                    account = new Account(Long.parseLong(accountsRecords[0]), status, accountsRecords[2].substring(0, accountsRecords[2].length() - 1));
                    return account;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account save(Account account) {
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String s = account.getId().toString() + "," + account.getAccountStatus() + "," + account.getAccountData() + "/\n";
            bufferWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }

    public void delete(Long id) {
        String saveAccountLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((saveAccountLine = reader.readLine()) != null) {
                String[] accountRecords = saveAccountLine.split(",");
                if (!accountRecords[0].equals(id.toString())) {
                    stringBuffer.append(saveAccountLine).append("\n");
                }
            }
            saveAccountLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[saveAccountLine.length()];
        saveAccountLine.getChars(0, saveAccountLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteByObject(Account account) {
        String saveAccountLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            String accountRecords = account.getId().toString() + "," + account.getAccountStatus() + "," + account.getAccountData() + "/";
            while ((saveAccountLine = reader.readLine()) != null) {
                if (!accountRecords.equals(saveAccountLine)) {
                    stringBuffer.append(saveAccountLine).append("\n");
                }
            }
            saveAccountLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] buffer = new char[saveAccountLine.length()];
        saveAccountLine.getChars(0, saveAccountLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Account update(Account account) {
        String saveAccountLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((saveAccountLine = reader.readLine()) != null) {
                String[] accountRecords = saveAccountLine.split(",");
                if (!accountRecords[0].equals(account.getId().toString())) {
                    stringBuffer.append(saveAccountLine).append("\n");
                } else {
                    stringBuffer.append(account.getId().toString() + "," + account.getAccountStatus() + "," + account.getAccountData() + "/").append("\n");
                }
            }
            saveAccountLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[saveAccountLine.length()];
        saveAccountLine.getChars(0, saveAccountLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return account;
    }
}
