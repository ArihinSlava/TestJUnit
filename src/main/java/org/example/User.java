package org.example;

import java.util.Objects;

public class User {
    String login;
    String email;

    private final static String char1 = "@";
    private final static String char2 = ".";

    public User() {
    }

    public User(String login, String email) {
        ValidateUserParameters(login, email);
        this.login = login;
        this.email = email;
    }


    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        validateLogin(login);
        this.login = login;
    }

    public void setEmail(String email) {
        validateMail(email);
        this.email = email;
    }

    public void validateLogin(String login) {
        if (login == null) {
            throw new IllegalArgumentException("Некорректные логин");
        }
    }

    public void validateMail(String email) {
        if ( email == null || !email.contains(char1)||!email.contains(char2)) {
            throw new IllegalArgumentException("Неверная почта");
        }
    }

    public void ValidateUserParameters(String login, String email) {
        validateLogin(login);
        validateMail(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }
}
