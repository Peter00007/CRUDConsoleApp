package main.java.com.crudconsoleapp.repository;


import main.java.com.crudconsoleapp.model.Developer;
import main.java.com.crudconsoleapp.model.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeveloperRepository {
    private static final String FILE_PATH = "D:\\JavaCourse\\CRUDConsoleApp\\src\\main\\resourses\\files\\developers.txt";
    SkillRepository skillRepository;
    AccountRepository accountRepository;

    public DeveloperRepository() {
        skillRepository = new SkillRepository();
        accountRepository = new AccountRepository();
    }

    public List<Developer> getAll() {
        List<Developer> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String developerFileContent;
            while ((developerFileContent = bufferedReader.readLine()) != null) {
                String[] developerRecords = developerFileContent.split(",");
                Set<Skill> set = new HashSet<>();
                set.add(skillRepository.getById(Long.parseLong(developerRecords[4].substring(1, developerRecords[4].length()))));
                for (int i = 5; i < developerRecords.length - 1; i++) {
                    if (i == developerRecords.length - 2) {
                        set.add(skillRepository.getById(Long.parseLong(developerRecords[i].substring(0, developerRecords[i].length() - 1))));
                    } else {
                        set.add(skillRepository.getById(Long.parseLong(developerRecords[i])));
                    }
                }
                Long accountId = Long.parseLong(developerRecords[developerRecords.length - 1].substring(0, developerRecords[developerRecords.length - 1].length() - 1));
                list.add(new Developer(Long.parseLong(developerRecords[0]), developerRecords[1], developerRecords[2],
                        developerRecords[3], set, accountRepository.getById(accountId)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Developer getById(Long id) {
        Developer developer;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String developerFileContent;
            while ((developerFileContent = bufferedReader.readLine()) != null) {
                String[] developerRecords = developerFileContent.split(",");
                Long equalsId = Long.parseLong(developerRecords[0]);
                if (equalsId == id) {
                    Set<Skill> set = new HashSet<>();
                    int index = developerRecords.length - 5;
                    if (index == 1) {
                    set.add(skillRepository.getById(Long.parseLong(developerRecords[4].substring(1, developerRecords[4].length() - 1))));
                    }
                    else {
                        set.add(skillRepository.getById(Long.parseLong(developerRecords[4].substring(1, developerRecords[4].length()))));
                    }
                    for (int i = 5; i < developerRecords.length - 1; i++) {
                        if (i == developerRecords.length - 2) {
                            set.add(skillRepository.getById(Long.parseLong(developerRecords[i].substring(0, developerRecords[i].length() - 1))));
                        } else {
                            set.add(skillRepository.getById(Long.parseLong(developerRecords[i])));
                        }
                    }
                    Long accountId = Long.parseLong(developerRecords[developerRecords.length - 1].substring(0, developerRecords[developerRecords.length - 1].length() - 1));

                    developer = new Developer(Long.parseLong(developerRecords[0]), developerRecords[1], developerRecords[2],
                            developerRecords[3], set, accountRepository.getById(accountId));
                    return developer;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Developer save(Developer developer) {
        try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String s = developer.getId().toString() + "," + developer.getFirstName() + "," + developer.getLastName() + "," +
                    developer.getSpecialty() + ",{";
            int index = 0;
            for (Skill str : developer.getSkills()) {
                if (index == developer.getSkills().size() - 1) {
                    s += str.getId();
                } else {
                    s += str.getId() + ",";
                }
                index++;
            }
            s += "}," + developer.getAccount().getId() + "/\n";
            bufferWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }

    public void delete(Long id) {
        String saveDeveloperLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((saveDeveloperLine = reader.readLine()) != null) {
                String[] developerRecords = saveDeveloperLine.split(",");
                if (!developerRecords[0].equals(id.toString())) {
                    stringBuffer.append(saveDeveloperLine).append("\n");
                }
            }
            saveDeveloperLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[saveDeveloperLine.length()];
        saveDeveloperLine.getChars(0, saveDeveloperLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(Developer developer) {
        String saveDeveloperLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            String developerRecords = developer.getId().toString() + "," + developer.getFirstName() + "," + developer.getLastName() +
                    "," + developer.getSpecialty() + ",{";
            int index = 0;
            for (Skill str : developer.getSkills()) {
                if (index == developer.getSkills().size() - 1) {
                    developerRecords += str.getId();
                } else {
                    developerRecords += str.getId() + ",";
                }
                index++;
            }
            developerRecords += "}," + developer.getAccount().getId() + "/";
            while ((saveDeveloperLine = reader.readLine()) != null) {
                if (!developerRecords.equals(saveDeveloperLine)) {
                    stringBuffer.append(saveDeveloperLine).append("\n");
                }
            }
            saveDeveloperLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        char[] buffer = new char[saveDeveloperLine.length()];
        saveDeveloperLine.getChars(0, saveDeveloperLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Developer update (Developer developer) {
        String saveDeveloperLine = null;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_PATH)))) {
            while ((saveDeveloperLine = reader.readLine()) != null) {
                String[] developerRecords = saveDeveloperLine.split(",");
                if (!developerRecords[0].equals(developer.getId().toString())) {
                    stringBuffer.append(saveDeveloperLine).append("\n");
                } else {
                    String devRecord = developer.getId().toString() + "," + developer.getFirstName() + "," + developer.getLastName() +
                            "," + developer.getSpecialty() + ",{";
                    int index = 0;
                    for (Skill str : developer.getSkills()) {
                        if (index == developer.getSkills().size() - 1) {
                            devRecord += str.getId();
                        } else {
                            devRecord += str.getId() + ",";
                        }
                        index++;
                    }
                    devRecord += "}," + developer.getAccount().getId() + "/";
                    stringBuffer.append(devRecord).append("\n");
                }
            }
            saveDeveloperLine = stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[saveDeveloperLine.length()];
        saveDeveloperLine.getChars(0, saveDeveloperLine.length(), buffer, 0);
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return developer;
    }
}
