package main.java.com.crudconsoleapp.controller;

import main.java.com.crudconsoleapp.model.Skill;
import main.java.com.crudconsoleapp.repository.SkillRepository;
import main.java.com.crudconsoleapp.repository.io.JavaIOSkillRepositoryImpl;

import java.util.List;

public class SkillController {
    SkillRepository javaIOSkillRepository = new JavaIOSkillRepositoryImpl();

    public Skill getById(Long id) {
        return javaIOSkillRepository.getById(id);
    }

    public List<Skill> getSkill () {
        return javaIOSkillRepository.getAll();
    }

    public Skill createSkill(Skill skill) {
        return javaIOSkillRepository.save(skill);
    }

    public Skill updateSkill (Skill skill) {
        return javaIOSkillRepository.update(skill);
    }

    public void deleteByIdSkill(Long id) {
        javaIOSkillRepository.delete(id);
    }

    public void deleteSkill(Skill skill) {
        javaIOSkillRepository.deleteByObject(skill);
    }
}
