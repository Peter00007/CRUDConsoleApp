package main.java.com.crudconsoleapp.repository;

import main.java.com.crudconsoleapp.model.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


 public class SkillRepository {
    private static final String FILE_PATH = "D:\\JavaCourse\\CRUDConsoleApp\\src\\main\\resourses\\files\\skills.txt";

    public List<Skill> getAll() {
        List<Skill> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String skillFileContent;
            while ((skillFileContent = bufferedReader.readLine()) != null) {
                String[] skillRecords = skillFileContent.split(",");
                list.add(new Skill(Long.parseLong(skillRecords[0]), skillRecords[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Skill getById(Long id) {
        Skill skill;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String skillFileContent;
            while ((skillFileContent = bufferedReader.readLine()) != null) {
                String[] skillRecords = skillFileContent.split(",");
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

    public Skill save(Skill skill) {
        try(BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String s = skill.getId().toString() + "," + skill.getName() + "/";
            bufferWriter.write(s);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return skill;
    }

    public void delete (Long id) {
        String saveSkillLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((saveSkillLine = reader.readLine()) != null) {
                String[] skillRecords = saveSkillLine.split(",");
                if (!skillRecords[0].equals(id.toString())) {
                    stringBuffer.append(saveSkillLine).append("\n");
                }
            }
            saveSkillLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[saveSkillLine.length()];
        saveSkillLine.getChars(0, saveSkillLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete (Skill skill) {
        String saveSkillLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((saveSkillLine = reader.readLine()) != null) {
                String skillRecords = skill.getId().toString() + "," + skill.getName() + "/";
                if (!skillRecords.equals(saveSkillLine)) {
                    stringBuffer.append(saveSkillLine).append("\n");
                }
            }
            saveSkillLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] buffer = new char[saveSkillLine.length()];
        saveSkillLine.getChars(0, saveSkillLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Skill update (Skill skill) {
        String saveSkillLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((saveSkillLine = reader.readLine()) != null) {
                String[] skillRecords = saveSkillLine.split(",");
                if (!skillRecords[0].equals(skill.getId().toString())) {
                    stringBuffer.append(saveSkillLine).append("\n");
                } else {
                    stringBuffer.append(skill.getId().toString() + "," + skill.getName() + "/").append("\n");
                }
            }
            saveSkillLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[saveSkillLine.length()];
        saveSkillLine.getChars(0, saveSkillLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return skill;
    }
}
