package main.java.com.crudconsoleapp.controller;

import main.java.com.crudconsoleapp.model.Developer;
import main.java.com.crudconsoleapp.repository.DeveloperRepository;

import java.util.List;

/**
 * Created by User on 14.03.2019.
 */
public class DeveloperController {
    DeveloperRepository developerRepository = new DeveloperRepository();

    public Developer getById(Long id) {
        return developerRepository.getById(id);
    }

    public List<Developer> getDeveloper () {
        return developerRepository.getAll();
    }

    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer updateDeveloper (Developer developer) {
        return developerRepository.update(developer);
    }

    public void deleteByIdDeveloper(Long id) {
        developerRepository.delete(id);
    }

    public void deleteDeveloper(Developer developer) {
        developerRepository.delete(developer);
    }
}
