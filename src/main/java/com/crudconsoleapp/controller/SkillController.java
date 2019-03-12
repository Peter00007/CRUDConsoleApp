package main.java.com.crudconsoleapp.controller;

import main.java.com.crudconsoleapp.model.Skill;
import main.java.com.crudconsoleapp.repository.SkillRepository;

public class SkillController {
    SkillRepository skillRepository = new SkillRepository();

    public void getById(Long id) {
        skillRepository.getById(id);
    }

    public void getSkill () {
        System.out.println(skillRepository.getAll());
    }

    public void createSkill(Skill skill) {
        skillRepository.save(skill);
    }

    public void updateSkill (Skill skill) {
        skillRepository.update(skill);
    }

    public void deleteByIdSkill(Long id) {
        skillRepository.delete(id);
    }

    public void deleteSkill(Skill skill) {
        skillRepository.delete(skill);
    }
}
