package main.java.com.crudconsoleapp.controller;

import main.java.com.crudconsoleapp.model.Skill;
import main.java.com.crudconsoleapp.repository.SkillRepository;

import java.util.List;

public class SkillController {
    SkillRepository skillRepository = new SkillRepository();

    public Skill getById(Long id) {
        return skillRepository.getById(id);
    }

    public List<Skill> getSkill () {
        return skillRepository.getAll();
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill (Skill skill) {
        return skillRepository.update(skill);
    }

    public void deleteByIdSkill(Long id) {
         skillRepository.delete(id);
    }

    public void deleteSkill(Skill skill) {
        skillRepository.delete(skill);
    }
}
