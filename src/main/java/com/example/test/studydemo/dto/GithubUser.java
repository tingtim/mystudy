package com.example.test.studydemo.dto;

/**
 * Description
 * User :LT
 * Date : 2019-2019.12.5-05  12:03
 */

public class GithubUser {
    private  String login;
    private  Long id;
    private  String bio;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
