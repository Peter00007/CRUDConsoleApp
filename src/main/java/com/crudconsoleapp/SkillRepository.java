package main.java.com.crudconsoleapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class SkillRepository {
    private static final String FILE_PATH = "D:\\JavaCourse\\CRUDConsoleApp\\src\\main\\java\\com\\resources\\files\\skills.txt";

    public List<Skill> getAll () {
        List<Skill> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))){
            String skillFileContent ;
            while ((skillFileContent  = bufferedReader.readLine()) != null) {
                String [] skillRecords = skillFileContent .split(",");
                list.add(new Skill(Long.parseLong(skillRecords[0]), skillRecords[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public Skill getById (Long id) {
        Skill skill;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))){
            String skillFileContent ;
            while ((skillFileContent  = bufferedReader.readLine()) != null) {
                String [] skillRecords = skillFileContent .split(",");
                Long equalsId = Long.parseLong(skillRecords[0]);
                if (equalsId == id) {
                    skill = new Skill(Long.parseLong(skillRecords[0]), skillRecords[1]);
                    return skill;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
