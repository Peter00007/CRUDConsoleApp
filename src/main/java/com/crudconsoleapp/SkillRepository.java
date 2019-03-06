package main.java.com.crudconsoleapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 07.03.2019.
 */
public class SkillRepository {
    static void getAll () {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JavaCourse\\CRUDConsoleApp\\src\\main\\java\\com\\resources\\files\\skills.txt"))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getById (long id) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JavaCourse\\CRUDConsoleApp\\src\\main\\java\\com\\resources\\files\\skills.txt"))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] lines = line.split(" ");
                Long a = Long.parseLong(lines[0]);
                if (a == id) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
