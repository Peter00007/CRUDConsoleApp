package main.java.com.crudconsoleapp;


public class CRUDRunner {
    public static void main(String[] args) {
        SkillRepository skillRepository = new SkillRepository();
        System.out.println(skillRepository.getById(1L));
    }
}
