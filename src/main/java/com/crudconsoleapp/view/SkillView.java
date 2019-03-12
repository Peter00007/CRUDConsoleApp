package main.java.com.crudconsoleapp.view;

import main.java.com.crudconsoleapp.controller.SkillController;
import main.java.com.crudconsoleapp.model.Skill;

import java.util.Scanner;

public class SkillView {
    Scanner in = new Scanner(System.in);
    SkillController skillController = new SkillController();

    private String start = "Enter:\n" +
            "1 if you want Get skill by ID\n" +
            "2 if you want Get all skills\n" +
            "3 if you want Create skill\n" +
            "4 if you want Update skill\n" +
            "5 if you want Delete skill";

    private String getSkillByIdMessage = "Input Id our Skill:";
    private String getAllSkillMessage = "Get our All Skill:";
    private String createSkillMessageId = "Input Id:";
    private String createSkillMessageName = "Input Name:";
    private String choiceDeleteMessage = "Enter:\n" +
            "1 if you want delete Skill by Id\n" +
            "2 if you want delete Skill by Skill";


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
                        System.out.println(getSkillByIdMessage);
                        String getId = in.next();
                        try {
                            Long idSkill = Long.parseLong(getId);
                            getByIdSkill(idSkill);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.println(getAllSkillMessage);
                        getAllSkill();
                        break;
                    case 3:
                        System.out.println("Create Skill\n" + createSkillMessageId);
                        String getIdSkill = in.next();
                        System.out.println(createSkillMessageName);
                        String getNameSkill = in.next();
                        try {
                            Long getSkillId = Long.parseLong(getIdSkill);
                            Skill skill = new Skill(getSkillId, getNameSkill);
                            createSkill(skill);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        System.out.println("Update Skill\n" + createSkillMessageId);
                        String getUpdateId = in.next();
                        System.out.println(createSkillMessageName);
                        String getUpdateName = in.next();
                        try {
                            Long updateId = Long.parseLong(getUpdateId);
                            Skill skill = new Skill(updateId, getUpdateName);
                            updateSkill(skill);
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
                                    System.out.println(createSkillMessageId);
                                    try {
                                        String deleteId = in.next();
                                        Long getDeleteId = Long.parseLong(deleteId);
                                        deleteById(getDeleteId);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (count == 2) {
                                    System.out.println(createSkillMessageId);
                                    String deleteIdSkill = in.next();
                                    System.out.println(createSkillMessageName);
                                    String deleteNameSkill = in.next();
                                    try {
                                        Long getDeleteId = Long.parseLong(deleteIdSkill);
                                        Skill skill = new Skill(getDeleteId, deleteNameSkill);
                                        deleteSkill(skill);
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

    void getByIdSkill(Long id) {
        System.out.println(skillController.getById(id));
    }

    void getAllSkill() {
        System.out.println(skillController.getSkill());
    }

    void createSkill(Skill skill) {
        System.out.println(skillController.createSkill(skill));
    }

    void updateSkill(Skill skill) {
        System.out.println(skillController.updateSkill(skill));
    }

    void deleteById(Long id) {
        skillController.deleteByIdSkill(id);
    }

    void deleteSkill(Skill skill) {
        skillController.deleteSkill(skill);
    }
}
