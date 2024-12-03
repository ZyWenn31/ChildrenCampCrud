package ru.sasha.trzbd.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    @NotEmpty(message = "The password cannot be empty")
    @Size(min = 3, max = 20, message = "The login must be between 3 and 25 characters long")
    private String Password;

    @NotEmpty(message = "The login cannot be empty")
    @Size(min = 3, max = 25, message = "The login must be between 3 and 25 characters long")
    private String login;

    public User(){};

    public User(String Password, String login) {
        this.Password = Password;
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
