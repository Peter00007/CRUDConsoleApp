package main.java.com.crudconsoleapp.view;


import main.java.com.crudconsoleapp.controller.DeveloperController;
import main.java.com.crudconsoleapp.model.Developer;
import main.java.com.crudconsoleapp.model.Skill;
import main.java.com.crudconsoleapp.repository.AccountRepository;
import main.java.com.crudconsoleapp.repository.DeveloperRepository;
import main.java.com.crudconsoleapp.repository.SkillRepository;
import main.java.com.crudconsoleapp.repository.io.JavaIOAccountRepositoryImpl;
import main.java.com.crudconsoleapp.repository.io.JavaIODeveloperRepositoryImpl;
import main.java.com.crudconsoleapp.repository.io.JavaIOSkillRepositoryImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeveloperView {
    Scanner in;
    DeveloperController developerController;
    SkillRepository javaIOSkillRepository;
    AccountRepository javaIOAccountRepository;
    DeveloperRepository javaIODeveloperRepository;

    public DeveloperView() {
        in = new Scanner(System.in);
        developerController = new DeveloperController();
        javaIOSkillRepository = new JavaIOSkillRepositoryImpl();
        javaIOAccountRepository = new JavaIOAccountRepositoryImpl();
        javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();
    }

    private final String start = "Enter:\n" +
            "1 if you want Get Developer by ID\n" +
            "2 if you want Get All Developers\n" +
            "3 if you want Create Developer\n" +
            "4 if you want Update Developer\n" +
            "5 if you want Delete Developer";

    private final String getDeveloperByIdMessage = "Input Id our Developer:";
    private final String getAllDeveloperMessage = "Get our All Developer:";
    private final String createDeveloperMessageId = "Input Id:";
    private final String createDeveloperMessageFirstName = "Input firstName:";
    private final String createDeveloperMessageLastName = "Input lastName:";
    private final String createDeveloperMessageSpecialty = "Input Specialty:";
    private final String createSkills = "Input Id Skill:";
    private final String createAccount = "Input Id Account:";
    private final String choiceDeleteMessage = "Enter:\n" +
            "1 if you want delete Developer by Id\n" +
            "2 if you want delete Developer by Developer";
    private final String finishCreateSkill = "If you want to write Skill, press - 1, if not write - 2";

    public void startCRUD() {
        System.out.println(start);
        try {
            int pointer;
            do {
                String getData = in.next();
                int number = Integer.parseInt(getData);
                pointer = number;
                switch (number) {
                    case 1:
                        System.out.println(getDeveloperByIdMessage);
                        String getId = in.next();
                        try {
                            Long idDeveloper = Long.parseLong(getId);
                            getByIdDeveloper(idDeveloper);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.println(getAllDeveloperMessage);
                        getAllDeveloper();
                        break;
                    case 3:
                        try {
                            System.out.println("Create Developer");
                            boolean f;
                            String getIdDeveloper;
                            do {
                                System.out.println(createDeveloperMessageId);
                                getIdDeveloper = in.next();
                                if (javaIODeveloperRepository.getById(Long.parseLong(getIdDeveloper)) == null) {
                                    f = true;
                                }
                                else
                                {
                                    f = false;
                                }
                            } while (f == false);
                            System.out.println(createDeveloperMessageFirstName);
                            String getFirsName = in.next();
                            System.out.println(createDeveloperMessageLastName);
                            String getLastName = in.next();
                            System.out.println(createDeveloperMessageSpecialty);
                            String getSpecialty = in.next();
                            Set<Skill> set = new HashSet<>();
                            String finish;
                            do {
                                System.out.println(createSkills);
                                String getIdSkill = in.next();
                                if (javaIOSkillRepository.getById(Long.parseLong(getIdSkill)) != null) {
                                    set.add(javaIOSkillRepository.getById(Long.parseLong(getIdSkill)));
                                }
                                System.out.println(finishCreateSkill);
                                finish = in.next();
                            } while (!finish.equals("2"));
                            String getIdAccount;
                            do {
                                System.out.println(createAccount);
                                getIdAccount = in.next();
                            } while (javaIOAccountRepository.getById(Long.parseLong(getIdAccount)) == null);
                            Developer developer = new Developer(Long.parseLong(getIdDeveloper), getFirsName, getLastName, getSpecialty, set, javaIOAccountRepository.getById(Long.parseLong(getIdAccount)));
                            createSkill(developer);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        System.out.println("Update Developer");
                        try {
                            boolean f;
                            String getIdDeveloper;
                            do {
                                System.out.println(createDeveloperMessageId);
                                getIdDeveloper = in.next();
                                if (javaIODeveloperRepository.getById(Long.parseLong(getIdDeveloper)) != null) {
                                    f = true;
                                }
                                else
                                {
                                    f = false;
                                }
                            } while (f == false);
                            System.out.println(createDeveloperMessageFirstName);
                            String getFirsName = in.next();
                            System.out.println(createDeveloperMessageLastName);
                            String getLastName = in.next();
                            System.out.println(createDeveloperMessageSpecialty);
                            String getSpecialty = in.next();
                            Set<Skill> set = new HashSet<>();
                            String finish;
                            do {
                                System.out.println(createSkills);
                                String getIdSkill = in.next();
                                if (javaIOSkillRepository.getById(Long.parseLong(getIdSkill)) != null) {
                                    set.add(javaIOSkillRepository.getById(Long.parseLong(getIdSkill)));
                                }
                                System.out.println(finishCreateSkill);
                                finish = in.next();
                            } while (!finish.equals("2"));
                            String getIdAccount;
                            do {
                                System.out.println(createAccount);
                                getIdAccount = in.next();
                            } while (javaIOAccountRepository.getById(Long.parseLong(getIdAccount)) == null);
                            Developer developer = new Developer(Long.parseLong(getIdDeveloper), getFirsName, getLastName, getSpecialty, set, javaIOAccountRepository.getById(Long.parseLong(getIdAccount)));
                            updateDeveloper(developer);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        System.out.println(choiceDeleteMessage);
                        try {
                            int index;
                            do {
                                String choiceCount = in.next();
                                int count = Integer.parseInt(choiceCount);
                                index = count;
                                if (count == 1) {
                                    System.out.println(createDeveloperMessageId);
                                    try {
                                        String deleteId = in.next();
                                        Long getDeleteId = Long.parseLong(deleteId);
                                        deleteById(getDeleteId);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (count == 2) {
                                    try {
                                        String getIdDeveloper;
                                        do {
                                            System.out.println(createDeveloperMessageId);
                                            getIdDeveloper = in.next();
                                        } while (javaIODeveloperRepository.getById(Long.parseLong(getIdDeveloper)) == null);
                                        System.out.println(createDeveloperMessageFirstName);
                                        String getFirsName = in.next();
                                        System.out.println(createDeveloperMessageLastName);
                                        String getLastName = in.next();
                                        System.out.println(createDeveloperMessageSpecialty);
                                        String getSpecialty = in.next();
                                        Set<Skill> set = new HashSet<>();
                                        String finish;
                                        do {
                                            System.out.println(createSkills);
                                            String getIdSkill = in.next();
                                            if (javaIOSkillRepository.getById(Long.parseLong(getIdSkill)) != null) {
                                                set.add(javaIOSkillRepository.getById(Long.parseLong(getIdSkill)));
                                            }
                                            System.out.println(finishCreateSkill);
                                            finish = in.next();
                                        } while (!finish.equals("2"));
                                        String getIdAccount;
                                        do {
                                            System.out.println(createAccount);
                                            getIdAccount = in.next();
                                        } while (javaIOAccountRepository.getById(Long.parseLong(getIdAccount)) == null);
                                        Developer developer = new Developer(Long.parseLong(getIdDeveloper), getFirsName, getLastName, getSpecialty, set, javaIOAccountRepository.getById(Long.parseLong(getIdAccount)));
                                        deleteDeveloper(developer);
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

    void getByIdDeveloper(Long id) {
        System.out.println(developerController.getById(id));
    }

    void getAllDeveloper() {
        System.out.println(developerController.getDeveloper());
    }

    void createSkill(Developer developer) {
        System.out.println(developerController.createDeveloper(developer));
    }

    void updateDeveloper(Developer developer) {
        System.out.println(developerController.updateDeveloper(developer));
    }

    void deleteById(Long id) {
        developerController.deleteByIdDeveloper(id);
    }

    void deleteDeveloper(Developer developer) {
        developerController.deleteDeveloper(developer);
    }
}
