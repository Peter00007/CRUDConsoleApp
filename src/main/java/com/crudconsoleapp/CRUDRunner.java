package main.java.com.crudconsoleapp;


import main.java.com.crudconsoleapp.model.Skill;
import main.java.com.crudconsoleapp.repository.SkillRepository;

public class CRUDRunner {
    public static void main(String[] args) {
        SkillRepository skillRepository = new SkillRepository();
        //System.out.println(skillRepository.save(new Skill(1L,"Aaaa")));
        //skillRepository.delete(1L);
        skillRepository.delete(new Skill(1L,"Aaaa"));

    }
}
