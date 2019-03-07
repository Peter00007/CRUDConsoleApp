package main.java.com.crudconsoleapp;


public class CRUDRunner {
    public static void main(String[] args) {
        SkillRepository skillRepository = new SkillRepository();
        skillRepository.saveSkill(new Skill(1L, "Dima"));
        skillRepository.updateSkill(new Skill(2L,"Vova"));
        skillRepository.deleteSkillById(1L);
        skillRepository.deleteSkillByObject(new Skill(2L,"Vova"));
        System.out.println(skillRepository.getAll());
    }
}
