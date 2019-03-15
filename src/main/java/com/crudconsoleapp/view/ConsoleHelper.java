package main.java.com.crudconsoleapp.view;

public class ConsoleHelper {
    SkillView skillView = new SkillView();
    AccountView accountView = new AccountView();
    DeveloperView developerView = new DeveloperView();

    public void start() {
        developerView.startCRUD();
    }
}
