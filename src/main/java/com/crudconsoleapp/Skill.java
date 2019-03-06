package main.java.com.crudconsoleapp;

/**
 * Created by User on 07.03.2019.
 */
public class Skill {
    private long id;
    private String name;

    public Skill(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
