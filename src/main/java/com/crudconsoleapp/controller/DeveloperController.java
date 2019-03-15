package main.java.com.crudconsoleapp.controller;

import main.java.com.crudconsoleapp.model.Developer;
import main.java.com.crudconsoleapp.repository.DeveloperRepository;
import main.java.com.crudconsoleapp.repository.io.JavaIODeveloperRepositoryImpl;

import java.util.List;

/**
 * Created by User on 14.03.2019.
 */
public class DeveloperController {
    DeveloperRepository javaIODeveloperRepository = new JavaIODeveloperRepositoryImpl();

    public Developer getById(Long id) {
        return javaIODeveloperRepository.getById(id);
    }

    public List<Developer> getDeveloper () {
        return javaIODeveloperRepository.getAll();
    }

    public Developer createDeveloper(Developer developer) {
        return javaIODeveloperRepository.save(developer);
    }

    public Developer updateDeveloper (Developer developer) {
        return javaIODeveloperRepository.update(developer);
    }

    public void deleteByIdDeveloper(Long id) {
        javaIODeveloperRepository.delete(id);
    }

    public void deleteDeveloper(Developer developer) {
        javaIODeveloperRepository.deleteByObject(developer);
    }
}
