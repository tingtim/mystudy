package com.example.test.studydemo.provider;

import com.alibaba.fastjson.JSON;
import com.example.test.studydemo.dto.AcessTokenDTO;
import com.example.test.studydemo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

/**
 * Description
 * User :LT
 * Date : 2019-2019.12.5-05  10:09
 */

@Component
public class GithubProvider {
    public String getAcessTokenDTO(AcessTokenDTO accessTokenDTO){
      MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
               .url("https://github.com/login/oauth/access_token")
                //.url("https://github.com/login/oauth/access_token?client_id=Iv1.20551cdd18d4d4c7&client_secret=d6320095a6e0d58f9ee0c58954f82a4231a35222&code="+accessTokenDTO.getCode()+"&redirect_uri=http://localhost:8080/callback&state=1")
                .post(body)
               // .addHeader("Acceept","application/json")
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string =response.body().string();
            System.out.println(string);
            System.out.println(string.split("&")[0].split("=")[1]);

           // String token =string.split("&")[0].split("=")[1];
            return string;
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

    }
    public GithubUser githubUser(String accessTokenDTO){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessTokenDTO)
                .build();
            try (Response response = client.newCall(request).execute()) {
               String string= response.body().string();
                GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
                return  githubUser;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

    }
    }
