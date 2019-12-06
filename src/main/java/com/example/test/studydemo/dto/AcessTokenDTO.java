package com.example.test.studydemo.dto;

/**
 * Description
 * User :LT
 * Date : 2019-2019.12.5-05  10:12
 */

public class AcessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private  String redirect_uri;
    private String state;


    public String getClient_id() {
        return client_id;
    }
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }
    public String getClient_secret() {
        return client_secret;
    }
    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
